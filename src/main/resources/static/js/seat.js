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
// vị trí bàn đang được trỏ tới
let table_index
let midClass
let midColor

// ------ Thêm bàn cần cho vòng for này vào để add JS cho bàn mới --------
for (let i = 0; i < table.length; i++) {
	table[i].addEventListener('click', () => {
		table_index = i // Vị trí bàn đang trỏ tới
		console.log(table_index)
		if (isDisplay) return
		midClass = mid[table_index].className
		midColor = midClass.split(' ')[1] // Màu hiện tại
		// Chọn pop-up phù hợp với bàn để hiển thị
		if (midColor == 'green') {
			wrap[0].style.display = 'flex'
		}
		else if (midColor == 'yellow') {
			var customername = $('#' + 'table' + table_index).data('customername');
			var telephone = $('#' + 'table' + table_index).data('telephone');
			var expired_time = $('#' + 'table' + table_index).data('expiredtime');
			//alert(customername);
			document.getElementsByClassName("expired time")[0].innerHTML = "Expired Time : " + expired_time;
			document.getElementsByClassName("customer reserved")[0].innerHTML = "Customer : " + customername;
			document.getElementsByClassName("tel reserved")[0].innerHTML = "Tel	  : " + telephone;
			wrap[1].style.display = 'flex'
		}
		else if (midColor == 'red') {
			var customername = $('#' + 'table' + table_index).data('customername');
			var telephone = $('#' + 'table' + table_index).data('telephone');
			//alert(customername);
			document.getElementsByClassName("customer occupied")[0].innerHTML = "Customer : " + customername;
			document.getElementsByClassName("tel occupied")[0].innerHTML = "Tel      : " + telephone;
			wrap[2].style.display = 'flex'
		}
		else {
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

for (let j = 0; j < colorChange.length; j++) {
	colorChange[j].addEventListener('click', () => {
		let tableColor = colorChange[j].className // Màu option      
		let midClass = mid[table_index].className
		let midColor = midClass.split(' ')[1] // Màu hiện tại

		if (midColor == 'red') {
			// Nếu bàn đang sử dụng thì không thay đổi được
		} else if (tableColor == 'yellow' && midColor != 'yellow') {
			// Nếu bàn đang được đặt mà đặt tiếp thì không được
			change_status_display.style.display = 'none'
			show_reservation_info()
			change_status_display.style.display = 'none'
			isDisplay = false
		} else if (tableColor == 'red') {
			// Thay đổi màu trạng thái
			//var id = $('#' + 'table'+table_index).data('tableid');
			//$(".close_status").attr("href", "/table/use/" + id);
			//alert(id);
			//mid[table_index].classList.remove(midColor)
			//mid[table_index].classList.add(tableColor)
		} else if (tableColor == 'green') {
			// Thay đổi màu trạng thái
			var id = $('#' + 'table' + table_index).data('tableid');
			$(".close_status").attr("href", "/table/cancel/" + id);
			mid[table_index].classList.remove(midColor)
			mid[table_index].classList.add(tableColor)
		} else {
			mid[table_index].classList.remove(midColor)
			mid[table_index].classList.add(tableColor)
			change_status_display.style.display = 'none'
		    isDisplay = false
		}
	})
}

// --------- Pop-up Reservation Info -----------
let popup_reservation = document.getElementsByClassName("reservation_info")[0]
show_reservation_info = () => {
	var id = $('#' + 'table' + table_index).data('tableid');
	document.getElementById("reserved_table_id").value = id;
	popup_reservation.style.display = 'block'
}
let reservation_cancel = document.getElementById("reservation_cancel")
reservation_cancel.addEventListener('click', () => {
	popup_reservation.style.display = 'none'
	isDisplay = false
})
let reservation_add = document.getElementById("reservation_add")
reservation_add.addEventListener('click', () => {
	mid[table_index].classList.remove(mid[table_index].className.split(' ')[1])
	mid[table_index].classList.add("yellow")
	popup_reservation.style.display = 'none'
	isDisplay = false
	countTable()
})

// --------- Pop-up Add Table ------------------
let AddTable = document.getElementById("table_add")
let popup_NewTable = document.getElementsByClassName("NewTable")[0]
AddTable.addEventListener('click', () => {
	if (!isDisplay) {
		popup_NewTable.style.display = 'block'
		isDisplay = true
	}
})
let addTable_cancel = document.getElementById("addTable_cancel")
addTable_cancel.addEventListener('click', () => {
	popup_NewTable.style.display = 'none'
	isDisplay = false
})

// ------------ Count Table ------------------------
let countTable = () => {
	let countGreen = 0, countYellow = 0, countRed = 0, countGrey = 0

	for (let i = 0; i < mid.length; i++) {
		//get color
		let classColor = mid[i].getAttribute('class').split(' ')[1].trim()
		if (classColor == 'green') {
			countGreen++;
		}
		else if (classColor == 'yellow') {
			countYellow++
		}
		else if (classColor == 'red') {
			countRed++
		}
		else if (classColor == 'dark') {
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
let DeleteButton_free = document.querySelector('.free > ul > li:nth-child(3)')
let DeleteButton_outOfOrder = document.querySelector('.outOfOrder > ul > li:nth-child(3)')
let Delete_display = document.getElementsByClassName('confirmDelete')[0]

DeleteButton_free.addEventListener('click', () => {
	wrap[0].style.display = 'none'
	Delete_display.style.display = 'block'
	isDisplay = true
})
DeleteButton_outOfOrder.addEventListener('click', () => {
	wrap[3].style.display = 'none'
	Delete_display.style.display = 'block'
	isDisplay = true
})

let close_delete = document.getElementById('confirmDelete_no')
close_delete.addEventListener('click', () => {
	Delete_display.style.display = 'none'
	isDisplay = false
})

let confirmDelete = document.getElementById('confirmDelete_yes')
confirmDelete.addEventListener('click', () => {
	//getter
	let classColor = mid[table_index].getAttribute('class').split(' ')[1].trim()
	if (classColor == "green") {
		// set href cho button
		var id = $('#' + 'table' + table_index).data('tableid');
		$("#confirmDelete_yes").attr("href", "/table/" + id);
		//alert($('#confirmDelete_yes').attr('href'));
	} else if (classColor == "dark") {
		alert("Không thể xóa bàn này")
	}
	Delete_display.style.display = 'none'
	isDisplay = false
})

// -------------- Bill Detail ------------------
let billDetail = document.getElementById("billdetailid")

billDetail.addEventListener('click', () => {
	//	var tableId = $('#' + 'table'+table_index).data('tableid');
	var billID = $('#' + 'table' + table_index).data('tblbillid');
	sessionStorage.setItem("bill_id_get_from_table", billID);
	//	var id = 0;
	//	alert(billID);

	//	while(true){
	//		var temp = $('#' +'bill'+ id).data('billid');
	//		alert('#' +'bill'+ id);
	//		alert(temp);
	//		if(billID == temp){
	//			alert(id);
	//			break;
	//		}
	//		id += 1;
	//	}
})

//var mess = $('#message').data('mess');

//if (mess != undefined) {
//	if (mess == 'NewTable-Fail') {
//		alert("Trùng Tên Bàn.	 Vui Lòng Thêm Lại !!!");
//		popup_message.style.display = 'block'
//	} else if (mess = 'NewTable-Success') {
//		alert("Thêm Bàn Thành Công!");
//	}
//	mess = undefined;
//}
