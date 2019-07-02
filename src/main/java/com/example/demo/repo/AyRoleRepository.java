package com.example.demo.repo;

import com.example.demo.model.AyRole;
import org.springframework.data.jpa.repository.JpaRepository;

/*用户角色
* */
public interface AyRoleRepository extends JpaRepository<AyRole,String> {
}
