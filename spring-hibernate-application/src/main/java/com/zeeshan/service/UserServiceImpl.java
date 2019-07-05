package com.zeeshan.service;

import static com.zeeshan.util.DateUtil.dateToString;
import static com.zeeshan.util.DateUtil.stringToDate;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeeshan.dao.UserDAO;
import com.zeeshan.entity.UserBO;
import com.zeeshan.vo.UserVO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void addUser(UserVO user) throws ParseException {
		System.out.println("service save method");
		UserBO bo = new UserBO();
		// bo.setId(Integer.parseInt(user.getId()));
		bo.setName(user.getName());
		bo.setEmail(user.getEmail());
		bo.setMobileNo(Long.parseLong(user.getMobileNo()));
		bo.setDate(stringToDate(user.getDob()));

		Period period = calculateDate(stringToDate(user.getDob()));
		bo.setDays(period.getDays());
		bo.setMonths(period.getMonths());
		bo.setYears(period.getYears());

		userDAO.addUser(bo);

	}

	@Override
	@Transactional
	public void updateUser(UserVO user) throws ParseException {
		UserBO bo = new UserBO();
		bo.setId(Integer.parseInt(user.getId()));
		bo.setName(user.getName());
		bo.setEmail(user.getEmail());
		bo.setMobileNo(Long.parseLong("9999999999"));
		bo.setDate(stringToDate(user.getDob()));
		Period period = calculateDate(stringToDate(user.getDob()));
		bo.setDays(period.getDays());
		bo.setMonths(period.getMonths());
		bo.setYears(period.getYears());
		userDAO.updateUser(bo);

	}

	@Override
	public UserVO getUser(int id) {
		UserBO bo = userDAO.getUser(id);
		UserVO user = new UserVO();
		user.setId(bo.getId().toString());
		user.setName(bo.getName());
		user.setEmail(bo.getEmail());
		user.setMobileNo(bo.getMobileNo().toString());
		user.setDob(dateToString(bo.getDate()));
		Period period = calculateDate(bo.getDate());
		bo.setDays(period.getDays());
		bo.setMonths(period.getMonths());
		bo.setYears(period.getYears());
		return user;
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);

	}

	@Override
	public List<UserVO> getUsers() {
		List<UserBO> list = userDAO.getUsers();
		List<UserVO> listVO = new ArrayList<UserVO>();
		for (UserBO bo : list) {
			Integer day = 0, month = 0, year = 0;
			UserVO vo = new UserVO();
			vo.setId(bo.getId().toString());
			vo.setName(bo.getName());
			vo.setEmail(bo.getEmail());
			vo.setMobileNo(bo.getMobileNo().toString());
			vo.setDob(dateToString(bo.getDate()));

			Period period = calculateDate(bo.getDate());
			day = period.getDays();
			month = period.getMonths();
			year = period.getYears();

			vo.setDays(day.toString());
			vo.setMonths(month.toString());
			vo.setYears(year.toString());
			listVO.add(vo);
		}
		return listVO;
	}

	@Override
	public Period calculateDate(Date date) {

		Instant instant = Instant.ofEpochMilli(date.getTime());
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		LocalDate localDate = localDateTime.toLocalDate();

		LocalDate now = LocalDate.now();
		Period period = Period.between(localDate, now);
		return period;

	}

}
