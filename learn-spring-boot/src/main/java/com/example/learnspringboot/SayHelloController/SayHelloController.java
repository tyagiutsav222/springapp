package com.example.learnspringboot.SayHelloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //controller to call jsp page.
public class SayHelloController {
	
	@RequestMapping("say-hello-jsp")   //url
	public String SayHelloMethod()
	{
		return "sayHello";  //returns jsp page;	
	}

}
