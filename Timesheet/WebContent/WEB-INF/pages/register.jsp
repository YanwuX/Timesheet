<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js">
</script>
<script>
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
<body>
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
</body>
</html>