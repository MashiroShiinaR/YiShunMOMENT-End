package com.YiShun.pojo;

import javax.persistence.*;

public class Users {
    @Id
    private String id;

    /**
     * �û���
     */
    private String username;

    /**
     * ����
     */
    private String password;

    /**
     * �ҵ�ͷ�����û��Ĭ�ϸ�һ��
     */
    @Column(name = "face_image")
    private String faceImage;

    /**
     * �ǳ�
     */
    private String nickname;

    /**
     * �ҵķ�˿����
     */
    @Column(name = "fans_counts")
    private Integer fansCounts;

    /**
     * �ҹ�ע��������
     */
    @Column(name = "follow_counts")
    private Integer followCounts;

    /**
     * �ҽ��ܵ�������/�ղ� ������
     */
    @Column(name = "receive_like_counts")
    private Integer receiveLikeCounts;

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
     * ��ȡ�û���
     *
     * @return username - �û���
     */
    public String getUsername() {
        return username;
    }

    /**
     * �����û���
     *
     * @param username �û���
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * ��ȡ����
     *
     * @return password - ����
     */
    public String getPassword() {
        return password;
    }

    /**
     * ��������
     *
     * @param password ����
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ��ȡ�ҵ�ͷ�����û��Ĭ�ϸ�һ��
     *
     * @return face_image - �ҵ�ͷ�����û��Ĭ�ϸ�һ��
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * �����ҵ�ͷ�����û��Ĭ�ϸ�һ��
     *
     * @param faceImage �ҵ�ͷ�����û��Ĭ�ϸ�һ��
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    /**
     * ��ȡ�ǳ�
     *
     * @return nickname - �ǳ�
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * �����ǳ�
     *
     * @param nickname �ǳ�
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * ��ȡ�ҵķ�˿����
     *
     * @return fans_counts - �ҵķ�˿����
     */
    public Integer getFansCounts() {
        return fansCounts;
    }

    /**
     * �����ҵķ�˿����
     *
     * @param fansCounts �ҵķ�˿����
     */
    public void setFansCounts(Integer fansCounts) {
        this.fansCounts = fansCounts;
    }

    /**
     * ��ȡ�ҹ�ע��������
     *
     * @return follow_counts - �ҹ�ע��������
     */
    public Integer getFollowCounts() {
        return followCounts;
    }

    /**
     * �����ҹ�ע��������
     *
     * @param followCounts �ҹ�ע��������
     */
    public void setFollowCounts(Integer followCounts) {
        this.followCounts = followCounts;
    }

    /**
     * ��ȡ�ҽ��ܵ�������/�ղ� ������
     *
     * @return receive_like_counts - �ҽ��ܵ�������/�ղ� ������
     */
    public Integer getReceiveLikeCounts() {
        return receiveLikeCounts;
    }

    /**
     * �����ҽ��ܵ�������/�ղ� ������
     *
     * @param receiveLikeCounts �ҽ��ܵ�������/�ղ� ������
     */
    public void setReceiveLikeCounts(Integer receiveLikeCounts) {
        this.receiveLikeCounts = receiveLikeCounts;
    }
}