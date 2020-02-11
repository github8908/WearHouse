package com.jyoti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jyoti.model.Employee;
import com.jyoti.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	IEmployeeService service;
	@RequestMapping("/register")
	public String ShowRegisterPage() {
		return "EmployeeRegister";
	}
	@RequestMapping(value = "/save" ,method = RequestMethod.POST)
	public String EmployeeRegister(@ModelAttribute Employee employee,Model model) {
		//call the service method
		Integer id=service.saveEmployee(employee);
		String msg="Record "+id+" save";
		model.addAttribute("msg",msg);
		return "EmployeeRegister";
	}
}
