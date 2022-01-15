const serveMeal = document.querySelector('.serve-meal');
serveMeal.addEventListener('click', function() {
	serveMeal.style.display = "none";
	var showEvent = document.querySelector('.show-event');
	showEvent.style.display = "block";
	var event = document.querySelector('.event');
    event.style.backgroundImage = "linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url('image/bgevent.png')";
});





