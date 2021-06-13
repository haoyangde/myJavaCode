package com.mytest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisTest {

    public static void main(String[] args) throws Exception {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 3. 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行查询，获取结果User
        // 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
        Object user = sqlSession.selectOne("test.queryUserById", 1);

        // 6. 打印结果
        System.out.println("user = " + user.toString());


        // 7. 释放资源
        sqlSession.close();
    }
}
