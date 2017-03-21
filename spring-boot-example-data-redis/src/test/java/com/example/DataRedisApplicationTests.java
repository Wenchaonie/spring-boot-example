package com.example;

import com.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataRedisApplicationTests {

    private static Logger logger = Logger.getGlobal();

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, User> userRedisTemplate;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setId(2L);
        user.setUsername("conanli");
        user.setPassword("123456");

        userRedisTemplate.opsForHash().put("USER", user.getId().toString(), user);

        User existedUser = (User) userRedisTemplate.opsForHash().get("USER", user.getId().toString());
        logger.info(String.format("existed user: %s", existedUser));

        userRedisTemplate.opsForHash().delete("USER", user.getId().toString());
    }

}
