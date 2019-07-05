package org.jiang;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Li.Linhua
 * @description TODO
 * @Date 2019/5/16 13:24
 */
public class MyTest {

    @Test
    public void test(){
        //服务IP
        String ip = "172.168.x.y";
        Set sentinels = new HashSet();
        //Sentine端口
        sentinels.add(new HostAndPort(ip, 26379).toString());
        sentinels.add(new HostAndPort(ip, 26380).toString());
        JedisSentinelPool sentinelPool = new JedisSentinelPool("master1", sentinels);
        System.out.println("Current master: " + sentinelPool.getCurrentHostMaster().toString());
        Jedis master = sentinelPool.getResource();
        master.set("username","liangzhichao");
//        sentinelPool.returnResource(master);
        Jedis master2 = sentinelPool.getResource();
        String value = master2.get("username");
        System.out.println("username: " + value);
        master2.close();
        sentinelPool.destroy();
    }
}
