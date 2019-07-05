package org.jiang.dao;

import com.google.gson.Gson;
import org.jiang.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author Li.Linhua
 * @description TODO
 * @Date 2019/4/27 21:39
 */
@Repository
public class UserRedis {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void add(String key, long time, User user){
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        redisTemplate.opsForValue().set(key,userJson,time, TimeUnit.SECONDS);
    }

    public User get(String key){
        String userJson = redisTemplate.opsForValue().get(key);
        User user = null;
        if(userJson!=null&&userJson!=""){
            Gson gson = new Gson();
            user = gson.fromJson(userJson, User.class);
        }
        return user;
    }
}
