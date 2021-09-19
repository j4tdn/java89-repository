$(document).ready(function() {
    var addType = $('.add__type');
    var addDescription = $('.add__description');
    var addValue = $('.add__value');
    var addBtn = $('.add__btn');
    var incomeList = $('.income__list');
    var expensesList = $('.expenses__list');
    var budgetIncomeValue = $('.budget__income--value');
    var budgetExpensesValue = $('.budget__expenses--value');
    var budget__Value = $('.budget__value');
    var budgetPercentage = $('.budget__expenses--percentage');
    var index = 2;
    var incomes = [{
            id: 0,
            description: "Java",
            value: 10000
        },
        {
            id: 1,
            description: "Javascript",
            value: 20000
        },
    ];
    var expenes = [{
            id: 0,
            description: "SQL",
            value: 2000
        },
        {
            id: 1,
            description: "HTML",
            value: 2000
        },
    ];


    // Date
    let date = new Date();
    let formatDate = `${date.getHours()}:${date.getMinutes()} ${date.getDate()}/${date.getMonth()+1}/${date.getFullYear()}`;
    $('.budget__title--month').text(formatDate);


    function delIncome(index) {
        console.log(index);
        incomes.splice(index, 1);
    };
    // addIncome
    function addIncome(id, description, value) {
        return `<div class="item clearfix" id="${id}">
        <div class="item__description">${description}</div>
        <div class="right clearfix">
            <div class="item__value">+ ${value}</div>
            <div class="item__delete">
                <button class="item__delete--btn" onclick='delIncome(${id})'>
                    <i class="ion-ios-close-outline"></i>
                </button>
            </div>
        </div>
    </div>`;
    }

    //addExpenses
    function addExpense(id, description, value, percent) {
        return `<div class="item clearfix" id="${id}">
        <div class="item__description">${description}</div>
        <div class="right clearfix">
            <div class="item__value">- ${value}</div>
            <div class="item__percentage">${percent} %</div>
            <div class="item__delete">
                <button class="item__delete--btn" onclick="del(${id})"><i class="ion-ios-close-outline"></i></button>
            </div>
        </div>
    </div>`;

    }

    // totalSumIncome
    function budgetIncome() {
        const reducer = (previousValue, currentValue) => previousValue + currentValue;
        let sumbudgeIncomeValue = incomes.map(item => item.value).reduce(reducer);
        return sumbudgeIncomeValue;
    }

    // totalSumExpense 
    function budgetExpenses() {
        const reducer = (previousValue, currentValue) => previousValue + currentValue;
        let total = expenes.map(item => item.value).reduce(reducer);
        return total;
    }

    // sub between totalSumIncome and totalSumIncome
    function budgetValue() {
        let a = incomes.length !== 0 ? budgetIncome() : 0;
        let b = expenes.length !== 0 ? budgetExpenses() : 0;
        let totalBudgetValue = a - b;
        return totalBudgetValue;
    }

    // delIncome
    function render() {
        let element1 = "";
        let element2 = "";
        let toTalPercent = 0;
        for (income of incomes) {
            element1 += addIncome(income.id, income.description, income.value);
        }
        for (expene of expenes) {
            let percent = expene.value / budgetValue() * 100;
            toTalPercent += percent;
            element2 += addExpense(expene.id, expene.description, expene.value, percent.toFixed(2));
        }
        budgetPercentage.text(toTalPercent.toFixed(2));
        incomeList.html(element1);
        expensesList.html(element2);
        let sumbudgeIncomeValue = budgetIncome();
        budgetIncomeValue.text(sumbudgeIncomeValue);
        let sumBudgetExpensesValue = budgetExpenses();
        budgetExpensesValue.text(sumBudgetExpensesValue);
        let totalBudgetValue = budgetValue();
        budget__Value.text(totalBudgetValue);
    }

    addBtn.click(function() {
        if (addDescription.val() === "" || addValue.val() == "") {
            return;
        }
        if (addType.val() === 'inc') {
            income = {
                id: index++,
                description: addDescription.val(),
                value: parseFloat(addValue.val())
            };
            incomes.push(income);
            budgetIncome();
        } else if (addType.val() === 'exp') {
            expense = {
                id: index++,
                description: addDescription.val(),
                value: parseFloat(addValue.val()),
                percent: 1
            };
            expenes.push(expense);
            budgetExpenses();
        }
        render();
    })

    function renderGui() {
        budgetIncome();
        budgetExpenses();
        budgetValue();
        render();
    }
    renderGui();





})