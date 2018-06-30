package com.YiShun.service;

import com.YiShun.pojo.Videos;
import com.YiShun.utils.PagedResult;

/**
 * Created by Lanly on 2018/6/27 下午3:14
 */

public interface VideoService {

    /**
     * @Description: 保存视频
     */
    public String saveVideo(Videos video);

    /**
     * @Description: 修改视频的封面
     */
    public void updateVideo(String videoId, String coverPath);

    /**
     * @Description: 分页查询视频列表
     */
    public PagedResult getAllVideos(Integer page, Integer pageSize);

}
