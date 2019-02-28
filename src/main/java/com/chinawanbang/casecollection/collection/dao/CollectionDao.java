package com.chinawanbang.casecollection.collection.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chinawanbang.casecollection.system.entity.Person;

public interface CollectionDao {
	// 新增人员信息
	int addPerson(@Param("person") Person person);
	// 人员信息查询
	Person personDetail(@Param("id") int id);
	// 删除ppt
	int delppt(@Param("id") int id);
	// 人员列表
	List<Person> personList(@Param("map") Map<String, Object> map);
	// 人员个数
	int count(@Param("map") Map<String, Object> map);

}
