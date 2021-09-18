const today = new Date();
let month = document.getElementById('month');
let budget = document.getElementById('budget');
let income = document.getElementById('income');
let expenses = document.getElementById('expenses');
let percentage = document.getElementById('percentage');
let select = document.getElementById('select');
let description = document.getElementById('description');
let number = document.getElementById('number');
let blockExpenses = document.getElementById('blockExpenses');
let blockIncome = document.getElementById('blockIncome');

let idIncome = 0;
let idExpenses = 0;
let sumIncome = 0;
let sumExpenses = 0;

function init() {
	month.textContent = today.toLocaleString('default', { month: 'long' });
	budget.textContent = 0;
	income.textContent = 0;
	expenses.textContent = 0;
	percentage.textContent = 0;
}

function addIncome(value, description) {
	if (value === '' || description === '') {
		alert('You should not leave the field blank');
	}

	blockIncome.innerHTML = `
    <div class="item clearfix" id="income-${idIncome}">
        <div class="item__description">${description}</div>
        <div class="right clearfix">
            <div class="item__value">+ ${value}</div>
            <div class="item__delete">
                <button class="item__delete--btn"  onclick={removeItem('income-${idIncome}')}>
                    <i class="ion-ios-close-outline"></i>
                </button>
            </div>
        </div>
    </div>`
    idIncome++;
    sumIncome  =  parseFloat(sumIncome) + parseFloat(value);
    update();
}

function addExpenses(value, description) {
	if (value === '' || description === '') {
		alert('You should not leave the field blank');
	}

	blockExpenses.innerHTML = `
        <div class="item clearfix" id="expense-${idExpenses}">
            <div class="item__description">${description}</div>
            <div class="right clearfix">
                <div class="item__value" id="itemNumberExppenses-${idExpenses}">- ${value}</div>
                <div class="item__percentage" id="itemPerExppenses-${idExpenses}">${0}%</div>
                <div class="item__delete">
                    <button class="item__delete--btn" onclick={removeItem('expense-${idExpenses}')}>
                        <i class="ion-ios-close-outline"></i>
                    </button>
                </div>
            </div>
        </div>`
    idExpenses++;
    sumExpenses  =  parseFloat(sumExpenses) + parseFloat(value);
    update();
}

function removeItem(id) {
    let itemRemove = document.getElementById(id);
    itemRemove.remove();
}

function summit() {
    let selectText = select.options[select.selectedIndex].value === 'inc'
    selectText ? addIncome(number.value,description.value) : addExpenses(number.value,description.value)
   
}

function update() {
	income.textContent = new Intl.NumberFormat().format(Number.parseFloat(sumIncome).toFixed(2));
    expenses.textContent = new Intl.NumberFormat().format(Number.parseFloat(sumExpenses).toFixed(2));
    budget.textContent = new Intl.NumberFormat().format(Number.parseFloat(sumIncome - sumExpenses).toFixed(2));
    let listExppenses = document.querySelector(".expenses__list").childElementCount;

    for (i = 1; i <= listExppenses; ++i) {
       let numberChildEx = document.getElementById(`itemNumberExppenses-${i-1}`);
       let percentChildEx = document.getElementById(`itemPerExppenses-${i-1}`);
       let exp = numberChildEx.textContent.replace('-','').trim();
       let rouding = new Intl.NumberFormat().format(Number.parseFloat((parseFloat(exp)/parseFloat(sumIncome))*100).toFixed(1));
       percentChildEx.textContent = rouding + "%"
      }

      percentage.textContent = new Intl.NumberFormat().format(Number.parseFloat((sumExpenses/sumIncome)*100).toFixed(2)) + "%";
}

init();