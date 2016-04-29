var markers = new Array();
function initialize() 
{
	// Config google map
	var mapOptions = {
			// Tọa độ muốn hiển thị ban đầu (tung độ,vỹ độ)
			center: new google.maps.LatLng(10.771971, 106.697845),
			// Mức độ zoom
			zoom: 16,	
			scaleControl: true,
			mapTypeControlOptions: {
				style: google.maps.MapTypeControlStyle.DROPDOWN_MENU,
				position:google.maps.ControlPosition.TOP_RIGHT, 
				mapTypeIds: [
				             google.maps.MapTypeId.ROADMAP,
				             google.maps.MapTypeId.TERRAIN,
				             google.maps.MapTypeId.HYBRID,
				             google.maps.MapTypeId.SATELLITE
				             ]
			},

			zoomControl: true,
			zoomControlOptions: {
				style: google.maps.ZoomControlStyle.SMALL
			}
	};

	// Hiển thị div lên bản đồ (div#map-canvas)
	var map = new google.maps.Map(document.getElementById("map-canvas"),mapOptions);
	var input = document.getElementById("in-search");
	var autocomplete = new google.maps.places.Autocomplete(input);
	return map;
}
//Ham tao Marker 

function placeMarker(position,map,address){

	//tao infoWindow
	var icon = {url:"images/busMarker.png",
			scaledSize:new google.maps.Size(50,50),
	};
	var contentString = '<div id="content">'+
	'<div id="siteNotice">'+
	'</div>'+
	'<h3 id="firstHeading" class="firstHeading">Address</h3>'+'<div id="bodyContent">'+'<p>'+address+'</p>'+
	'</div>'+
	'</div>';
	var infowindow = new google.maps.InfoWindow({
		content: contentString
	});

	//tao Marker
	var marker = new google.maps.Marker({
		position: position,
		map: map,
		title: address,
		draggable:false,
		icon: icon/*{
			path: google.maps.SymbolPath.BACKWARD_CLOSED_ARROW,
			scale: 5,
			strokeWeight:2,
			strokeColor:"#FF0000",

		}*/,
		//To make the marker bounce`
		//animation:google.maps.Animation.BOUNCE,
		//To make the marker drop
		animation:google.maps.Animation.Drop

	});
	map.panTo(position);
	markers.push(marker);
	marker.addListener('click', function() {
		infowindow.open(map, marker);
	});

}
function clearMarker(){
	for (index in markers) {
		markers[index].setMap(null);
	};

}

