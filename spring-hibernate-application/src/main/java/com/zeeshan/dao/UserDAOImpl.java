package com.zeeshan.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zeeshan.entity.UserBO;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(UserBO user) {
		logger.debug("addUser method");
		this.sessionFactory.getCurrentSession().save(user);

	}

	@Override
	public void updateUser(UserBO user) {

		logger.debug("updateUser method");
		UserBO userToUpdate = getUser(user.getId());
		userToUpdate.setId(user.getId());
		userToUpdate.setName(user.getName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setMobileNo(userToUpdate.getMobileNo());
		userToUpdate.setDate(user.getDate());
		userToUpdate.setDays(user.getDays());
		userToUpdate.setMonths(user.getMonths());
		userToUpdate.setYears(user.getYears());
		this.sessionFactory.getCurrentSession().update(userToUpdate);

	}

	@Override
	public UserBO getUser(int id) {

		logger.debug("getUser method");
		UserBO user = (UserBO) this.sessionFactory.getCurrentSession().get(UserBO.class, id);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		logger.debug("deleteUser method");
		UserBO user = getUser(id);
		if (user != null) {
			this.sessionFactory.getCurrentSession().delete(user);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBO> getUsers() {
		logger.debug("getUser method");
		List<UserBO> list = this.sessionFactory.getCurrentSession().createQuery("from UserBO").list();
		return list;
	}

}
