package com.bjpowernode;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    //测试方法,测试功能
    @Test
    public void testInsert() throws IOException {
        //1.mybatis主配置文件
        String config = "mybatis.xml";
        //2. 读取配置文件
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3. 创建 SqlSessionFactory 对象 , 目的是获取 Sql Session
        SqlSessionFactory factory = builder.build(in);
        //4. 获取 SqlSession,SqlSession 能执行 sql 语句
        /*SqlSession sqlSession = factory.openSession();*/
        SqlSession sqlSession = factory.openSession(true);
        String sqlId = "com.bjpowernode.domain.dao.StudentDao"+"."+"insertStudents";
        Student student = new Student();
        student.setId(1011);
        student.setName("少司命");
        student.setEmail("shaosiming@qq.com");
        student.setAge(18);
        int numbers = sqlSession.insert(sqlId,student);
       /* sqlSession.commit();*/
        System.out.println("执行insert结果:"+numbers);
        sqlSession.close();


    }

}
