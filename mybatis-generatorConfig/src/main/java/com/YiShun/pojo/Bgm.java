package com.YiShun.pojo;

import javax.persistence.*;

public class Bgm {
    @Id
    private String id;

    private String author;

    private String name;

    /**
     * ���ŵ�ַ
     */
    private String path;

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
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ȡ���ŵ�ַ
     *
     * @return path - ���ŵ�ַ
     */
    public String getPath() {
        return path;
    }

    /**
     * ���ò��ŵ�ַ
     *
     * @param path ���ŵ�ַ
     */
    public void setPath(String path) {
        this.path = path;
    }
}