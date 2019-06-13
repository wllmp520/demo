package com.example.demo;

import com.example.demo.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 *@Description: 用户Dao层
 *@Param:
 *@date: 2019/6/13
 */
@Repository
public interface AyUserRepository extends JpaRepository<AyUser,String> {
    //自定义符合JPA规范的方法
    List<AyUser> findByName(String name);

    List<AyUser> findByNameLike(String name);

    List<AyUser> findByIdIn(Collection<String> ids);
}
