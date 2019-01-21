package com.chinawanbang.casecollection.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chinawanbang.casecollection.common.vo.ResultVO;
import com.chinawanbang.casecollection.system.service.UserService;

/**
 * 用户 Controller 层
 * @author LS
 * @date 2019-01-17 15:26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    /**
     * 上传测试页面
     * @return
     */
    @GetMapping("")
    public ModelAndView test() {
    	ModelAndView mv = new ModelAndView("stats/code");
        return mv;
    }
    
    /**
     * 获取登录页面
     * @return
     */
    @GetMapping("/index")
    public ModelAndView login() {
    	ModelAndView mv = new ModelAndView("stats/index");
        return mv;
    }
    /**
     * 获取登录页面
     * @return
     */
    @GetMapping("/upload")
    public ModelAndView upload() {
    	ModelAndView mv = new ModelAndView("stats/upload");
        return mv;
    }
    /**
     * 获取二维码
     * @param token
     * @return
     */
    @RequestMapping("/qrCode")
    @ResponseBody
    public ResultVO qrCode(HttpSession session) {
        return userService.qrCode(session);
    }
    
    @RequestMapping("/login")
    @ResponseBody
    public ResultVO login(HttpSession session) {
    	return userService.login(session);
    }

}
