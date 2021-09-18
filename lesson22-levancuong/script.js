<<<<<<< HEAD
// dateMonthYear
var date = new Date();    
document.getElementById('date').innerText = date;

function showIncome(name, value, id) { 	
 	return ` <div class="item clearfix" id="${id}">
    	        <div class="item__description">${name}</div>
        	    <div class="right clearfix">
            	    <div class="item__value">+ ${value}</div>
                	<div class="item__delete">
                    	<button class="item__delete--btn" onclick="deleteIncomeItem('${id}')">
                        	<i class="ion-ios-close-outline"></i>
                    	</button>
                	</div>
            	</div>
        	</div>`
};

function showExpense(name, value, id, percent) {
    return ` <div class="item clearfix" id="${id}">
            	<div class="item__description">${name}</div>
            	<div class="right clearfix">
                	<div class="item__value">- ${value}</div>
                	<div class="item__percentage">${percent}%</div>
                	<div class="item__delete">
                    	<button class="item__delete--btn"  onclick="updateExpeneseItem('${id}')">
                        	<i class="ion-ios-close-outline"></i>
                    	</button>
                	</div>
            	</div>
        	</div>`
};

addButton.on("click", function() {

    if(selectAdd.val() === 'inc'){
        let id = "incom-"+incomCount
        value = parseFloat(inputValue.val()).toFixed(2)
        income = {
            name: inputName.val(),
            value: value,
            id: id
        }
        incomes.push(income)
        let element = addIncomItem(inputName.val(),
                                    value,
                                    id)
        document.getElementById("incomeList").innerHTML += element
        incomFinal += parseFloat(parseFloat(inputValue.val()).toFixed(2))
        incomValue.text(`+ ${incomFinal}`)
        incomCount++;
    } else {
        let id = "expenses-"+expensesCount
        let value = parseFloat(inputValue.val()).toFixed(2)
        exp = {
            name: inputName.val(),
            value: value,
            id: id
        }
        expenses.push(exp)
        percent = ((value/incomFinal)*100).toFixed(1)
        let element = addExpensesItem(inputName.val(),
                                    value,
                                    id,
                                    percent)
        document.getElementById("expensesList").innerHTML += element
        expensesFinal += parseFloat(parseFloat(inputValue.val()).toFixed(2))
        expensesValue.text(`- ${expensesFinal}`)
        
        expensesCount++;
    }
    updateExpeneseItem(null)
});
var items=[];
function deleteItem(index) {
  items.splice(index, 1);
  render();
};

function showTotal() {
  let sumIncome = items.filter(item => item.value > 0).	((currentValue, item) => currentValue + item.value, 0);
  let sumExpense = items.filter(item => item.value < 0).reduce((currentValue, item) => currentValue + item.value, 0);
  $(".budget__income--value").html(sumIncome);
  $(".budget__expenses--value").html(sumExpense);
  console.log(sumIncome - sumExpense);
  $(".budget__value").html(sumIncome + sumExpense);
};

=======
let add_btn = document.querySelector(".add__btn");
let sumInc = document.querySelector(".budget__income--value");
let sumDec = document.querySelector(".budget__expenses--value");
let sumAll = document.querySelector(".budget__value");
let perAll = document.querySelector(".budget__expenses--percentage");
let sign = document.querySelector(".add__type");
let input_des = document.querySelector(".add__description");
let input_val = document.querySelector(".add__value");
let arr_inc = [];
let arr_dec = [];

let d = new Date();
let n = d.getMonth();
let month = document.querySelector(".budget__title--month");
month.textContent = n + 1;


function countSumAll(sumInc, sumDec) {
  return Number(sumInc) - Number(sumDec);
}

function countPerAll(sumInc, sumDec) {
  return ((Number(sumDec) * 100) / Number(sumInc)).toFixed(2);
}

