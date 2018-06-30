package com.YiShun.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "users_report")
public class UsersReport {
    @Id
    private String id;

    /**
     * ���ٱ��û�id
     */
    @Column(name = "deal_user_id")
    private String dealUserId;

    @Column(name = "deal_video_id")
    private String dealVideoId;

    /**
     * ���ͱ��⣬���û�ѡ������� ö��
     */
    private String title;

    /**
     * ����
     */
    private String content;

    /**
     * �ٱ��˵�id
     */
    private String userid;

    /**
     * �ٱ�ʱ��
     */
    @Column(name = "create_date")
    private Date createDate;

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
     * ��ȡ���ٱ��û�id
     *
     * @return deal_user_id - ���ٱ��û�id
     */
    public String getDealUserId() {
        return dealUserId;
    }

    /**
     * ���ñ��ٱ��û�id
     *
     * @param dealUserId ���ٱ��û�id
     */
    public void setDealUserId(String dealUserId) {
        this.dealUserId = dealUserId;
    }

    /**
     * @return deal_video_id
     */
    public String getDealVideoId() {
        return dealVideoId;
    }

    /**
     * @param dealVideoId
     */
    public void setDealVideoId(String dealVideoId) {
        this.dealVideoId = dealVideoId;
    }

    /**
     * ��ȡ���ͱ��⣬���û�ѡ������� ö��
     *
     * @return title - ���ͱ��⣬���û�ѡ������� ö��
     */
    public String getTitle() {
        return title;
    }

    /**
     * �������ͱ��⣬���û�ѡ������� ö��
     *
     * @param title ���ͱ��⣬���û�ѡ������� ö��
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ��ȡ����
     *
     * @return content - ����
     */
    public String getContent() {
        return content;
    }

    /**
     * ��������
     *
     * @param content ����
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * ��ȡ�ٱ��˵�id
     *
     * @return userid - �ٱ��˵�id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * ���þٱ��˵�id
     *
     * @param userid �ٱ��˵�id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * ��ȡ�ٱ�ʱ��
     *
     * @return create_date - �ٱ�ʱ��
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * ���þٱ�ʱ��
     *
     * @param createDate �ٱ�ʱ��
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}