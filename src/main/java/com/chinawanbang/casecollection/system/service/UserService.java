package com.chinawanbang.casecollection.system.service;

import javax.servlet.http.HttpSession;

import com.chinawanbang.casecollection.common.vo.ResultVO;

public interface UserService {
	/**
	 * 获取二维码
	 * @return
	 */
	ResultVO qrCode(HttpSession session);
	/**
	 * 登录判断
	 * @param session
	 * @return
	 */
	ResultVO login(HttpSession session);

}
