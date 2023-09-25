package study;

import com.study.my.entity.FsmpRwhAppInfo;
import com.study.my.mapper.FsmpRwhAppInfoMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import study.common.MybatisTools;
import java.sql.SQLException;


/**
 * @author huangsenwei
 * @Description
 */

@RunWith(JUnit4.class)
public class AnyTest {
    @Test
    public static void main(String[] args) throws SQLException {
        SqlSession sqlSession = MybatisTools.getSqlSession();



        FsmpRwhAppInfoMapper mapper = sqlSession.getMapper(FsmpRwhAppInfoMapper.class);
        FsmpRwhAppInfo fsmpRwhAppInfo = mapper.selectByPrimaryKey(1);
        System.out.println("fsmpRwhAppInfo = " + fsmpRwhAppInfo);
        fsmpRwhAppInfo = null;
        Assert.assertNotNull(fsmpRwhAppInfo);
    }
}
