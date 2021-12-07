let li = document.querySelectorAll('#main .menu li');

// let active
// for (let [index,element] of li.entries()) {
//     element.addEventListener('click', () => {
//         if(active) {
//             li[active].style.background = '#C3C3C4'
//         }
//         element.style.background = 'red'
//         active = index
//         console.log(index);
//     })
// }

let active;
for (let i = 0; i < li.length; i++) {
  li[i].addEventListener("click", () => {
    if (active) {    
        li[active - 1].style.background = '#C3C3C4'
    }
    li[i].style.background = 'linear-gradient(180deg, #1326D6, #BDBEC0)'
    active=i + 1;
  });
}

// let seat = document.querySelector('li')
// let content = document.querySelector('.content')
// seat.addEventListener('click', () => {
//   let iframe = document.createElement('iframe')
//   iframe.src = 'seat.html'
//   iframe.style.marginLeft = '300px'
//   content.appendChild(iframe)
// })

// let seat = document.querySelector('li')
// let content = document.querySelector('.content')
// seat.addEventListener('click', () => {
//   let h1 = document.createElement('h1')
//   h1.innerHTML = 'Hello'
//   // h1.style.marginLeft = '300px'
//   content.appendChild(h1)
// })


//---------- seat -----------
let seat = document.querySelector('.menu ul li:first-child')
let content_seat = document.querySelector('.content_seat')
// console.log(seat);
seat.addEventListener('click',() => {
  // console.log(content_seat);
  // content_seat.style.display = 'block'
  content_seat.style.visibility = 'visible'
})



