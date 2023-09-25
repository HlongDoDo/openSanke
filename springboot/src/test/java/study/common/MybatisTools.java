package study.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName MybatisTools
 * @Description TODO
 * @Author yuanpeng
 * @Date 2022/1/14 11:46
 **/
@Slf4j
public class MybatisTools {
    private static SqlSessionFactory SessionFactory;
    static {
        try {
            //加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            //构建sqlSession的工厂
            SessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            log.error("Failed to build session factory.", e);
        }
    }

    //对外提供可以获得sqlSession的方法
    public static SqlSession getSqlSession() {
        return  SessionFactory.openSession();
    }
}
