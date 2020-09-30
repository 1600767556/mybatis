package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    /**
     * 一个简单类型的参数
     * @param id
     * @return
     */
    public Student selectStudentById(@Param("studentId") Integer id);
    /**
     * 多个参数:命名参数
     */
    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);
    List<Student> selectMultiObject(QueryParam queryParam);
    List<Student> selectMultiStudent(Student student);
    List<Student> selectUser$Order(@Param("colName") String colName);
}
