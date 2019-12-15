package com.mytest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MybatisTest {

    // 动态代理开发
    /**
     * Mapper接口开发需要遵循以下规范：
     * 1、Mapper.xml文件中的namespace与mapper接口的类路径相同。
     * 2、Mapper接口方法名和Mapper.xml中定义的每个statement的id相同
     * 3、Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql 的parameterType的类型相同
     * 4、Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同
     */

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        // 创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlsessionFactory
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void testQueryUserById() {
        // 获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        // 从sqlSession中获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询方法
        User user = userMapper.queryUserById(1);
        System.out.println(user);

        // 和spring整合后由spring管理
        sqlSession.close();
    }
}
