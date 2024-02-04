package com.ty.food.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.Admin;
import com.ty.food.dto.Product;
import com.ty.food.dto.User;
import com.ty.food.service.AdminService;
import com.ty.food.service.ProductService;
import com.ty.food.service.UserService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	ProductService  productService;
	
	@RequestMapping("/creatadmine")
	public ModelAndView loadAdmin() {
		ModelAndView modelAndView = new ModelAndView("createadmin.jsp");
		modelAndView.addObject("create", new Admin());
		return modelAndView;
	}

	@RequestMapping("/createadminaccount")
	public ModelAndView saveAdmin1(@ModelAttribute Admin admin) {
		Admin admine = adminService.saveAdmin(admin);
		ModelAndView modelAndView = null;
		if (admine != null) {
			// modelAndView.addObject("create", new Admin());
			modelAndView=new ModelAndView("home.jsp");
			modelAndView.addObject("message ", admine.getName() + " admin name is  saved successfully");
		} else {
			modelAndView=new ModelAndView("home.jsp");

			modelAndView.addObject("message",admine.getName() + "admin name is  not saved");

		}
		return modelAndView;
	}

//	@GetMapping("/adminlogin")
//	public ModelAndView loadadmine() {
//		ModelAndView modelAndView = new ModelAndView("adminlogin.jsp");
//		modelAndView.addObject("load", new Admin());
//		return modelAndView;
//	}

	@PostMapping("/admindata")
	public ModelAndView fetchAdminData( String email, String password) {
		Admin admin2 = adminService.validateAdmin(email, password);
		ModelAndView modelAndView = null;
		if (admin2 != null) {
			modelAndView = new ModelAndView("adminmenu.jsp");
			modelAndView.addObject("message", "successfully login admin");	

		} else {
			modelAndView = new ModelAndView("home.jsp");
			modelAndView.addObject("message", "wrong password or wrong username");
		}
		return modelAndView;
	}
	///////////////////////////////////////product///////////////////////////////////
	@GetMapping("/loadproduct")
	public ModelAndView addProduct() {
		ModelAndView modelAndView=new ModelAndView("adminsavingproduct.jsp");
		modelAndView.addObject("saveproduct",new Product());
		return modelAndView;
	}
	@PostMapping("/saveproduct")
	public ModelAndView savingProductInDataBase(@ModelAttribute Product product) {
		Product  product2=productService.saveProduct(product);
		ModelAndView modelAndView=new ModelAndView("adminmenu.jsp");
		if(product2!=null) {
			modelAndView.addObject("message",product2.getName()+" ,product is saved successfull");

		}else {
			modelAndView.addObject("message",product2.getName()+" ,product is not saved successfull");
		}
		return modelAndView;
	}
////////////////////////////////////getallproduct/////////////////////////dddddddddddddoooooooooooooooooooooo
	@GetMapping("/getallproduct")
	public ModelAndView getAllproducts() {
		List<Product> products=productService.getAllProduct();
		ModelAndView  modelAndView=new ModelAndView("adminviewingallproduct.jsp");

		if(products.size()>0) {
			modelAndView.addObject("allproduct",products);
			//modelAndView=new ModelAndView("adminviewingallproduct.jsp");

		}else {
			modelAndView.addObject("allproduct","there is no product to show");
			modelAndView=new ModelAndView("adminmenu.jsp");

		}
		return modelAndView;
	}
	
	////////editproduct////////////////
	@GetMapping("/editproducting")
	public ModelAndView loadEditProduct() {
		ModelAndView  modelAndView=new ModelAndView("editproduct.jsp");
		modelAndView.addObject("editloadproduct",new Product());
		return modelAndView;
	}
	
	@GetMapping("/editproductfromdatabase")
	public ModelAndView editProduct(@ModelAttribute Product product,@RequestParam(name = "id")int id) {
		Product  product2=productService.updateProduct(product,id);
		ModelAndView  modelAndView=new ModelAndView();
		if(product2!=null) {
			modelAndView.addObject("messageabouteditproductbyadmin",product2.getName()+" product is updated");
		modelAndView=new ModelAndView("adminmenu.jsp");
		}else {
			modelAndView.addObject("messageabouteditproductbyadmin",product2.getName()+"product is not updated");
			modelAndView=new ModelAndView("adminmenu.jsp");

		}
		return modelAndView;
	}
	
	//////////////////////////////delete product///////////////////////
	@GetMapping("/deleteproduct")
	public ModelAndView deleteProduct(@RequestParam(name = "id")int id) {
		boolean result=productService.deleteProduct(id);
		ModelAndView modelAndView=new ModelAndView("adminmenu.jsp");

		if(result){
			modelAndView.addObject("message","item is deleted successfully");
			//modelAndView=new ModelAndView("adminviewingallproduct.jsp");
		}else {
			modelAndView.addObject("message","item is not deleted ");
			modelAndView=new ModelAndView("adminviewingallproduct.jsp");

		}
		return modelAndView;
	}
	
	
	
	
	
	
}
