package com.example.demo.service.impl;

import com.example.demo.AyUserRepository;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.AyUser;
import com.example.demo.repo.AyUserDao;
import com.example.demo.service.AyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

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

    @Autowired
    private AyUserDao ayUserDao;

    @Override
    @Retryable(value = {BusinessException.class},backoff = @Backoff(delay = 5000,multiplier = 2))
    public AyUser findByNameAndPasswordRetry(String name, String password) {
        System.out.println("主动扔出异常，测试重试机制");
        throw new BusinessException();
    }

    @Override
    public AyUser findById(String id) {
        return null;
    }

    @Override
    public List<AyUser> findAll() {
        System.out.println("task...begin");
        long start=System.currentTimeMillis();
        List<AyUser> all = ayUserRepository.findAll();
        System.out.println("task...finish:"+(System.currentTimeMillis()-start)+"ms");
        return all ;
    }

    @Override
    @Async
    public Future<List<AyUser>> findAsynAll() {
        System.out.println("findAsynAll...begin");
        long start=System.currentTimeMillis();
        List<AyUser> all = ayUserRepository.findAll();
        System.out.println("findAsynAll...finish:"+(System.currentTimeMillis()-start)+"ms");
        return new AsyncResult<List<AyUser>>(all);
    }

    @Override
    public AyUser save(AyUser ayUser) {
        return ayUserRepository.save(ayUser);
    }

    @Override
    public void delete(String id) {
       ayUserRepository.deleteById(id);
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

    @Override
    public AyUser findByNameAndPassword(String name, String password) {
        return ayUserDao.findByNameAndPassword(name,password);
    }
}