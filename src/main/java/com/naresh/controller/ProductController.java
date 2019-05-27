package com.naresh.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naresh.model.AddToCart;
import com.naresh.model.Category;
import com.naresh.model.Product;
import com.naresh.model.Supplier;
import com.naresh.Daoimpl.CategoryDaoImpl;
import com.naresh.Daoimpl.ProductDaoImpl;
import com.naresh.Daoimpl.SupplierDaoImpl;
@Controller
public class ProductController 
{
	@Autowired
	ProductDaoImpl productdaoimpl;
	@Autowired
	CategoryDaoImpl category;
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
@RequestMapping("/addproducts")
public ModelAndView goToProductForm()
{
	List<Category> categorylist=category.getCategoryData();
ModelAndView mv=new ModelAndView("AddProducts");
mv.addObject("catlists", categorylist);
List<Supplier> supplierlist=supplierDaoImpl.getSupplierData();
mv.addObject("suplist", supplierlist);
mv.addObject("pro",new Product());
mv.addObject("buttonname","AddProducts");

return mv;
}
@RequestMapping(value="/addpro",method=RequestMethod.POST)
public ModelAndView recieveproductFormData(@ModelAttribute ("pro") Product p)
{
	ModelAndView mv=new ModelAndView("home");
	 System.out.println(p.getProductId());
     System.out.println(p.getProductName());
     System.out.println(p.getProductPrice());
     System.out.println(p.getProductDescription());
     System.out.println(p.getProductCategory());
     System.out.println(p.getProductSupplier());
     productdaoimpl.productDao(p);
     MultipartFile image=p.getProimage();
     System.out.println("testing image="+image);
     try {
    	 byte bytearray[]=image.getBytes();
		FileOutputStream fos=new FileOutputStream("F:\\ eclipse-workspace\\eshop\\src\\main\\webapp\\resources\\product-images\\"+p.getProductId()+".jpg");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		bos.write(bytearray);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    finally
    {
    	FilterOutputStream bos = null;
		try {
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   return mv;
}        

@RequestMapping("/showproducts")
public ModelAndView RetrieveAllProductData()
  {


      ModelAndView  mv=new ModelAndView("showproducts");
      
       List<Product> showproductdata=(List<Product>)productdaoimpl.getProductData();
     
  	mv.addObject("prolist",showproductdata);
       
      return  mv;
      }
@RequestMapping("/deletepro")
public String deleteproduct(@RequestParam("proid")int productid)
  {

	  System.out.println(productid);
	  Product p=productdaoimpl.getproduct(productid);
	  productdaoimpl.deleteproduct(productid);
      File file=new File("F:\\ eclipse-workspace\\eshop\\src\\main\\webapp\\resources\\product-images\\"+p.getProductId()+".jpg");
      file.delete();
       return  "redirect:showproducts";
  }

@RequestMapping("/editpro")
public ModelAndView editproduct(@RequestParam("proid")int productid)
  {

	  System.out.println(productid);
	  Product prod=productdaoimpl.getproduct(productid);
	  
      ModelAndView  mv=new ModelAndView("AddProducts");
      
       
      
      
  	mv.addObject("pro",prod);
  	mv.addObject("buttonname","UpdateProduct");
  	List<Category> categorylist=category.getCategoryData();
  	mv.addObject("catlists", categorylist);
  	List<Supplier> supplierlist=supplierDaoImpl.getSupplierData();
  	mv.addObject("suplist", supplierlist);
       
      return  mv;
  }

												//**********USER MODULE***********//


@RequestMapping("/userhome")
public ModelAndView userProducts()
{


    ModelAndView  mv=new ModelAndView("UserProducts");
    
     List<Product> userproducts=(List<Product>)productdaoimpl.getProductData();
   
	mv.addObject("prolist",userproducts);
     
    return  mv;
}
    @RequestMapping("/viewdetails")
    public ModelAndView productDetails(@RequestParam("proid")int productid)
    {
    	ModelAndView  mv=new ModelAndView("ProductDetails");
        
     Product product=productdaoimpl.getproduct(productid);
       
    	mv.addObject("prolist",product);
         
        return  mv;
    }
    
}
    


