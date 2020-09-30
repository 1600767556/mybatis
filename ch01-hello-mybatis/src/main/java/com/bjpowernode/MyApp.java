package com.bjpowernode;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        //1.mybatis主配置文件
        String config = "mybatis.xml";
        //2. 读取配置文件
         InputStream in = Resources.getResourceAsStream(config);
         SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3. 创建 SqlSessionFactory 对象 , 目的是获取 Sql Session
        SqlSessionFactory factory = builder.build(in);
        //4. 获取 SqlSession,SqlSession 能执行 sql 语句
        SqlSession sqlSession = factory.openSession();
        //5. 执行 SqlSession 的 selectList()
        String sqlId = "com.bjpowernode.domain.dao.StudentDao"+"."+"selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        studentList.forEach(student -> System.out.println(student));
        sqlSession.close();

    }
}
