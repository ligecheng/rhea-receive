package com.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.admin.util.BasicData;

@Controller
@RequestMapping(value = "/socket")
public class SocketController extends BaseController {

	@RequestMapping(value = "/control")
	public void control(HttpServletRequest request, HttpServletResponse response, String key, String value) {
		System.out.println("key----->" + key);
		System.out.println("value----->" + value);
		BasicData.socketMap.put(key, value);
		super.outJson(response, "success");
	}

}