function countPerItem(sumDec, sumItem) {
  return ((Number(sumItem) * 100) / Number(sumDec)).toFixed(2);
}
add_btn.onclick = function () {

  if (sign.value === "inc") {
    let i = document.createElement("i");
    i.className = "ion-ios-close-outline";

    let btn = document.createElement("i");
    btn.className = "item__delete--btn";
    btn.appendChild(i);

    let item__delete = document.createElement("div");
    item__delete.className = "item__delete";
    item__delete.appendChild(btn);

    let item__value = document.createElement("div");
    item__value.className = "item__value";
    let value = `${input_val.value}`;
    item__value.textContent = `+${input_val.value}`;
    let item_right_clearfix = document.createElement("div");
    item_right_clearfix.className = "right clearfix";
    item_right_clearfix.appendChild(item__value);
    item_right_clearfix.appendChild(item__delete);

    let item_des = document.createElement("div");
    item_des.className = "item__description";
    item_des.textContent = `${input_des.value}`;

    let income__list = document.querySelector(".income__list");
    let temp = income__list.children.length;
    let item_inc = document.createElement("div");
    item_inc.className = "item clearfix";
    item_inc.id = `${temp}`;
    item_inc.appendChild(item_des);
    item_inc.appendChild(item_right_clearfix);
    income__list.appendChild(item_inc);

    arr_inc.push({
      id: temp,
      val: value,
    });
    let sum = Number(sumInc.textContent) + Number(value);
    sumInc.textContent = sum;
    sumAll.textContent = countSumAll(sumInc.textContent, sumDec.textContent);
    perAll.textContent = countPerAll(sumInc.textContent, sumDec.textContent);
    i.onclick = function () {
      for (i in arr_inc) {
        if (arr_inc[i].id == item_inc.id) {
          let element = income__list.children[i];
          element.remove();
          let sum = Number(sumInc.textContent);
          sumInc.textContent = sum - Number(arr_inc[i].val);
          arr_inc.splice(i, 1);
          sumAll.textContent = countSumAll(
            sumInc.textContent,
            sumDec.textContent
          );
          perAll.textContent = countPerAll(
            sumInc.textContent,
            sumDec.textContent
          );
          break;
        }
      }
    };
  } else {
    let i = document.createElement("i");
    i.className = "ion-ios-close-outline";
    let btn = document.createElement("i");
    btn.className = "item__delete--btn";
    btn.appendChild(i);

    let item__delete = document.createElement("div");
    item__delete.className = "item__delete";
    item__delete.appendChild(btn);

    let item__value = document.createElement("div");
    item__value.className = "item__value";
    let value = `${input_val.value}`;
    item__value.textContent = `-${input_val.value}`;

    let item__percentage = document.createElement("div");
    item__percentage.className = "item__percentage";
    item__percentage.textContent = `0`;

    let item_right_clearfix = document.createElement("div");
    item_right_clearfix.className = "right clearfix";
    item_right_clearfix.appendChild(item__value);
    item_right_clearfix.appendChild(item__percentage);
    item_right_clearfix.appendChild(item__delete);

    let item_des = document.createElement("div");
    item_des.className = "item__description";
    item_des.textContent = `${input_des.value}`;

    let expenses__list = document.querySelector(".expenses__list");
    let temp = expenses__list.children.length;
    let item_sub = document.createElement("div");
    item_sub.className = "item clearfix";
    item_sub.id = `dec${temp}`;
    item_sub.appendChild(item_des);
    item_sub.appendChild(item_right_clearfix);
    expenses__list.appendChild(item_sub);

    arr_dec.push({
      id: temp,
      val: value,
    });
    let sum = Number(sumDec.textContent) + Number(value);
    sumDec.textContent = sum;
    sumAll.textContent = countSumAll(sumInc.textContent, sumDec.textContent);
    perAll.textContent = countPerAll(sumInc.textContent, sumDec.textContent);
    item__percentage.textContent = countPerItem(
      sumDec.textContent,
      Number(value)
    );

    i.onclick = function () {
      for (i in arr_dec) {
        if ("dec" + arr_dec[i].id == item_sub.id) {
          let element = expenses__list.children[i];
          element.remove();
          let sum = Number(sumDec.textContent);
          sumDec.textContent = sum - Number(arr_dec[i].val);
          arr_dec.splice(i, 1);
          sumAll.textContent = countSumAll(
            sumInc.textContent,
            sumDec.textContent
          );
          perAll.textContent = countPerAll(
            sumInc.textContent,
            sumDec.textContent
          );

          break;
        }
      }
    };
  }
};
>>>>>>> 5d6f38a (lesson22-levancuong submit code 01)
