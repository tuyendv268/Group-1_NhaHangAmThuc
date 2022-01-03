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
// done dish
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

// infomation food item
let getInfoDish = () => {
    ulDishItem = document.querySelectorAll('.ulDish li')
    for (let i = 0; i < ulDishItem.length; i++) {
        ulDishItem[i].addEventListener('click', (e) => {
            boxDishInfo.style.display = 'block'
        })
    }
    

    doneBoxInfoDish.addEventListener('click', () => {
        boxEditDish.style.display = 'none'
    })
    
    editInfo.addEventListener('click', () => {
        boxEditDish.style.display = 'block'
        boxDishInfo.style.display = 'none'
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
// edit Food on Combo
let Food2Combo_button = document.getElementsByClassName('food2Combo_button')[0]

let comboDetail = () => {
    ulComboItem = document.querySelectorAll('.ulCombo li')
    for (let i = 0; i < ulComboItem.length; i++) {
        ulComboItem[i].addEventListener('click', () => {
            if(!isDisplay){
                boxComboItem.style.display = 'block'
                isDisplay=true
            }
        })
    }

    buttonEditCombo.addEventListener('click', () => {
        boxComboEdit.style.display = 'block'
        boxComboItem.style.display = 'none'
    })

    doneEditCombo.addEventListener('click', () => {
        boxComboEdit.style.display = 'none'
        isDisplay=false
    })

    exitListChooseFood.addEventListener('click', (e) => {
        listAddFood.style.display = 'none'
        isDisplay=false
    })

    Food2Combo_button.addEventListener('click', (e) => {
        listAddFood.style.display = 'block'
        boxComboItem.style.display = 'none'
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
