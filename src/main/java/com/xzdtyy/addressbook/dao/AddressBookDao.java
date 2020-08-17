package com.xzdtyy.addressbook.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xzdtyy.addressbook.entity.Person;

public interface AddressBookDao {
	// 首页
	List<Person> getAddressBook(@Param("map") Map<String, Object> map);	
	int getAddressBookCount(@Param("map") Map<String, Object> map);
	// 办公室
	List<Person> getBgsAddressBook(@Param("map") Map<String, Object> map);
	int getBgsAddressBookCount(@Param("map") Map<String, Object> map);
	// 人力资源
	List<Person> getRlzyAddressBook(@Param("map") Map<String, Object> map);
	int getRlzyAddressBookCount(@Param("map") Map<String, Object> map);
	// 党群工作部
	List<Person> getDqgzAddressBook(@Param("map") Map<String, Object> map);
	int getDqgzAddressBookCount(@Param("map") Map<String, Object> map);
	// 安全技术部
	List<Person> getAqjsAddressBook(@Param("map") Map<String, Object> map);
	int getAqjsAddressBookCount(@Param("map") Map<String, Object> map);
	// 企划部
	List<Person> getQhAddressBook(@Param("map") Map<String, Object> map);
	int getQhAddressBookCount(@Param("map") Map<String, Object> map);
	// 物资部
	List<Person> getWzAddressBook(@Param("map") Map<String, Object> map);
	int getWzAddressBookCount(@Param("map") Map<String, Object> map);
	// 调度票务部
	List<Person> getDdpwAddressBook(@Param("map") Map<String, Object> map);
	int getDdpwAddressBookCount(@Param("map") Map<String, Object> map);
	// 调度票务部总调室
	List<Person> getZdAddressBook(@Param("map") Map<String, Object> map);
	int getZdAddressBookCount(@Param("map") Map<String, Object> map);
	// 调度票务部票务室
	List<Person> getPwAddressBook(@Param("map") Map<String, Object> map);
	int getPwAddressBookCount(@Param("map") Map<String, Object> map);
	// 客运部
	List<Person> getKyAddressBook(@Param("map") Map<String, Object> map);
	int getKyAddressBookCount(@Param("map") Map<String, Object> map);
	// 客运部站务室
	List<Person> getZwAddressBook(@Param("map") Map<String, Object> map);
	int getZwAddressBookCount(@Param("map") Map<String, Object> map);
	// 客运部乘务室
	List<Person> getCwAddressBook(@Param("map") Map<String, Object> map);
	int getCwAddressBookCount(@Param("map") Map<String, Object> map);
	// 客运部车站
	List<Person> getCzAddressBook(@Param("map") Map<String, Object> map);
	int getCzAddressBookCount(@Param("map") Map<String, Object> map);
	// 车辆部
	List<Person> getClAddressBook(@Param("map") Map<String, Object> map);
	int getClAddressBookCount(@Param("map") Map<String, Object> map);
	// 车辆部检修室
	List<Person> getJxAddressBook(@Param("map") Map<String, Object> map);
	int getJxAddressBookCount(@Param("map") Map<String, Object> map);
	// 车辆部设备室
	List<Person> getSbAddressBook(@Param("map") Map<String, Object> map);
	int getSbAddressBookCount(@Param("map") Map<String, Object> map);
	// 机电设施部
	List<Person> getJdssAddressBook(@Param("map") Map<String, Object> map);
	int getJdssAddressBookCount(@Param("map") Map<String, Object> map);
	// 机电设施部供电室
	List<Person> getGdsAddressBook(@Param("map") Map<String, Object> map);
	int getGdsAddressBookCount(@Param("map") Map<String, Object> map);
	// 机电设施部工建室
	List<Person> getGjsAddressBook(@Param("map") Map<String, Object> map);
	int getGjsAddressBookCount(@Param("map") Map<String, Object> map);
	// 机电设施部机电室
	List<Person> getJdsAddressBook(@Param("map") Map<String, Object> map);
	int getJdsAddressBookCount(@Param("map") Map<String, Object> map);
	// 机电设施部自动化室
	List<Person> getZdhAddressBook(@Param("map") Map<String, Object> map);
	int getZdhAddressBookCount(@Param("map") Map<String, Object> map);
	// 机电设施部通号室
	List<Person> getThAddressBook(@Param("map") Map<String, Object> map);
	int getThAddressBookCount(@Param("map") Map<String, Object> map);
	
}
