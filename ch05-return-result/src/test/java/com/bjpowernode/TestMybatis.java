package com.bjpowernode;


import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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
    public void testselectStudentsId(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        ViewStudent student = dao.selecetViewStudent(1005);
        System.out.println("student="+student);

    }
    @Test
    public void testselectCountStudnet(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int student = dao.countStudnet();
        System.out.println(student);

    }
    @Test
    public void testselectMapStudnetById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object,Object> map = dao.selectMapById(1005);
        System.out.println(map);

    }
    @Test
    public void testSelectAllStudnets(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectAllMyStudnets(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectAllMyStudents();
        for (MyStudent student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectLikeOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectLikeOne("%少%");
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectLikeTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectLikeTwo("胡");
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
