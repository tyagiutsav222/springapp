package com.example.learnspringboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login", method= RequestMethod.GET )  //url
	//public String gotoLoginPage(@RequestParam String name, ModelMap model)
	public String gotoLoginPage()
	{
		//model.put("name", name);
		return "LoginPage";  //returns jsp page;
		
	}
	
	@RequestMapping(value="login", method= RequestMethod.POST )   //url
	public String gotowelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model)	
	{
		if(authenticationService.authenticate(name, password))
		{
		model.put("name", name);
		model.put("password", password);
		return "welcomePage";  //returns jsp page;
		}
		else {
			model.put("errorMeassage", "Invalid Credentials. please try again.");
			return "LoginPage";
		}
	}

}
