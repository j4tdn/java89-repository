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

var incomeItems = [
    {
        description: "Salary",
        value: 21000
    },
    {
        description: "Sold car",
        value: 15000
    }
];
var expensesItems = [
    {
        description: "Apartment rent",
        value: -900
    },
    {
        description: "Grocery shopping",
        value: -435
    }
];

function deleteIncomeItem(index) {
    incomeItems.splice(index, 1);
    renderUI();
};

function deleteExpensesItem(index) {
    expensesItems.splice(index, 1);
    renderUI();
};

function renderIncome() {
    let incomeList = "";
    incomeItems.forEach((item, index) => {
       
        incomeList += `<div class="item clearfix">
                    <div class="item__description">${item.description}</div>
                    <div class="right clearfix">
                        <div class="item__value">+ ${item.value}</div>
                        <div class="item__delete">
                            <button class="item__delete--btn" onclick="deleteIncomeItem(${index})">
                                    <i class="ion-ios-close-outline"></i>
                            </button>
                        </div>
                    </div>
                </div>`
        
    });

    $('#incomeList').html(incomeList);
};

function percentExpenses(value) {
    let sumIncome = incomeItems.reduce((currentValue, task) => currentValue + task.value, 0);
    let percent = Math.abs(value) / sumIncome;
    percent = Math.round(percent * 100);
    return percent;
};


function renderExpense() {
    let expensesList = "";
    expensesItems.forEach((item, index) => {
            expensesList += `<div class="item clearfix">
                            <div class="item__description">${item.description}</div>
                            <div class="right clearfix">
                                <div class="item__value">${item.value}</div>
                                <div class="item__percentage">${percentExpenses(item.value)}%</div>
                                <div class="item__delete">
                                    <button class="item__delete--btn" onclick="deleteExpensesItem(${index})"><i class="ion-ios-close-outline"></i></button>
                                </div>
                            </div>
                        </div>`
    });

    $('#expensesList').html(expensesList);
};

function renderTotalValue() {
    let sumIncome = incomeItems.reduce((currentValue, item) => currentValue + item.value, 0);
    let sumExpense = expensesItems.reduce((currentValue, item) => currentValue + item.value, 0);
    let totalValue = sumIncome - sumExpense;

    $(".budget__income--value").html("+ " + sumIncome + ".00");
    $(".budget__expenses--value").html( sumExpense + ".00");
    if((totalValue) >= 0) {
        $(".budget__value").html("+ " + totalValue + ".00");
    } else {
        $(".budget__value").html(totalValue + ".00");
    }

    let percent = Math.abs(sumExpense) / sumIncome;
    percent = Math.round(percent * 100);
    $(".budget__expenses--percentage").html(percent + "%");
    
};

function renderUI() {
    renderExpense();
    renderIncome();
    renderTotalValue();
}

renderUI();

$("#addButton").click(() => {
    let item = {};
    let description = $("#description").val();
    let addType = $("#addType").val();
    let addValue = $("#value").val();

    item.description = description;
    item.value = parseInt(addValue);

    if (addType ==='inc') {
        incomeItems.push(item);
    } else {
        expensesItems.push(item);
    }
    renderUI();
    $("#description").val("");
    $("#value").val("");
});

