package com.ch.mytemplate.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 返回结果枚举
 * @author  ch
 * @date  2021-06-29
 * @version 1.0
 */
@Getter
public enum  ResultEnum {
    /**
     *   返回结果枚举,每个枚举代表着一个返回状态
     */
    SUCCESS(200, "操作成功！"),
    ERROR(400, "操作失败！"),
    DATA_NOT_FOUND(401, "查询失败！"),
    PARAMS_NULL(402, "参数不能为空！"),
    PARAMS_ERROR(405, "参数不合法！"),

    NOT_LOGIN(403, "当前账号未登录！")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
