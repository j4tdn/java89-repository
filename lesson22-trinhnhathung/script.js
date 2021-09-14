const tasks = [
    {
        task: "Salary",
        value: 21000
    },
    {
        task: "Sold car",
        value: 15000
    },
    {
        task: "Apartment rent",
        value: -900
    },
    {
        task: "Grocery shopping",
        value: -435
    }
];

function deleteItem(index) {
    tasks.splice(index, 1);
    renderUI();
};

function renderIncome() {
    let incomes = "";
    tasks.forEach((task, index) => {
        if (task.value > 0) {
            incomes += `<div class="item clearfix">
                        <div class="item__description">${task.task}</div>
                        <div class="right clearfix">
                            <div class="item__value">+ ${task.value}</div>
                            <div class="item__delete">
                                <button class="item__delete--btn" onclick="deleteItem(${index})">
                                        <i class="ion-ios-close-outline"></i>
                                </button>
                            </div>
                        </div>
                    </div>`
        }
    });

    $('#incomes').html(incomes);
};

function percentExpenses(value) {
    let sum = tasks.filter(task => task.value > 0).reduce((currentValue, task) => currentValue + task.value, 0);
    let percent = Math.abs(value) / sum;
    percent = Math.round(percent * 100);
    return percent;
};

function renderExpense() {
    let expenses = "";
    tasks.forEach((task, index) => {
        if (task.value < 0) {
            expenses += `<div class="item clearfix">
                            <div class="item__description">${task.task}</div>
                            <div class="right clearfix">
                                <div class="item__value">${task.value}</div>
                                <div class="item__percentage">${percentExpenses(task.value)}%</div>
                                <div class="item__delete">
                                    <button class="item__delete--btn" onclick="deleteItem(${index})"><i class="ion-ios-close-outline"></i></button>
                                </div>
                            </div>
                        </div>`
        }
    });

    $('#expenses').html(expenses);
};

function renderTotalMoney() {
    let sumIncome = tasks.filter(task => task.value > 0).reduce((currentValue, task) => currentValue + task.value, 0);
    let sumExpense = tasks.filter(task => task.value < 0).reduce((currentValue, task) => currentValue + task.value, 0);
    console.log(sumIncome);
    $(".budget__income--value").html(sumIncome);
    $(".budget__expenses--value").html(sumExpense);
    $(".budget__value").html(sumIncome - sumExpense);
    let percent = Math.abs(sumExpense) / sumIncome;
    percent = Math.round(percent * 100);
    $(".budget__expenses--percentage").html(percent + "%");
};

function renderUI() {
    renderExpense();
    renderIncome();
    renderTotalMoney();
}

renderUI();

$("#add__btn").click(() => {
    let task = {};
    let description = $("#add__description").val();
    let addType = $("#add__type").val();
    let addValue = $("#add__value").val();
    if (description === "" || addValue === "") {
        return;
    }

    task.task = description;
    task.value = parseInt(addType + addValue);
    tasks.push(task);
    renderUI();
    $("#add__description").val("");
    $("#add__value").val("");
});