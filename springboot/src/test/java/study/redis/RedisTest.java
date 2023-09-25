package study.redis;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.SpringBootMain;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;

/**
 * @author huangsenwei
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMain.class)
public class RedisTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void stringKeyTest() {
        ValueOperations<String, String> op = stringRedisTemplate.opsForValue();
        op.set("tianzheng", "nihaotianzhen");
        System.out.println(op.get("tianzheng"));
    }

    @Test
    public void setSet() {
        SetOperations op = redisTemplate.opsForSet();
        op.add("hhh", 8, 7, 7);
    }

    @Test
    public void menberSet() {
        SetOperations op = redisTemplate.opsForSet();
        System.out.println(op.members("hhh"));
    }

    @Test
    public void setHash() {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("hash", "name", "huang");
    }

    @Test
    public void doScript() {
//            String script = " redis.call('RPUSH', KEYS[1], ARGV[1])  redis.call('EXPIRE', KEYS[1], ARGV[2]); ";
//          String script =
//                  "local isExists = redis.call('EXISTS',KEYS[1])" +
//                  "if isExists == 1 then" +
//                  "    redis.call('RPUSH',KEYS[1],ARGV[1])" +
//                  "end" +
//                  "if isExists == 0 then" +
//                  "  redis.call('RPUSH', KEYS[1], ARGV[1])" + " redis.call('EXPIRE', KEYS[1], ARGV[2])" +
//                  "end"  +
//                  "return redis.call('llen',KEYS[1]);" ;
//          String script =
//                  "local isExists = redis.call('EXISTS',KEYS[1]) if isExists == 1 then redis.call('RPUSH',KEYS[1],ARGV[1]) end  if isExists == 0 then  redis.call('RPUSH', KEYS[1], ARGV[1])  redis.call('EXPIRE', KEYS[1], ARGV[2]) end  return redis.call('llen',KEYS[1]);" ;

//        String script =
//                "local isExists = redis.call('EXISTS',KEYS[1]) if isExists == 1 then redis.call('SADD',KEYS[1],ARGV[1]) end  if isExists == 0 then  redis.call('SADD', KEYS[1], ARGV[1])  redis.call('EXPIRE', KEYS[1], ARGV[2]) end  return redis.call('SCARD',KEYS[1]);" ;

        String script =
                "local isExists = redis.call('EXISTS',KEYS[1]) if isExists == 1 then redis.call('incr',KEYS[1]) end  if isExists == 0 then  redis.call('incr', KEYS[1])  redis.call('EXPIRE', KEYS[1], ARGV[1]) end ;" ;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTimeUtil.beginOfDay(now.plusDays(1L)) ;
        int expireTime = (int) LocalDateTimeUtil.between(now, localDateTime, ChronoUnit.SECONDS);
       stringRedisTemplate.execute(new
                DefaultRedisScript<>(script, Long.class), Arrays.asList("sososokkkss"), String.valueOf(expireTime));


        String sososokkkss = stringRedisTemplate.opsForValue().get("sososokkkss");

        System.out.println(StringUtils.isBlank(sososokkkss));

        System.out.println(sososokkkss);

        Integer integer = Integer.valueOf(sososokkkss);
        System.out.println(integer);

    }
}
