package com.chinawanbang.casecollection.system.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

/**
 * @author LS
 * @date 2019-01-14 下午12:01:52
 */
@Controller
@RequestMapping("/base")
public class BaseController implements ServletConfigAware, ServletContextAware {
	protected ServletContext servletContext;
	
	protected ServletConfig servletConfig;
	
	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
	}

	@Override
	public void setServletConfig(ServletConfig arg0) {
		this.servletConfig = arg0;
	}
	
	@RequestMapping("/downloadppt")
	public void downloadppt(HttpSession session, HttpServletResponse response) {
		FileInputStream fis = null;
		ServletOutputStream out = null;
		try {
			// 获取服务器文件流
			String realPath = servletContext.getRealPath("/download/病例模板.ppt");
			File file = new File(realPath);
			if (!file.exists()) {
				return;
			}
			fis = new FileInputStream(file);
			// 浏览器导出文件流
			response.reset();
			response.setContentType("application/msexcel;charset=UTF-8");
			response.addHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("病例模板.ppt", "UTF-8"));
			out = response.getOutputStream();
			byte[] b = new byte[1024];
			int len = 0;
			while ((len  = fis.read(b)) > 0) {
				out.write(b, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) out.close();
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
