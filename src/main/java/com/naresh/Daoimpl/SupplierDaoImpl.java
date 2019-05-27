
package com.naresh.Daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naresh.model.Category;
import com.naresh.model.Supplier;
@Component
public class SupplierDaoImpl {
	@Autowired
	SessionFactory sessionFactory;
	public void SupplierDaoAddData(Supplier supplier)
	{
	   Session session=sessionFactory.openSession();
	   if(supplier.getSupplierId()==0)
	   {
		   int id=(int)(Math.random()*10000);
		   supplier.setSupplierId(id);
		   System.out.println("if loading");
	   }
	   session.saveOrUpdate(supplier);
	   Transaction transaction=session.beginTransaction();
	   transaction.commit();
	   System.out.println(sessionFactory);
	    session.close();
	}
	public List<Supplier> getSupplierData()
	{
	Session session=sessionFactory.openSession();
	   Query query=session.createQuery("from Supplier");
		List<Supplier> supplierlist=query.list();
		for(Supplier supplierdata:supplierlist)
		{
			System.out.println(supplierdata.getSupplierId());
			System.out.println(supplierdata.getSupplierName());
			System.out.println(supplierdata.getSupplierDetails());
		}
		session.close();
		return supplierlist;
	}
	public Supplier getsupplier(int supplierId)
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
		}
	public void deletesupplier(int supplierId)
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=getsupplier(supplierId);
		session.delete(supplier);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
	}
	public void editcategory(int supplierId)
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=getsupplier(supplierId);
		session.saveOrUpdate(supplier);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
	}
	}
	
	
	
	
	
	
	

