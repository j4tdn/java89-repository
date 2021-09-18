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

