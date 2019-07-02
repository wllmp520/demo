package com.example.demo.service.impl;

import com.example.demo.model.AyRole;
import com.example.demo.model.AyUserRoleRel;
import com.example.demo.repo.AyRoleRepository;
import com.example.demo.repo.AyUserRoleRelRepository;
import com.example.demo.service.AyRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AyRoleServiceImpl implements AyRoleService {
    @Autowired
    private AyRoleRepository ayRoleRepository;
    @Autowired
    private AyUserRoleRelRepository ayUserRoleRelRepository;
    @Override
    public AyRole find(String id){
        return ayRoleRepository.findById(id).get();
    }

    @Override
    public List<AyUserRoleRel> findByUserId(String userId){
        return ayUserRoleRelRepository.findByUserId(userId);
    }

}
