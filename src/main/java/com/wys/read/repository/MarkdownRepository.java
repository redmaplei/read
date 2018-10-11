package com.wys.read.repository;

import com.wys.read.domain.Markdown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 16:01 2018/10/6
 * @Modified By:
 */
@Repository
public interface MarkdownRepository extends JpaRepository<Markdown, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM markdown ORDER BY writetime DESC LIMIT 5")
    List<Markdown> findMarkdownsByTimeLimit();

    @Query(nativeQuery = true, value = "select * from markdown limit ?1,?2")
    List<Markdown> findMarkdownsByPage(int page, int size);

}
