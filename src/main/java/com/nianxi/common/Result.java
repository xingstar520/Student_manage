package com.nianxi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/5
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    // 状态码 0为成功，1为失败
    private Integer code;
    // 返回信息
    private String msg;
    // 返回前端的数据
    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<T>();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
