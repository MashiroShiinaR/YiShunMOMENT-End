package com.YiShun.controller;

import com.YiShun.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lanly on 2018/6/25 下午12:22
 */

public class BasicController {

    @Autowired
    public RedisOperator redis;

    public static final String USER_REDIS_SESSION = "user-redis-session";

    // 文件保存的命名空间
    public static final String FILE_SPACE = "/usr/local/YiShunCache";

    // ffmpeg所在目录
    public static final String FFMPEG_EXE = "/usr/local/Cellar/ffmpeg/4.0.1/bin/ffmpeg";

    // 每页分页的数量
    public static final Integer PAGE_SIZE = 5;
}
