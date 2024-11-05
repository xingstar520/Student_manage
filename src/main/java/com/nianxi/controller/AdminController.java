package com.nianxi.controller;

import com.nianxi.common.Result;
import com.nianxi.entity.Course;
import com.nianxi.entity.StuGradeVO;
import com.nianxi.entity.Student;
import com.nianxi.service.CourseService;
import com.nianxi.service.ScService;
import com.nianxi.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/5
 * @version: 1.0
 */
@Controller
@Slf4j
public class AdminController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ScService scService;

    /**
     * 查询所有学生信息
     */
    public Result<List<Student>> queryListStudent() {
        List<Student> students = studentService.queryListStudent();
        return Result.success(students);
    }
    /**
     * 根据学号查询单个学生信息
     * @param sno
     */
    public Result<Student> queryStudent(String sno) {
        studentService.queryStudent(sno);
        return Result.success();
    }

    /**
     * 根据课程号查询课程信息
     * @param Cno
     * @return
     */
    public Result<Course> queryCourse(String Cno) {
        courseService.queryCourse(Cno);
        return Result.success();
    }

    /**
     * 根据学号查询选课信息及姓名成绩
     * @param Sno
     * @return
     */
    public Result<List<StuGradeVO>> querySc(String Sno) {
        List<StuGradeVO> stuGradeVOS = scService.querySc(Sno);
        return Result.success(stuGradeVOS);
    }

    /**
     * 添加学生信息
     * @return
     */
    public Result addStudent(Student student) {
        studentService.addStudent(student);
        return Result.success();
    }

    /**
     * 根据学号删除学生信息
     * @return
     */
    public Result deleteStudent(String Sno) {
        studentService.deleteStudent(Sno);
        return Result.success();
    }

    /**
     * 更新学生信息
     * @return
     */
    public Result<Student> updateStudent(String oldSno) {
        studentService.updateStudent(oldSno);
        return Result.success();
    }

    /**
     * 退出系统
     * @return
     */
    public Result exit() {
        System.exit(0);
        return Result.success();
    }
}
