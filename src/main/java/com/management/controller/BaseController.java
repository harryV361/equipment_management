package com.management.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.management.service.AccountService;
import com.management.service.AuthorityService;
import com.management.service.OrganizationService;
import com.management.service.RoleService;

public abstract class BaseController {  

	protected final String searchModelName="searchModel";
	protected final String treeDataSourceName="treeDataSource";
	protected final String selectDataSourceName="selectDataSource";
	
	@Autowired
    @Qualifier("RoleService")
    protected RoleService roleService;
	
	@Autowired
    @Qualifier("AccountService")
    protected AccountService accountService;
	
	@Autowired
    @Qualifier("AuthorityService")
	protected AuthorityService authorityService;
	
	@Autowired
    @Qualifier("OrganizationService")
	protected OrganizationService organizationService;
	
	@ExceptionHandler  
    public String exception(HttpServletRequest request, Exception e) {  
          
        request.setAttribute("exceptionMessage", e.getMessage());  
          
        // 根据不同错误转向不同页面  
        if(e instanceof SQLException) 
            return "testerror";   
        else
            return "error";  
    }  
	
}  
