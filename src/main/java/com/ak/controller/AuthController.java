package com.ak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class AuthController {

	    @PostMapping("/login")
	    public String login(@RequestParam String username, @RequestParam String password) {
	    	   System.out.println("Login attempted with: " + username + ", " + password);
	        // check credentials
	        if (username.equals("admin") && password.equals("password")) {
	            return "redirect:/employee/add";  // ✅ redirect to another controller
	        } else {
	            return "login"; // show the login page again
	        }
	    }

			    @GetMapping("/login")
			    public String showLoginForm() {
			        return "login";  // renders login.html from templates/
			    }
		
}
