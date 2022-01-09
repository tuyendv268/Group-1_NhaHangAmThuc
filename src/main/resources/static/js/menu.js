let addDishf = (nth) => {
    return `<img src="./image/dish/dish0${nth}.jpg" alt="">`
}

// let menuDishUl = document.getElementsByClassName('ulDish')[0]
// for (let i = 0; i < 3; i++) {
//     let li = document.createElement('li')
//     li.innerHTML = addDishf(i)
//     menuDishUl.appendChild(li)
// }

// Upload picture combo
// Get base 64
let url = ''
function encodeImageFileAsURL(element) {
    var file = element.files[0];
    var reader = new FileReader();
    reader.onloadend = function() {
        url = reader.result
    }
    reader.readAsDataURL(file);
}

//---------
let isDisplay = false

//------------------- menu dish -----------------------
// done dish //done for add a new Dish
let doneDish = document.querySelector('.box_add_dish button')
// box_add_dish
let boxDish = document.querySelector('.box_add_dish')
// add dish button
let addDishButton = document.querySelector('.add_Dish')
// list dish
let ulDishItem = document.querySelectorAll('.ulDish li')
// ul dish
let ulDish = document.querySelector('.box_add_dish ul')
// box dish info item
let boxDishInfo = document.getElementsByClassName('box_dish_info')[0]
// edit dish box
let editInfo = document.querySelector('.edit_Info')
// box edit dish
let boxEditDish = document.querySelector('.box_InfoFood')
// done edit info dish
let doneBoxInfoDish = document.querySelector('.box_InfoFood button')
//remove dish
let remove_dish = document.getElementById('remove_dish')
let remove_dish0 = document.getElementById('remove_dish0')
// infomation food item
let getInfoDish = () => {
	var id;
	var index;
    ulDishItem = document.querySelectorAll('.ulDish li')
    for (let i = 0; i < ulDishItem.length; i++) {
        ulDishItem[i].addEventListener('click', (e) => {
            boxDishInfo.style.display = 'block'

			index=document.getElementsByClassName('temp')[i].id;
			id = $('#' + index).data('dishid');
			$("#remove_dish0").attr("href", "/menu/delete/"+id);
			
			document.getElementsByClassName("dish id")[0].innerHTML = $('#' + index).data('dishid');
			document.getElementsByClassName("dish name")[0].innerHTML = $('#' + index).data('dishname');
			document.getElementsByClassName("dish price")[0].innerHTML = $('#' + index).data('dishprice');
			document.getElementsByClassName("dish description")[0].innerHTML = $('#' + index).data('dishdescription');
			document.getElementsByClassName("dish category")[0].innerHTML = $('#' + index).data('dishcategory');
			document.getElementsByClassName("dish ingredient")[0].innerHTML = $('#' + index).data('dishingredient');
			//document.getElementsByClassName("dish creation time")[0].innerHTML = $('#' + i).data('dishID');
			//document.getElementsByClassName("dish modification time")[0].innerHTML = $('#' + i).data('dishID');
			document.getElementsByClassName("dish status of existence")[0].innerHTML = $('#' + index).data('dishstatus');
        })
    }
    

    doneBoxInfoDish.addEventListener('click', () => {
        boxEditDish.style.display = 'none'
    })
    
    editInfo.addEventListener('click', () => {
        boxEditDish.style.display = 'block'
        boxDishInfo.style.display = 'none'
		
			document.getElementsByClassName("dish id")[1].value = $('#' + index).data('dishid');
			document.getElementsByClassName("dish name")[1].value = $('#' + index).data('dishname');
			document.getElementsByClassName("dish price")[1].value = $('#' + index).data('dishprice');
			document.getElementsByClassName("dish description")[1].value = $('#' + index).data('dishdescription');
			document.getElementsByClassName("dish category")[1].value = $('#' + index).data('dishcategory');
			document.getElementsByClassName("dish ingredient")[1].value = $('#' + index).data('dishingredient');
			//document.getElementsByClassName("dish creation time")[0].innerHTML = $('#' + i).data('dishID');
			//document.getElementsByClassName("dish modification time")[0].innerHTML = $('#' + i).data('dishID');
			if($('#' + index).data('dishstatus')===true)
				document.getElementsByClassName("dish status of existence")[1].checked=true;
			else if($('#' + index).data('dishstatus')===false)
				document.getElementsByClassName("dish status of existence")[1].checked=false;
    })
    console.log(1);
}
getInfoDish()

//------------------------
// Add dish
let addDishItem = (urlDish) => {
    return `<img src="${urlDish}" alt="">`
}

// add list food to choose to combo
let addListFood = (urlDish) => {
    let nth = document.querySelectorAll('.ulDish li').length
    console.log(nth);
    return `<span>
                <img src="${urlDish}" alt="">
            </span>
            <p>Food Name ${nth}</p> 
            <span>
                <input type="checkbox">
            </span>`
}

addDishButton.addEventListener('click', (e) => {
    boxDish.style.display = 'block'
})

doneDish.addEventListener('click', (e) => {
    boxDish.style.display = 'none'
    if(url!=='') {
        let menuDishUl = document.getElementsByClassName('ulDish')[0]
        let li = document.createElement('li')
        li.innerHTML = addDishItem(url)
        menuDishUl.appendChild(li)

        let listChooseFood = document.querySelector('.listChooseFood')
        let listChoose = document.createElement('li')
        listChoose.innerHTML = addListFood(url)
        listChooseFood.appendChild(listChoose)
        
        getInfoDish()
    }
    url = ''
})


