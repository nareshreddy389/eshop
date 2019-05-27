package com.naresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.naresh.Daoimpl.SupplierDaoImpl;
import com.naresh.model.Category;
import com.naresh.model.Supplier;
@Controller
public class SupplierController
{
   @Autowired
   SupplierDaoImpl supplierDaoImpl;
@RequestMapping("/Supplier")
public ModelAndView goToSupplierform()
   {
ModelAndView  mv=new ModelAndView("Supplier");


      mv.addObject("sup",new Supplier());
      mv.addObject("buttonname","AddSupplier");
      return  mv;
   }

   @RequestMapping(value="/addsup",method=RequestMethod.POST)
   public ModelAndView recieveSupplierFormData(@ModelAttribute("sup") Supplier su)
   {
	   ModelAndView mv=new ModelAndView("home");
       System.out.println(su.getSupplierId());
       System.out.println(su.getSupplierName());
       System.out.println(su.getSupplierDetails());
       supplierDaoImpl.SupplierDaoAddData(su);
       return mv;
   }

   @RequestMapping("/showsup")
	  public ModelAndView RetrieveAllSupplierData()
	    {

	  
	        ModelAndView  mv=new ModelAndView("showsupplier");
	        
	         List<Supplier> showsupplierdata=(List<Supplier>)supplierDaoImpl.getSupplierData();
	       
	    	mv.addObject("suplist",showsupplierdata);
	         
	        return  mv;
	        }
	
	  @RequestMapping("/deleting")
	  public String deletesupplier(@RequestParam("supid")int supplierId)
	    {

		  System.out.println(supplierId);
		  supplierDaoImpl.deletesupplier(supplierId);
	        
	        return  "redirect:showsup";
	    }
	
	  @RequestMapping("/editing")
	  public ModelAndView editsupplier(@RequestParam("supid")int supplierId)
	    {

		  System.out.println(supplierId);
		  Supplier supp=supplierDaoImpl.getsupplier(supplierId);
		  
	        ModelAndView  mv=new ModelAndView("Supplier");
	        
	         
	        
	       
	    	mv.addObject("sup",supp);
	    	mv.addObject("buttonname","UpdateSupplier");
	         
	        return  mv;
	    }
	  
	    }
	
	