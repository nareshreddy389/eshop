package com.naresh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class c1 {
	
	c1()
	{
	System.out.println("C1 is loading ");
	}
	@RequestMapping("/bbc")
	ModelAndView m2()
	{
	ModelAndView modelAndView=new ModelAndView("xyz");
	modelAndView.addObject("nm",145);
	return modelAndView;
	}
	
	@RequestMapping("/category")
	ModelAndView m3()
	{
		ModelAndView modelAndView=new ModelAndView("addcategory");
		modelAndView.addObject("n",200);
		return modelAndView;
				
	}

	@RequestMapping("/suri")
	String m4()
	{
		return "showcategory";
	}
			
	}


