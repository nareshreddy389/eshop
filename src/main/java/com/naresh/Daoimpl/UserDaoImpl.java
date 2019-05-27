package com.naresh.Daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naresh.model.User;

@Component
public class UserDaoImpl {

	@Autowired
	SessionFactory sessionFactory;
	public void getUserDetails(User user)
	{
		user.setRole("ROLE-USER");
		user.setEnabled(true);
		Session session=sessionFactory.openSession();
		session.save(user);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
	}
	
	public boolean checkLogin(User user)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where email=:em and password=:pw");
		query.setParameter("em",user.getEmail());
		query.setParameter("pw",user.getPassword());
		User user2=(User)query.uniqueResult();
		if(user2==null)
		{
			return false;
		}
			else
			{
				return true;
			}
		}
	}

