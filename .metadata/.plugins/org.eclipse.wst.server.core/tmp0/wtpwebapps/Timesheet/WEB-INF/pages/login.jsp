<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Mercury Systems Inc</title>
<!-- Bootstrap -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<!-- Custom Fonts -->
<link href="font-awesome-4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

<script>
	$(document).ready(function() {
		if ("<c:out value='${param.login_error}'/>" != "") {
			$('#wrongCredentials').show();
		}
		$("#login").on("click", loginValidation);
	});

	function loginValidation() {
		$("#usernameAndPasswordReq").hide();
		$("#usernameReq").hide();
		$("#passwordReq").hide();
		$("#wrongCredentials").hide();
		if ($("#j_username").val().length == 0
				&& $("#j_password").val().length == 0) {
			$("#usernameAndPasswordReq").show();
			return false;
		} else if ($("#j_username").val().length == 0) {
			$('#usernameReq').show();
			return false;
		} else if ($("#j_password").val().length == 0) {
			$("#passwordReq").show();
			return false;
		} else {
			return true;
		}
	}
	
	$(document).ready(function() {
		$("#empno").on("blur", function() {
			$("#empnoValid").hide();
			$("#empnoNo").hide();
			$("#empnoExist").hide();
			$(".registerInfo").hide();
			$.ajax({
				url: "validation/emp.html",
				type: "get",
				dataType: "html",
				data: {empno: $("#empno").val()},
				success: function(response) {
					var result = response.toString().trim();
					if (result=="valid") {
						$(".registerInfo").show();
					}
					else if (result=="empty") {
						$("#empnoValid").show();
					}
					else if (result=="no") {
						$("#empnoNo").show();
					}
					else if (result=="exist") {
						$("#empnoExist").show();
					}
				},
				error: function(msg) {
					alert(msg);
				}
			});
		});
		$("#username").on("blur", function() {
			$("#usernameValid").hide();
			$("#usernameAva").hide();
			$("#usernameExist").hide();
			$("#usernameReq").hide();
			$.ajax({
				url: "validation/username.html",
				type: "get",
				dataType: "html",
				data: {username: $("#username").val()},
				success: function(response) {
					var result = response.toString().trim();
					if (result=="empty") {
						$("#usernameValid").show();
					}
					else if (result=="success") {
						$("#usernameAva").show();
					}
					else {
						$("#usernameExist").show();
					}
				},
				error: function(msg) {
					alert(msg);
				}
			});
		});
		$("#submit").on("click", validateForm);
	});
	
	function validateForm() {
		$("#usernameReq").hide();
		$("#passwordReq").hide();
		$("#emailReq").hide();
		if($("#username").val().length==0) {
			$("#usernameReq").show();
			return false;
		}
		if($("#password").val().length==0) {
			$("#passwordReq").show();
			return false;
		}
		if($("#email").val().length==0) {
			$("#emailReq").show();
			return false;
		}
		else {
			return true;
		}
	}
</script>
<style>
.alert {
	color: red;
	line-height: 16px;
	width: 400px;
	margin: 10;
	position: relative;
}
</style>
</head>


<body id="page-top" class="index">


	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#page-top">Mercury Systems Inc.</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li><a href="#login" data-toggle="modal">Login</a></li>
					<li><a href="#register" data-toggle="modal">Register</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="modal fade" id="login" role="dialog">
		<div class="modal-content">
			<p>Login with username and password</p>
			<!-- Login Form -->
			<form name="f" action="<c:url value='j_spring_security_check'/>"
				method="POST" id="login-form">
				<table>
					<tr>
						<td>Username:</td>
						<td><input type="text" name="j_username" id="j_username" /></td>
						<td class="alert" style="display: none" id="usernameReq">
							Username is required</td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="j_password" id="j_password" /></td>
						<td class="alert" style="display: none" id="passwordReq">
							Password is required</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<button type="reset">Clear</button>
							<button id="login" type="submit">Login</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="modal-footer">
				<a class="btn btn-default" data-dismiss="modal">Close</a>
			</div>
	</div>

	<div class="modal fade" id="register" role="register">
		<div class="modal-content">
			<form id="registerForm" action="registered.html" method="post">
	<table>
		<tr>
			<td>Employee No.:</td>
			<td><input id="empno" type="text" name="empno"/></td>
			<td class="alert" id="empnoValid" style="display:none">
				Invalid employee number
			</td>
			<td class="alert" id="empnoExist" style="display:none">
				Account already exists for this employee number
			</td>
			<td class="alert" id="empnoNo" style="display:none">
				No such employee number
			</td>
		</tr>
		<tr class="registerInfo" style="display:none">
			<td>Username:</td>
			<td><input id="username" type="text" name="username" required/></td>
			<td class="alert" id="usernameValid" style="display:none">
				Invalid username
			</td>
			<td class="alert" id="usernameExist" style="display:none">
				Username already exists
			</td>
			<td class="alert" id="usernameReq" style="display:none">
				Username is required
			</td>
			<td id="usernameAva" style="display:none; color:green">
				Available
			</td>
		</tr>
		<tr class="registerInfo" style="display:none">
			<td>Password:</td>
			<td><input id="password" type="password" name="password" required/></td>
			<td class="alert" id="passwordReq" style="display:none">
				Password is required
			</td>
		</tr>
		<tr class="registerInfo" style="display:none">
			<td>Email:</td>
			<td><input id="email" type="email" name="email" required/></td>
			<td class="alert" id="emailReq" style="display:none">
				Email is required
			</td>
		</tr>
		<tr class="registerInfo" style="display:none">
			<td></td>
			<td>
				<input id="clear" type="reset" value="Clear"/>
				<input id="submit" type="submit" value="Submit"/>
			</td>
		</tr>
	</table>
</form>
		</div>
		<div class="modal-footer">
				<a class="btn btn-default" data-dismiss="modal">Close</a>
			</div>
	</div>


	<div class="videoBG"
		style="position: fixed; z-index: -10; top: 100px; left: 0px; height: 100%; width: 100%; opacity: 1; overflow: hidden;">
		<video
			poster="http://templateocean.com/stamp/resources/video/video.jpg"
			autoplay="autoplay" loop
			src="http://templateocean.com/stamp/resources/video/video.webm"
			style="position: absolute; z-index: -1; top: -191px; left: 0px; min-width: 0px; min-height: 0px; width: 1887px; height: auto;">
		</video>
	</div>

	    <!-- jQuery -->
    <script src="bootstrap/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="bootstrap/js/classie.js"></script>
    <script src="bootstrap/js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="bootstrap/js/jqBootstrapValidation.js"></script>
    <script src="bootstrap/js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="bootstrap/js/agency.js"></script>


</body>
</html>