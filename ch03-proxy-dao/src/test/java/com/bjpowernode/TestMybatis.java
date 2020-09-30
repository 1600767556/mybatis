package com.bjpowernode;


import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testselectStudents(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void testinsertStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1013);
        student.setName("海问香");
        student.setEmail("海问香@qq.com");
        student.setAge(18);
        int nums = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("添加对象的数量:"+nums);
    }


}
