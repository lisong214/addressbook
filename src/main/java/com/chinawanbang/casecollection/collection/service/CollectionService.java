package com.chinawanbang.casecollection.collection.service;

import javax.servlet.http.HttpSession;

import com.chinawanbang.casecollection.common.vo.ResultVO;
import com.chinawanbang.casecollection.system.entity.Person;

public interface CollectionService {
	// 人员信息入库
	int addPerson(Person person);
	// 删除ppt
	ResultVO delppt(HttpSession session);
	// 人员信息查询
	ResultVO personDetail(HttpSession session);

}
