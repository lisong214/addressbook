package com.xzdtyy.addressbook.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xzdtyy.addressbook.entity.Person;
import com.xzdtyy.addressbook.service.AddressBookService;
import com.xzdtyy.addressbook.utils.PageUtils;
import com.xzdtyy.addressbook.utils.Query;

import lombok.extern.slf4j.Slf4j;
/**
 * 通讯录
 * @author LS
 *
 */
@Slf4j
@Controller
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
	private AddressBookService addressBookService;
	
	/**
     * 获取列表页面
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index() {
    	ModelAndView mv = new ModelAndView("stats/index");
        return mv;
    }
	
	/**
	 * 获取通讯录列表
	 * @param session
	 * @return
	 */
	@RequestMapping("/getaddressbook")
    @ResponseBody
    public PageUtils getaddressbook(@RequestParam Map<String, Object> params) {
		// 查询列表数据
        Query query = new Query(params);
        List<Person> collageList = addressBookService.getAddressBook(query);
        int total = addressBookService.getAddressBookCount(query);
        PageUtils pageUtils = new PageUtils(collageList, total);
        return pageUtils;
    }
	
	@RequestMapping("/getprintAddressbook")
    @ResponseBody
	public List<Person> getprintAddressbook(String option, String name, String offic) {
		return addressBookService.getprintAddressbook(option, name, offic);
	}

}
