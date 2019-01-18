package com.chinawanbang.casecollection.system.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.chinawanbang.casecollection.common.constant.KeyEnum;
import com.chinawanbang.casecollection.common.constant.MsgEnum;
import com.chinawanbang.casecollection.common.util.HttpsClientUtil;
import com.chinawanbang.casecollection.common.util.RedisUtil;
import com.chinawanbang.casecollection.common.vo.ResultVO;
import com.chinawanbang.casecollection.system.entity.Person;
import com.chinawanbang.casecollection.system.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Value("${qrCodeUrl}")
	private String qrCodeUrl;
	@Value("${loginUrl}")
	private String loginUrl;
	@Autowired
	private RedisUtil redisUtil;
	
	@Override
	public ResultVO qrCode(HttpSession session) {
		ResultVO r = new ResultVO();
		try {
			Map<String,String> param = new HashMap<String,String>();
			param.put("loginType", "CVC");
			String resString = HttpsClientUtil.postRequest(qrCodeUrl ,param);
			JSONObject resJson = JSONObject.parseObject(resString);
			if ("YJK001".equals(resJson.getString("status"))) {
				JSONObject datasJson = resJson.getJSONObject("datas");
				String ticket = datasJson.getString("ticket");
				session.setAttribute("qrcode_ticket", ticket);
				String qrCode = datasJson.getString("qr_code");
				r.setSuccess(true);
				r.setAttrValue(KeyEnum.QRCODE, qrCode);
			} else {
				r.setSuccess(false);
				r.setMessage(MsgEnum.GET_QR_CODE_FAIL);
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.info("获取二维码失败：", e);
			r.setSuccess(false);
			r.setMessage(MsgEnum.UNKNOWN_ERROR);
		}
		return r;
	}

	@Override
	public ResultVO login(HttpSession session) {
		ResultVO r = new ResultVO();
		try {
			String ticket = (String) session.getAttribute("qrcode_ticket");
			if (null != ticket) {
				ticket = ticket + "_OK";
			} else {
				r.setSuccess(false);
				r.setMessage(MsgEnum.GET_QR_CODE);
				return r;
			}
			log.info("登录ticket：" + ticket);
			String personStr = (String) redisUtil.getRedisTemplate().opsForValue().get(ticket);
			if (personStr == null) {
				r.setSuccess(false);
				r.setMessage(MsgEnum.LOG_ING);
			} else {
				r.setSuccess(true);
				r.setAttrValue(KeyEnum.PERSON, JSONObject.parseObject(personStr, Person.class));
			}
		} catch (Exception e) {
			log.info("登陆错误：", e);
			r.setSuccess(false);
			r.setMessage(MsgEnum.LOG_FALL);
		}
		return r;
	}

}
