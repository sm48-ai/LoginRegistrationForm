package in.sp.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entities.User;
import in.sp.main.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	private UserService userService;
	
	@GetMapping("regPage")
	public String openRegPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user,Model model) {
		boolean status=userService.registerUser(user);
		if(status) {
			model.addAttribute("succMsg", "User Registered Successfully");
			System.out.println("User Registered Successfully");
		}else {
			model.addAttribute("errMsg","Registration failed");
			System.out.println("Registration failed");
		}
		return "register";
	}
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("userst", new User());
		
		return "login";
	}
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("userst") User user,Model model) {
		User validuser=userService.loginUser(user.getEmail(), user.getPassword());
		if(validuser !=null) {
			model.addAttribute("modelName", validuser.getName());
			return "profile";
		}else {
			model.addAttribute("errMsg","Email Id and Password didnt match");
			return "login";
		}
		
		
		
	}
	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest req) {
		HttpSession session= req.getSession(false);
		if(session !=null) {
		session.invalidate();
		}
		
		return "login";
	}

}
