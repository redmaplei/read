package com.wys.read.domain;

import javax.persistence.*;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 15:56 2018/10/6
 * @Modified By:
 */

@Entity
public class MarkdownCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * category
     */
    private String category;

    /**
     * count
     */
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
