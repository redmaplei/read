package com.wys.read.domain;

import javax.persistence.*;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 16:28 2018/10/7
 * @Modified By:
 */

@Entity
@Table(name = "md_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * title
     */
    private String title;

    /**
     * category
     */
    private String category;

    public Category() {

    }

    public Category(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
