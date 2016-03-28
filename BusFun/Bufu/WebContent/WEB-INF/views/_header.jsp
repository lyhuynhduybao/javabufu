<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header">
	<div style="float: left; padding: 10px">
		<a class="logo" href="${pageContext.request.contextPath}/home">Bufu</a>
	</div>

	<div
		style="float: right; padding: 10px; text-align: right;">
		

		<!-- User store in session with attribute: loginedUser -->
		<%-- <b style="color: white">${loginedUser.userName}</b> <br /> --%>
		
			<a class="button" href="${pageContext.request.contextPath}/signup" >Sign
				Up</a> <a class="bt" onclick="blurBackSide()" href="${pageContext.request.contextPath}/login" >Log
				In</a>


	</div>

</div>