package com.ty.food.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.Product;
import com.ty.food.dto.User;
import com.ty.food.service.ProductService;
import com.ty.food.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService  userService;
	@Autowired
	ProductService productService;

////////////////////////save user////////////////////////
	@GetMapping("/usersignin")
	public ModelAndView loadUser() {
		ModelAndView modelAndView = new ModelAndView("usersigninform.jsp");
		modelAndView.addObject("loaduser", new User());
		return modelAndView;
	}

	@PostMapping("/signinuser")
	public ModelAndView signinUser(@ModelAttribute User user) {
		User user2 = userService.saveUser(user);
		ModelAndView modelAndView = null;

		if (user2 != null) {
			modelAndView = new ModelAndView("home.jsp");
			modelAndView.addObject("message", user.getName() + " is saved succeessfully");
		} else {
			modelAndView = new ModelAndView("home.jsp");
			modelAndView.addObject("message", user.getName() + " is not saved ");

		}
		return modelAndView;
	}
	@PostMapping("/login")
	public ModelAndView validateUser(String email, String password,HttpServletRequest req) {
		List<User> users = userService.validateUserById(email, password);
		HttpSession  session =req.getSession();
		session.setAttribute("user", users);
		ModelAndView modelAndView = null;
		if (users!=null) {
			modelAndView = new ModelAndView("allproduct");
			modelAndView.addObject("validatuser","yes");
			
		} else {
			modelAndView = new ModelAndView("home.jsp");
			modelAndView.addObject("validatuser","emai or password wrong");

		}
		return modelAndView;
	}
	@PostMapping("/allproduct")
	public ModelAndView getAllProduct() {
		List<Product>  products=productService.getAllProduct();
		ModelAndView modelAndView=null;
		if(products.size()>0) {
			modelAndView=new ModelAndView("listofproductforuser.jsp");
			modelAndView.addObject("listofproduct",products);
		}else {
			modelAndView=new ModelAndView("userlogin.jsp");
			modelAndView.addObject("listofproduct","there is no product to show");
		
		}
		return modelAndView;
	}
}
