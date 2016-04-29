<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up Page</title>
<link rel="shortcut icon" href="images/school.png">
<link rel="stylesheet" type="text/css" href="css/style.css"
	media="screen" />
<script type="text/javascript" src="js/script.js"></script>
</head>
<body onload="detectBrowser()">
	<div class="center2">
		<form method="POST" action="doSignup">
			<h2 class="select2">Sign Up</h2>
			<table class="table2">
				<tr>

					<td><input class="in2" type="text" name="userName"
						placeholder="User name" /></td>
					<td><p style="color: red;">${errorString}</p></td>
				</tr>
				<tr>
					<td><input class="in2" type="password" name="password"
						placeholder="Password" /></td>
				</tr>
				<tr>
					<td><input class="in2" type="text" name="name"
						placeholder="Name" /></td>

				</tr>
				<tr>
					<td><input class="in2" type="text" name="address"
						placeholder="Address" /></td>

				</tr>
				<tr>
					<td><select class="select" name="listBusStop">
							<option value="0">...Chose the bus stop</option>
							<option value="1">31 Nguyen Thai Son, Go Vap, HCM</option>
							<option value="2">91 Nguyen Thai Son, Go Vap, HCM</option>
							<option value="3">10 Nguyen Kiem, Go Vap, HCM</option>
					</select></td>
				</tr>
				<tr>
					<td><select class="select" name="listTime">
							<option value="0">...Chose the start time</option>
							<option value="1">09:20:00</option>
							<option value="2">16:20:00</option>
					</select></td>
				</tr>
				<table class="table2">
				<tr>
					<td><input class="btct" type="submit" value="Create" /></td>
					<td><a class="text2"
						href="${pageContext.request.contextPath}/home">Cancel</a></td>
				</tr>
				</table>
			</table>
		</form>
	</div>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>