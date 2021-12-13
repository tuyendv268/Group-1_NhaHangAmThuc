let table = document.getElementsByClassName('table')
console.log(table);
let wrap = document.getElementsByClassName('wrap')[0]

let isDisplay = false

let done = document.getElementsByClassName('done')[0]
done.addEventListener('click', () => {
    wrap.style.display = 'none'
})


// ---------- info -----------------
let info_Wrap = document.querySelector('.wrap > ul > li:nth-child(2)')
let info = document.getElementsByClassName('info')[0]
info_Wrap.addEventListener('click', () => {
    wrap.style.display = 'none'
    info.style.display = 'block'
    isDisplay = true
})

let close_info = document.getElementsByClassName('close-info')[0]
close_info.addEventListener('click', () => {
    info.style.display = 'none'
    isDisplay = false
})

for (let i = 0; i < table.length; i++) {
    table[i].addEventListener('click', () => {
        if(isDisplay) return
        wrap.style.display = 'flex'
    })
}

// ----------- Change status ---------------
let change_status = document.querySelector('.wrap > ul > li:nth-child(1)')
let change_status_display = document.getElementsByClassName('change_status')[0]
change_status.addEventListener('click', () => {
    wrap.style.display = 'none'
    change_status_display.style.display = 'block'
    isDisplay = true
})

let close_status = document.getElementsByClassName('close_status')[0]
close_status.addEventListener('click', () => {
    change_status_display.style.display = 'none'
    isDisplay = false
})

let color = document.querySelectorAll('.getColor span:first-child')
let mid = document.getElementsByClassName('mid')

let index
for (let i = 0; i < table.length; i++){
    table[i].addEventListener('click', () => {
        index = i; // Vị trí bàn đang trỏ tới
    })
}

for (let j = 0; j < color.length; j++){
    color[j].addEventListener('click', () => {
        let tableColor = color[j].className // Màu option
        let midClass = mid[index].className
        let midColor = midClass.split(' ')[1] // Màu hiện tại
        
        // Thay đổi màu trạng thái
        mid[index].classList.remove(midColor)
        mid[index].classList.add(tableColor)
    })
}
// ----------- delete ---------------

