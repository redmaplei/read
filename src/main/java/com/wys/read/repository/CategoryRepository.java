package com.wys.read.repository;

import com.wys.read.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 16:30 2018/10/7
 * @Modified By:
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    int countByCategory(String category);

}
