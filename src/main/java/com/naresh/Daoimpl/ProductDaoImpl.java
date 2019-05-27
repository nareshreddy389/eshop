package com.naresh.Daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naresh.model.AddToCart;
import com.naresh.model.Category;
import com.naresh.model.Product;
import com.naresh.model.Supplier;

@Component
public class ProductDaoImpl {
@Autowired
SessionFactory sessionFactory;
@Autowired
ProductDaoImpl productdaoimpl;
public void productDao(Product product)
{
	Session session=sessionFactory.openSession();
	if(product.getProductId()==0) 
	   {
	int id=(int)(Math.random()*10000);
	product.setProductId(id);
	   }
	session.saveOrUpdate(product);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
}
public List<Product> getProductData()
{
Session session=sessionFactory.openSession();
   Query query=session.createQuery("from Product");
	List<Product> productlist=query.list();
	for(Product productdata:productlist)
	{
		System.out.println(productdata.getProductId());
		System.out.println(productdata.getProductName());
		System.out.println(productdata.getProductPrice());
		System.out.println(productdata.getProductDescription());
		System.out.println(productdata.getProductCategory());
		System.out.println(productdata.getProductSupplier());
	}
	session.close();
	return productlist;
}
public Product getproduct(int productid)
{
	Session session=sessionFactory.openSession();
	Product product=session.get(Product.class,productid);
	session.close();
	return product;
	}
public void deleteproduct(int productid)
{
	Session session=sessionFactory.openSession();
	Product product=getproduct(productid);
	session.delete(product);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
}
public void editcategory(int productid)
{
	Session session=sessionFactory.openSession();
	Product product=getproduct(productid);
	session.saveOrUpdate(product);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
}
}
										//*************USER MODULE***************//

















