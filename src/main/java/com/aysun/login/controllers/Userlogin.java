package com.aysun.login.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aysun.login.models.Users;
import com.aysun.login.service.UserService;
import com.aysun.login.validator.UserValidator;

@Controller
public class Userlogin {

	private UserService userService;
	private UserValidator userValidator;
	
	public Userlogin(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	 @RequestMapping("/login")
	 	public String index(
				@Valid @ModelAttribute("user") Users user,
				@RequestParam(value="error", required=false) String error,
				@RequestParam(value="logout", required=false) String logout,
				Model model) {
			if (error != null) {
				model.addAttribute("errorMessage", "Invalid credentials; please try again.");
			}
			if (logout != null) {
				model.addAttribute("logoutMessage", "Logout successful!");
			}
			return "registrationPage.jsp";
		}
	    
	    @RequestMapping(value = {"/", "/home"})
	    public String home(Principal principal, Model model) {
	        // 1
	    	System.out.println("Aysun Far");
	        String username = principal.getName();
	        model.addAttribute("currentUser", userService.findByUsername(username));
	        return "homePage.jsp";
	    }
	    
	    @RequestMapping("/registration")
	    public String registerForm(@Valid @ModelAttribute("user") Users user) {
	        return "registrationPage.jsp";
	    }
	    
	    @PostMapping("/registration")
	    public String registration(@Valid @ModelAttribute("user") Users user, BindingResult result, Model model) {
	        // NEW
	        userValidator.validate(user, result);
	        if (result.hasErrors()) {
	            return "registrationPage.jsp";
	        }
	        
	        userService.saveWithUserRole(user);
	        return "redirect:/";
	    }
	}