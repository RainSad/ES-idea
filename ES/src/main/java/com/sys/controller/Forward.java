package com.sys.controller;

import com.core.common.utill.IdToolUtil;
import com.sys.entity.user.User;
import com.sys.repository.user.UserRepositoryImp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	UserRepositoryImp userRepositoryImp;

	@RequestMapping("/")
	public String toIndex() {
		log.debug(" -- > ['toIndex'] --> [ '/' ]  --> [ '/WEB-INF/view/index/index.html' ]");
		return "index/index";
	}
	
	@RequestMapping("toIndex")
	public String toIndex2() {
		log.debug(" -- > ['toIndex'] --> [ '/toIndex' ]  --> [ '/WEB-INF/view/index/index.html' ]");
		return "index/index";
	}


	@RequestMapping("toLogin")
	public String toLogin() {
		log.debug(" -- > ['toLogin'] --> [ '/toLogin' ]  --> [ '/WEB-INF/view/index/login.html' ]");
		return "index/login";
	}

	@RequestMapping("toRigister")
	public String toRegister() {
		log.debug(" -- > ['toRegister'] --> [ '/toRigister' ]  --> [ '/WEB-INF/view/index/register.html' ]");
		return "index/register";
	}
	
	@RequestMapping("toDetail")
	public String toDetail() {
		log.debug(" -- > ['toDetail'] --> [ '/toRigister' ]  --> [ '/WEB-INF/view/index/detail.html' ]");
		return "index/detail";
	}

	@RequestMapping("toWebSocket")
	public String webSocket() {

		return "index/websockettest";
	}

	@RequestMapping("testSql")
	public void test() {

		User entity = new User();

		entity.setId(IdToolUtil.getUUID());
		entity.setUserName("sunwx");
		entity.setNickName("孙文祥");
		userRepositoryImp.save(entity);

	}
}
