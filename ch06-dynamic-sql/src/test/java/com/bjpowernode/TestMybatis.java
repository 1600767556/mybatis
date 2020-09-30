package com.bjpowernode;


import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMybatis {
    @Test
    public void testselectStudentsIf(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students =  dao.selectStudentIf(student);
        for (Student student1 : students) {
            System.out.println("if=="+student1);
        }

    }
    @Test
    public void testselectStudentsWhere(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students =  dao.selectStudentWhere(student);
        for (Student student1 : students) {
            System.out.println("if=="+student1);
        }

    }
    @Test
    public void testselectForeachOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list  = new ArrayList<Integer>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students =  dao.selectForeachOne(list);
        for (Student student1 : students) {
            System.out.println("if=="+student1);
        }

    }
    @Test
    public void testselectForeachTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> stuList  = new ArrayList<Student>();
        Student s1 = new Student();
        s1.setId(1001);
        stuList.add(s1);
        s1 = new Student();
        s1.setId(1008);
        stuList.add(s1);
        List<Student> students =  dao.selectForeachTwo(stuList);
        for (Student student1 : students) {
            System.out.println("if=="+student1);
        }

    }
    @Test
    public void testselectAllPageHelper(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        PageHelper.startPage(3,3);
        List<Student> students =  dao.selectAll();
        for (Student student1 : students) {
            System.out.println(student1);
        }

    }


}
