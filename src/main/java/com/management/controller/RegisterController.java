package com.management.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infrastructure.exception.EntityOperateException;
import com.infrastructure.exception.ValidatException;
import com.management.model.AccountRegisterModel;
import com.management.model.extension.AccountRegisterModelExtension;
import com.management.service.AccountService;

@Controller
public class RegisterController extends BaseController {

	@Autowired
	@Qualifier("AccountService")
	private AccountService accountService;

	@RequestMapping(value = "/account/register", method = {RequestMethod.GET})
	public String register(Model model) {
		if (!model.containsAttribute("contentModel"))
			model.addAttribute("contentModel", new AccountRegisterModel());
		return "account/register";
	}

	@RequestMapping(value = "/account/register", method = {RequestMethod.POST})
	public String register(HttpServletRequest request, Model model, @Valid @ModelAttribute("contentModel") AccountRegisterModel accountRegisterModel,
			BindingResult result) throws ValidatException, EntityOperateException, NoSuchAlgorithmException {
		if (!accountRegisterModel.getPassword().equals(accountRegisterModel.getConfirmPassword()))
			result.addError(new FieldError("contentModel", "confirmPassword", "确认密码与密码输入不一致。"));
		// 如果有验证错误 返回到form页面
		if (result.hasErrors())
			return register(model);
		else if (accountService.accountExist(accountRegisterModel.getUsername())) {
			result.addError(new FieldError("contentModel", "username", "该用户名已被注册。"));
			return register(model);
		}
		accountService.saveRegister(AccountRegisterModelExtension.toAccount(accountRegisterModel));

		return "redirect:/login";
	}

}
