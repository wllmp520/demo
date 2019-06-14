package com.example.demo.service.impl;

import com.example.demo.AyUserRepository;
import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @program: demo
 * @description:用户逻辑实现类
 * @author: wllmp520
 * @create: 2019-06-13 13:46
 */
@Service
public class AyUserServiceImpl implements AyUserService {
    @Autowired
    private AyUserRepository ayUserRepository;

    @Override
    public AyUser findById(String id) {
        return null;
    }

    @Override
    public List<AyUser> findAll() {
        return ayUserRepository.findAll();
    }

    @Override
    public AyUser save(AyUser ayUser) {
        return ayUserRepository.save(ayUser);
    }

    @Override
    public void delete(String id) {

    }

    /**
     *@Description: 分页
     *@Param: 
     *@date: 2019/6/13
     */
    @Override
    public Page<AyUser> findAll(Pageable pageable) {
        return ayUserRepository.findAll(pageable);//是父类PaginAndSortingRepository方法
    }

    @Override
    public List<AyUser> findByName(String name) {
        return ayUserRepository.findByName(name);
    }

    @Override
    public List<AyUser> findByNameLike(String name) {
        return ayUserRepository.findByNameLike(name);
    }

    @Override
    public List<AyUser> findByIdIn(Collection<String> ids) {
        return ayUserRepository.findByIdIn(ids);
    }
}