package com.nianxi;

import com.nianxi.controller.AdminController;
import com.nianxi.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.Scanner;

@Slf4j
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminController adminController = context.getBean(AdminController.class);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    adminController.queryListStudent();
                    break;
                }
                case 2: {
                    System.out.print("请输入学生学号: ");
                    String sno = scanner.next();
                    adminController.queryStudent(sno);
                    break;
                }
                case 3: {
                    System.out.print("请输入课程编号: ");
                    String cno = scanner.next();
                    adminController.queryCourse(cno);
                    break;
                }
                case 4: {
                    System.out.print("请输入学生学号: ");
                    String sno = scanner.next();
                    adminController.querySc(sno);
                    break;
                }
                case 5: {
                    System.out.print("请输入学生学号: ");
                    String sno = scanner.next();
                    System.out.print("请输入学生姓名: ");
                    String Sname = scanner.next();
                    System.out.print("请输入学生性别: ");
                    String Ssex = scanner.next();
                    System.out.print("请输入学生年龄: ");
                    String Sage = scanner.next();
                    System.out.print("请输入学生系别: ");
                    String Sdept = scanner.next();
                    Student student = new Student(sno, Sname,Ssex,Sage,Sdept);
                    adminController.addStudent(student);
                    break;
                }
                case 6: {
                    System.out.print("请输入学生学号: ");
                    String sno = scanner.next();
                    adminController.deleteStudent(sno);
                    break;
                }
                case 7: {
                    System.out.print("请输入学生学号: ");
                    String oldSno = scanner.next();
                    adminController.updateStudent(oldSno);
                    break;
                }
                case 8: {
                    System.out.println("退出系统...");
                    adminController.exit();
                    return;
                }
                default:
                    System.out.println("无效的选项，请重新选择！");
                    break;
            }
        }
    }

    public static void Menu() {
        System.out.println("===========学生管理系统===========");
        System.out.println("=====1.查询所有学生信息=====");
        System.out.println("=====2.查询单个学生信息=====");
        System.out.println("=====3.查询课程信息=====");
        System.out.println("=====4.查询选课信息=====");
        System.out.println("=====5.添加学生信息=====");
        System.out.println("=====6.删除学生信息=====");
        System.out.println("=====7.更新学生信息=====");
        System.out.println("=====8.退出系统========");
        System.out.println("==================================");
        System.out.print("请选择操作: ");
    }
}
