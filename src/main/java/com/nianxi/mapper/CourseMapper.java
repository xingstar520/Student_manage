package com.nianxi.mapper;

import com.nianxi.entity.Course;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/5
 * @version: 1.0
 */
@Mapper
public interface CourseMapper {
    /**
     * 查询课程信息
     * @param cno
     */
    Course queryCourse(String cno);
}
