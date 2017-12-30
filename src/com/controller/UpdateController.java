package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.User;
import com.service.UserService;

@Controller
public class UpdateController {
	@Autowired
	private UserService us;
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public void updateUser(@RequestBody User user){
		us.updateUser(user);
	}
}
