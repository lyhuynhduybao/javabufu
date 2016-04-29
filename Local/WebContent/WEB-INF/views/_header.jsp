<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header">
	<div class="mainbt">
		<p class="logo">Buro is a new friend for your children</p>

	</div>

	<div class="subbt">


		<!-- User store in session with attribute: loginedUser -->
		<%-- <b style="color: white">${loginedUser.userName}</b> <br /> --%>

		
			<a class="button" id="signUp" href="${pageContext.request.contextPath}/signup"
				onmouseover="blash()" onmouseout="normal()">Sign Up</a>
	
		
			<a class="bt" id="logIn" onclick="blurBackSide()"
				href="${pageContext.request.contextPath}/login">Log In</a>


	</div>

</div>