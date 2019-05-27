package com.naresh.Daoimpl;

import java.util.List;

import javax.servlet.RequestDispatcher;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naresh.model.Category;



@Component
public class CategoryDaoImpl
{
@Autowired
SessionFactory sessionFactory;
public void CategoryDao(Category c)
{
    Session s=sessionFactory.openSession();
    if(c.getCategoryId()==0)
    {
    int id=(int)(Math.random()*10000);
    c.setCategoryId(id);
	System.out.println("if loading");
    }
    s.saveOrUpdate(c);
    Transaction t=s.beginTransaction();
    t.commit();
    System.out.println(sessionFactory);
    s.close();
}

public List<Category> getCategoryData()
{
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Category");
	List<Category> categoryList=query.list();
	for(Category category:categoryList)
	{
		
		System.out.println(category.getCategoryId());
		System.out.println(category.getCategoryName());
		System.out.println(category.getCategoryDiscription());
	}
	session.close();
	return categoryList;
	
}
public Category getcategory(int categoryid)
{
	Session session=sessionFactory.openSession();
	Category category=session.get(Category.class,categoryid);
	session.close();
	return category;
	}

public void deletecategory(int categoryid)
{
	Session session=sessionFactory.openSession();
	Category category=getcategory(categoryid);
	session.delete(category);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
}
public void editcategory(int categoryid)
{
	Session session=sessionFactory.openSession();
	Category category=getcategory(categoryid);
	session.saveOrUpdate(category);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	
}
}