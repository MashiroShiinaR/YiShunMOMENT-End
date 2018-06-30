package com.YiShun.mapper;

import com.YiShun.pojo.Videos;
import com.YiShun.pojo.vo.VideosVO;
import com.YiShun.utils.MyMapper;

import java.util.List;

public interface VideosMapperCustom extends MyMapper<Videos> {

    public List<VideosVO> queryAllVideos();

}