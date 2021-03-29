package com.fengzi.dubbo.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/03/26
 */
@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户中文名
     */
    private String userName;

    /**
     * 用户IP
     */
    private String ip;
}
