package com.lab;

import com.lab.Model.User;
import com.lab.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@Controller
public class AssignmentApplication {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model){
		// create model object to store form data
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

}
