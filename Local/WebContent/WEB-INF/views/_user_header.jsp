<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header">
	<div style="float: left; padding: 10px">
		<a class="logo" href="${pageContext.request.contextPath}/userInfo">Buro</a>
	</div>

	<div
		style="float: right; padding: 10px; text-align: right;">
		

		<!-- User store in session with attribute: loginedUser -->
		<%-- <b style="color: white">${loginedUser.userName}</b> <br /> --%>
		<div style="color: white">
			<a class="bt" href="${pageContext.request.contextPath}/userInfo">Hi ${loginedUser.name}!</a>
			 <a class="bt" href="${pageContext.request.contextPath}/logout" >Log Out</a>

		</div>

	</div>

</div>