//------------------ menu combo ------------------- 
// done combo
let doneCombo = document.querySelector('.done_Combo')

//Tiến thêm chỗ này
let add_or_remove_food = document.querySelector('.add_or_remove_food')

// box add combo
let boxCombo = document.querySelector('.box_add_combo')
// add combo
let addCombo = document.querySelector('.add_combo')
// ul Combo
let ulCombo = document.querySelector('.ulCombo')
// list combo
let ulComboItem = document.querySelectorAll('.ulCombo li')
let addCombof = (url) => {
    return `<img src="${url}" alt="">`
}
// boxComboItem
let boxComboItem = document.querySelector('.boxComboItem')
// boxComboEdit
let boxComboEdit = document.querySelector('.boxComboEdit')
// Combo Detail
let buttonEditCombo = document.getElementsByClassName('editCombo_button')[0]
// doneEditCombo
let doneEditCombo = document.querySelector('.boxComboEdit button')

// exit list choose food
let exitListChooseFood = document.getElementsByClassName('exit')[0]



// list add food
let listAddFood = document.querySelector('.addFoodCombo')

let addOrRemove = document.getElementsByClassName('add_or_remove_food_edit')[0]


let comboDetail = () => {
	var id;
	var index;
    ulComboItem = document.querySelectorAll('.ulCombo li')
    for (let i = 0; i < ulComboItem.length; i++) {
        ulComboItem[i].addEventListener('click', () => {
         
                boxComboItem.style.display = 'block'
                isDisplay=true
				
			index=document.getElementsByClassName('temp2')[i].id;
			id = $('#' + index).data('comboid');
			$("#remove_combo0").attr("href", "/menu/delete/combo/"+id);
			
			document.getElementsByClassName("combo id")[0].innerHTML = $('#' + index).data('comboid');
			document.getElementsByClassName("combo name")[0].innerHTML = $('#' + index).data('comboname');
			document.getElementsByClassName("combo price")[0].innerHTML = $('#' + index).data('comboprice');
			document.getElementsByClassName("combo description")[0].innerHTML = $('#' + index).data('combodescription');
			
			document.getElementsByClassName("combo amount of people")[0].innerHTML = $('#' + index).data('combonumberofpeoplerecommend');
			document.getElementsByClassName("combo discount rate")[0].innerHTML = $('#' + index).data('combodiscountrate');
			//document.getElementsByClassName("dish creation time")[0].innerHTML = $('#' + i).data('dishID');
			//document.getElementsByClassName("dish modification time")[0].innerHTML = $('#' + i).data('dishID');
			
            
        })
    }

    buttonEditCombo.addEventListener('click', () => {
        boxComboEdit.style.display = 'block'
        boxComboItem.style.display = 'none'
			document.getElementsByClassName("combo id")[1].value = $('#' + index).data('comboid');
			document.getElementsByClassName("combo name")[1].value = $('#' + index).data('comboname');
			document.getElementsByClassName("combo price")[1].value = $('#' + index).data('comboprice');
			document.getElementsByClassName("combo description")[1].value = $('#' + index).data('combodescription');
			
			document.getElementsByClassName("combo amount of people")[1].value = $('#' + index).data('combonumberofpeoplerecommend');
			document.getElementsByClassName("combo discount rate")[1].value = $('#' + index).data('combodiscountrate');
  	 	
 	})
	addOrRemove.addEventListener('click', () => {
		 listAddFood.style.display = 'block' 
	 	
	})
	
	
    doneEditCombo.addEventListener('click', () => {
        boxComboEdit.style.display = 'none'
        isDisplay=false
    })

    exitListChooseFood.addEventListener('click', (e) => {
        listAddFood.style.display = 'none'
        isDisplay=false
		var countEachDish = document.getElementsByName('count'); 
		var checkboxes = document.getElementsByName('listFood');
		var listAllFoodValue = document.getElementsByName('listFoodValue');
	
		var listSelectedFoodValue = []; 		 
		for (var i=0; i<checkboxes.length; i++) {    
     		if (checkboxes[i].checked){
        		 listSelectedFoodValue.push(listAllFoodValue[i].textContent);	
				 if(countEachDish[i].type="text")
				 listSelectedFoodValue.push(countEachDish[i].value)		
			}
			    	 
 		}
		document.getElementById('list_of_dishes_in_combo').value= listSelectedFoodValue;
    })

   

}
comboDetail()

//----------------------------------------

addCombo.addEventListener('click', (e) => {
    boxCombo.style.display = 'block'
    isDisplay=true  
})

doneCombo.addEventListener('click', (e) => {
    boxCombo.style.display = 'none'
    isDisplay=false
    if(url!=='') {
        let li = document.createElement('li')
        li.innerHTML = addCombof(url)
        console.log(li);
        ulCombo.appendChild(li)
    }
    url = ''
    comboDetail()
})

add_or_remove_food.addEventListener('click', (e) => {
        listAddFood.style.display = 'block'   
		var countEachDish = document.getElementsByName('count'); 
	
		/*	var checkboxes = document.getElementsByName('listFood');
		for (var i=0; i<checkboxes.length; i++) {  
			checkboxes[i].onclick= myFuction;
		}	
		function myFuction() {
   			alert("hello");
   		}*/
		var checkboxes = document.getElementsByName('listFood');
		for (var i=0; i<checkboxes.length; i++) {     
			 (function(index){
        		checkboxes[i].onclick = function(){
            		if(checkboxes[index].checked){
						countEachDish[index].type="text";
					}else{
						countEachDish[index].type="hidden";
					}
						
        		}    
   			 })(i);
		}
		  	
})

		
