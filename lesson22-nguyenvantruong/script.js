var addButton = $('#addButton')
var inputName = $('#name')
var inputValue = $('#value')
var selectAdd = $('#selectAdd')
var incomeList = $('#incomeList')
var expensesList = $('#expensesList')
var incomValue = $('#incomValue')
var expensesValue = $('#expensesValue')
var expensesPercent = $('#expensesPercent')
var valueFinal = $('#valueFinal')
var incomCount = 0
var expensesCount = 0
var incomFinal = 0
var expensesFinal = 0
var final = 0
var incomes = []
var expenses = []

var date = new Date()
$('#date').text(`${date.getDay()} - ${date.getMonth()} - ${date.getFullYear()}`)

function addIncomItem(name, value, id) {
    
    return `
        <div class="item clearfix" id="${id}">
            <div class="item__description">${name}</div>
            <div class="right clearfix">
                <div class="item__value">+ ${value}</div>
                <div class="item__delete">
                    <button class="item__delete--btn" onclick="deleteIncomeItem('${id}')">
                        <i class="ion-ios-close-outline"></i>
                    </button>
                </div>
            </div>
        </div>
    `
}

function addExpensesItem(name, value, id, percent) {
    
    return `
        <div class="item clearfix" id="${id}">
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
        </div>
    `
}

function findIndex(arr, id){
    for (let index = 0; index < arr.length; index++) {
        if(arr[index].id === id){
            return index;
        }
        
    }
}

function deleteIncomeItem(id) {
    elements = ""
    incomes.splice(findIndex(incomes,id),1)
    incomFinal = 0
    
    incomes.forEach(element => {
        incomFinal += parseFloat(element.value)
        elements += addIncomItem(element.name,
                                element.value,
                                element.id)
    });
    document.getElementById("incomeList").innerHTML = elements
    incomValue.text(`+ ${incomFinal}`)
    updateExpeneseItem(null)
    
}

function updateExpeneseItem(id) {
    elements = ""
    if(id!=null){
        expenses.splice(findIndex(expenses,id),1)
    }
    expensesFinal = 0
    
    for (let index = 0; index < expenses.length; index++) {
        
    }
    expenses.forEach(element => {
        expensesFinal += parseFloat(element.value)
        percent = ((parseFloat(element.value)/incomFinal)*100).toFixed(1)
        if(percent==Number.POSITIVE_INFINITY || isNaN(percent)){
            percent = "..."
        }
        elements += addExpensesItem(element.name,
                                element.value,
                                element.id,
                                percent)
    });
    document.getElementById("expensesList").innerHTML = elements
    expensesValue.text(`- ${expensesFinal}`)
    final = incomFinal - expensesFinal
    if(valueFinal >= 0){
        valueFinal.text(`+ ${final}`)
    }else{
        valueFinal.text(`${final}`)
    }
    let percentFinal = (expensesFinal/incomFinal * 100).toFixed(1)
    if(percentFinal==Number.POSITIVE_INFINITY || isNaN(percentFinal)){
        percentFinal = "..."
    }
    expensesPercent.text(`${percentFinal}%`)
}

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

})