//Gán hàm initialize vào trong sự kiện load dom google map
google.maps.event.addDomListener(window, 'load', initialize);
function detectBrowser() 
{
	// User Agent hiện tại
	var useragent = navigator.userAgent;

	// Div hiển thị google map
	var mapdiv = document.getElementById("map-canvas");

	// Nếu là iPhone hoặc Android thì thiết lập màn hình full 100%
	if (useragent.indexOf('iPhone') != -1 || useragent.indexOf('Android') != -1) {
		mapdiv.style.width = '74%';
		mapdiv.style.height = '82%';
	} else {
		// Ngược lại người dùng đang dùng desktop, ta thiết lập theo percent 
		mapdiv.style.width = '74%';
		mapdiv.style.height = '82%';
	}
}	
function mySearch() {
	var address = document.getElementById("in-search").value;
	var map = initialize();
	var geocoder = new google.maps.Geocoder();
	geocodeAddress(geocoder, map, address);

}
function myBusLoad(){
	var profileDiv = document.getElementById("pro-div");
	var bus = document.getElementById("busStop");
	var trip = document.getElementById("trip");
	var prof = document.getElementById("profile");
	var url = "getBusStop";
	var url2 = "getTime";
	var address = doHttpRequest.call(address,url,1);
	var time = doHttpRequest.call(time,url2,2);
	profileDiv.style.display = 'none';
	trip.style.display = 'none';
	bus.style.display = 'none';
	prof.style.display = 'none';	
}
function myTripLoad(){

	var profileDiv = document.getElementById("pro-div");
	var bus = document.getElementById("busStop");
	var trip = document.getElementById("trip");
	var prof = document.getElementById("profile");
	profileDiv.style.display = 'none';
	bus.style.display = 'none';
	trip.style.display = 'none';
	prof.style.display = 'none';	
	var url = "getTrip";
	var trip = doHttpRequest(url, 3);
	var div = document.getElementById("infomation");
	div.style.display = 'block';

}
function myProfile() {
	var profileDiv = document.getElementById("pro-div");
	if(profileDiv.style.display == 'none')
	{
		profileDiv.style.display = 'block';
	}
	else
		profileDiv.style.display = 'none';

}
function doHttpRequest(url,id){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(url) {
		if(xhttp.readyState == 4 && xhttp.status == 200 && id == 1){
			var myRes = xhttp.responseText;
			var res = doAddMarker.call(res,myRes);

		}
		if(xhttp.readyState == 4 && xhttp.status == 200 && id == 2){
			var myRes = xhttp.responseText;
			var res = doGetTime.call(res,myRes);

		}
		if(xhttp.readyState == 4 && xhttp.status == 200 && id == 3){
			var myRes = xhttp.responseText;
			var res = doAddTrip.call(res,myRes);

		}

	}
	xhttp.open("GET", url, true);
	xhttp.send();

}
function doAddTrip(jsonarray) {
	var jsonData = JSON.parse(jsonarray);
	var map = initialize();
	var imageicon = {url:"images/busMarker.png",
			scaledSize:new google.maps.Size(50,50),
	};
	var jsonlength = jsonData.length;
	var waypoints = [];
	var div = document.getElementById("infomation");
	div.style.display = 'block';
	//Add Renderer to the map
	var renderOption = {
			map: map,
			suppressMarkers : true
	};
	var directionsService = new google.maps.DirectionsService;
	var directionsDisplay = new google.maps.DirectionsRenderer(renderOption);
	directionsDisplay.setMap(map);
	//add origin
	var origin = "12 Nguyen Van Bao, Go Vap, HCM";
	for (var i = 0 ;i < jsonlength; i++)
	{
		var geocoder = new google.maps.Geocoder();
		var address = jsonData[i].address;
		geocodeAddress(geocoder, map,address);
		var childdiv = document.createElement("div");
		childdiv.style.marginTop = '20px';
		childdiv.style.borderBottom = 'white solid';
		childdiv.innerHTML = i+". "+jsonData[i].address+"<br/>";
		div.appendChild(childdiv);
		//Add waypoints 
		if(jsonData[0].address == "12 Nguyen Van Bao, Go Vap, HCM")
		{
			clearMarker();
			for(var j = 1;j < jsonlength;j++)
				waypoints.push({
					location: jsonData[j].address,
					stopover: true
				});

		}
		else
		{
			clearMarker();
			for(var j = 0;j < jsonlength;j++)
				waypoints.push({
					location: jsonData[j].address,
					stopover: true
				});

		}



	}	
	directionsService.route({
		origin: origin,
		destination : origin,
		waypoints : waypoints,
		optimizeWaypoints : true,
		travelMode : google.maps.TravelMode.DRIVING
	},function(response, status) {
		if (status === google.maps.DirectionsStatus.OK) {
			//clearMarker();
			requestLimitWait = 1000;//set awaiting time for request
			directionsDisplay.setDirections(response);
			var myRoute = response.routes[0].legs[0];
			//var route = showSteps.call(route, myRoute,map,address);

		}
	});

}
function showSteps(myRoute, map,address){
	var schoolIcon = {url:"images/sch.png",
			scaledSize:new google.maps.Size(50,50)};
	for (var i = 0; i < myRoute.steps.length; i++) {
		var iconnum = "https://chart.googleapis.com/chart?chst=d_map_pin_letter&chld=" + i + "|1EFF14|000000";
		if (i == 0) {
			//Icon as start position
			icon = schoolIcon;
		}
		var marker = new placeMarker(myRoute.steps[i].start_point, map,iconnum,address);
	}
	//Icon as end position
	var marker = new google.maps.Marker({
		position: myRoute.steps[i].end_point, 
		map: map,
		icon: "https://chart.googleapis.com/chart?chst=d_map_pin_letter&chld=" + i + "|1EFF14|000000"
	});
}

function getAddress(response) {
	var json = JSON.parse(response);
	var address = json.address;
	return address;
}
function doGetTime(response) {
	var json = JSON.parse(response);
	var time = json.interv;
	var div = document.getElementById("infomation");
	var childDiv = document.createElement("div");
	div.style.display = 'block';
	div.appendChild(childDiv);
	childDiv.innerHTML = '<h4>Arrive At:</h4> '+ time;

}
function doAddMarker(response) {
	//window.alert(response);
	var address = getAddress(response);	
	var div = document.getElementById("infomation");
	var out;
	// Config google map
	var imageicon = {url:"images/busMarker.png",
			scaledSize:new google.maps.Size(50,50),
	};
	var map = initialize();
	var geocoder = new google.maps.Geocoder();
	geocodeAddress(geocoder, map, address);
	//placeMarker(position, map);
	div.style.display = 'block';
	var childDiv = document.createElement("div");
	div.appendChild(childDiv); 	
	childDiv.innerHTML = "<h4>Address:</h4>"+address;
}
function geocodeAddress(geocoder, resultsMap, address) {
	geocoder.geocode({'address': address}, function(results, status) {
		/*var imageicon = {url:"images/busMarker.png",
				scaledSize:new google.maps.Size(50,50),
				};*/
		if (status === google.maps.GeocoderStatus.OK) {
			resultsMap.setCenter(results[0].geometry.location);
			var add = results[0].formatted_address;
			var marker = new placeMarker(results[0].geometry.location,resultsMap,add);
		} else {
			alert('Please enter a location!');
		}
	});
}	
function blash() {
	var signup = document.getElementById("signUp");
	signup.style.filter = 'brightness(0.50)';
}
function normal(){
	var signup = document.getElementById("signUp");
	signup.style.filter = 'brightness(1)';
}
/*function geocodeLatLng(geocoder, position) {
	geocoder.geocode({'latLng': position},function(resuts,status){
		if(status === google.maps.GeocoderStatus.OK){
			return resuts[0].formatted_address;
		}
		else {
			alert('Geocode was not successful for the following reason: ' + status);
		}
	});
}*/
