/**  Your code  */
var months = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
];
var INC_TYPE = "inc";
var EXP_TYPE = "exp";
var numberFormat = new Intl.NumberFormat("en-IN");

var currentMonthEle = document.querySelector("#current-month");
var budgetValueEle = document.querySelector("#budget-value");
var incomeValueEle = document.querySelector("#income-value");
var expensesValueEle = document.querySelector("#expenses-value");
var expensesPercentEle = document.querySelector("#expenses-percentage-value");

var addTypeEle = document.querySelector("#add-type");
var addDescriptionEle = document.querySelector("#add-description");
var addValueEle = document.querySelector("#add-value");
var incomeListHtml = document.querySelector("#incomeListHtml");
var expensesListHtml = document.querySelector("#expensesListHtml");

var incomeList = [
    { des: "Salary", value: 2100.32 },
    { des: "Sold car", value: 1500 },
];
var expensesList = [
    { des: "Apartment rent", value: 900 },
    { des: "Grocery shopping", value: 435.28 },
];

window.onload = function() {
    var date = new Date();
    currentMonthEle.innerHTML =
        months[date.getMonth()] + " " + date.getFullYear();

    renderIncomeList(incomeList);
    renderExpenseList(expensesList);

    setConclusionValue(incomeList, expensesList);
};

function updateBudget() {
    let des = addDescriptionEle.value;
    let value = +addValueEle.value;

    if (addTypeEle.value === INC_TYPE) {
        incomeList.push({ des: des, value: value });
        renderIncomeList(incomeList);
    } else if (addTypeEle.value === EXP_TYPE) {
        expensesList.push({ des: des, value: value });
        renderExpenseList(expensesList);
    }
}

function setConclusionValue(income, expenses) {
    let incomeValue = sum(income);
    let expensesValue = sum(expenses);

    budgetValueEle.innerHTML =
        `${incomeValue >= expensesValue ? "+" : "-"} ${numberFormat.format(Math.abs(incomeValue - expensesValue).toFixed(2))}`;
    incomeValueEle.innerHTML = `+ ${numberFormat.format(incomeValue.toFixed(2))}`;
    expensesValueEle.innerHTML = `- ${numberFormat.format(expensesValue.toFixed(2))}`;
    expensesPercentEle.innerHTML =
        Math.round((expensesValue * 100) / incomeValue) + "%";
}

function renderIncomeList(income) {
    const html = income
        .map(
            (item) =>
            `
      <div class="item clearfix">
        <div class="item__description">${item.des}</div>
        <div class="right clearfix">
          <div class="item__value">+ ${(item.value).toFixed(2)}</div>
          <div class="item__delete">
            <button class="item__delete--btn">
              <i class="ion-ios-close-outline"></i>
            </button>
          </div>
        </div>
      </div>
      `
        )
        .join("");
    incomeListHtml.innerHTML = html;

    let deleteIncomeItemBtn = incomeListHtml.querySelectorAll('.item__delete--btn');
    console.dir(deleteIncomeItemBtn);
    for (let i = 0; i < deleteIncomeItemBtn.length; i++) {
        deleteIncomeItemBtn[i].addEventListener('click', () => {
            deleteIncomeItem(i);
        })
    }

    setConclusionValue(incomeList, expensesList);
}

function renderExpenseList(expenses) {
    let incomeValue = sum(incomeList);
    const html = expenses
        .map(
            (item) =>
            `
      <div class="item clearfix">
        <div class="item__description">${item.des}</div>
        <div class="right clearfix">
          <div class="item__value">- ${(item.value).toFixed(2)}</div>
          <div class="item__percentage">${Math.round((item.value * 100) / incomeValue)}%</div>
          <div class="item__delete">
            <button class="item__delete--btn">
              <i class="ion-ios-close-outline"></i>
            </button>
          </div>
        </div>
      </div>
    `
        )
        .join("");
    expensesListHtml.innerHTML = html;

    let deleteExpenseItemBtn = expensesListHtml.querySelectorAll('.item__delete--btn');
    console.dir(deleteExpenseItemBtn);
    for (let i = 0; i < deleteExpenseItemBtn.length; i++) {
        deleteExpenseItemBtn[i].addEventListener('click', () => {
            deleteExpenseItem(i);
        })
    }

    setConclusionValue(incomeList, expensesList);
}

function deleteIncomeItem(index) {
    console.log('deleteIncomeItem');
    incomeList.splice(index, 1);
    renderIncomeList(incomeList);
}

function deleteExpenseItem(index) {
    console.log('deleteExpenseItem');
    expensesList.splice(index, 1);
    renderExpenseList(expensesList);
}

function sum(list) {
    let sum = 0;
    list.forEach((item) => (sum += item.value));
    return sum;
}