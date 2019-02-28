package com.chinawanbang.casecollection.collection.service;

import java.util.List;
import java.util.Map;

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
	// 人员列表
	List<Person> personList(Map<String, Object> map);
	// 人员个数
	int count(Map<String, Object> map);

}
