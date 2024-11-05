package com.nianxi.service;

import com.nianxi.entity.Student;

import java.util.List;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/4
 * @version: 1.0
 */
public interface StudentService {
    /**
     * 查询所有学生信息
     */
    List<Student> queryListStudent();
    /**
     * 查询单个学生信息
     */
    void queryStudent(String Sno);
    /**
     * 添加学生信息
     */
    void addStudent(Student student);
    /**
     * 删除学生信息
     */
    void deleteStudent(String Sno);
    /**
     * 修改学生信息
     */
    void updateStudent(String oldSno);
}
