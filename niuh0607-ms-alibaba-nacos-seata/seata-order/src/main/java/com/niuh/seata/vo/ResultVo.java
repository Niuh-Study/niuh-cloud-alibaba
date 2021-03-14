package com.niuh.seata.vo;

import lombok.Data;

/**
 * Created by hejianhui on 2019/12/9.
 */
@Data
public class ResultVo {
    private boolean success;
    private String msg;
    private Object data;
}
