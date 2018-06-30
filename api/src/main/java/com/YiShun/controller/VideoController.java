package com.YiShun.controller;

import com.YiShun.enums.VideoStatusEnum;
import com.YiShun.pojo.Bgm;
import com.YiShun.pojo.Videos;
import com.YiShun.service.BgmService;
import com.YiShun.service.UserService;
import com.YiShun.service.VideoService;
import com.YiShun.utils.FetchVideoCover;
import com.YiShun.utils.JSONResult;
import com.YiShun.utils.MergeVideoMp3;
import com.YiShun.utils.PagedResult;
import io.swagger.annotations.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import static com.YiShun.controller.BasicController.*;

/**
 * Created by Lanly on 2018/6/27 下午3:00
 */

@RestController
@Api(value = "视频相关业务的借口", tags = {"视频相关业务的controller"})
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private UserService userService;

    @Autowired
    private BgmService bgmService;

    @Autowired
    private VideoService videoService;


    @ApiOperation(value = "上传视频", notes = "上传视频的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId", value="用户Id", required=true,
                    dataType="String", paramType="form"),
            @ApiImplicitParam(name="bgmId", value="背景音乐id", required=false,
                    dataType="String", paramType="form"),
            @ApiImplicitParam(name="videoSeconds", value="背景音乐播放长度", required=true,
                    dataType="String", paramType="form"),
            @ApiImplicitParam(name="videoWidth", value="视频宽度", required=true,
                    dataType="String", paramType="form"),
            @ApiImplicitParam(name="videoHeight", value="视频高度", required=true,
                    dataType="String", paramType="form"),
            @ApiImplicitParam(name="desc", value="视频描述", required=false,
                    dataType="String", paramType="form")
    })
    @PostMapping(value = "/upload", headers="content-type=multipart/form-data")
    public JSONResult upload(String userId, String bgmId, double videoSeconds,
                             int videoWidth, int videoHeight, String desc,
                             @ApiParam(value = "短视频", required = true)
                             MultipartFile file) throws Exception {

        if (StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("用户Id不能为空");
        }

        // 文件保存的命名空间
//        String FILE_SPACE = "/usr/local/YiShunCache";
        // 保存到数据库的相对路径
        String uploadPathDB = "/" + userId + "/video";
        String coverPathDB = "/" + userId + "/video";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        // 文件上传的最终保存路径
        String finalVideoPath = "";
        try {
            if (file != null) {

                String fileName = file.getOriginalFilename();
                // abc.mp4
                String arrayFilenameItem[] =  fileName.split("\\.");
                String fileNamePrefix = "";
                for (int i = 0 ; i < arrayFilenameItem.length-1 ; i ++) {
                    fileNamePrefix += arrayFilenameItem[i];
                }
                // fix bug: 解决小程序端OK，PC端不OK的bug，原因：PC端和小程序端对临时视频的命名不同
//				String fileNamePrefix = fileName.split("\\.")[0];

                if (StringUtils.isNotBlank(fileName)) {

                    finalVideoPath = FILE_SPACE + uploadPathDB + "/" + fileName;
                    // 设置数据库保存的路径
                    uploadPathDB += ("/" + fileName);
                    coverPathDB = coverPathDB + "/" + fileNamePrefix + ".jpg";

                    File outFile = new File(finalVideoPath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }

                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }

            } else {
                return JSONResult.errorMsg("上传出错...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JSONResult.errorMsg("上传出错...");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        // 判断bgmId是否为空，如果不为空，
        // 那就查询bgm的信息，并且合并视频，生产新的视频
        if (StringUtils.isNotBlank(bgmId)) {
            Bgm bgm = bgmService.queryBgmById(bgmId);
            String mp3InputPath = FILE_SPACE + bgm.getPath();

            MergeVideoMp3 tool = new MergeVideoMp3(FFMPEG_EXE);
            String videoInputPath = finalVideoPath;

            String videoOutputName = UUID.randomUUID().toString() + ".mp4";
            uploadPathDB = "/" + userId + "/video" + "/" + videoOutputName;
            finalVideoPath = FILE_SPACE + uploadPathDB;
            tool.convertor(videoInputPath, mp3InputPath, videoSeconds, finalVideoPath);
        }
        System.out.println("uploadPathDB=" + uploadPathDB);
        System.out.println("finalVideoPath=" + finalVideoPath);

        // 对视频进行截图
        FetchVideoCover videoInfo = new FetchVideoCover(FFMPEG_EXE);
        videoInfo.getCover(finalVideoPath, FILE_SPACE + coverPathDB);

        // 保存视频信息到数据库
        Videos video = new Videos();
        video.setAudioId(bgmId);
        video.setUserId(userId);
        video.setVideoSeconds((float)videoSeconds);
        video.setVideoHeight(videoHeight);
        video.setVideoWidth(videoWidth);
        video.setVideoDesc(desc);
        video.setVideoPath(uploadPathDB);
        video.setCoverPath(coverPathDB);
        video.setStatus(VideoStatusEnum.SUCCESS.value);
        video.setCreateTime(new Date());


        String videoId = videoService.saveVideo(video);

        return JSONResult.ok(videoId);
    }


        @ApiOperation(value = "上传封面", notes = "上传封面的接口")
        @ApiImplicitParams({
                @ApiImplicitParam(name="userId", value="用户Id", required=true,
                        dataType="String", paramType="form"),
                @ApiImplicitParam(name="videoId", value="视频主键Id", required=true,
                        dataType="String", paramType="form")

        })
        @PostMapping(value = "/uploadCover", headers="content-type=multipart/form-data")
        public JSONResult uploadCover(String userId,String videoId,
                                 @ApiParam(value = "视频封面", required = true)
                                         MultipartFile file) throws Exception {

            if (StringUtils.isBlank(videoId) || StringUtils.isBlank(userId)) {
                return JSONResult.errorMsg("视频主键Id和用户Id不能为空");
            }

            // 文件保存的命名空间
//        String FILE_SPACE = "/usr/local/YiShunCache";
            // 保存到数据库的相对路径
            String uploadPathDB = "/" + userId + "/video";
            String coverPathDB = "/" + userId + "/video";

            FileOutputStream fileOutputStream = null;
            InputStream inputStream = null;
            String finalCoverPath = "";
            try {
                if (file != null) {

                    String fileName = file.getOriginalFilename();
                    // abc.mp4
                    String arrayFilenameItem[] =  fileName.split("\\.");
                    String fileNamePrefix = "";
                    for (int i = 0 ; i < arrayFilenameItem.length-1 ; i ++) {
                        fileNamePrefix += arrayFilenameItem[i];
                    }
                    // fix bug: 解决小程序端OK，PC端不OK的bug，原因：PC端和小程序端对临时视频的命名不同
//				String fileNamePrefix = fileName.split("\\.")[0];

                    if (StringUtils.isNotBlank(fileName)) {

                        finalCoverPath = FILE_SPACE + uploadPathDB + "/" + fileName;
                        // 设置数据库保存的路径
                        uploadPathDB += ("/" + fileName);
                        coverPathDB = coverPathDB + "/" + fileNamePrefix + ".jpg";

                        File outFile = new File(finalCoverPath);
                        if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                            // 创建父文件夹
                            outFile.getParentFile().mkdirs();
                        }

                        fileOutputStream = new FileOutputStream(outFile);
                        inputStream = file.getInputStream();
                        IOUtils.copy(inputStream, fileOutputStream);
                    }

                } else {
                    return JSONResult.errorMsg("上传出错...");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return JSONResult.errorMsg("上传出错...");
            } finally {
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }

            videoService.updateVideo(videoId, uploadPathDB);

            return JSONResult.ok();
        }

    @PostMapping(value = "/showAll")
    public JSONResult showAll(Integer page) throws Exception {

        if (page == null) {
            page = 1;
        }

        PagedResult result = videoService.getAllVideos(page, PAGE_SIZE);
        return JSONResult.ok(result);
    }
    }

