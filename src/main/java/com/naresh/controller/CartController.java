 package com.naresh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naresh.Daoimpl.AddToCartDaoimpl;
import com.naresh.Daoimpl.ProductDaoImpl;
import com.naresh.model.AddToCart;
import com.naresh.model.Category;
import com.naresh.model.Product;

@Controller
public class CartController {

	@Autowired
	ProductDaoImpl productdaoimpl;
	@Autowired
	AddToCartDaoimpl addtocartdaoimpl;
	/* @RequestMapping("/AddToCart")
	public String setcart(@RequestParam("proid") int productId)
	{
		System.out.println(productId);
		Product product=productdaoimpl.getproduct(productId);
		AddToCart addToCart=addtocartdaoimpl.getCart(product);
		
		return null;
	} */
	@RequestMapping("/Cart")
	public String Addtocart(HttpServletRequest httpServletRequest)
	{
		int productid=Integer.parseInt(httpServletRequest.getParameter("id"));
		int quantity=Integer.parseInt(httpServletRequest.getParameter("Quantity"));
		Product product=productdaoimpl.getproduct(productid);
		AddToCart addToCart=addtocartdaoimpl.getCart(product,quantity);
		return null;
	}
	@RequestMapping("/displaycart")
	public ModelAndView RetrieveAllCartData()
	  {


	      ModelAndView  mv=new ModelAndView("DisplayCart");
	      
	       List<AddToCart> cartdata=(List<AddToCart>)addtocartdaoimpl.getcartData();
	     
	  	mv.addObject("cartlist",cartdata);
	       
	      return  mv;
	      }
	
}

	
	
	
