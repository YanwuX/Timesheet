/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2014-12-01 15:54:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html >\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("<title>Mercury Systems Inc</title>\r\n");
      out.write("<!-- Bootstrap -->\r\n");
      out.write("<!-- Latest compiled and minified CSS -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- Optional theme -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Custom Fonts -->\r\n");
      out.write("<link href=\"font-awesome-4.1.0/css/font-awesome.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"http://fonts.googleapis.com/css?family=Montserrat:400,700\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<!-- jQuery -->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\tif (\"");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("\" != \"\") {\r\n");
      out.write("\t\t\t$('#wrongCredentials').show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(\"#login\").on(\"click\", loginValidation);\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction loginValidation() {\r\n");
      out.write("\t\t$(\"#usernameAndPasswordReq\").hide();\r\n");
      out.write("\t\t$(\"#usernameReq\").hide();\r\n");
      out.write("\t\t$(\"#passwordReq\").hide();\r\n");
      out.write("\t\t$(\"#wrongCredentials\").hide();\r\n");
      out.write("\t\tif ($(\"#j_username\").val().length == 0\r\n");
      out.write("\t\t\t\t&& $(\"#j_password\").val().length == 0) {\r\n");
      out.write("\t\t\t$(\"#usernameAndPasswordReq\").show();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if ($(\"#j_username\").val().length == 0) {\r\n");
      out.write("\t\t\t$('#usernameReq').show();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if ($(\"#j_password\").val().length == 0) {\r\n");
      out.write("\t\t\t$(\"#passwordReq\").show();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(\"#empno\").on(\"blur\", function() {\r\n");
      out.write("\t\t\t$(\"#empnoValid\").hide();\r\n");
      out.write("\t\t\t$(\"#empnoNo\").hide();\r\n");
      out.write("\t\t\t$(\"#empnoExist\").hide();\r\n");
      out.write("\t\t\t$(\".registerInfo\").hide();\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl: \"validation/emp.html\",\r\n");
      out.write("\t\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\t\tdataType: \"html\",\r\n");
      out.write("\t\t\t\tdata: {empno: $(\"#empno\").val()},\r\n");
      out.write("\t\t\t\tsuccess: function(response) {\r\n");
      out.write("\t\t\t\t\tvar result = response.toString().trim();\r\n");
      out.write("\t\t\t\t\tif (result==\"valid\") {\r\n");
      out.write("\t\t\t\t\t\t$(\".registerInfo\").show();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse if (result==\"empty\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#empnoValid\").show();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse if (result==\"no\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#empnoNo\").show();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse if (result==\"exist\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#empnoExist\").show();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function(msg) {\r\n");
      out.write("\t\t\t\t\talert(msg);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#username\").on(\"blur\", function() {\r\n");
      out.write("\t\t\t$(\"#usernameValid\").hide();\r\n");
      out.write("\t\t\t$(\"#usernameAva\").hide();\r\n");
      out.write("\t\t\t$(\"#usernameExist\").hide();\r\n");
      out.write("\t\t\t$(\"#usernameReq\").hide();\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl: \"validation/username.html\",\r\n");
      out.write("\t\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\t\tdataType: \"html\",\r\n");
      out.write("\t\t\t\tdata: {username: $(\"#username\").val()},\r\n");
      out.write("\t\t\t\tsuccess: function(response) {\r\n");
      out.write("\t\t\t\t\tvar result = response.toString().trim();\r\n");
      out.write("\t\t\t\t\tif (result==\"empty\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#usernameValid\").show();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse if (result==\"success\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#usernameAva\").show();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse {\r\n");
      out.write("\t\t\t\t\t\t$(\"#usernameExist\").show();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function(msg) {\r\n");
      out.write("\t\t\t\t\talert(msg);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#submit\").on(\"click\", validateForm);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction validateForm() {\r\n");
      out.write("\t\t$(\"#usernameReq\").hide();\r\n");
      out.write("\t\t$(\"#passwordReq\").hide();\r\n");
      out.write("\t\t$(\"#emailReq\").hide();\r\n");
      out.write("\t\tif($(\"#username\").val().length==0) {\r\n");
      out.write("\t\t\t$(\"#usernameReq\").show();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif($(\"#password\").val().length==0) {\r\n");
      out.write("\t\t\t$(\"#passwordReq\").show();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif($(\"#email\").val().length==0) {\r\n");
      out.write("\t\t\t$(\"#emailReq\").show();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write(".alert {\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("\tline-height: 16px;\r\n");
      out.write("\twidth: 400px;\r\n");
      out.write("\tmargin: 10;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body id=\"page-top\" class=\"index\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<nav class=\"navbar navbar-default navbar-fixed-top\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("\t\t\t<div class=\"navbar-header page-scroll\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\"\r\n");
      out.write("\t\t\t\t\tdata-target=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" href=\"#page-top\">Mercury Systems Inc.</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse\"\r\n");
      out.write("\t\t\t\tid=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t<li class=\"hidden\"><a href=\"#page-top\"></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#login\" data-toggle=\"modal\">Login</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#register\" data-toggle=\"modal\">Register</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.navbar-collapse -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.container-fluid -->\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"modal fade\" id=\"login\" role=\"dialog\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<p>Login with username and password</p>\r\n");
      out.write("\t\t\t<!-- Login Form -->\r\n");
      out.write("\t\t\t<form name=\"f\" action=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"\r\n");
      out.write("\t\t\t\tmethod=\"POST\" id=\"login-form\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>Username:</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"j_username\" id=\"j_username\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"alert\" style=\"display: none\" id=\"usernameReq\">\r\n");
      out.write("\t\t\t\t\t\t\tUsername is required</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>Password:</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"password\" name=\"j_password\" id=\"j_password\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"alert\" style=\"display: none\" id=\"passwordReq\">\r\n");
      out.write("\t\t\t\t\t\t\tPassword is required</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"reset\">Clear</button>\r\n");
      out.write("\t\t\t\t\t\t\t<button id=\"login\" type=\"submit\">Login</button>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<a class=\"btn btn-default\" data-dismiss=\"modal\">Close</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"modal fade\" id=\"register\" role=\"register\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<form id=\"registerForm\" action=\"registered.html\" method=\"post\">\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Employee No.:</td>\r\n");
      out.write("\t\t\t<td><input id=\"empno\" type=\"text\" name=\"empno\"/></td>\r\n");
      out.write("\t\t\t<td class=\"alert\" id=\"empnoValid\" style=\"display:none\">\r\n");
      out.write("\t\t\t\tInvalid employee number\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td class=\"alert\" id=\"empnoExist\" style=\"display:none\">\r\n");
      out.write("\t\t\t\tAccount already exists for this employee number\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td class=\"alert\" id=\"empnoNo\" style=\"display:none\">\r\n");
      out.write("\t\t\t\tNo such employee number\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"registerInfo\" style=\"display:none\">\r\n");
      out.write("\t\t\t<td>Username:</td>\r\n");
      out.write("\t\t\t<td><input id=\"username\" type=\"text\" name=\"username\" required/></td>\r\n");
      out.write("\t\t\t<td class=\"alert\" id=\"usernameValid\" style=\"display:none\">\r\n");
      out.write("\t\t\t\tInvalid username\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td class=\"alert\" id=\"usernameExist\" style=\"display:none\">\r\n");
      out.write("\t\t\t\tUsername already exists\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td class=\"alert\" id=\"usernameReq\" style=\"display:none\">\r\n");
      out.write("\t\t\t\tUsername is required\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td id=\"usernameAva\" style=\"display:none; color:green\">\r\n");
      out.write("\t\t\t\tAvailable\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"registerInfo\" style=\"display:none\">\r\n");
      out.write("\t\t\t<td>Password:</td>\r\n");
      out.write("\t\t\t<td><input id=\"password\" type=\"password\" name=\"password\" required/></td>\r\n");
      out.write("\t\t\t<td class=\"alert\" id=\"passwordReq\" style=\"display:none\">\r\n");
      out.write("\t\t\t\tPassword is required\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"registerInfo\" style=\"display:none\">\r\n");
      out.write("\t\t\t<td>Email:</td>\r\n");
      out.write("\t\t\t<td><input id=\"email\" type=\"email\" name=\"email\" required/></td>\r\n");
      out.write("\t\t\t<td class=\"alert\" id=\"emailReq\" style=\"display:none\">\r\n");
      out.write("\t\t\t\tEmail is required\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"registerInfo\" style=\"display:none\">\r\n");
      out.write("\t\t\t<td></td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input id=\"clear\" type=\"reset\" value=\"Clear\"/>\r\n");
      out.write("\t\t\t\t<input id=\"submit\" type=\"submit\" value=\"Submit\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<a class=\"btn btn-default\" data-dismiss=\"modal\">Close</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"videoBG\"\r\n");
      out.write("\t\tstyle=\"position: fixed; z-index: -10; top: 100px; left: 0px; height: 100%; width: 100%; opacity: 1; overflow: hidden;\">\r\n");
      out.write("\t\t<video\r\n");
      out.write("\t\t\tposter=\"http://templateocean.com/stamp/resources/video/video.jpg\"\r\n");
      out.write("\t\t\tautoplay=\"autoplay\" loop\r\n");
      out.write("\t\t\tsrc=\"http://templateocean.com/stamp/resources/video/video.webm\"\r\n");
      out.write("\t\t\tstyle=\"position: absolute; z-index: -1; top: -191px; left: 0px; min-width: 0px; min-height: 0px; width: 1887px; height: auto;\">\r\n");
      out.write("\t\t</video>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t    <!-- jQuery -->\r\n");
      out.write("    <script src=\"bootstrap/js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\r\n");
      out.write("    <script src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Plugin JavaScript -->\r\n");
      out.write("    <script src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js\"></script>\r\n");
      out.write("    <script src=\"bootstrap/js/classie.js\"></script>\r\n");
      out.write("    <script src=\"bootstrap/js/cbpAnimatedHeader.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Contact Form JavaScript -->\r\n");
      out.write("    <script src=\"bootstrap/js/jqBootstrapValidation.js\"></script>\r\n");
      out.write("    <script src=\"bootstrap/js/contact_me.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom Theme JavaScript -->\r\n");
      out.write("    <script src=\"bootstrap/js/agency.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /WEB-INF/pages/login.jsp(41,7) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.login_error}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/pages/login.jsp(195,26) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("j_spring_security_check");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}