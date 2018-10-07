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
    private String title;

    /**
     * time
     */
    private String time;

    /**
     * info
     */
    private String info;

    /**
     * catefory
     */
    private String category;

    public Markdown() {}

    public Markdown(String title, String time, String info, String category) {
        this.title = title;
        this.time = time;
        this.info = info;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
