package com.mednet.employee.controller;

import com.mednet.employee.model.Employee;
import com.mednet.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Display the registration page
	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}

	// Handle registration form submission
	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute Employee employee) {

		employeeService.registerEmployee(employee);
		return "redirect:/login";
	}

	// Display the login page
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	// Handle login request and validate credentials
	@PostMapping("/login")
	public String loginEmployee(@RequestParam String loginId, @RequestParam String password, HttpSession session, Model model) {

		Employee employee = employeeService.login(loginId, password);

		if (employee != null) {
			session.setAttribute("loggedUser", employee);
			return "redirect:/welcome";
		} 
		else {
			model.addAttribute("error", "Invalid Login Credentials");
			return "login";
		}
	}

	// Show welcome page with list of registered employees
	@GetMapping("/welcome")
	public String welcomePage(HttpSession session, Model model) {

		Employee loggedUser = (Employee) session.getAttribute("loggedUser");

		if (loggedUser == null) {
			return "redirect:/login";
		}

		List<Employee> employees = employeeService.getAllEmployees();

		model.addAttribute("user", loggedUser);
		model.addAttribute("employees", employees);

		return "welcome";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
