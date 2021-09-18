let data = [];
let itemId = 0;
let income = 0;
let expenses = 0;
const type = document.getElementById('type');
const description = document.getElementById('description');
const value = document.getElementById('value');
const incomeList = document.getElementById("income_list");
const expensesList = document.getElementById("expenses_list");

document.getElementById('month').innerHTML = new Date().toLocaleString('default', { month: 'long', year: 'numeric' });

document.getElementById('add_btn').onclick = () => {
    if (description.value === "" || value.value === "") {
        return;
    }
    const item = {
        id: itemId++,
        type: type.value,
        description: description.value,
        value: Number(value.value).toFixed(2)
    };
    data.push(item);
    renderData();
    clearInput();
}

const renderData = () => {
    income = data.filter(item => item.type === "inc").reduce((prev, curr) => prev + Number(curr.value), 0);
    expenses = data.filter(item => item.type === "exp").reduce((prev, curr) => prev + Number(curr.value), 0);
    document.getElementById('budget_value').innerHTML = income - expenses >= 0 ? `+ ${numberWithCommas((income - expenses).toFixed(2))}`: `- ${numberWithCommas((expenses - income).toFixed(2))}`;
    document.getElementById('income').innerHTML = `+ ${numberWithCommas(income.toFixed(2))}`;
    document.getElementById('expenses').innerHTML = `- ${numberWithCommas(expenses.toFixed(2))}`;
    document.getElementById('expenses_percentage').innerHTML = income !== 0 ? `${(expenses / income * 100).toFixed(2)}%` : '...%';

    incomeList.innerHTML = '';
    expensesList.innerHTML = '';
    data.forEach(item => {
        item.type === "inc" ? incomeList.innerHTML += renderItem(item) : expensesList.innerHTML += renderItem(item);
    });
}

const renderItem = (item) => {
    return `
        <div class="item clearfix" id="${item.id}">
            <div class="item__description">${item.description}</div>
            <div class="right clearfix">
                <div class="item__value">${item.type === 'inc' ? '+' : '-'} ${numberWithCommas(item.value)}</div>
                <div class="item__percentage" style="display: ${item.type === 'inc' ? 'none' : 'block'}">${income !== 0 ? (item.value / income * 100).toFixed(2) : '...'}%</div>
                <div class="item__delete">
                    <button class="item__delete--btn" onclick="deleteItem(${item.id})">
                        <i class="ion-ios-close-outline"></i>
                    </button>
                </div>
            </div>
        </div>
    `
}

const deleteItem = (id) => {
    data = data.filter(item => item.id !== id);
    renderData();
}

const clearInput = () => {
    description.value = '';
    value.value = '';
}

const numberWithCommas = (number) => {
    return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}