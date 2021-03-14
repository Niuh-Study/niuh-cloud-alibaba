package com.niuh.compent.exception;

import lombok.Data;

/**
 * 网关异常
 * Created by hejianhui on 2019/12/26.
 */
@Data
public class GateWayException extends RuntimeException {

    private String code;

    private String msg;

    public GateWayException(SystemErrorType systemErrorType) {
        this.code = systemErrorType.getCode();
        this.msg = systemErrorType.getMesg();
    }

}
