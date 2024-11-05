package com.nianxi.service.Impl;

import com.nianxi.entity.StuGradeVO;
import com.nianxi.mapper.ScMapper;
import com.nianxi.service.ScService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/5
 * @version: 1.0
 */
@Service
@Slf4j
public class ScServiceImpl implements ScService {
    @Autowired
    private ScMapper scMapper;

    /**
     * 根据学号查询选课信息及姓名成绩
     * @param Sno
     */
    @Override
    public List<StuGradeVO> querySc(String Sno) {
        List<StuGradeVO> stuGradeVO = scMapper.querySc(Sno);
        if (stuGradeVO == null) {
            System.out.println("查询到的学生信息为空,请重新输入学号 输入n退出");
            Scanner scanner = new Scanner(System.in);
            String sno = scanner.next();
            if ("n".equals(sno)) {
                return null;
            }
            querySc(sno);
        } else {
            System.out.println("查询到的学生信息为：");
            for (StuGradeVO vo : stuGradeVO) {
                System.out.println(vo);
            }
        }
        return stuGradeVO;
    }
}
