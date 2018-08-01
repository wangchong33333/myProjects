package com.mrwang.hellospringmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.mrwang.hellospringmvc.domain.User;

public class CommandController extends AbstractCommandController {

	public CommandController() {
		// TODO Auto-generated constructor stub
		this.setCommandClass(User.class);
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		// TODO Auto-generated method stub
		User user = (User) command;
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("index");
		return mv;
	}

	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {

		String string = request.getParameter("birthday");
		if (string.contains("/")) {
			binder.registerCustomEditor(Date.class, new CustomDateEditor(
					new SimpleDateFormat("yyyy/MM/dd"), true));
		} else if (string.contains("-")) {
			binder.registerCustomEditor(Date.class, new CustomDateEditor(
					new SimpleDateFormat("yyyy-MM-dd"), true));
		}

	}
}
