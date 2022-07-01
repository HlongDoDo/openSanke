import com.alibaba.fastjson.JSON;
import com.study.my.CommonMain;
import com.study.my.entity.Roles;
import com.study.my.mapper.RolesMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

/**
 * @author huangsenwei
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonMain.class)
public class TestCommon {

    @Autowired
    RolesMapper mapper;

    @Test
    public void test1 (){
        Roles roles = mapper.selectByPrimaryKey(1);

        System.out.println(JSON.toJSONString(roles));
        System.out.println("123456789");
    }

}
