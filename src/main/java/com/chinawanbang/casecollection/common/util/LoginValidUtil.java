package com.chinawanbang.casecollection.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.chinawanbang.casecollection.system.entity.Person;
@Slf4j
@Component
public class LoginValidUtil {
	
	private RedisUtil redisUtil;
	
	public LoginValidUtil(RedisUtil redisUtil) {
		super();
		this.redisUtil = redisUtil;
	}

	public Map<String, Object> loginValid (HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String ticket = (String) session.getAttribute("qrcode_ticket");
			if (null != ticket) {
				ticket = ticket + "_OK";
			} else {
				map.put("success", false);
				return map;
			}
			log.info("验证ticket：" + ticket);
			String personStr = (String) redisUtil.getRedisTemplate().opsForValue().get(ticket);
			log.info("验证ticketVal：" + personStr);
			if (personStr == null) {
				map.put("success", false);
			} else {
				map.put("success", true);
				map.put("person", JSONObject.parseObject(personStr, Person.class));
			}
		} catch (Exception e) {
			log.info("身份验证错误：", e);
			map.put("success", false);
		}
		return map;
	}

}
