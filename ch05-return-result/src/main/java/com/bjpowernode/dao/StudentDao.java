package com.bjpowernode.dao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student selectStudentById(@Param("studentId") Integer id);

    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);
    ViewStudent selecetViewStudent (@Param("sid") Integer id);
    int countStudnet();
    Map<Object,Object> selectMapById(@Param("stuid") Integer id);
    List<Student> selectAllStudents();
    List<MyStudent> selectAllMyStudents();
    /**
     * 两种模糊查询
     */
    List<Student> selectLikeOne(String name);

    List<Student> selectLikeTwo(String name);
}
