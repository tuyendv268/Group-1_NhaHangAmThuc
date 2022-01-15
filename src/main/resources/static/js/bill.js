//Hiển thị hóa đơn
const dishlist = document.getElementsByClassName("dish-list")[0];
const customer = document.querySelector('.customer-list');
const listCheckbox = document.getElementsByClassName("dish-checkbox");
const quantity = document.getElementsByClassName("quantityDish");
customer.addEventListener('click', function(event) {
	var list = Array.prototype.slice.call(customer.children);

	billindex = list.indexOf(event.target.parentElement);
	localStorage.setItem('target', billindex);

	var bill = document.getElementById("bill");
	bill.style.display = "block";
	create.style.display = "none";

	var id = event.target.parentElement.children[1].innerText;

	document.getElementsByClassName("popup-bill-id")[0].innerHTML = "ID : ";
	document.getElementsByClassName("popup-bill-name")[0].innerHTML = "Customer’s name : ";
	document.getElementsByClassName("popup-bill-phone")[0].innerHTML = "Phone : ";
	document.getElementsByClassName("popup-bill-total")[0].innerHTML = "Total : ";
	document.getElementsByClassName("popup-bill-creation-time")[0].innerHTML = "Created :";

	const billid = document.querySelector('.bill-id span')
	billid.innerHTML = id
	const name = document.querySelector('#bill-name span')
	name.innerHTML = event.target.parentElement.children[2].innerText;
	
	const phone = document.querySelector('#bill-phone span')
	phone.innerHTML = $('#' + billindex).data('phone');
	const status = document.querySelector('#bill-completion-time span')
	status.innerHTML = event.target.parentElement.children[5].innerText;
	const total = document.querySelector('#bill-total span')
	total.innerHTML = event.target.parentElement.children[4].innerText;
	const createtime = document.querySelector('#bill-creation-time span')
	createtime.innerHTML = $('#' + billindex).data('createdtime');
	const rank = document.querySelector('#bill-rank span');
	const seat = document.querySelector('#bill-seat span')
	seat.innerHTML = event.target.parentElement.children[3].innerHTML;
	
	rank.innerHTML = $('#' + billindex).data('memberank');
	
	$("#delete-yes-btn").attr("href", "/deleteBill/" + id);
	dishlist.innerHTML = '';
	for (let i = 0; i < listCheckbox.length; i++){
		listCheckbox[i].checked = false;
		quantity[i].value = 1;
		quantity[i].style.display = "none";
	}
	
	document.getElementById("bill-id-for-dish").value = id;
	var dishinbill = $('#dish-in-bill' + id);
	var dishes = dishinbill[0].children;
	for (let i =0; i < dishes.length; i++){
	$('#dishcheckbox' + $(dishes[i]).data('dishid') ).prop('checked', true);
	$('#dishnumber' + $(dishes[i]).data('dishid') ).css("display", "inline-block");
	$('#dishnumber' + $(dishes[i]).data('dishid') )[0].value = $(dishes[i]).data('quantity')
	}
	
	var comboinbill = $('#combo-in-bill' + id);
	var combos = comboinbill[0].children;
	for (let i =0; i < combos.length; i++){
	$('#combocheckbox' + $(combos[i]).data('comboid') ).prop('checked', true);
	$('#combonumber' + $(combos[i]).data('comboid') ).css("display", "inline-block");
	$('#combonumber' + $(combos[i]).data('comboid') )[0].value = $(combos[i]).data('quantity')
	}
	
	for (let i = 0; i < listCheckbox.length; i++) {
		if (listCheckbox[i].checked) {
			var dish = document.createElement("UL");
			dish.appendChild(listCheckbox[i].parentElement.children[0].cloneNode(true));
			dish.appendChild(listCheckbox[i].parentElement.children[1].cloneNode(true));
			dish.appendChild(listCheckbox[i].parentElement.children[2].cloneNode(true));
			dish.appendChild(listCheckbox[i].parentElement.children[4].cloneNode(true));
			dish.appendChild(listCheckbox[i].parentElement.children[5].cloneNode(true));
			dishlist.appendChild(dish);
		}
	}
	document.getElementById("edit-bill-id").value = id;
	document.getElementById("edit-name").value = event.target.parentElement.children[2].innerText;
	document.getElementById("edit-phone").value = $('#' + billindex).data('phone');
});


