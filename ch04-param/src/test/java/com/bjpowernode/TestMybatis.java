package com.bjpowernode;


import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testselectStudentsById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1002);
        System.out.println("student="+student);

    }
    @Test
    public void testSelectMultiParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiParam("少司命", 22);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectMultiObject(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam param = new QueryParam();
        param.setParamAge(22);
        param.setParamName("焰灵姬");
        List<Student> students = dao.selectMultiObject(param);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectMultiStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setAge(22);
        student.setName("胡鑫亮");
        List<Student> students = dao.selectMultiStudent(student);
        for (Student stu : students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectUser$Order(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectUser$Order("age");
        for (Student stu : students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }


}
