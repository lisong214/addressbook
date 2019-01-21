package com.chinawanbang.casecollection.collection.service.impl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinawanbang.casecollection.collection.dao.CollectionDao;
import com.chinawanbang.casecollection.collection.service.CollectionService;
import com.chinawanbang.casecollection.common.constant.KeyEnum;
import com.chinawanbang.casecollection.common.constant.MsgEnum;
import com.chinawanbang.casecollection.common.util.LoginValidUtil;
import com.chinawanbang.casecollection.common.util.RedisUtil;
import com.chinawanbang.casecollection.common.vo.ResultVO;
import com.chinawanbang.casecollection.system.entity.Person;
@Service
@Slf4j
public class CollectionServiceImpl implements CollectionService {
	
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private CollectionDao collectionDao;

	@Override
	public ResultVO delppt(HttpSession session) {
		ResultVO r = new ResultVO();
		try {
			LoginValidUtil loginValidUtil = new LoginValidUtil(redisUtil);
			Map<String, Object> loginValid = loginValidUtil.loginValid(session);
			if ((boolean) loginValid.get("success")) {
				// 根据人员openid删除ppt
				Person personObj = (Person) loginValid.get("person");
				if (collectionDao.delppt(personObj.getId())>=1) {
					r.setSuccess(true);
					r.setMessage(MsgEnum.OPERATION_SUCCESS);
				} else {
					r.setSuccess(false);
					r.setMessage(MsgEnum.OPERATION_FAIL);
				}
			} else {
				r.setSuccess(false);
				r.setMessage(MsgEnum.LOG_FALL);
			}
		} catch (Exception e) {
			log.info("删除ppt错误：", e);
			r.setSuccess(false);
			r.setMessage(MsgEnum.LOG_FALL);
		}	
		return r;
	}

	@Override
	public ResultVO personDetail(HttpSession session) {
		ResultVO r = new ResultVO();
		try {
			LoginValidUtil loginValidUtil = new LoginValidUtil(redisUtil);
			Map<String, Object> loginValid = loginValidUtil.loginValid(session);
			if ((boolean) loginValid.get("success")) {
				// 获取redis人员信息
				Person personObj = (Person) loginValid.get("person");
				log.info("人员信息："+personObj.getTrueName());
				// 根据id获取人员信息
				Person person = collectionDao.personDetail(personObj.getId());
				if (null != person) {
					r.setSuccess(true);
				    r.setAttrValue(KeyEnum.PERSON, person);
				} else {
					r.setSuccess(true);
				    r.setAttrValue(KeyEnum.PERSON, personObj);
				}
			} else {
				r.setSuccess(false);
				r.setMessage(MsgEnum.LOG_FALL);
			}
		} catch (Exception e) {
			log.info("获取人员信息错误：", e);
			r.setSuccess(false);
			r.setMessage(MsgEnum.LOG_FALL);
		}	
		return r;
	}

	@Override
	public int addPerson(Person person) {
		return collectionDao.addPerson(person);
	}

}