//Chỉnh sửa hóa đơn
const editBill = document.querySelector('#edit-btn');
editBill.addEventListener('click', function() {
	var bill = document.getElementById("bill");
	bill.style.display = "none";
	var edit = document.getElementById("edit");
	edit.style.display = "block";
	
});


//Xác nhận chỉnh sửa
const editDone = document.querySelector('#edit-done-btn');
editDone.addEventListener('click', function() {
	var edit = document.getElementById("edit");
	edit.style.display = "none";
	var bill = document.getElementById("bill");
	bill.style.display = "block";
});


//Xóa hóa đơn
const deleteBill = document.querySelector('#delete-btn');
deleteBill.addEventListener('click', function() {
	var delete1 = document.getElementById("delete");
	delete1.style.display = "block";
});




//Xác nhận xóa hóa đơn
/*
const deleteYes = document.querySelector('#delete-yes-btn');
deleteYes.addEventListener('click', function(){
	var bill = document.getElementById("bill");
	bill.style.display = "none";
	var delete1 = document.getElementById("delete");
	delete1.style.display = "none";
	create.style.display = "block";
	var item = customer.children[localStorage.getItem('target')];
	item.remove();
});
*/

//Hủy xóa hóa đơn
const deleteNo = document.querySelector('#delete-no-btn');
deleteNo.addEventListener('click', function() {
	var delete1 = document.getElementById("delete");
	delete1.style.display = "none";
});


//Thanh toán hóa đơn
const payBill = document.querySelector('#pay-btn');
payBill.addEventListener('click', function() {
	var pay = document.getElementById("pay");
	pay.style.display = "block";
});


//Thanh toán tiền mặt
const payCash = document.querySelector('#pay-cash-btn');
payCash.addEventListener('click', function() {
	var pay = document.getElementById("pay");
	pay.style.display = "none";
	var cash = document.getElementById("pay-cash");
	cash.style.display = "block";
});


//Xác nhận số tiền
const payCashMoney = document.querySelector('#cash-btn');
payCashMoney.addEventListener('click', function() {
	var cash = document.getElementById("pay-cash");
	cash.style.display = "none";
	var cashConf = document.getElementById("pay-cash-conf");
	cashConf.style.display = "block";
});


//Hoàn tất thanh toán tiền mặt
const cashConfirm = document.querySelector('#cash-conf-btn');
cashConfirm.addEventListener('click', function() {
	var cashConf = document.getElementById("pay-cash-conf");
	cashConf.style.display = "none";
	var bill = document.getElementById("bill");
	bill.style.display = "none";
});


//Thanh toán thẻ ATM
const payAtm = document.querySelector('#pay-atm-btn');
payAtm.addEventListener('click', function() {
	var pay = document.getElementById("pay");
	pay.style.display = "none";
	var atm = document.getElementById("pay-atm");
	atm.style.display = "block";
});


//Hoàn tất thanh toán thẻ ATM
const atmConfirm = document.querySelector('#atm-conf-btn');
atmConfirm.addEventListener('click', function() {
	var atm = document.getElementById("pay-atm");
	atm.style.display = "none";
	var bill = document.getElementById("bill");
	bill.style.display = "none";
});


//Đóng hóa đơn
const billDone = document.querySelector('#done-btn');
billDone.addEventListener('click', function() {
	console.log(billDone);
	var bill = document.getElementById("bill");
	bill.style.display = "none";
	create.style.display = "block";
	
});


const newNameInput = document.querySelector('#name-input');
const newPhoneInput = document.querySelector('#phone-input');
const newCodeInput = document.querySelector('#code-input');
const newSeatInput = document.querySelector('#seat-input');

//Thêm hóa đơn mới
const create = document.querySelector('#create-btn');

