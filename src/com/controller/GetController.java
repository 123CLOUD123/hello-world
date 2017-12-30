package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.User;
import com.service.UserService;

@Controller
public class GetController {
	@Autowired
	private UserService us;
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ResponseBody
	public List<User> getUser(){
		List<User> l=us.getAllUsers();
		return l;
	}
}
