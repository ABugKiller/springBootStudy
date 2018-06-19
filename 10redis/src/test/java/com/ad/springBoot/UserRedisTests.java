package com.ad.springBoot;

import com.ad.springBoot.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ZhengYingDeng
 * @email 892467242@qq.com
 * @create 14:23 2018/6/19
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRedisTests {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void test() throws Exception {

        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        User user1 = redisTemplate.opsForValue().get("超人");
        User user2 = redisTemplate.opsForValue().get("蝙蝠侠");
        User user3 = redisTemplate.opsForValue().get("蜘蛛侠");
        System.out.println("a");
    }
}
