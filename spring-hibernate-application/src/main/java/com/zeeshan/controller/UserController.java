package com.zeeshan.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zeeshan.service.UserService;
import com.zeeshan.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public ModelAndView mainPage() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/index")
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/user/add")
	public ModelAndView addUserPage() {

		System.out.println("controller save method");
		ModelAndView mav = new ModelAndView("add-user-form");
		mav.addObject("user", new UserVO());
		return mav;
	}

	@RequestMapping(value = "/user/add/process")
	public ModelAndView addingUser(@ModelAttribute("user") @Valid UserVO user, BindingResult result)
			throws ParseException {
		ModelAndView mav = new ModelAndView("home");
		if (result.hasErrors()) {
			return new ModelAndView("add-user-form");
		}
		userService.addUser(user);

		/* Period period = userService.calculateDate(stringToDate(user.getDob())); */
		String message = "user added Successfully";
		mav.addObject("message", message);
		/*
		 * mav.addObject("days", period.getDays()); mav.addObject("months",
		 * period.getMonths()); mav.addObject("years", period.getYears());
		 */ return mav;
	}

	@RequestMapping(value = "/user/list")
	public ModelAndView listOfUsers() {
		ModelAndView mav = new ModelAndView("list-of-users");
		List<UserVO> users = userService.getUsers();
		mav.addObject("users", users);
		return mav;
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editingUser(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("edit-user-form");
		UserVO user = userService.getUser(id);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUser(@PathVariable Integer id, @ModelAttribute("user") @Valid UserVO user,
			BindingResult result) throws ParseException {
		ModelAndView mav = new ModelAndView("home");
		if (result.hasErrors()) {
			return new ModelAndView("edit-user-form");
		}

		userService.updateUser(user);
		String message = "user edited Successfully";
		mav.addObject("message", message);
		return mav;
	}

	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer id) {

		ModelAndView mav = new ModelAndView("home");
		userService.deleteUser(id);
		String message = "user deleted Successfully";
		mav.addObject("message", message);
		return mav;
	}

}
