package com.example.demo;

import com.example.demo.activemq.AyMoodProducer;
import com.example.demo.model.AyMood;
import com.example.demo.model.AyUser;
import com.example.demo.service.AyMoodService;
import com.example.demo.service.AyUserService;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest//引入了入口类的配置
public class DemoApplicationTests {
    @Autowired
    private  AyMoodProducer ayMoodProducer;
    @Autowired
    private AyMoodService ayMoodService;

    @Autowired
    private AyUserService ayUserService;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
    //测试集成redis
    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("name","wl");
        String name= (String) redisTemplate.opsForValue().get("name");
       // System.out.println(name);
        stringRedisTemplate.opsForValue().set("it","lmp");
        System.out.println(stringRedisTemplate.opsForValue().get("it"));
    }

    //测试集成mybatis
    @Test
    public void testMybatis(){
        AyUser ayUser= ayUserService.findByNameAndPassword("b","9998");
        Assert.assertNotNull(ayUser);
    }

    @Test
    public void testAyMood(){
        AyMood ayMood=new AyMood();
        ayMood.setId("1");
        ayMood.setUserId("1");
        ayMood.setPraiseNum(0);
        ayMood.setContent("第一条微信说说");
        ayMood.setPublishTime(new Date());
        ayMoodService.save(ayMood);
    }

    @Test
    public void testActiveMQ1(){
       Destination destination=new ActiveMQQueue("ayqueue");
       ayMoodProducer.sendMessage(destination,"初步试用ActivMQ");
    }
    @Test
    public void testActiveMQ2(){
        //模拟用户发表微信说说
        AyMood ayMood=new AyMood();
        ayMood.setId("2");
        ayMood.setUserId("2");
        ayMood.setPraiseNum(0);
        ayMood.setContent("第二条微信说说");
        ayMood.setPublishTime(new Date());
        String status= ayMoodService.aysncSave(ayMood);
        System.out.println("异步消息发送:"+status);
    }
    @Test
    public void testAsync() throws InterruptedException{
       /* System.out.println("beginSynchroTest...");
        long start=System.currentTimeMillis();
        ayUserService.findAll();
        ayUserService.findAll();
        ayUserService.findAll();
        System.out.println("endSynchroTest..."+(System.currentTimeMillis()-start)+"ms");
*/
        System.out.println("beginfindAsynAllTest...");
        long start1=System.currentTimeMillis();
        Future<List<AyUser>> asynAll = ayUserService.findAsynAll();
        Future<List<AyUser>> all = ayUserService.findAsynAll();
        Future<List<AyUser>> all1 = ayUserService.findAsynAll();
        while (true){
            if(asynAll.isDone() && all.isDone() && all1.isDone()) break;
            else Thread.sleep(10);
        }
        System.out.println("endfindAsynAllTest..."+(System.currentTimeMillis()-start1)+"ms");
    }
}
