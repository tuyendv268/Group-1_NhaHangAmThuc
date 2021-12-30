// ------------ Add Event ------------------------------------
let create_event = document.getElementById("create_event")
let new_event_popup = document.getElementsByClassName("new_event")[0]

create_event.addEventListener('click', () => {
    new_event_popup.style.display = 'block'
})

let close_event_popup = document.getElementsByClassName("close_button")[0]
close_event_popup.addEventListener('click', () => {
    new_event_popup.style.display = 'none'
})

// event-info-popup
let infoPopup = document.getElementsByClassName('event-info-popup')[0]
let closeIf = document.getElementsByClassName('close_if')[0]
// open pop up
// ------------ event-item --------------------------------
let eventItems = document.getElementsByClassName('event-item')
for (let i = 0; i < eventItems.length; i++) {
        eventItems[i].addEventListener('click', () => {
            infoPopup.style.display = 'block'
        })
    }
closeIf.addEventListener('click', (e) => {
    infoPopup.style.display = 'none'
})

// ------------ mã base64 ---------------------------------
let url = ''
function encodeImageFileAsURL(element) {
    var file = element.files[0];
    var reader = new FileReader();
    reader.onloadend = function() {
      url = reader.result
    }
    reader.readAsDataURL(file);
}

// create event
let createEventItem = (eventName, src) => {
    return `<div class="event-item">
                <img src="${src}" alt="">
                <span>${eventName}</span>
            </div>`
}

// create button
let createEventButton = document.getElementsByClassName('create_button')[0]
let nameEvent = document.querySelector('#name_event input')
let events = document.getElementsByClassName('event')[0]

// upload pic
createEventButton.addEventListener('click', () => {
    let item = createEventItem(nameEvent.value, url) 
    events.innerHTML += item
    new_event_popup.style.display = 'none'

    for (let i = 0; i < eventItems.length; i++) {
        eventItems[i].addEventListener('click', () => {
            infoPopup.style.display = 'block'
        })
    }
})
