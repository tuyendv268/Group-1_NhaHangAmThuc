const serveMeal = document.querySelector('.serve-meal');
serveMeal.addEventListener('click', function() {
	serveMeal.style.display = "none";
	var showEvent = document.querySelector('.show-event');
	showEvent.style.display = "block";
	var event = document.querySelector('.event');
    event.style.backgroundImage = "linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url('image/bgevent.png')";
});

let eventInfoBoxes = document.getElementsByClassName("eventInfo");

for (let i = 0; i < eventInfoBoxes.length; i++) {
	var eventImage = document.getElementById("event" + i);
	var infoBox = document.getElementById("eventInfo" + i);
	
	infoBox.style.display = "none";
	infoBox.click(function () {
    	infoBox.style.display = "none";
	}); 
	eventImage.addEventListener('click', function() {
		infoBox.style.display = "block";
	})
	
	infoBox.click(function () {
    	infoBox.style.display = "none";
	}); 
}




