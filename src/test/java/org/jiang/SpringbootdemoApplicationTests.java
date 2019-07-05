package org.jiang;

import org.jiang.dao.UserRedis;
import org.jiang.demo.domain.Person;
import org.jiang.dao.UserRepository;
import org.jiang.domain.MybatisDepartment;
import org.jiang.domain.User;
import org.jiang.mapper.MybatisDepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.Iterator;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Person person;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRedis userRedis;
    @Autowired
    private MybatisDepartmentMapper mybatisDepartmentMapper;

    @Test
    public void contextLoads() {
        System.out.println(person.toString());
    }

    @Test
    public void logTest() {
        //日志的级别；
        //由低到高   trace<debug<info<warn<error
        //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }

    @Test
    public void jpaTest(){
        User user = new User();
        user.setName("admin2");
        user.setPwd("111111");
        User save = userRepository.save(user);
        System.out.println(save.toString());
    }

    @Test
    public void japPageTest(){
        PageRequest pageRequest = new PageRequest(1,10);
        Page<User> users = userRepository.findAll(pageRequest);
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            System.out.println(next);
        }
    }
    
    @Test
    public void redisTest(){
        Optional<User> byId = userRepository.findById("1");
        User user = byId.get();
        user.setName(user.getName()+"_redis");
        userRedis.add("1",30,user);
        User user1 = userRedis.get("1");
        System.out.println(user1.toString());
    }

    @Test
    public void mybatisTest(){
        MybatisDepartment mybatisDepartment = new MybatisDepartment();
        mybatisDepartment.setDepartmentName("测试部门2");
        mybatisDepartmentMapper.insert(mybatisDepartment);
    }
}
