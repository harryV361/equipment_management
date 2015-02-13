package com.management.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infrastructure.util.PageListUtil;
import com.management.auth.AuthPassport;
import com.management.model.AccountSearchModel;
import com.management.service.AccountService;

@Controller
@RequestMapping(value = "/account")
public class UserController extends BaseController {

	@Autowired
	@Qualifier("AccountService")
	private AccountService accountService;

	@AuthPassport
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public String list(HttpServletRequest request, Model model, AccountSearchModel searchModel) {
		model.addAttribute("requestUrl", request.getServletPath());
		model.addAttribute("requestQuery", request.getQueryString());
		System.out.print(request.getAttribute("permissionMenu"));

		model.addAttribute("searchModel", searchModel);
		int pageNo = ServletRequestUtils.getIntParameter(request, PageListUtil.PAGE_NO_NAME, PageListUtil.DEFAULT_PAGE_NO);
		int pageSize = ServletRequestUtils.getIntParameter(request, PageListUtil.PAGE_SIZE_NAME, PageListUtil.DEFAULT_PAGE_SIZE);
		model.addAttribute("contentModel", accountService.listPage(searchModel.getName(), searchModel.getUsername(), pageNo, pageSize));

		return "account/list";
	}
}
