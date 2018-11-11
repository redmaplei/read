package com.wys.read.service;

import com.wys.read.ReadApplication;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 11:51 2018/10/7
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReadApplication.class)
public class MarkdownServiceTest {

    @Autowired
    MarkdownService markdownService;

    private final Logger log = LoggerFactory.getLogger(MarkdownServiceTest.class);
//    @Test
//    public void uploadmd() {
//
//        Markdown markdown = new Markdown("aaaa", "twitch", "twitch", "twitch", "");
//
//        String s = markdownService.uploadmd(markdown);
//
//        log.info(" sss  {}", s);
//
//    }


}
