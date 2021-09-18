
var items = [
    {
        name : "Salary",
        value : 2100
    },
    {
        name : "Sold car",
        value : 1500
    },
    {
        name : "Apartment rent",
        value : -900
    },
    {
        name : "Grocery shopping",
        value : -435
    }
    
];
const $  = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);
const addBtn = $('.add__btn');
const addDesInput = $('.add__description');
const addValueInput = $('.add__value');
const incomeList = $('.income__list');
const expensesList = $('.expenses__list');
const addType = $('.add__type');

addBtn.onclick = () => {
    if((addDesInput.value != '') && addValueInput.value != '') {
        value = parseInt(addValueInput.value, 10);
        if(addType.value === 'inc') {
            items.push({name : addDesInput.value, value : value});
        } else {
            items.push({name : addDesInput.value, value : (-1) * value});
        }
        loadData();
    }
}

loadData();

function loadData() {
    loadExpensesList();
    loadIncomeList();

    // Add Events
    const deleteBtns = $$('.item__delete--btn');
    deleteBtns.forEach((btn) => {
        btn.onclick = () => {
            let id = btn.id.match(/\d+/g)[0];
            removeItem(id);
        }
    })
}

function removeItem(index) {
    items.splice(index, 1);
    loadData();
}

function loadExpensesList() {
    let html = items.map((item, index) => {
        return {name: item.name, value: item.value, id : index};
    })
    html = html.filter((item) => (item.value < 0));
    html = html.map((item, index) => {
        return `<div class="item clearfix" id="expense-${index}">
                    <div class="item__description">${item.name}</div>
                    <div class="right clearfix">
                        <div class="item__value">${item.value}.00</div>
                        <div class="item__percentage">${calPercentExpenses(item.value)}%</div>
                        <div class="item__delete">
                            <button id="item-${item.id}" class="item__delete--btn"><i class="ion-ios-close-outline"></i></button>
                        </div>
                    </div>
                </div>`;
    })
    html = html.join('');
    expensesList.innerHTML = html;
}

function calPercentExpenses(value) {
    let income = items.reduce((initVal, item) => {
        if(item.value > 0) {
            return initVal + item.value;
        }
        return initVal;
    }, 0);
    return Math.round(value*(-100)/income);
}

function loadIncomeList() {
    let html = items.map((item, index) => {
        return {name: item.name, value: item.value, id : index};
    });
    html = html.filter((item) => (item.value > 0));
    html = html.map((item, index) => {
        return `<div class="item clearfix" id="income-${index}">
                    <div class="item__description">+${item.name}</div>
                    <div class="right clearfix">
                        <div class="item__value">+${item.value}.00</div>
                        <div class="item__delete">
                            <button id="item-${item.id}" class="item__delete--btn">
                                <i class="ion-ios-close-outline"></i>
                            </button>
                        </div>
                    </div>
                </div>`;
    });
    html = html.join('');
    incomeList.innerHTML = html;
}

