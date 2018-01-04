package com.sys.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @ClassName: index
 * @Description: (首页的各种操作)
 * @author 孙文祥
 * @date 2017年8月11日 下午5:10:04
 *
 */
@Controller
public class Forward {

	Logger log = Logger.getLogger(Forward.class);


	@RequestMapping("/")
	public String toIndex() {
		log.debug(" -- > ['toIndex'] --> [ '/' ]  --> [ '/WEB-INF/view/index/index.html' ]");
		return "index/index";
	}

    @RequestMapping("/index")
    public String toIndex2() {
		log.debug(" -- > ['toIndex'] --> [ '/toIndex' ]  --> [ '/WEB-INF/view/index/index.html' ]");
		return "index/index";
	}


	@RequestMapping("/toLogin")
	public String toLogin() {
		log.debug(" -- > ['toLogin'] --> [ '/toLogin' ]  --> [ '/WEB-INF/view/index/login.html' ]");
		return "index/login";
	}

    @RequestMapping("/toRigister")
    public String toRegister() {
		log.debug(" -- > ['toRegister'] --> [ '/toRigister' ]  --> [ '/WEB-INF/view/index/register.html' ]");
		return "index/register";
	}

    @RequestMapping("/toDetail")
    public String toDetail() {
		log.debug(" -- > ['toDetail'] --> [ '/toRigister' ]  --> [ '/WEB-INF/view/index/detail.html' ]");
		return "index/detail";
	}

    @RequestMapping("/toWebSocket")
    public String webSocket() {

		return "index/websockettest";
	}

}
