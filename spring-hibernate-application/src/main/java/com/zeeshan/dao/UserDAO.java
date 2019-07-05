package com.zeeshan.dao;

import java.util.List;

import com.zeeshan.entity.UserBO;

public interface UserDAO {

	public void addUser(UserBO user);

	public void updateUser(UserBO user);

	public UserBO getUser(int id);

	public void deleteUser(int id);

	public List<UserBO> getUsers();
}
