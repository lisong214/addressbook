package com.xzdtyy.addressbook.service;

import java.util.List;
import java.util.Map;

import com.xzdtyy.addressbook.entity.Person;

public interface AddressBookService {
	// 查询全部
	List<Person> getAddressBook(Map<String, Object> map);
	
	int getAddressBookCount(Map<String, Object> map);

	//打印页面数据
	List<Person> getprintAddressbook(String option, String name, String offic);

}
