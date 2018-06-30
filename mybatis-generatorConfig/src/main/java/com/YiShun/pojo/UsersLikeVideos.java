package com.YiShun.pojo;

import javax.persistence.*;

@Table(name = "users_like_videos")
public class UsersLikeVideos {
    @Id
    private String id;

    /**
     * �û�
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * ��Ƶ
     */
    @Column(name = "video_id")
    private String videoId;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ��ȡ�û�
     *
     * @return user_id - �û�
     */
    public String getUserId() {
        return userId;
    }

    /**
     * �����û�
     *
     * @param userId �û�
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ��ȡ��Ƶ
     *
     * @return video_id - ��Ƶ
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * ������Ƶ
     *
     * @param videoId ��Ƶ
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}