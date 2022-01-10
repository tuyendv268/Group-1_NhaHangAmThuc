//Hiển thị action
const customer = document.querySelector('.customer-list');
customer.addEventListener('click', function(event) {
    var list = Array.prototype.slice.call( customer.children );
    index = list.indexOf(event.target.parentElement);
    localStorage.setItem('target-member', index);
    var action = document.getElementById("action");
    action.style.display = "block";
});

//Thay đổi thông tin member
const changeMember = document.querySelector('#change-btn');
changeMember.addEventListener('click', function(){
    var action = document.getElementById("action");
    action.style.display = "none";
    var change = document.getElementById("change");
    change.style.display = "block";
});

//Hủy thay đổi thông tin member
const changeCancel = document.querySelector('#change-cancel-btn');
changeCancel.addEventListener('click', function(){
    var action = document.getElementById("action");
    action.style.display = "block";
    var change = document.getElementById("change");
    change.style.display = "none";
});

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
const deleteYes = document.querySelector('#delete-yes-btn');
deleteYes.addEventListener('click', function(){
    var delete0 = document.getElementById("delete");
    delete0.style.display = "none";
    var item = customer.children[localStorage.getItem('target-member')];
    item.remove();
});

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
const manageDiscount = document.querySelector('#manage-btn');
manageDiscount.addEventListener('click', function(){
    var manage = document.getElementById("manage");
    manage.style.display = "block";
});

//Xác nhận thay đổi
const manageDone = document.querySelector('#manage-done-btn');
manageDone.addEventListener('click', function(){
    var manage = document.getElementById("manage");
    manage.style.display = "none";
});