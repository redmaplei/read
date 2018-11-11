package com.wys.read.repository;

import com.wys.read.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 9:51 2018/10/6
 * @Modified By:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

}
