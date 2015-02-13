<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <%@ include file="../shared/taglib.jsp" %>

        <html>

        <head>
            <title>注册</title>
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta content="width=device-width, initial-scale=1.0" name="viewport" />
            <meta content="" name="description" />
            <meta content="" name="author" />
            <meta name="MobileOptimized" content="320">

            <%@ include file="../shared/importCss.jsp" %>
                <link href="<c:url value='/static/css/pages/login.css'/>" rel="stylesheet" type="text/css" />

                <%@ include file="../shared/importJs.jsp" %>
                    <script src="<c:url value='/static/plugins/jquery-validation/dist/jquery.validate.min.js'/>" type="text/javascript"></script>
                    <script src="<c:url value='/static/js/app.js'/>" type="text/javascript"></script>
                    <script src="<c:url value='/static/js/account.validate.js'/>" type="text/javascript"></script>

                    <link rel="shortcut icon" href="favicon.ico" />
        </head>

        <body class="login">
            <div class="logo">
                <!-- <img src="static/assets/img/logo.png" alt="" /> -->
            </div>
            <div class="content">
                <form:form modelAttribute="contentModel" class="register-form" method="POST">
                    <h3>注册新账户</h3>
                    <p>请输入个人信息：</p>
                    <div class="form-group">
                        <label class="control-label visible-ie8 visible-ie9">姓名</label>
                        <div class="input-icon">
                            <i class="icon-font"></i>
                            <form:input path="name" class="form-control placeholder-no-fix" autocomplete="off" placeholder="姓名" />
                            <br />
                            <form:errors path="name" class="field-has-error"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label visible-ie8 visible-ie9">邮箱</label>
                        <div class="input-icon">
                            <i class="icon-envelope"></i>
                            <form:input path="email" class="form-control placeholder-no-fix" autocomplete="off" placeholder="邮箱" />
                            <br />
                            <form:errors path="email" class="field-has-error"></form:errors>
                        </div>
                    </div>
                    <p>请输入账户信息：</p>
                    <div class="form-group">
                        <label class="control-label visible-ie8 visible-ie9">用户名</label>
                        <div class="input-icon">
                            <i class="icon-user"></i>
                            <form:input path="username" class="form-control placeholder-no-fix" autocomplete="off" placeholder="用户名" />
                            <br />
                            <form:errors path="username" class="field-has-error"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label visible-ie8 visible-ie9">密码</label>
                        <div class="input-icon">
                            <i class="icon-lock"></i>
                            <form:password path="password" class="form-control placeholder-no-fix" autocomplete="off" placeholder="密码" />
                            <br />
                            <form:errors path="password" class="field-has-error"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label visible-ie8 visible-ie9">确认密码</label>
                        <div class="controls">
                            <div class="input-icon">
                                <i class="icon-ok"></i>
                                <form:password path="confirmPassword" class="form-control placeholder-no-fix" autocomplete="off" placeholder="确认密码" />
                                <br />
                                <form:errors path="confirmPassword" class="field-has-error"></form:errors>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="register_agreement_error"></div>
                        <form:errors path="agreement" class="field-has-error"></form:errors>
                    </div>
                    <div class="form-actions">
                        <button id="register-back-btn" type="button" class="btn btn-default" onclick="window.history.back()">
                            <i class="m-icon-swapleft"></i> 返回
                        </button>
                        <button type="submit" id="register-submit-btn" class="btn btn-info pull-right">
                            注册 <i class="m-icon-swapright m-icon-white"></i>
                        </button>
                    </div>
                </form:form>
            </div>
            <div class="copyright">2015 &copy; equipment management by Lee.</div>

            <script type="text/javascript">
                $(function() {
                    App.init();
                    AccountValidate.handleRegister();
                });

                $("#register-back-btn").click(function() {
                    $(this).hide();
                });
            </script>
        </body>

        </html>