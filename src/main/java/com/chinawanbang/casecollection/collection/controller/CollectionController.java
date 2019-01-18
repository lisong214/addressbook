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
import com.chinawanbang.casecollection.common.util.RedisUtil;

@Controller
@RequestMapping("/collection")
@Slf4j
public class CollectionController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CollectionController.class);
	
	@Autowired
	private CollectionService collectionService;
	@Autowired
	private RedisUtil redisUtil;
	
    @RequestMapping(value = "/uploadppt")
    @ResponseBody
    public Map<String, Object> uploadppt(MultipartFile file, HttpSession session) {
    	Map<String, Object> json = new HashMap<String, Object>();
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
                String ticket = (String) session.getAttribute("qrcode_ticket");
                //Object ticketVal = redisUtil.getRedisTemplate().opsForValue().get(ticket);
                //上传文件名称
                String upFileName = fileName;
                //上传文件到oss
                // 创建OSSClient实例
                ossClient = new OSSClient(CollectionConstant.ENDPOINT, CollectionConstant.ACCESSKEYID, CollectionConstant.ACCESSKEYSECRET);
                // 上传
                String absoluteApk = CollectionConstant.OBJECTKEY + upFileName;
                ossClient.putObject(CollectionConstant.BUCKETNAME, absoluteApk, new ByteArrayInputStream(file.getBytes()));
                String url = CollectionConstant.BUCKET_URL + absoluteApk;
                // 存入数据库
                
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
}