create.addEventListener('click', function() {
	var createBill = document.getElementById("new");
	createBill.style.display = "block";
	create.style.display = "none";
});
//tat nút tạo mới
const cancel_new = document.querySelector('#cancel-new-btn')
cancel_new.addEventListener('click', function() {
	var createBill = document.getElementById("new");
	createBill.style.display = 'none';
	create.style.display = 'block';
})

// bật tab chọn bàn

const selectTablebtn = document.getElementById('new-select-btn');
selectTablebtn.addEventListener('click', function() {
	var selectTable = document.getElementById('select-table');
	selectTable.style.display = "block";
});
const doneTablebtn = document.getElementById('done-select-table');
doneTablebtn.addEventListener('click', function() {
	var selectTable = document.getElementById('select-table');
	selectTable.style.display = "none";
});
// mở tab chọn món
const selectDishbtn = document.getElementById('add-btn');
const selectDish = document.getElementById('dish-select');
const doneSelectDish = document.getElementById('done-select-dish');
selectDishbtn.addEventListener('click', function() {
	selectDish.style.display = "block";
});



// bật số lượng

for (let i = 0; i < listCheckbox.length; i++) {
	(function(index) {
		listCheckbox[i].onclick = function() {
			if (listCheckbox[index].checked) {
				listCheckbox[index].parentElement.children[4].style.display = "inline-block"
				listCheckbox[index].parentElement.children[4].value = 1;
			} else {
				listCheckbox[index].parentElement.children[4].style.display = "none";
			}
		}

	})(i);
}

// hiển thị sang list
doneSelectDish.addEventListener('click', function() {
	selectDish.style.display = "none";
	dishlist.innerHTML = '';
	for (let i = 0; i < listCheckbox.length; i++) {
		if (listCheckbox[i].checked) {
			var dish = document.createElement("UL");
			dish.appendChild(listCheckbox[i].parentElement.children[0].cloneNode(true));
			dish.appendChild(listCheckbox[i].parentElement.children[1].cloneNode(true));
			dish.appendChild(listCheckbox[i].parentElement.children[2].cloneNode(true));
			dish.appendChild(listCheckbox[i].parentElement.children[4].cloneNode(true));
			dish.appendChild(listCheckbox[i].parentElement.children[5].cloneNode(true));
			dishlist.appendChild(dish);
		}
	}
});




var bill_id_get_from_table = sessionStorage.getItem("bill_id_get_from_table");
if (bill_id_get_from_table != null) {
	var idx = 0;
	var temp = $('#' + idx).data('billid');
	while (temp != undefined) {
		if (temp == bill_id_get_from_table) {
			bill.style.display = "block";
   			create.style.display = "none";
   			
   			var billID = bill_id_get_from_table;
   			var customername = $('#'+idx).data('customer');
			var phone = $('#'+idx).data('phone');
			var total = $('#'+idx).data('total');
			var statuspayment = $('#'+idx).data('statuspayment');
			var createdtime = $('#'+idx).data('createdtime');
			var memberank = $('#'+idx).data('memberank');
			document.getElementsByClassName("popup-bill-id")[0].innerHTML = "ID : " + billID;
			document.getElementsByClassName("popup-bill-name")[0].innerHTML = "Customer’s name : " + customername;
			document.getElementsByClassName("popup-bill-phone")[0].innerHTML = "Phone : " + phone;
			document.getElementsByClassName("popup-bill-total")[0].innerHTML = "Total : " + total;
			document.getElementsByClassName("popup-bill-creation-time")[0].innerHTML = "Created : " + createdtime;
			document.getElementsByClassName("popup-bill-rank")[0].innerHTML = "Member Rank : " + memberank;
			document.getElementsByClassName("popup-bill-completion-time")[0].innerHTML = "Status : " + statuspayment;
   			document.getElementsByClassName("popup-bill-seat")[0].innerHTML =document.getElementById("table"+idx).innerHTML;
   			
   			break;
		}
		idx = idx + 1;
		temp = $('#' + idx).data('billid');
	}
	sessionStorage.removeItem("bill_id_get_from_table");
	bill_id_get_from_table = null;
}