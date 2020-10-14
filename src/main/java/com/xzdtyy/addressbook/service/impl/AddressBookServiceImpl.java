package com.xzdtyy.addressbook.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzdtyy.addressbook.dao.AddressBookDao;
import com.xzdtyy.addressbook.entity.Person;
import com.xzdtyy.addressbook.service.AddressBookService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookServiceImpl implements AddressBookService {
	
	@Autowired
	private AddressBookDao addressBookDao;
	
	@Override
	public List<Person> getAddressBook(Map<String, Object> map) {
		List<Person> list = new ArrayList<Person>();
		String offic = (String) map.get("offic");
		if("sy".equals(offic)) {                      // 首页
			list = addressBookDao.getAddressBook(map);
		} else if ("bgs".equals(offic)) {             // 办公室
			list = addressBookDao.getBgsAddressBook(map);
		} else if ("rlzy".equals(offic)) {            // 人力资源
			list = addressBookDao.getRlzyAddressBook(map);
		} else if ("dqgz".equals(offic)) {            // 党群工作部
			list = addressBookDao.getDqgzAddressBook(map);
		} else if ("aqjs".equals(offic)) {            // 安全技术部
			list = addressBookDao.getAqjsAddressBook(map);
		} else if ("qh".equals(offic)) {              // 企划部
			list = addressBookDao.getQhAddressBook(map);
		} else if ("wz".equals(offic)) {              // 物资部
			list = addressBookDao.getWzAddressBook(map);
		} else if ("ddpw".equals(offic)) {            // 调度票务部
			list = addressBookDao.getDdpwAddressBook(map);
		} else if ("zd".equals(offic)) {              // 调度票务部总调室
			list = addressBookDao.getZdAddressBook(map);
		} else if ("pw".equals(offic)) {              // 调度票务部票务室
			list = addressBookDao.getPwAddressBook(map);
		} else if ("ky".equals(offic)) {              // 客运部
			list = addressBookDao.getKyAddressBook(map);
		} else if ("zw".equals(offic)) {              // 客运部站务室
			list = addressBookDao.getZwAddressBook(map);
		} else if ("cw".equals(offic)) {              // 客运部乘务室
			list = addressBookDao.getCwAddressBook(map);
		} else if ("yicz".equals(offic)) {              // 客运部一号线车站
			list = addressBookDao.getCzAddressBook(map);
		} else if ("ercz".equals(offic)) {              // 客运部二号线车站
			list = addressBookDao.getErczAddressBook(map);
		} else if ("cl".equals(offic)) {              // 车辆部
			list = addressBookDao.getClAddressBook(map);
		} else if ("jx".equals(offic)) {              // 车辆部检修室
			list = addressBookDao.getJxAddressBook(map);
		} else if ("sb".equals(offic)) {              // 车辆部设备室
			list = addressBookDao.getSbAddressBook(map);
		} else if ("jdss".equals(offic)) {            // 机电设施部
			list = addressBookDao.getJdssAddressBook(map);
		} else if ("gds".equals(offic)) {             // 机电设施部供电室
			list = addressBookDao.getGdsAddressBook(map);
		} else if ("gjs".equals(offic)) {             // 机电设施部工建室
			list = addressBookDao.getGjsAddressBook(map);
		} else if ("jds".equals(offic)) {             // 机电设施部机电室
			list = addressBookDao.getJdsAddressBook(map);
		} else if ("zdh".equals(offic)) {             // 机电设施部自动化室
			list = addressBookDao.getZdhAddressBook(map);
		} else if ("th".equals(offic)) {              // 机电设施部通号室
			list = addressBookDao.getThAddressBook(map);
		} else if ("zbdh".equals(offic)) {            // 值班电话
			list = addressBookDao.getZbdhAddressBook(map);
		}
		return list;
	}

	@Override
	public int getAddressBookCount(Map<String, Object> map) {
		int count = 0;
		String offic = (String) map.get("offic");;
		if("sy".equals(offic)) {                      // 首页
			count = addressBookDao.getAddressBookCount(map);
		} else if ("bgs".equals(offic)) {             // 办公室
			count = addressBookDao.getBgsAddressBookCount(map);
		} else if ("rlzy".equals(offic)) {            // 人力资源
			count = addressBookDao.getRlzyAddressBookCount(map);
		} else if ("dqgz".equals(offic)) {            // 党群工作部
			count = addressBookDao.getDqgzAddressBookCount(map);
		} else if ("aqjs".equals(offic)) {            // 安全技术部
			count = addressBookDao.getAqjsAddressBookCount(map);
		} else if ("qh".equals(offic)) {              // 企划部
			count = addressBookDao.getQhAddressBookCount(map);
		} else if ("wz".equals(offic)) {              // 物资部
			count = addressBookDao.getWzAddressBookCount(map);
		} else if ("ddpw".equals(offic)) {            // 调度票务部
			count = addressBookDao.getDdpwAddressBookCount(map);
		} else if ("zd".equals(offic)) {              // 调度票务部总调室
			count = addressBookDao.getZdAddressBookCount(map);
		} else if ("pw".equals(offic)) {              // 调度票务部票务室
			count = addressBookDao.getPwAddressBookCount(map);
		} else if ("ky".equals(offic)) {              // 客运部
			count = addressBookDao.getKyAddressBookCount(map);
		} else if ("zw".equals(offic)) {              // 客运部站务室
			count = addressBookDao.getZwAddressBookCount(map);
		} else if ("cw".equals(offic)) {              // 客运部乘务室
			count = addressBookDao.getCwAddressBookCount(map);
		} else if ("yicz".equals(offic)) {              // 客运部一号线车站
			count = addressBookDao.getCzAddressBookCount(map);
		} else if ("ercz".equals(offic)) {              // 客运部二号线车站
			count = addressBookDao.getErczAddressBookCount(map);
		} else if ("cl".equals(offic)) {              // 车辆部
			count = addressBookDao.getClAddressBookCount(map);
		} else if ("jx".equals(offic)) {              // 车辆部检修室
			count = addressBookDao.getJxAddressBookCount(map);
		} else if ("sb".equals(offic)) {              // 车辆部设备室
			count = addressBookDao.getSbAddressBookCount(map);
		} else if ("jdss".equals(offic)) {            // 机电设施部
			count = addressBookDao.getJdssAddressBookCount(map);
		} else if ("gds".equals(offic)) {             // 机电设施部供电室
			count = addressBookDao.getGdsAddressBookCount(map);
		} else if ("gjs".equals(offic)) {             // 机电设施部工建室
			count = addressBookDao.getGjsAddressBookCount(map);
		} else if ("jds".equals(offic)) {             // 机电设施部机电室
			count = addressBookDao.getJdsAddressBookCount(map);
		} else if ("zdh".equals(offic)) {             // 机电设施部自动化室
			count = addressBookDao.getZdhAddressBookCount(map);
		} else if ("th".equals(offic)) {              // 机电设施部通号室
			count = addressBookDao.getThAddressBookCount(map);
		} else if ("zbdh".equals(offic)) {            // 值班电话
			count = addressBookDao.getZbdhAddressBookCount(map);
		}
		return count;
	}

	@Override
	public List<Person> getprintAddressbook(String option, String name, String offic) {
		List<Person> list = new ArrayList<Person>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("option", option);
		map.put("name", name);
		map.put("offset", 0);
		map.put("limit", Long.MAX_VALUE);
		if("sy".equals(offic)) {                      // 首页
			list = addressBookDao.getAddressBook(map);
		} else if ("bgs".equals(offic)) {             // 办公室
			list = addressBookDao.getBgsAddressBook(map);
		} else if ("rlzy".equals(offic)) {            // 人力资源
			list = addressBookDao.getRlzyAddressBook(map);
		} else if ("dqgz".equals(offic)) {            // 党群工作部
			list = addressBookDao.getDqgzAddressBook(map);
		} else if ("aqjs".equals(offic)) {            // 安全技术部
			list = addressBookDao.getAqjsAddressBook(map);
		} else if ("qh".equals(offic)) {              // 企划部
			list = addressBookDao.getQhAddressBook(map);
		} else if ("wz".equals(offic)) {              // 物资部
			list = addressBookDao.getWzAddressBook(map);
		} else if ("ddpw".equals(offic)) {            // 调度票务部
			list = addressBookDao.getDdpwAddressBook(map);
		} else if ("zd".equals(offic)) {              // 调度票务部总调室
			list = addressBookDao.getZdAddressBook(map);
		} else if ("pw".equals(offic)) {              // 调度票务部票务室
			list = addressBookDao.getPwAddressBook(map);
		} else if ("ky".equals(offic)) {              // 客运部
			list = addressBookDao.getKyAddressBook(map);
		} else if ("zw".equals(offic)) {              // 客运部站务室
			list = addressBookDao.getZwAddressBook(map);
		} else if ("cw".equals(offic)) {              // 客运部乘务室
			list = addressBookDao.getCwAddressBook(map);
		} else if ("yicz".equals(offic)) {              // 客运部一号线车站
			list = addressBookDao.getCzAddressBook(map);
		} else if ("ercz".equals(offic)) {              // 客运部二号线车站
			list = addressBookDao.getErczAddressBook(map);
		} else if ("cl".equals(offic)) {              // 车辆部
			list = addressBookDao.getClAddressBook(map);
		} else if ("jx".equals(offic)) {              // 车辆部检修室
			list = addressBookDao.getJxAddressBook(map);
		} else if ("sb".equals(offic)) {              // 车辆部设备室
			list = addressBookDao.getSbAddressBook(map);
		} else if ("jdss".equals(offic)) {            // 机电设施部
			list = addressBookDao.getJdssAddressBook(map);
		} else if ("gds".equals(offic)) {             // 机电设施部供电室
			list = addressBookDao.getGdsAddressBook(map);
		} else if ("gjs".equals(offic)) {             // 机电设施部工建室
			list = addressBookDao.getGjsAddressBook(map);
		} else if ("jds".equals(offic)) {             // 机电设施部机电室
			list = addressBookDao.getJdsAddressBook(map);
		} else if ("zdh".equals(offic)) {             // 机电设施部自动化室
			list = addressBookDao.getZdhAddressBook(map);
		} else if ("th".equals(offic)) {              // 机电设施部通号室
			list = addressBookDao.getThAddressBook(map);
		} else if ("zbdh".equals(offic)) {            // 值班电话
			list = addressBookDao.getZbdhAddressBook(map);
		}
		return list;
	}

}
