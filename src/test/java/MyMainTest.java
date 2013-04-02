import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import per.liu.mapper.UserMapper;
import per.liu.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: liu
 * Date: 13-4-2
 * Time: 下午3:05
 */
public class MyMainTest {

    private SqlSession sqlSession = null;

    private SqlSessionFactory getFactory() throws IOException {
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();//指定mybatis日志打印器
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    private void setSqlSession() throws IOException {
//        默认的 openSession()方法没有参数,它会创建有如下特性的 SqlSession:
//
//           会开启一个事务(也就是不自动提交)
//           连接对象会从由活动环境配置的数据源实例中得到。
//           事务隔离级别将会使用驱动或数据源的默认设置。
//           预处理语句不会被复用,也不会批量处理更新。

        sqlSession = getFactory().openSession();
    }

    private void setSpecialSqlSession() throws IOException {

//        ExecutorType.SIMPLE: 这个执行器类型不做特殊的事情。它为每个语句的执行创建一个新的预处理语句。
//        ExecutorType.REUSE: 这个执行器类型会复用预处理语句。
//        ExecutorType.BATCH: 这个执行器会批量执行所有更新语句,如果 SELECT 在它们中间执行还会标定它们是 必须的,来保证一个简单并易于理解的行为。
        sqlSession = getFactory().openSession(ExecutorType.BATCH, true);
    }

    @Test
    public void testXml() throws IOException {
        setSqlSession();
        try {
            List<User> user = sqlSession.selectList("per.liu.mapper.UserMapper.getUsers");
            System.out.println(1);

        } finally {
            sqlSession.close();
        }

        System.out.println();
    }

    @Test
    public void testInterface() throws IOException {
        setSqlSession();
        try {
            List<User> user = sqlSession.selectList("per.liu.mapper.UserMapper.selectOne", 1);
//            User user = (User)sqlSession.selectOne("per.liu.mapper.UserMapper.selectOne",1);
            System.out.println(1);

        } finally {
            sqlSession.close();
        }
        System.out.println();
    }

    @Test
    public void testInterfaceFromJavaMapper() throws IOException {
        setSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = mapper.selectOne(10066);
//            User user = (User)sqlSession.selectOne("per.liu.mapper.UserMapper.selectOne",1);
            System.out.println(1);

        } finally {
            sqlSession.close();
        }
        System.out.println();
    }

    @Test
    public void testInsert() throws IOException {
        setSpecialSqlSession();
        try {
            User user = new User();
            user.setDescn("come from mybatis-ORM");
            user.setUsername("liu-test7");
            user.setPassword("the pass");
//             user.setStatus(1);
            sqlSession.insert("per.liu.mapper.UserMapper.insert", user);
            sqlSession.commit();
            System.out.println(1);

        } finally {
            sqlSession.close();
        }
        System.out.println();


    }

    @Test
    public void testSeniorMapper() throws IOException {
        setSqlSession();
        try {
//             List<User> user = sqlSession.selectList("per.liu.mapper.UserMapper.selectOne", 1);
            List<User> users = sqlSession.selectList("per.liu.mapper.UserMapperS.selectAllUser", 1);
            System.out.println(1);

        } finally {
            sqlSession.close();
        }
        System.out.println();
    }

}
