package cn.edu.learn.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * redisѧϰ
 */
public class TestRedis {

    Jedis jedis = null;

    @Before
    public void init() {
        jedis = new Jedis("192.168.182.134");
        System.out.println("connection to server sucess fully");
    }

    /**
     * ������redis������������
     */
    @Test
    public void testRedisConnection() {
        System.out.println("Server is running" + jedis.ping());
    }

    /**
     * ���string
     */
    @Test
    public void testString() {
        jedis.set("name", "dave");
        System.out.println("Get data form redis" + " name: " + jedis.get("name"));
    }

    /**
     * ���list��list���Ϳ���
     */
    @Test
    public void testList() {
        jedis.lpush("friendList", "dave");
        jedis.lpush("friendList", "java");
        jedis.lpush("friendList", "Jack");

        List<String> friends = jedis.lrange("friendList", 0, 3);
        System.out.println(friends.size());
        for (String str : friends)
            System.out.println(str);
    }

    /**
     * ����hash
     */
    @Test
    public void testHash() {
        Map<String, String> userField = new HashMap<String, String>();
        userField.put("name", "dave");
        userField.put("age", "10");
        userField.put("gender", "male");
        jedis.hmset("user:1", userField);
        System.out.println(jedis.hget("user:1", "name"));
        jedis.hincrBy("user:1", "age", 10);
        System.out.println(jedis.hget("user:1", "age"));
    }
}
