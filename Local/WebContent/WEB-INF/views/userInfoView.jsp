<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css"
	media="screen" />
	<link rel="shortcut icon" href="images/school.png">
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAgOvBQPESQwEPTPwqM8iOyTiECdysp2VY&lang=vi&libraries=places"></script>
<script type="text/javascript" src="js/initMap.js"></script>
<title>User Home Page</title>
</head>
<body onload="detectBrowser()" >
	<div class="bright">
	<div class="head-img">	
		</div>
	</div>
			<jsp:include page="_user_header.jsp"></jsp:include>
			<div id="direction" class="menu">
			
			<jsp:include page="_user_control.jsp"></jsp:include>
			<jsp:include page="_user_profile.jsp"></jsp:include> 
			</div>
			<jsp:include page="mapView.jsp"></jsp:include>
			
		
		
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>