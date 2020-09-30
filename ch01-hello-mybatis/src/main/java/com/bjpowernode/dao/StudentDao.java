package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 查询student的所有数据
     * @return
     */
    public List<Student> selectStudents();
    public int insertStudents(Student student);
}
