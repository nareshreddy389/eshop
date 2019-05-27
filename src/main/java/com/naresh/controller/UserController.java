package com.naresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naresh.Daoimpl.UserDaoImpl;
import com.naresh.model.Category;
import com.naresh.model.Product;
import com.naresh.model.Supplier;
import com.naresh.model.User;

@Controller
public class UserController 
{
@Autowired
UserDaoImpl userdaoimpl;

   
@RequestMapping(value="/register",method =RequestMethod.GET)
public ModelAndView goToRegisterForm()
{
	ModelAndView modelAndView=new ModelAndView("Register");
	 modelAndView.addObject("reg",new User());
	return modelAndView;
			
}

@RequestMapping(value="/toregister",method=RequestMethod.POST)
public ModelAndView recieveRegisterFormData(@ModelAttribute ("reg") User user)
{
	ModelAndView mv=new ModelAndView("Register");
    
    
     userdaoimpl.getUserDetails(user);
   return mv;
}        

@RequestMapping(value="/login",method =RequestMethod.GET)
public ModelAndView goToLoginForm()
{
	ModelAndView modelAndView=new ModelAndView("Login");
	 modelAndView.addObject("user",new User());
	return modelAndView;
			
}

@RequestMapping(value="/tologin",method=RequestMethod.POST)
public ModelAndView recieveLoginFormData(@ModelAttribute ("user") User user)
{
	boolean result=userdaoimpl.checkLogin(user);
	
	if(result==true)
	{
		ModelAndView modelAndView=new ModelAndView("LoginSuccess");
		return modelAndView;
	}
	else 
	{
		ModelAndView modelAndView=new ModelAndView("Login");
		modelAndView.addObject("logininfo", "WRONG USERNAME/PASSWORD");
		return modelAndView;
	}
	
}        	
}