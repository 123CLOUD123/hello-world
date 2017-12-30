package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.User;
import com.service.UserService;

@Controller
public class DelController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	@ResponseBody
	public void delUser(@RequestParam("id") int id){
		User u=new User();
		u.setId(id);
		userService.deleteUser(u);
	}
}
