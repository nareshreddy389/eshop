package com.naresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naresh.Daoimpl.CategoryDaoImpl;
import com.naresh.Daoimpl.TestingSessionFactory;
import com.naresh.model.Category;
	

	@Controller
	public class CategoryController
	{
		@Autowired
		TestingSessionFactory test;
		@Autowired
	     CategoryDaoImpl category;
	//@RequestMapping("/category")
	    @RequestMapping(value="/category", method=RequestMethod.GET)
	    public ModelAndView goToCategoryForm()
	    {

	  
	        ModelAndView  mv=new ModelAndView("category");
	        
	        mv.addObject("cat",new Category());
	        mv.addObject("buttonname","AddCategory");
	        return  mv;
	    }
	    
	    @RequestMapping(value="/addCat",method=RequestMethod.POST)
	    public ModelAndView recieveCategoryFormData(@ModelAttribute ("cat") Category ca)
	    {
	    	ModelAndView mv=new ModelAndView("home");
	        System.out.println(ca.getCategoryDiscription());
	        System.out.println(ca.getCategoryName());
	        test.testingsessionfactory();
	         category.CategoryDao(ca);
	       return mv;
	    }        
	  @RequestMapping("/showcat")
	  public ModelAndView RetrieveAllCategoryData()
	    {
		  ModelAndView  mv=new ModelAndView("showcategory");
	        
	         List<Category>showcategorydata=(List<Category>) category.getCategoryData();
	       
	    	mv.addObject("catlist",showcategorydata);
	         
	        return  mv;
	        }
	
	  @RequestMapping("/del")
	  public String deletecategory(@RequestParam("catid")int categoryid)
	    {

		  System.out.println(categoryid);
		  category.deletecategory(categoryid);
	       	         
	        return  "redirect:showcat";
	    }
	
	  @RequestMapping("/edit")
	  public ModelAndView editcategory(@RequestParam("catid")int categoryid)
	    {

		  System.out.println(categoryid);
		  Category cate=category.getcategory(categoryid);
		  
	        ModelAndView  mv=new ModelAndView("category");
	        
	         
	        
	       
	    	mv.addObject("cat",cate);
	    	mv.addObject("buttonname","UpdateCategory");
	         
	        return  mv;
	    }
	  
	    }
	
	
	
	
	
	    
	

