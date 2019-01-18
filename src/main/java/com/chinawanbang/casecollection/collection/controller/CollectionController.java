package com.chinawanbang.casecollection.collection.controller;

import groovy.util.logging.Slf4j;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.chinawanbang.casecollection.collection.constant.CollectionConstant;
import com.chinawanbang.casecollection.collection.service.CollectionService;
import com.chinawanbang.casecollection.common.util.LoginValidUtil;
import com.chinawanbang.casecollection.common.util.RedisUtil;
import com.chinawanbang.casecollection.common.vo.ResultVO;
import com.chinawanbang.casecollection.system.entity.Person;

@Controller
@RequestMapping("/collection")
@Slf4j
public class CollectionController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CollectionController.class);
	
	@Autowired
	private CollectionService collectionService;
	@Autowired
	private RedisUtil redisUtil;
	
	/**
	 * 文件上传
	 * @param file
	 * @param session
	 * @return
	 */
    @RequestMapping(value = "/uploadppt")
    @ResponseBody
    public Map<String, Object> uploadppt(MultipartFile file, HttpSession session) {
    	Map<String, Object> json = new HashMap<String, Object>();
    	LoginValidUtil loginValidUtil = new LoginValidUtil(redisUtil);
    	Map<String, Object> loginValid = loginValidUtil.loginValid(session);
		if (!(boolean) loginValid.get("success")) {
			json.put("success", false);
            json.put("msg", "请先扫描二维码登陆");
			return json;
		}
        // 首先判断文件是否为空
        if (!file.isEmpty()) {
        	OSSClient ossClient = null;
			try {
                //获取文件名称
                String fileName = file.getOriginalFilename();
                //获取文件后缀
                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (!"ppt".equalsIgnoreCase(fileType)) {
                    json.put("success", false);
                    json.put("msg", "请您选择ppt类型文件上传！");
                    return json;
                }
                Person person = (Person) loginValid.get("person");
                //上传文件名称
                String upFileName = person.getHospital()+person.getTrueName()+".ppt";
                //上传文件到oss
                // 创建OSSClient实例
                ossClient = new OSSClient(CollectionConstant.ENDPOINT, CollectionConstant.ACCESSKEYID, CollectionConstant.ACCESSKEYSECRET);
                // 上传
                String absolutePpt = CollectionConstant.OBJECTKEY + upFileName;
                ossClient.putObject(CollectionConstant.BUCKETNAME, absolutePpt, new ByteArrayInputStream(file.getBytes()));
                String url = CollectionConstant.BUCKET_URL + absolutePpt;
                // 存入数据库
                person.setPptUrl(upFileName);
                collectionService.addPerson(person);
                json.put("success", true);
                json.put("url", url);
            } catch (Exception e) {
                LOG.info("上传错误：", e);
                json.put("success", false);
                json.put("msg", "上传ppt文件失败，请联系管理员！");
                return json;
            } finally {
            	// 关闭client
                if (ossClient != null) ossClient.shutdown();
            }
        } else {
            json.put("success", false);
            json.put("msg", "获取上传的ppt文件失败！");
            return json;
        }
        return json;
    }
    
    /**
     * 文件删除
     * @param session
     * @return
     */
    @RequestMapping("/delppt")
    @ResponseBody
    public ResultVO delppt(HttpSession session) {
        return collectionService.delppt(session);
    }
    
    /**
     * 获取人员信息
     * @param session
     * @return
     */
    @RequestMapping("/personDetail")
    @ResponseBody
    public ResultVO personDetail(HttpSession session) {
        return collectionService.personDetail(session);
    }
}
