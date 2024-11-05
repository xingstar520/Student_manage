package com.nianxi.service;

import com.nianxi.entity.StuGradeVO;

import java.util.List;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/5
 * @version: 1.0
 */
public interface ScService {
    /**
     * 查询选课信息
     * @param Sno
     */
    List<StuGradeVO> querySc(String Sno);
}
