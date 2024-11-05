package com.nianxi.service.Impl;

import com.nianxi.entity.Course;
import com.nianxi.entity.StuGradeVO;
import com.nianxi.entity.Student;
import com.nianxi.mapper.CourseMapper;
import com.nianxi.mapper.ScMapper;
import com.nianxi.mapper.StudentMapper;
import com.nianxi.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/4
 * @version: 1.0
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ScMapper scMapper;

    /**
     * 添加学生信息
     * @param student
     */
    @Override
    public void addStudent(Student student) {
        Scanner sc = new Scanner(System.in);

        if (student.getSno() == null || student.getSno().isEmpty()) {
            System.out.println("学号不能为空,请重新输入");
            String sno = sc.next();
            student.setSno(sno);
        }

        if (student.getSname() == null || student.getSname().isEmpty()) {
            System.out.println("姓名不能为空,请重新输入");
            String sname = sc.next();
            student.setSname(sname);
        }

        if (student.getSsex() == null || student.getSsex().isEmpty()) {
            System.out.println("性别不能为空,请重新输入");
            String ssex = sc.next();
            student.setSsex(ssex);
        }

        if (student.getSage() == null || student.getSage().isEmpty()) {
            System.out.println("年龄不能为空,请重新输入");
            String sage = sc.next();
            student.setSage(sage);
        }

        if (student.getSdept() == null || student.getSdept().isEmpty()) {
            System.out.println("系别不能为空,请重新输入");
            String sdept = sc.next();
            student.setSdept(sdept);
        }

        studentMapper.addStudent(student);
        System.out.println("添加学生信息成功");
    }


    /**
     * 删除学生信息
     * @param Sno
     */
    @Override
    public void deleteStudent(String Sno) {
        Scanner scanner = new Scanner(System.in);
        Student student = studentMapper.queryStudent(Sno);
        if (student == null) {
            System.out.println("查询到的学生信息为空,请重新输入学号 输入n退出");
            String newSno = scanner.next();
            if ("n".equals(newSno)) {
                return;
            }
            deleteStudent(newSno);
        } else {
            scMapper.deleteSc(Sno);
            studentMapper.deleteStudent(Sno);
            System.out.println("删除学生信息成功");
        }
    }

    /**
     * 修改学生信息
     * @param oldSno
     */
    @Override
    public void updateStudent(String oldSno) {
        Scanner scanner = new Scanner(System.in);
        Student student1 = studentMapper.queryStudent(oldSno);
        boolean flag = false;
        if (student1 == null) {
            System.out.println("查询到的学生信息为空,请重新输入学号 输入n退出");
            oldSno = scanner.next();
            if ("n".equals(oldSno)) {
                return;
            }
            updateStudent(oldSno);
        } else {
            System.out.println("请输入新学号: ");
            String newSno = scanner.next();
            System.out.print("请输入新姓名: ");
            String Sname = scanner.next();
            System.out.print("请输入新性别: ");
            String Ssex = scanner.next();
            System.out.print("请输入新年龄: ");
            String Sage = scanner.next();
            System.out.print("请输入新系别: ");
            String Sdept = scanner.next();
            Student student = new Student(newSno, Sname,Ssex,Sage,Sdept);
            List<StuGradeVO> stuGradeVO = scMapper.querySc(oldSno);
            if (stuGradeVO != null) {
                flag = true;
            }
            studentMapper.disableForeignKeyChecks();
            if (flag) {
                scMapper.updateSc(newSno, oldSno);
            }
            studentMapper.updateStudent(student, oldSno);
            studentMapper.enableForeignKeyChecks();
            System.out.println("修改学生信息成功");
        }
    }

    /**
     * 查询单个学生信息
     */
    @Override
    public void queryStudent(String Sno) {
        Student student = studentMapper.queryStudent(Sno);
        if (student == null) {
            System.out.println("查询到的学生信息为空,请重新输入学号 输入n退出");
            Scanner scanner = new Scanner(System.in);
            String sno = scanner.next();
            if ("n".equals(sno)) {
                return;
            }
            queryStudent(sno);
        }else {
            System.out.println("查询到的学生信息为：" + student);
        }
    }

    /**
     * 查询所有学生信息
     */
    @Override
    public List<Student> queryListStudent() {
        List<Student> students = studentMapper.queryListStudent();
        if (students.isEmpty()) {
            log.info("查询到的学生信息为空");
            throw new RuntimeException("查询到的学生信息为空");
        }
        System.out.println("查询到的学生信息为：");
        for (Student student : students) {
            log.info("查询到的学生信息为：{}", student);
            System.out.println(student);
        }
        return students;
    }
}
