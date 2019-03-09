package com.keymao.jedis;

import com.keymao.common.jedis.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class JedisTest {
    @Test
    public  void testJedisCluster(){
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.27.106",7001));
        nodes.add(new HostAndPort("192.168.27.106",7002));
        nodes.add(new HostAndPort("192.168.27.106",7003));
        nodes.add(new HostAndPort("192.168.27.106",7004));
        nodes.add(new HostAndPort("192.168.27.106",70015));
        nodes.add(new HostAndPort("192.168.27.106",7006));
        JedisCluster jedisCluster  = new JedisCluster(nodes);

        jedisCluster.set("hello","xiaojm");
        String str = jedisCluster.get("hello");
        System.out.println(str);
        jedisCluster.close();
    }



}
