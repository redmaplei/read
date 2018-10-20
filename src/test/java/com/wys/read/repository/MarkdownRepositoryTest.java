package com.wys.read.repository;

import com.wys.read.ReadApplication;
import com.wys.read.domain.Markdown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 17:34 2018/10/6
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReadApplication.class)
public class MarkdownRepositoryTest {

    @Autowired
    MarkdownRepository markdownRepository;

    private final Logger log = LoggerFactory.getLogger(MarkdownRepositoryTest.class);

    @Test
    public void s() {

        List<Markdown> list = markdownRepository.findMarkdownsByTimeLimit();
        log.info("list ========================  {}",list.get(4).getWritetime());

    }

    @Test
    public void ss() {

        markdownRepository.findAll();

    }

    @Test
    public void page() {

        List<Markdown> list = markdownRepository.findMarkdownsByPage(2, 2);
        log.info("list ========================  {} {}",list.get(0).getWritetime());

    }

}
