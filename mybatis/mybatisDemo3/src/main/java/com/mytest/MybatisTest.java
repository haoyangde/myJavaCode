package com.mytest;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisTest {

    // mybatis spring 整合
    /**
     * 整合思路
     * 1、SqlSessionFactory对象应该放到spring容器中作为单例存在。
     * 2、传统dao的开发方式中，应该从spring容器中获得sqlsession对象。
     * 3、Mapper代理形式中，应该从spring容器中直接获得mapper的代理对象。
     * 4、数据库的连接以及数据库连接池事务管理都交给spring容器来完成。
     */

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testQueryUserById() {
        // 获取userDao
        UserMapper userMapper = this.context.getBean(UserMapper.class);

        User user = userMapper.queryUserById(1);
        System.out.println(user);
    }

}
