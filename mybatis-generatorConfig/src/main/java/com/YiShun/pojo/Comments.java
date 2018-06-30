package com.YiShun.pojo;

import java.util.Date;
import javax.persistence.*;

public class Comments {
    @Id
    private String id;

    @Column(name = "father_comment_id")
    private String fatherCommentId;

    @Column(name = "to_user_id")
    private String toUserId;

    /**
     * ��Ƶid
     */
    @Column(name = "video_id")
    private String videoId;

    /**
     * �����ߣ����۵��û�id
     */
    @Column(name = "from_user_id")
    private String fromUserId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * ��������
     */
    private String comment;

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
     * @return father_comment_id
     */
    public String getFatherCommentId() {
        return fatherCommentId;
    }

    /**
     * @param fatherCommentId
     */
    public void setFatherCommentId(String fatherCommentId) {
        this.fatherCommentId = fatherCommentId;
    }

    /**
     * @return to_user_id
     */
    public String getToUserId() {
        return toUserId;
    }

    /**
     * @param toUserId
     */
    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * ��ȡ��Ƶid
     *
     * @return video_id - ��Ƶid
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * ������Ƶid
     *
     * @param videoId ��Ƶid
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    /**
     * ��ȡ�����ߣ����۵��û�id
     *
     * @return from_user_id - �����ߣ����۵��û�id
     */
    public String getFromUserId() {
        return fromUserId;
    }

    /**
     * ���������ߣ����۵��û�id
     *
     * @param fromUserId �����ߣ����۵��û�id
     */
    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * ��ȡ��������
     *
     * @return comment - ��������
     */
    public String getComment() {
        return comment;
    }

    /**
     * ������������
     *
     * @param comment ��������
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}