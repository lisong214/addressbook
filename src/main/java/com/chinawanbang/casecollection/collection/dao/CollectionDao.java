package com.chinawanbang.casecollection.collection.dao;

import org.apache.ibatis.annotations.Param;

import com.chinawanbang.casecollection.system.entity.Person;

public interface CollectionDao {
	// 新增人员信息
	int addPerson(@Param("person") Person person);
	// 人员信息查询
	Person personDetail(@Param("id") int id);
	// 删除ppt
	int delppt(@Param("id") int id);

}
