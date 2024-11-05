package com.nianxi.mapper;

import com.nianxi.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/4
 * @version: 1.0
 */
@Mapper
public interface StudentMapper {
    /**
     * 添加学生信息
     *
     * @param student
     */
    void addStudent(Student student);

    /**
     * 删除学生信息
     */
    void deleteStudent(@Param("sno") String sno);

    /**
     * 修改学生信息
     */
    void updateStudent(@Param("student") Student student, @Param("oldSno") String oldSno);


    /**
     * 查询单个学生信息
     *
     * @param Sno
     * @return
     */
    Student queryStudent(String Sno);

    /**
     * 查询所有学生信息
     *
     * @return
     */
    List<Student> queryListStudent();

    /**
     * 禁用外键约束
     */
    void disableForeignKeyChecks();

    /**
     * 启用外键约束
     */
    void enableForeignKeyChecks();
}
