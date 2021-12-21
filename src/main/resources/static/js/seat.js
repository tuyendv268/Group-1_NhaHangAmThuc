let table = document.getElementsByClassName('table')
let wrap = document.getElementsByClassName('wrap')

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

// ----------- delete ---------------
let colorChange = document.querySelectorAll('.getColor span:first-child')
let mid = document.getElementsByClassName('mid')
let index
let midClass
let midColor

for (let i = 0; i < table.length; i++){
    table[i].addEventListener('click', () => {
        index = i // Vị trí bàn đang trỏ tới
        console.log(index)
        var id = $('#'+index).data('myval'); //getter
        var a = document.getElementById("delete");
        a.href = "/table/"+id;
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
    countTable()
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
        // Nếu chuyển sang reserved thì hiện pop-up lấy thông tin
        if (tableColor=='yellow'){
            change_status_display.style.display = 'none'
            show_reservation_info()
        }
    })
}

// --------- Pop-up Reservation Info -----------
let popup_reservation = document.getElementsByClassName("reservation_info")[0]
show_reservation_info = () => {
    popup_reservation.style.display = 'block'
}
let reservation_cancel = document.getElementById("reservation_cancel")
reservation_cancel.addEventListener('click', () => {
    popup_reservation.style.display = 'none'
})
let reservation_add = document.getElementById("reservation_add")
reservation_add.addEventListener('click', () => {
    popup_reservation.style.display = 'none'
    countTable()
})

// --------- Pop-up Add Table ------------------
let AddTable = document.getElementById("table_add")
let popup_NewTable = document.getElementsByClassName("NewTable")[0]
AddTable.addEventListener('click', () => {
    popup_NewTable.style.display = 'block'
})
let addTable_cancel = document.getElementById("addTable_cancel")
addTable_cancel.addEventListener('click', () => {
    popup_NewTable.style.display = 'none'
})

// ------------ Count Table ------------------------
let countTable = () => {
    let countGreen = 0, countYellow = 0, countRed = 0, countGrey = 0

    for (let i = 0; i < mid.length; i++) {
        //get color
        let classColor = mid[i].getAttribute('class').split(' ')[1].trim()
        if(classColor == 'green') {
            countGreen++;
        }
        else if(classColor == 'yellow') {
            countYellow++
        }
        else if(classColor == 'red') {
            countRed++
        }
        else if(classColor == 'dark') {
            countGrey++;
        }
    }
    let count = document.getElementsByClassName('count')
    count[0].textContent = `Avaible: ${countGreen}`
    count[1].textContent = `Reserved: ${countYellow}`
    count[2].textContent = `Occupied: ${countRed}`
    count[3].textContent = `Out of Order: ${countGrey}`
}

countTable()

// -------------- confirm Delete ------------------
let confirmDelete_free = document.querySelector('.free > ul > li:nth-child(3)')
let confirmDelete_outOfOrder = document.querySelector('.outOfOrder > ul > li:nth-child(3)')
let confirmDelete_display = document.getElementsByClassName('confirmDelete')[0]

confirmDelete_free.addEventListener('click', () => {  
    wrap[0].style.display = 'none'
    confirmDelete_display.style.display = 'block'
    isDisplay = true
})
confirmDelete_outOfOrder.addEventListener('click', () => {
    wrap[3].style.display = 'none'
    confirmDelete_display.style.display = 'block'
    isDisplay = true
})

let close_delete = document.getElementById('confirmDelete_no')
close_delete.addEventListener('click', () => {
    confirmDelete_display.style.display = 'none'
    isDisplay = false
})