let inputDescription = document.getElementById("input-description");
let inputValue = document.getElementById("input-value");
let budgetTypeOpt = document.getElementById("budget-change-type");
let btnAdd = document.getElementById("btn-add");
let incomeBox = document.getElementById("income-list");

const budgetTypes = {
    inc: {
        value: "inc",
        containerId: "income-list",
        totalValueId: "income-total-value",
        childrenIdPrefix: "income-",
        sign: "+",
        budgetData: [
            {
                id: 0,
                description: "Salary",
                value: 2100
            },
            {
                id: 1,
                description: "Sold car",
                value: 1500
            },
        ]        
    },
    exp: {
        value: "exp",
        containerId: "expenses-list",
        totalValueId: "expenses-total-value",
        childrenIdPrefix: "expense-",
        sign: "-",
        budgetData: [
            {
                id: 0,
                description: "Apartment rent",
                value: 900
            },
            {
                id: 1,
                description: "Grocery shopping",
                value: 435.28,
            },
        ]
    },
}

migrateData(budgetTypes.inc.value);
migrateData(budgetTypes.exp.value);
updateTotalBudget();

function migrateData(budgetType) {
    budgetTypes[budgetType].budgetData.forEach((budget) => {
        addNewBudgetDiv(budget, budgetType);
    })
}

function addNewBudgetDiv(budget, budgetType) {
    const budgetListContainer = document.getElementById(budgetTypes[budgetType].containerId);
    const id = budgetTypes[budgetType].childrenIdPrefix + budget.id;
    const childElement = document.createElement('div');
    childElement.setAttribute("id", id);
    childElement.classList.add("item", "clearfix");
    
    let percentageElementString = '';
    if (budgetType === budgetTypes.exp.value){
        let percentageElement = document.createElement('div');
        percentageElement.classList.add("item__percentage");
        percentageElement.innerHTML = Math.round(budget.value * 100 / calculateTotalValue(budgetTypes.inc.value)) + "%";
        percentageElementString = percentageElement.outerHTML;
    }

    childElement.innerHTML = 
    `
        <div class="item__description">${budget.description}</div>
        <div class="right clearfix">
            <div class="item__value">${budgetTypes[budgetType].sign} ${formatValue(budget.value)}</div>
            ${percentageElementString}
            <div class="item__delete">
                <button class="item__delete--btn" onclick="deleteBudget('${budgetType}', '${id}')">
                    <i class="ion-ios-close-outline"></i>
                </button>
            </div>
        </div>
    `;
    budgetListContainer.prepend(childElement);
}

function calculateTotalValue(budgetType) {
    let result = budgetTypes[budgetType].budgetData.reduce((total, element) => total += element.value, 0);
    return result;
}

function updateTotalBudget() {
    let totalIncomeValue = calculateTotalValue(budgetTypes.inc.value);
    totalIncomeValue = Math.round(totalIncomeValue * 100) / 100;
    let totalExpensesValue = calculateTotalValue(budgetTypes.exp.value);
    totalExpensesValue = Math.round(totalExpensesValue * 100) / 100;

    document.getElementById(budgetTypes.inc.totalValueId).innerHTML = 
        `${budgetTypes.inc.sign} ${formatValue(totalIncomeValue)}`;
    document.getElementById(budgetTypes.exp.totalValueId).innerHTML = 
        `${budgetTypes.exp.sign} ${formatValue(totalExpensesValue)}`;

    let percent = Math.round(totalExpensesValue * 100 / totalIncomeValue);
    document.getElementById("expenses-total-percent").innerHTML = `${percent}%`;

    let totalValue = formatValue(totalIncomeValue - totalExpensesValue);
    document.getElementById("total-value").innerHTML = `${totalValue}`;
}

btnAdd.addEventListener("click", function(){
    let description = inputDescription.value;
    let value = parseInt(inputValue.value);
    let budgetType = budgetTypeOpt.value;

    const budgetData = budgetTypes[budgetType].budgetData;
    const id = budgetData.length === 0 ? 0 : (budgetData[budgetData.length - 1].id + 1);


    addNewBudgetDiv({id, description, value}, budgetType);
    budgetTypes[budgetType].budgetData.push({
        id,
        description,
        value
    });
    updateTotalBudget();
});

function formatValue(value) {
    return (value).toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');
}

function deleteBudget(budgetType, budgetId) {
    document.getElementById(budgetId).remove();
    let id = budgetId.replace(budgetTypes[budgetType].childrenIdPrefix, "");
    budgetData = budgetTypes[budgetType].budgetData;
    budgetTypes[budgetType].budgetData = budgetData.filter(el => el.id != id);
    updateTotalBudget();

    if(budgetType === budgetTypes.inc.value) {
        document.getElementById(budgetTypes.exp.containerId).innerHTML = "";
        migrateData(budgetTypes.exp.value);
    }
}