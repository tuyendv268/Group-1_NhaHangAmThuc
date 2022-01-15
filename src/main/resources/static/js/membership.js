var chosenIndex;
//Hiển thị action
let customers = document.getElementsByClassName('member')
for (let i = 0; i < customers.length; i++) {
	customers[i].addEventListener('click', () => {
		var id = $('#' + i).data('customerid');
		chosenIndex = i;
		$("#delete-yes-btn").attr("href", "/membership/delete/" + id);
		
		action = document.getElementById("action");
    	action.style.display = "block";
	})
}
//const customer = document.querySelector('.member-list');
//customer.addEventListener('click', function(event) {	
//  var list = Array.prototype.slice.call( customer.children );
//    index = list.indexOf(event.target.parentElement);
//    localStorage.setItem('target-member', index);
//    var action = document.getElementById("action");
//    action.style.display = "block";
//});

//Thay đổi thông tin member
let changeMember = document.getElementById("change-btn");
changeMember.addEventListener('click', function(){
	
	
    var action = document.getElementById("action");
    action.style.display = "none";
    var change = document.getElementById("change");
    change.style.display = "block";
    
    document.getElementById("edit-id").value = $('#' + chosenIndex).data('customerid');
    document.getElementById("edit-name").value = $('#' + chosenIndex).data('name');
    document.getElementById("edit-phone").value = $('#' + chosenIndex).data('phone');
});

//Hủy thay đổi thông tin member
//const changeCancel = document.querySelector('#change-cancel-btn');
//changeCancel.addEventListener('click', function(){
//    var action = document.getElementById("action");
//    action.style.display = "block";
//    var change = document.getElementById("change");
//    change.style.display = "none";
//});

//Xác nhận thay đổi thông tin member
const changeDone = document.querySelector('#change-done-btn');
changeDone.addEventListener('click', function(){
    var change = document.getElementById("change");
    change.style.display = "none";
});

//Xóa member
const deleteMember = document.querySelector('#delete-btn');
deleteMember.addEventListener('click', function(){
    var action = document.getElementById("action");
    action.style.display = "none";
    var delete0 = document.getElementById("delete");
    delete0.style.display = "block";
});

//Hủy xóa member
const deleteNo = document.querySelector('#delete-no-btn');
deleteNo.addEventListener('click', function(){
    var action = document.getElementById("action");
    action.style.display = "block";
    var delete0 = document.getElementById("delete");
    delete0.style.display = "none";
});

//Xác nhận xóa member
//const deleteYes = document.querySelector('#delete-yes-btn');
//deleteYes.addEventListener('click', function(){
//    var delete0 = document.getElementById("delete");
//    delete0.style.display = "none";
//});

//Đóng action
const back = document.querySelector('#action i');
back.addEventListener('click', function(){
    var action = document.getElementById("action");
    action.style.display = "none";
});

//Thêm member
const addMember = document.querySelector('#add-btn');
addMember.addEventListener('click', function(){
    var add = document.getElementById("add");
    add.style.display = "block";
});

//Hủy thay đổi thông tin member
const addCancel = document.querySelector('#add-cancel-btn');
addCancel.addEventListener('click', function(){
    var add = document.getElementById("add");
    add.style.display = "none";
});

//Xác nhận thay đổi thông tin member
const addDone = document.querySelector('#add-done-btn');
addDone.addEventListener('click', function(){
    var add = document.getElementById("add");
    add.style.display = "none";
});

//Quản lý khuyến mãi



let discountEditButtons = document.getElementsByClassName('manage-change-btn');
let discountDoneButtons = document.getElementsByClassName('change-done-btn');

const manageDiscount = document.querySelector('#manage-btn');
manageDiscount.addEventListener('click', function(){
    var manage = document.getElementById("manage");
    manage.style.display = "block";
    
    for (let i = 0; i < discountDoneButtons.length; i++) { 
		document.getElementById("discountChange" + i).style.display = "none";
	}
	
	for (let i = 0; i < discountEditButtons.length; i++) { 
		document.getElementById("discountLabel" + i).style.display = "block";
	}
});

//Xác nhận thay đổi
const manageDone = document.querySelector('#manage-done-btn');
manageDone.addEventListener('click', function(){
    var manage = document.getElementById("manage");
    manage.style.display = "none";
});

//Hiển thị action

for (let i = 0; i < discountEditButtons.length; i++) {
	discountEditButtons[i].addEventListener('click', () => {
		document.getElementById("discountLabel" + i).style.display = "none";
		document.getElementById("discountChange" + i).style.display = "block";
		
		document.getElementById("rank" + i).value = $('#' + "discountPanel" + i).data('rankid');
		document.getElementById("discountRateInput" + i).value = $('#' + "discountPanel" + i).data('discountrate');
	})
}
