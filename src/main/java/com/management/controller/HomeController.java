package com.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.management.auth.AuthPassport;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

	@AuthPassport
	@RequestMapping(value = "/index")
	public String index() {

		return "home/index";
	}

}
