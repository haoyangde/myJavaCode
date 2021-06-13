package com.mytest;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserMapper{

    public User queryUserById(int id) {
        // 获取SqlSession
        SqlSession sqlSession = super.getSqlSession();

        // 使用SqlSession执行操作
        User user = sqlSession.selectOne("com.mytest.UserMapper.queryUserById", id);

        // 不要关闭sqlSession

        return user;
    }
}
