package com.example.demo.service;

import com.example.demo.model.AyRole;
import com.example.demo.model.AyUserRoleRel;

import java.util.List;

public interface AyRoleService {
    AyRole find(String id);

    List<AyUserRoleRel> findByUserId(String userId);
}
