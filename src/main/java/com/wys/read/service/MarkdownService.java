package com.wys.read.service;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.sun.javafx.scene.traversal.Direction;
import com.wys.read.domain.Markdown;
import com.wys.read.repository.MarkdownRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 16:32 2018/10/6
 * @Modified By:
 */
@Service
public class MarkdownService {

    @Autowired
    MarkdownRepository markdownRepository;


    /**
     * 获取最新发布的50篇md
     * @return
     */
    public List<Markdown> getNewmd() {

        List<Markdown> list = markdownRepository.findMarkdownsByTimeLimit();

        return list;
    }

    /**
     * 分页查询 一页查10条数据
     * @return
     */
    public List<Markdown> getPagemd() {

        //markdownRepository.findAll()


        return null;
    }

}
