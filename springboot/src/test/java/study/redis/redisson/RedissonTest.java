package study.redis.redisson;

import com.SpringBootMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author huangsenwei
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMain.class)
public class RedissonTest {

    @Resource
    RedissonClient redis;

    @Test
    public void testRedisson(){
        System.out.println(redis.getAtomicLong("name"));
    }

}
