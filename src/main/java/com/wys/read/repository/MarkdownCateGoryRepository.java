package com.wys.read.repository;

import com.wys.read.domain.MarkdownCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 16:02 2018/10/6
 * @Modified By:
 */
@Repository
public interface MarkdownCateGoryRepository extends JpaRepository<MarkdownCategory, Long> {

    MarkdownCategory findMarkdownCategoryByCategory(String category);

}
