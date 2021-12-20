let table = document.getElementsByClassName('table')
console.log(table);
let wrap = document.getElementsByClassName('wrap')[0]

let isDisplay = false

// ----------- Done -----------------------
let done = document.getElementsByClassName('done')[0]
done.addEventListener('click', () => {
    wrap[0].style.display = 'none'
})
let done1 = document.getElementsByClassName('done')[1]
done1.addEventListener('click', () => {
    wrap[1].style.display = 'none'
})
let done2 = document.getElementsByClassName('done')[2]
done2.addEventListener('click', () => {
    wrap[2].style.display = 'none'
})
let done3 = document.getElementsByClassName('done')[3]
done3.addEventListener('click', () => {
    wrap[3].style.display = 'none'
})

for (let i = 0; i < table.length; i++){
    table[i].addEventListener('click', () => {
        index = i; // Vị trí bàn đang trỏ tới
        if(isDisplay) return
        midClass = mid[index].className
        midColor = midClass.split(' ')[1] // Màu hiện tại
        // Chọn pop-up phù hợp với bàn để hiển thị
        if (midColor=='green'){
            wrap[0].style.display = 'flex'
        }
        else if (midColor=='yellow'){
            wrap[1].style.display = 'flex'
        }
        else if (midColor=='red'){
            wrap[2].style.display = 'flex'
        }
        else{
            wrap[3].style.display = 'flex'
        }
    })
}

// ----------- Change status pop-up ---------------
let change_status_free = document.querySelector('.free > ul > li:nth-child(1)')
let change_status_reserved = document.querySelector('.reserved > ul > li:nth-child(1)')
let change_status_occupied = document.querySelector('.occupied > ul > li:nth-child(1)')
let change_status_outOfOrder = document.querySelector('.outOfOrder > ul > li:nth-child(1)')
let change_status_display = document.getElementsByClassName('change_status')[0]

change_status_free.addEventListener('click', () => {  
    wrap[0].style.display = 'none'
    change_status_display.style.display = 'block'
    isDisplay = true
})
change_status_reserved.addEventListener('click', () => {
    wrap[1].style.display = 'none'
    change_status_display.style.display = 'block'
    isDisplay = true
})
change_status_occupied.addEventListener('click', () => {
    wrap[2].style.display = 'none'
    change_status_display.style.display = 'block'
    isDisplay = true
})
change_status_outOfOrder.addEventListener('click', () => {
    wrap[3].style.display = 'none'
    change_status_display.style.display = 'block'
    isDisplay = true
})

let close_status = document.getElementsByClassName('close_status')[0]
close_status.addEventListener('click', () => {
    change_status_display.style.display = 'none'
    isDisplay = false
})

for (let j = 0; j < colorChange.length; j++){
    colorChange[j].addEventListener('click', () => {
        let tableColor = colorChange[j].className // Màu option      
        let midClass = mid[index].className
        let midColor = midClass.split(' ')[1] // Màu hiện tại

        // Thay đổi màu trạng thái
        mid[index].classList.remove(midColor)
        mid[index].classList.add(tableColor)
    })
}
// ----------- delete ---------------
let index
for (let i = 0; i < table.length; i++){
    table[i].addEventListener('click', () => {
        index = i; // Vị trí bàn đang trỏ tới
        var id = $('#'+index).data('myval'); //getter
        var a = document.getElementById("delete");
//        alert(id);
        a.href = "/table/"+id;
    })
}
