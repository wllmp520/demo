package com.example.demo.repo;

import com.example.demo.model.AyUserRoleRel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*用户角色关联*/
public interface AyUserRoleRelRepository extends JpaRepository<AyUserRoleRel,String> {

    List<AyUserRoleRel> findByUserId(String userId);
}
