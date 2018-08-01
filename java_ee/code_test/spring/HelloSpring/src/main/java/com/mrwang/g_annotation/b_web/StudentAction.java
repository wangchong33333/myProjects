package com.mrwang.g_annotation.b_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("studentAction")
public class StudentAction {

	@Autowired
	private StudentService studentService;

	public void execute() {
studentService.addStudent();
	}
}
