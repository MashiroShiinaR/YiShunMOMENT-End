package com.YiShun.service;

import com.YiShun.pojo.Bgm;

import java.util.List;

/**
 * Created by Lanly on 2018/6/26 下午4:22
 */

public interface BgmService {

    /**
     * @Description: 查询背景音乐列表
     */
    public List<Bgm> queryBgmList();

    /**
     * @Description: 根据id查询bgm信息
     */
    public Bgm queryBgmById(String bgmId);

}
