package com.nianxi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/5
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StuGradeVO implements Serializable {
    private String Sno;
    private String Sname;
    private String Cno;
    private String Cname;
    private String Grade;
}
