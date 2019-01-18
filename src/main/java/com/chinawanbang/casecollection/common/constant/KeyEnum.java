package com.chinawanbang.casecollection.common.constant;

/**
 * 后台返回前台结果 Key
 * @author LS
 * @date 2017-08-25 11:17
 */
public enum KeyEnum {
    // 消息码
    CODE("code"),
    // 消息
    MESSAGE("message"),
    // 错误码
    ERR_CODE("errcode"),
    // 错误消息
    ERR_MSG("errmsg"),
    // 登录二维码
	QRCODE("qrcode"),
	// 人员信息
	PERSON("person");

    private String name;

    KeyEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
