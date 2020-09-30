package com.bjpowernode;

import com.bjpowernode.dao.Impl.StudentDaoImpl;
import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testselectStudents(){
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void testinsertStudent(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1012);
        student.setName("焰灵姬");
        student.setEmail("yanlingji@qq.com");
        student.setAge(18);
        int nums = studentDao.insertStudent(student);
        System.out.println("添加对象的数量:"+nums);

    }


}
