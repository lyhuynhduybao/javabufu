<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="contrl">
	<div id="search">
		<table class="table">
			<tr>
				<td><input id="in-search" type="text" name="search"
					placeholder="Search Place" /></td>
				<td><a class="icon-search" onclick="mySearch()"><img
						class="icon-search" src="images/search.png"></a></td>
			</tr>
		</table>
	</div>
	<div id="busStop">
		<a class="icon" onclick="myBusLoad()"><img class="icon"
			src="images/stop.png" title="My bus stop location"> <img /></a><br /> <br />
	</div>
	<div id="trip">
		<a class="icon" onclick="myTripLoad()"><img class="icon"
			src="images/trip.png" title="My trip"> <img /></a><br />  <br />
	</div>
	<div id="infomation"></div>
	<div id="profile">
		<a class="icon" onclick="myProfile()"><img class="icon"
			src="images/user.png" title="My profile"> <img /></a><br />  <br />
	</div>

</div>