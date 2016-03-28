<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="pro-div" class="prof">
	<h4>Profile</h4>
	Student name: ${loginedUser.name}<br/>
	Address:<input id="address" type="text" name="address" value="${loginedUser.address}" /><br /> 
		Bus ID : <b>${loginedUser.bus_id}</b><br /> 
		Time ID:<b>${loginedUser.time_id}</b><br /> 
	Name :<input type="text" name="userName" value="${loginedUser.userName }" size="5" ><br /> 
	Password: <input type="text" name="password" value="${loginedUser.password }" size="5"><br /> 
	Administrator: <b> ${loginedUser.admin }</b><br/>
	
	
</div>