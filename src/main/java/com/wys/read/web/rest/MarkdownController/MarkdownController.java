package com.wys.read.web.rest.MarkdownController;

import com.wys.read.domain.Markdown;
import com.wys.read.service.MarkdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 16:21 2018/10/6
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/md")
public class MarkdownController {

    @Autowired
    MarkdownService markdownService;

    /**
     * 获取最新发布的5篇md
     * @return md
     */
    @GetMapping(value = "/getnewmd")
    public ResponseEntity<List<Markdown>> getNewmd() {

        List<Markdown> list = markdownService.getNewmd();

        return ResponseEntity.ok()
                .body(list);
    }



}
