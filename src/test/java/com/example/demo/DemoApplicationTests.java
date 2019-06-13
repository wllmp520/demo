package com.example.demo;

import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest//引入了入口类的配置
public class DemoApplicationTests {

    @Autowired
    private AyUserService ayUserService;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {
    }

    //测试集成mysql
    @Test
    public void mysqlTest(){
        String sql = "select * from ay_user";
        List<AyUser> userlIST=jdbcTemplate.query(sql,new RowMapper<AyUser>(){
            @Override
            public AyUser mapRow(ResultSet rs,int rowNum) throws SQLException{
                AyUser user=new AyUser();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                return user;
            };
        });
        System.out.println("查询成功");
        for (AyUser ayUer : userlIST) {
            System.out.println(ayUer.getId());
        }
    }
    //测试集成spring-dataJPA
    @Test
    public void testRepository(){
        //查询所有数据
        List<AyUser> users= ayUserService.findAll();
        System.out.println("findAll()"+users.size());

        //name查询
        List<AyUser> user2= ayUserService.findByName("wl");
        System.out.println("findByName()"+user2.size());
        Assert.assertTrue("data error",user2.get(0).getName().equals("wl"));

        //name模糊查询
        List<AyUser> user3= ayUserService.findByNameLike("%wl%");
        System.out.println("findByNameLike()"+user3.size());
        Assert.assertTrue("data error",user3.get(0).getName().equals("wl"));

        //id列表查询数据
        List<String> ids=new ArrayList<String>();
        ids.add("1");
        ids.add("2");
        List<AyUser> user4= ayUserService.findByIdIn(ids);
        System.out.println("findByIdIn()"+user4.size());

        //新增数据
        AyUser ayUser=new AyUser();
        ayUser.setId("3");
        ayUser.setName("wl");
        ayUser.setPassword("999");
        ayUserService.save(ayUser);

        //分页查询
        PageRequest pageRequest=PageRequest.of(0,10);
        Page<AyUser> user5=ayUserService.findAll(pageRequest);
        System.out.println("findAll(pageRequest)"+user5.getTotalPages());
    }
}
