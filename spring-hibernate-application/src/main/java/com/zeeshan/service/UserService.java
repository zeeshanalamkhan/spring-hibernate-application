package com.zeeshan.service;

import java.text.ParseException;
import java.time.Period;
import java.util.Date;
import java.util.List;

import com.zeeshan.vo.UserVO;

public interface UserService {

	public void addUser(UserVO User)throws ParseException;

	public void updateUser(UserVO User) throws ParseException;

	public UserVO getUser(int id);

	public void deleteUser(int id);

	public List<UserVO> getUsers();

	public Period calculateDate(Date date);
	
}
