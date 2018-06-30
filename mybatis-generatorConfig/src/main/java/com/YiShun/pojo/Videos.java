package com.YiShun.pojo;

import java.util.Date;
import javax.persistence.*;

public class Videos {
    @Id
    private String id;

    /**
     * ������id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * �û�ʹ����Ƶ����Ϣ
     */
    @Column(name = "audio_id")
    private String audioId;

    /**
     * ��Ƶ����
     */
    @Column(name = "video_desc")
    private String videoDesc;

    /**
     * ��Ƶ��ŵ�·��
     */
    @Column(name = "video_path")
    private String videoPath;

    /**
     * ��Ƶ����
     */
    @Column(name = "video_seconds")
    private Float videoSeconds;

    /**
     * ��Ƶ���
     */
    @Column(name = "video_width")
    private Integer videoWidth;

    /**
     * ��Ƶ�߶�
     */
    @Column(name = "video_height")
    private Integer videoHeight;

    /**
     * ��Ƶ����ͼ
     */
    @Column(name = "cover_path")
    private String coverPath;

    /**
     * ϲ��/����������
     */
    @Column(name = "like_counts")
    private Long likeCounts;

    /**
     * ��Ƶ״̬��
1�������ɹ�
2����ֹ���ţ�����Ա����
     */
    private Integer status;

    /**
     * ����ʱ��
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * ��ȡ������id
     *
     * @return user_id - ������id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ���÷�����id
     *
     * @param userId ������id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ��ȡ�û�ʹ����Ƶ����Ϣ
     *
     * @return audio_id - �û�ʹ����Ƶ����Ϣ
     */
    public String getAudioId() {
        return audioId;
    }

    /**
     * �����û�ʹ����Ƶ����Ϣ
     *
     * @param audioId �û�ʹ����Ƶ����Ϣ
     */
    public void setAudioId(String audioId) {
        this.audioId = audioId;
    }

    /**
     * ��ȡ��Ƶ����
     *
     * @return video_desc - ��Ƶ����
     */
    public String getVideoDesc() {
        return videoDesc;
    }

    /**
     * ������Ƶ����
     *
     * @param videoDesc ��Ƶ����
     */
    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    /**
     * ��ȡ��Ƶ��ŵ�·��
     *
     * @return video_path - ��Ƶ��ŵ�·��
     */
    public String getVideoPath() {
        return videoPath;
    }

    /**
     * ������Ƶ��ŵ�·��
     *
     * @param videoPath ��Ƶ��ŵ�·��
     */
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    /**
     * ��ȡ��Ƶ����
     *
     * @return video_seconds - ��Ƶ����
     */
    public Float getVideoSeconds() {
        return videoSeconds;
    }

    /**
     * ������Ƶ����
     *
     * @param videoSeconds ��Ƶ����
     */
    public void setVideoSeconds(Float videoSeconds) {
        this.videoSeconds = videoSeconds;
    }

    /**
     * ��ȡ��Ƶ���
     *
     * @return video_width - ��Ƶ���
     */
    public Integer getVideoWidth() {
        return videoWidth;
    }

    /**
     * ������Ƶ���
     *
     * @param videoWidth ��Ƶ���
     */
    public void setVideoWidth(Integer videoWidth) {
        this.videoWidth = videoWidth;
    }

    /**
     * ��ȡ��Ƶ�߶�
     *
     * @return video_height - ��Ƶ�߶�
     */
    public Integer getVideoHeight() {
        return videoHeight;
    }

    /**
     * ������Ƶ�߶�
     *
     * @param videoHeight ��Ƶ�߶�
     */
    public void setVideoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
    }

    /**
     * ��ȡ��Ƶ����ͼ
     *
     * @return cover_path - ��Ƶ����ͼ
     */
    public String getCoverPath() {
        return coverPath;
    }

    /**
     * ������Ƶ����ͼ
     *
     * @param coverPath ��Ƶ����ͼ
     */
    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    /**
     * ��ȡϲ��/����������
     *
     * @return like_counts - ϲ��/����������
     */
    public Long getLikeCounts() {
        return likeCounts;
    }

    /**
     * ����ϲ��/����������
     *
     * @param likeCounts ϲ��/����������
     */
    public void setLikeCounts(Long likeCounts) {
        this.likeCounts = likeCounts;
    }

    /**
     * ��ȡ��Ƶ״̬��
1�������ɹ�
2����ֹ���ţ�����Ա����
     *
     * @return status - ��Ƶ״̬��
1�������ɹ�
2����ֹ���ţ�����Ա����
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * ������Ƶ״̬��
1�������ɹ�
2����ֹ���ţ�����Ա����
     *
     * @param status ��Ƶ״̬��
1�������ɹ�
2����ֹ���ţ�����Ա����
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return create_time - ����ʱ��
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * ���ô���ʱ��
     *
     * @param createTime ����ʱ��
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}