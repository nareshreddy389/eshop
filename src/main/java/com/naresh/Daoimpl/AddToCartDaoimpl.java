package com.naresh.Daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naresh.controller.CartController;
import com.naresh.model.AddToCart;
import com.naresh.model.Product;

@Component
public class AddToCartDaoimpl {

	@Autowired
	SessionFactory factory;
	//set productdata to cart
	public AddToCart getCart(Product product,int quantity)
	{
		AddToCart addToCart=new AddToCart();
		Session session=factory.openSession();
		if(addToCart.getCartId()==0) 
		   {
		int id=(int)(Math.random()*10000);
		addToCart.setCartId(id);
		   }
		addToCart.setProductId(product.getProductId());
		addToCart.setProductName(product.getProductName());
		addToCart.setProductPrice(product.getProductPrice());
		addToCart.setProductSupplier(product.getProductSupplier());
		addToCart.setQuantity(quantity);
		addToCart.setTotalPrice(addToCart.getProductPrice()*addToCart.getQuantity());
		session.save(addToCart);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return addToCart;
	}
	public List<AddToCart> getcartData()
	{
	Session session=factory.openSession();
	   Query query=session.createQuery("from AddToCart");
		List<AddToCart> cartlist=query.list();
		for(AddToCart cartdata:cartlist)
		{
			System.out.println(cartdata.getProductId());
			
		}
		session.close();
		return cartlist;
	}
}
