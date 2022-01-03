//Hiển thị hóa đơn
const customer = document.querySelector('.customer-list');
customer.addEventListener('click', function(event) {
    var list = Array.prototype.slice.call( customer.children );
    index = list.indexOf(event.target.parentElement);
    localStorage.setItem('target', index);
    var bill = document.getElementById("bill");
    bill.style.display = "block";
    create.style.display = "none";
    const name = document.querySelector('#bill-name span')
    name.innerHTML = event.target.parentElement.children[2].innerText;
    const code = document.querySelector('#bill-code span')
    code.innerHTML = event.target.parentElement.children[1].innerText;
    const status = document.querySelector('#bill-status span')
    status.innerHTML = event.target.parentElement.children[4].innerText;
});


//Chỉnh sửa hóa đơn
const editBill = document.querySelector('#edit-btn');
editBill.addEventListener('click', function(){
    var bill = document.getElementById("bill");
    bill.style.display = "none";
    var edit = document.getElementById("edit");
    edit.style.display = "block";
});


//Xác nhận chỉnh sửa
const editDone = document.querySelector('#edit-done-btn');
editDone.addEventListener('click', function(){
    var edit = document.getElementById("edit");
    edit.style.display = "none";
    var bill = document.getElementById("bill");
    bill.style.display = "block";
});


//Xóa hóa đơn
const deleteBill = document.querySelector('#delete-btn');
deleteBill.addEventListener('click', function(){
    var delete1 = document.getElementById("delete");
    delete1.style.display = "block";
});


//Xác nhận xóa hóa đơn
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


//Hủy xóa hóa đơn
const deleteNo = document.querySelector('#delete-no-btn');
deleteNo.addEventListener('click', function(){
    var delete1 = document.getElementById("delete");
    delete1.style.display = "none";
});


//Thanh toán hóa đơn
const payBill = document.querySelector('#pay-btn');
payBill.addEventListener('click', function(){
    var pay = document.getElementById("pay");
    pay.style.display = "block"; 
});


//Thanh toán tiền mặt
const payCash = document.querySelector('#pay-cash-btn');
payCash.addEventListener('click', function(){
    var pay = document.getElementById("pay");
    pay.style.display = "none";
    var cash = document.getElementById("pay-cash");
    cash.style.display = "block";
});


//Xác nhận số tiền
const payCashMoney = document.querySelector('#cash-btn');
payCashMoney.addEventListener('click', function(){
    var cash = document.getElementById("pay-cash");
    cash.style.display = "none";
    var cashConf = document.getElementById("pay-cash-conf");
    cashConf.style.display = "block";
});


//Hoàn tất thanh toán tiền mặt
const cashConfirm = document.querySelector('#cash-conf-btn');
cashConfirm.addEventListener('click', function(){
    var cashConf = document.getElementById("pay-cash-conf");
    cashConf.style.display = "none";
    var bill = document.getElementById("bill");
    bill.style.display = "none";
});


//Thanh toán thẻ ATM
const payAtm = document.querySelector('#pay-atm-btn');
payAtm.addEventListener('click', function(){
    var pay = document.getElementById("pay");
    pay.style.display = "none";
    var atm = document.getElementById("pay-atm");
    atm.style.display = "block";
});


//Hoàn tất thanh toán thẻ ATM
const atmConfirm = document.querySelector('#atm-conf-btn');
atmConfirm.addEventListener('click', function(){
    var atm = document.getElementById("pay-atm");
    atm.style.display = "none";
    var bill = document.getElementById("bill");
    bill.style.display = "none";
});


//Đóng hóa đơn
const billDone = document.querySelector('#done-btn');
billDone.addEventListener('click', function(){
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
create.addEventListener('click', function(){   
    var createBill = document.getElementById("new");
    createBill.style.display = "block";
    create.style.display = "none";
});

//Xác nhận hoá đơn mới
const newDone = document.querySelector('#new-done-btn');
newDone.addEventListener('click', function(){
    var createBill = document.getElementById("new");
    createBill.style.display = "none";
    create.style.display = "block";
    
    //Thêm dòng
    const customerTr = document.createElement("tr");
    customerTr.classList.add('customer');

    const newCustomerStt = document.createElement('td');
    const newCustomerCode = document.createElement('td');
    const newCustomerName = document.createElement('td');
    const newCustomerMoney = document.createElement('td');
    const newCustomerStatus = document.createElement('td');

    customerTr.appendChild(newCustomerStt);
    newCustomerCode.innerText = newCodeInput.value;
    customerTr.appendChild(newCustomerCode);
    console.log(newCustomerCode);
    newCustomerName.innerText = newNameInput.value;
    customerTr.appendChild(newCustomerName);
    console.log(newCustomerName);
    customerTr.appendChild(newCustomerMoney);
    customerTr.appendChild(newCustomerStatus);
    customer.appendChild(customerTr);
    console.log(customerTr);
    newCodeInput.value = '';
    newNameInput.value = '';
    newPhoneInput.value = '';
    newSeatInput.value = '';
});















