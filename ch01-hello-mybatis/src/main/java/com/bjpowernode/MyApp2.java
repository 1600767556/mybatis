package com.bjpowernode;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import java.io.IOException;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {
        final SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao"+"."+"selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        studentList.forEach(student -> System.out.println(student));
        sqlSession.close();

    }
}
