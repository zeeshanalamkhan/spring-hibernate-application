package com.zeeshan.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
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

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView mainPage() {
		logger.info("mainPage method");
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		logger.info("indexPage method");
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public ModelAndView addUserPage() {

		logger.info("addUserPage method");
		ModelAndView mav = new ModelAndView("add-user-form");
		mav.addObject("user", new UserVO());
		return mav;
	}

	@RequestMapping(value = "/user/add/process", method = RequestMethod.POST)
	public ModelAndView addingUser(@ModelAttribute("user") @Valid UserVO user, BindingResult result)
			throws ParseException {
		logger.info("addingUser method");
		ModelAndView mav = new ModelAndView("home");
		if (result.hasErrors()) {
			logger.error("user bean has error");
			return new ModelAndView("add-user-form");
		}

		logger.info("user bean has no errors");
		userService.addUser(user);

		String message = "user added Successfully";
		mav.addObject("message", message);
		return mav;
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public ModelAndView listOfUsers() {
		logger.info("listOfUsers method");
		ModelAndView mav = new ModelAndView("list-of-users");
		List<UserVO> users = userService.getUsers();

		mav.addObject("users", users);
		return mav;
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editingUser(@PathVariable Integer id) {
		logger.info("editingUser method");
		ModelAndView mav = new ModelAndView("edit-user-form");
		UserVO user = userService.getUser(id);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUser(@PathVariable Integer id, @ModelAttribute("user") @Valid UserVO user,
			BindingResult result) throws ParseException {
		logger.info("editUser method");
		ModelAndView mav = new ModelAndView("home");
		if (result.hasErrors()) {
			logger.info("user bean has errors");
			return new ModelAndView("edit-user-form");
		}

		logger.info("user bean has no errors");
		userService.updateUser(user);
		String message = "user edited Successfully";
		mav.addObject("message", message);
		return mav;
	}

	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer id) {

		logger.info("deleteUser method");
		ModelAndView mav = new ModelAndView("home");
		userService.deleteUser(id);
		String message = "user deleted Successfully";
		mav.addObject("message", message);
		return mav;
	}

}
