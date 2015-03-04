<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse navbar-fixed-top">
	<div class="header-inner">
		<a class="navbar-brand" href="index.html">设备智能管控系统 <!-- <img src="assets/img/logo.png" alt="logo" class="img-responsive" /> -->
		</a> <a href="javascript:;" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse"> <%-- <img
			src="<c:url value='/images/menu-toggler.png'/>" alt="" /> --%>
		</a>
		<ul class="nav navbar-nav pull-right">
			<li class="dropdown user"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" data-hover="dropdown"
				data-close-others="true"> <%-- <img alt="" src="<c:url value='/images/avatar3_small.jpg'/>" />&nbsp; --%>
					<span class="username">${sessionScope.accountAuth.name}</span>&nbsp;&nbsp;&nbsp;--&nbsp;&nbsp;&nbsp;
					<span class="username">${sessionScope.accountAuth.accountRole.name}</span>
					<i class="icon-angle-down"></i>
			</a>
				<ul class="dropdown-menu">
					<li><a href="extra_profile.html"><i class="icon-user"></i>我的账户</a>
					</li>
					<li class="divider"></li>
					<li><a href="<c:url value='/account/login'/>"><i
							class="icon-off"></i>注销登录</a></li>
				</ul></li>
		</ul>
	</div>
</div>