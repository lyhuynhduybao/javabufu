/*function myBusLoad(){
	
	var profileDiv = document.getElementById("pro-div");
	var time = document.getElementById("timeTable");
	var trip = document.getElementById("trip");
	var url = "getBusStop";
	var x = new doHttpRequest(url);
	profileDiv.style.display = 'none';
	time.style.display = 'none';
	trip.style.display = 'none';
	

}
function myTimeLoad(){

	var profileDiv = document.getElementById("pro-div");
	var bus = document.getElementById("busStop");
	var trip = document.getElementById("trip");
	profileDiv.style.display = 'none';
	bus.style.display = 'none';
	trip.style.display = 'none';

	
}
function myTripLoad(){

	var profileDiv = document.getElementById("pro-div");
	var time = document.getElementById("timeTable");
	var bus = document.getElementById("busStop");
	profileDiv.style.display = 'none';
	time.style.display = 'none';
	bus.style.display = 'none';

}
function doHttpRequest(url){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(url) {
		if(xhttp.readyState == 4 && xhttp.status == 200){
			var myRes = xhttp.responseText;
			
			var x = new doParseOb(myRes);
			//document.write(myRes);
		}
	}
	xhttp.open("GET", url, true);
	xhttp.send();
	
}
function doParseOb(response) {
	var jsob = JSON.parse(response);	
	var div = document.getElementById("infomation");
	var i;
	var out;
	out =+ jsob.lat +" "+jsob.lng; 
	div.style.display = 'block';
	div.innerHTML = out.toString();
	
	
}*/