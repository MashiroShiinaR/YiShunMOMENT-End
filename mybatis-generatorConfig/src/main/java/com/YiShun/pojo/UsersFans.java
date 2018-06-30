package com.YiShun.pojo;

import javax.persistence.*;

@Table(name = "users_fans")
public class UsersFans {
    @Id
    private String id;

    /**
     * �û�
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * ��˿
     */
    @Column(name = "fan_id")
    private String fanId;

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
     * ��ȡ��˿
     *
     * @return fan_id - ��˿
     */
    public String getFanId() {
        return fanId;
    }

    /**
     * ���÷�˿
     *
     * @param fanId ��˿
     */
    public void setFanId(String fanId) {
        this.fanId = fanId;
    }
}