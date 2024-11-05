package com.nianxi.service.Impl;

import com.nianxi.entity.Course;
import com.nianxi.mapper.CourseMapper;
import com.nianxi.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/5
 * @version: 1.0
 */
@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 查询课程信息
     * @param Cno
     */
    @Override
    public void queryCourse(String Cno) {
        Course course = courseMapper.queryCourse(Cno);
        if (course == null) {
            System.out.println("警告，该课程信息为空,请重新输入课程号 输入n退出查询");
            Scanner scanner = new Scanner(System.in);
            String cno = scanner.next();
            if ("n".equals(cno)) {
                return;
            }
            queryCourse(cno);
        }else {
            System.out.println("查询到的课程信息为：" + course);
        }
    }
}
