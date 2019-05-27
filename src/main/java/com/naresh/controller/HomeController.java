package com.naresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.naresh.Daoimpl.ProductDaoImpl;
import com.naresh.model.Product;

@Controller
public class HomeController {
@RequestMapping("/home")
public  String gohome()
{
	return "home";
}
@RequestMapping("/aboutus")
public  String aboutUs()
{
	return "Aboutus";
}
@RequestMapping("/contactus")
public  String contactUs()
{
	return "Contactus";
}

}
