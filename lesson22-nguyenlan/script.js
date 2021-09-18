var incomeCount = 0
var expensesCount = 0
var incomeFinal = 0
var expensesFinal = 0
var total = 0
var incomes = []
var expenses = []

const monthNames = ["January", "February", "March", "April", "May", "June",
  "July", "August", "September", "October", "November", "December"
];

var date = new Date()
document.getElementById('month').textContent = monthNames[date.getMonth()] + " " + date.getFullYear();



function addIncomItem(description, value, id) {
    
    return `
        <div class="item clearfix" id="${id}">
            <div class="item__description">${description}</div>
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

function addExpensesItem(description, value, id, percent) {
    
    return `
        <div class="item clearfix" id="${id}">
            <div class="item__description">${description}</div>
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
    incomeFinal = 0
    
    incomes.forEach(element => {
        incomeFinal += parseFloat(element.value)
        elements += addIncomItem(element.description,
                                element.value,
                                element.id)
    });
    document.getElementById("$('#incomeList')").innerHTML = elements
    $('#incomeValue').text(`+ ${incomeFinal}`)
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
        percent = ((parseFloat(element.value)/incomeFinal)*100).toFixed(1)
        if(percent==Number.POSITIVE_INFINITY || isNaN(percent)){
            percent = "..."
        }
        elements += addExpensesItem(element.description,
                                element.value,
                                element.id,
                                percent)
    });
    document.getElementById("$('#expensesList')").innerHTML = elements
    $('#expensesValue').text(`- ${expensesFinal}`)
    total = incomeFinal - expensesFinal
    if($('#totalValue') >= 0){
        $('#totalValue').text(`+ ${final}`)
    }else{
        $('#totalValue').text(`${final}`)
    }
    let percentFinal = (expensesFinal/incomeFinal * 100).toFixed(1)
    if(percentFinal==Number.POSITIVE_INFINITY || isNaN(percentFinal)){
        percentFinal = "..."
    }
    $('#expensesPercentage').text(`${percentFinal}%`)
}

$('#addButton').on("click", function() {

    if($('#selectAdd').val() === 'inc'){
        let id = "incom-"+incomeCount
        value = parseFloat($('#value').val()).toFixed(2)
        income = {
            description: $('#description').val(),
            value: value,
            id: id
        }
        incomes.push(income)
        let element = addIncomItem($('#description').val(),
                                    value,
                                    id)
        document.getElementById("incomeList").innerHTML += element
        incomeFinal += parseFloat(parseFloat($('#value').val()).toFixed(2))
        $('#incomeValue').text(`+ ${incomeFinal}`)
        incomeCount++;
    } else {
        let id = "expenses-"+expensesCount
        let value = parseFloat($('#value').val()).toFixed(2)
        exp = {
            description: $('#description').val(),
            value: value,
            id: id
        }
        expenses.push(exp)
        percent = ((value/incomeFinal)*100).toFixed(1)
        let element = addExpensesItem($('#description').val(),
                                    value,
                                    id,
                                    percent)
        document.getElementById("expensesList").innerHTML += element
        expensesFinal += parseFloat(parseFloat($('#value').val()).toFixed(2))
        $('#expensesValue').text(`- ${expensesFinal}`)
        
        expensesCount++;
    }
    updateExpeneseItem(null)

})