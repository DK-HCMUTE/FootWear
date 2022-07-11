package com.shop.footwear.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.footwear.user.Role;
import com.shop.footwear.user.User;
import com.shop.footwear.user.UserService;

@Controller
@RequestMapping("adminUser")
public class AdminController {

	@Autowired
	UserService userService;

	@GetMapping("home")
	public String adminHomeView(Model model) {
		return "index";
	}

	@GetMapping("view")
	public String adminUserView(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "user";
	}

	@GetMapping("new")
	public String adminUserNew(Model model) {
		List<Role> roles = userService.getRoles();
		System.out.println(roles);
		model.addAttribute("roles",roles);
		return "user_form";
	}

	@PostMapping("register")
	public String registerUser(@RequestBody User user) {
		userService.registerUser(user);
		return "saved";
	}
}
