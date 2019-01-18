package com.chinawanbang.casecollection.common.constant;

/**
 * 消息枚举
 */
public enum MsgEnum {

    UNKNOWN_ERROR(0, "系统繁忙，请稍后再试"),	// 未知错误，统一返回的信息
    GET_QR_CODE_FAIL(1002, "获取二维码失败，请联系管理员！"),
    LOG_ING(1001, "登录中，请稍后……");

	private int code;
	private String message;
	
	MsgEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
