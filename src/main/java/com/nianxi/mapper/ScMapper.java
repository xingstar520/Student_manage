package com.nianxi.mapper;

import com.nianxi.entity.StuGradeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/5
 * @version: 1.0
 */
@Mapper
public interface ScMapper {
    /**
     * 查询选课信息
     * @param sno
     */
    List<StuGradeVO> querySc(String sno);

    /**
     * 删除选课信息
     */
    void deleteSc(String sno);

    /**
     * 更新选课信息
     * @param newSno
     * @param oldSno
     */
    void updateSc(@Param("newSno") String newSno,@Param("oldSno") String oldSno);
}
