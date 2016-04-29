<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In Page</title>
<link rel="shortcut icon" href="images/school.png">
<link rel="stylesheet" type="text/css" href="css/style.css"
	media="screen" />
<script type="text/javascript" src="js/script.js"></script>
</head>
<body onload="detectBrowser()">
	<div id="head-div">
		<div class="bright"><div class="head-img">
		<jsp:include page="_header.jsp"></jsp:include>
			</div>
			</div>
			<div class="center">
				
				<form class="log" method="POST" action="doLogin">
					<table class="table">
						<tr>
							<td class="text">User Name</td>
							<td><input class="in" type="text" name="userName" value="${user.userName}" /></td>
						</tr>
						<tr>
							<td class="text">Password</td>
							<td><input class="in" type="password" name="password" value="${user.password}" /></td>
						</tr>
						<tr>
							<td class="text">Remember me</td>
							<td><input class="in" type="checkbox" name="rememberMe" value="Y" style="margin-right: 150px;"/></td>
						</tr>
						<tr>
							<td colspan="2"><input class="btct" type="submit" value="Login" /> <a class="bt" href="${pageContext.request.contextPath}/home">Cancel</a>
							</td>
						</tr>
					</table>
				</form>
			<p style="color: red;">${errorString}</p>
			</div>
			
			</div>
		
	


	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>