<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <%@ include file="../shared/taglib.jsp" %>

        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>首页</title>
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta content="width=device-width, initial-scale=1.0" name="viewport" />
            <meta content="" name="description" />
            <meta content="" name="author" />
            <meta name="MobileOptimized" content="320">

            <%@ include file="../shared/importCss.jsp" %>
                <link href="<c:url value='/static/plugins/fullcalendar/fullcalendar/fullcalendar.css'/>" rel="stylesheet" type="text/css" />

                <link rel="shortcut icon" href="favicon.ico" />
        </head>
        <!-- END HEAD -->
        <!-- BEGIN BODY -->

        <body class="page-header-fixed">

            <%@ include file="../shared/pageHeader.jsp" %>

                <div class="clearfix"></div>
                <div class="page-container">

                    <%@ include file="../shared/sidebarMenu.jsp" %>

                        <div class="page-content">

                            <%@ include file="../shared/styleSet.jsp" %>

                                <div class="row">
                                    <div class="col-md-12">
                                        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                                        <h3 class="page-title">首页 <small>欢迎使用设备管理系统</small></h3>
                                        <ul class="page-breadcrumb breadcrumb">
                                            <li><i class="icon-home"></i> ${requestScope.permissionMenu.rootName} <i class="icon-angle-right"></i>
                                            </li>
                                            <li>${requestScope.permissionMenu.subName}</li>
                                            <li class="pull-right">
                                                <div id="dashboard-report-range" class="dashboard-date-range tooltips" data-placement="top" data-original-title="Change dashboard date range">
                                                    <i class="icon-calendar"></i> <span></span> <i class="icon-angle-down"></i>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <!-- END PAGE HEADER-->

                                <div class="clearfix"></div>
                                <div class="row"></div>


                        </div>
                </div>
                <div class="footer">
                    <div class="footer-inner">2015 &copy; equipment management by Lee.
                    </div>
                    <div class="footer-tools">
                        <span class="go-top"> <i class="icon-angle-up"></i>
			</span>
                    </div>
                </div>

                <%@ include file="../shared/importJs.jsp" %>
                    <!-- BEGIN PAGE LEVEL PLUGINS -->
                    <script src="<c:url value='/static/plugins/gritter/js/jquery.gritter.js'/>" type="text/javascript"></script>
                    <script src="<c:url value='/static/plugins/fullcalendar/fullcalendar/fullcalendar.min.js'/>" type="text/javascript"></script>
                    <script src="<c:url value='/static/plugins/jquery.sparkline.min.js'/>" type="text/javascript"></script>
                    <script src="<c:url value='/static/js/app.js'/>" type="text/javascript"></script>
                    <script src="<c:url value='/static/js/index.js'/>" type="text/javascript"></script>

                    <script type="text/javascript">
                        jQuery(document).ready(function() {
                            App.init(); // initlayout and core plugins
                            Index.init();
                            Index.initCalendar(); // init index page's custom scripts
                            Index.initPeityElements();
                            Index.initKnowElements();
                            Index.initDashboardDaterange();
                        });
                    </script>
        </body>

        </html>