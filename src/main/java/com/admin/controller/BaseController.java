package com.admin.controller;

import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import com.admin.util.JsonUtil;

public class BaseController {

	public void outJson(HttpServletResponse response, Object obj) {
		try {
			String msg = JsonUtil.getInstance().writeValueAsString(obj);
			outString(response, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void outString(HttpServletResponse response, String msg) {
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(msg);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void outByte(HttpServletResponse response, byte[] bytes) {
		try {
			response.setCharacterEncoding("UTF-8");
			OutputStream os = response.getOutputStream();
			os.write(bytes);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
