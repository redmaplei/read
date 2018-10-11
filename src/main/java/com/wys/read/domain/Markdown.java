package com.wys.read.domain;

import javax.persistence.*;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 15:56 2018/10/6
 * @Modified By:
 */

@Entity
@Table(name = "markdown")
public class Markdown {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * title
     */
    private String blogtitle;

    /**
     * time
     */
    private String writetime;

    /**
     * info
     */
    private String markdowninfo;

    /**
     * catefory
     */
    private String category;

    public Markdown() {}

    public Markdown(String blogtitle, String writetime, String markdowninfo, String category) {
        this.blogtitle = blogtitle;
        this.writetime = writetime;
        this.markdowninfo = markdowninfo;
        this.category = category;
    }

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

    public String getWritetime() {
        return writetime;
    }

    public void setWritetime(String writetime) {
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
}
