const month = document.getElementById("month");

month.innerHTML = new Date().toLocaleString("default", { month: "long" });

const availableBudget = document.getElementById("budget");
const totalIncome = document.getElementById("income");
const totalExpense = document.getElementById("expenses");
const percentExpense = document.getElementById("expenses-percent");

const INCOME_TYPE = "inc";
const EXPENSE_TYPE = "exp";

let incomeItems = [];
let expenseItems = [];

let numberOfIncome = 0;
let numberOfExpenses = 0;

let budget = 0;
let currentIncome = 0;

const addNewItem = () => {
  const itemType = document.getElementById("item-type").value;

  const name = document.getElementById("item-name").value;
  const value = document.getElementById("item-value").value;

  if (itemType === INCOME_TYPE) {
    const newItem = {
      id: numberOfIncome++,
      name,
      value: Number(value).toFixed(2),
    };

    incomeItems.push(newItem);
  } else {
    const newItem = {
      id: numberOfExpenses++,
      name,
      value: Number(value).toFixed(2),
    };

    expenseItems.push(newItem);
  }

  renderData();
};

const renderData = () => {
  renderGeneralData();
  renderListIncome();
  renderListExpense();
};

const renderGeneralData = () => {
  const income = Number(
    incomeItems.reduce((a, b) => a + Number(b.value), 0)
  ).toFixed(2);
  totalIncome.innerHTML = income;
  currentIncome = income;

  const expense = Number(
    expenseItems.reduce((a, b) => a + Number(b.value), 0)
  ).toFixed(2);
  totalExpense.innerHTML = expense;

  budget = Number(income) - Number(expense);
  availableBudget.innerHTML = Number(budget).toFixed(2);
  percentExpense.innerHTML = Number((expense * 100) / income).toFixed(2);
};

const renderListIncome = () => {
  let listIncomeHtml = "";

  incomeItems.forEach(
    (x) =>
      (listIncomeHtml = listIncomeHtml.concat(`
    <div class="item clearfix" id="income-${x.id}">
      <div class="item__description">${x.name}</div>
      <div class="right clearfix">
        <div class="item__value">+ ${x.value}</div>
        <div class="item__delete">
            <button class="item__delete--btn">
                <i class="ion-ios-close-outline" onclick="removeElementById(${x.id}, '${INCOME_TYPE}')"></i>
            </button>
        </div>
     </div>
    </div>`))
  );

  document.getElementById("list-income").innerHTML = listIncomeHtml;
};

const renderListExpense = () => {
  let listExpenseHtml = "";

  const income = totalIncome.innerHTML;

  expenseItems.forEach(
    (x) =>
      (listExpenseHtml = listExpenseHtml.concat(`
    <div class="item clearfix" id="expense-${x.id}">
      <div class="item__description">${x.name}</div>
      <div class="right clearfix">
        <div class="item__value">- ${x.value}</div>
        <div class="item__percentage">${Number(
          (x.value * 100) / income
        ).toFixed(2)}%</div>
        <div class="item__delete">
            <button class="item__delete--btn"><i class="ion-ios-close-outline" onclick="removeElementById(${
              x.id
            }, '${EXPENSE_TYPE}')"></i></button>
        </div>
    </div>
    </div>`))
  );

  document.getElementById("list-expenses").innerHTML = listExpenseHtml;
};

const removeElementById = (id, type) => {
  if (type === INCOME_TYPE) {
    incomeItems = incomeItems.filter((x) => x.id !== id);
  } else {
    expenseItems = expenseItems.filter((x) => x.id !== id);
  }

  renderData();
};
