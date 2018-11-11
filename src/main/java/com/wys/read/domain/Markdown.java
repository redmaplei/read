package com.wys.read.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 15:56 2018/10/6
 * @Modified By:
 */

@Entity
public class Markdown {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * MD标题
     * title
     */
    private String blogtitle;

    /**
     * 编写时间
     * time
     */
    private Date writetime;

    /**
     * MD描述
     * info
     */
    private String markdowninfo;

    /**
     * 分类
     * catefory
     */
    private String category;

    /**
     * mdsrc
     */
    private String mdsrc;

    /**
     * md内容
     */
    private String mdcontent;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogtitle() {
        return blogtitle;
    }

    public void setBlogtitle(String blogtitle) {
        this.blogtitle = blogtitle;
    }

    public Date getWritetime() {
        return writetime;
    }

    public void setWritetime(Date writetime) {
        this.writetime = writetime;
    }

    public String getMarkdowninfo() {
        return markdowninfo;
    }

    public void setMarkdowninfo(String markdowninfo) {
        this.markdowninfo = markdowninfo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMdsrc() {
        return mdsrc;
    }

    public void setMdsrc(String mdsrc) {
        this.mdsrc = mdsrc;
    }

    public String getMdContent() {
        return mdcontent;
    }

    public void setMdContent(String mdContent) {
        this.mdcontent = mdContent;
    }
}
