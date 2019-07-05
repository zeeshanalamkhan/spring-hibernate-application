package com.zeeshan.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zeeshan.entity.UserBO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * protected Session getSession() { return sessionFactory.getCurrentSession(); }
	 */

	@Override
	public void addUser(UserBO user) {
		System.out.println("dao save method");
		this.sessionFactory.getCurrentSession().save(user);

	}

	@Override
	public void updateUser(UserBO user) {

		UserBO userToUpdate = getUser(user.getId());
		userToUpdate.setId(user.getId());
		userToUpdate.setName(user.getName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setMobileNo(userToUpdate.getMobileNo());
		userToUpdate.setDate(user.getDate());
		this.sessionFactory.getCurrentSession().update(userToUpdate);

	}

	@Override
	public UserBO getUser(int id) {

		UserBO user = (UserBO) this.sessionFactory.getCurrentSession().get(UserBO.class, id);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		UserBO user = getUser(id);
		if (user != null) {
			this.sessionFactory.getCurrentSession().delete(user);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBO> getUsers() {
		List<UserBO> list = this.sessionFactory.getCurrentSession().createQuery("from UserBO").list();
		return list;
	}

}
