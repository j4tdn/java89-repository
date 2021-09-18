const monthNames = ["January", "February", "March", "April", "May", "June",
  "July", "August", "September", "October", "November", "December"
];


let month = document.getElementById('month');
let budget = document.getElementById('budget');
let income =  document.getElementById('income');
let expenses =  document.getElementById('expenses');
let select = document.getElementById('select');
let description = document.getElementById('description');
let number = document.getElementById('number');
let percentage = document.getElementById('percentage');


let blockExpenses = document.getElementById('blockExpenses')
let blockIncome = document.getElementById('blockIncome')

let idIncome = 0;
let idExpenses = 0;
let sumIncome = 0;
let sumExpenses = 0;

function init () {
    month.textContent = monthNames[new Date().getMonth()-1];
    budget.textContent = 0; 
    income.textContent = 0; 
    expenses.textContent = 0; 
}

function addIncome(money, des) {
    let numberIncome = new Intl.NumberFormat().format(Number.parseFloat(money).toFixed(2));
    let doc = `
    <div class="item clearfix" id="income-${idIncome}">
        <div class="item__description">${des}</div>
        <div class="right clearfix">
            <div class="item__value">+ ${numberIncome}</div>
            <div class="item__delete">
                <button class="item__delete--btn"  onclick={removeItem('income-${idIncome}')}>
                    <i class="ion-ios-close-outline"></i>
                </button>
            </div>
        </div>
    </div>`
    blockIncome.insertAdjacentHTML( 'beforeend', doc );
    idIncome++;
    sumIncome  =  parseFloat(sumIncome) + parseFloat(money);
    updateSum();
}

function addExpenses(money, des) {
    let a = Number.parseFloat(money).toFixed(2);
    let b = Number.parseFloat(budget.textContent).toFixed(2);
    if(a <= b) {
        let numberExpenses = new Intl.NumberFormat().format(Number.parseFloat(money).toFixed(2));
        sumExpenses =  parseFloat(sumExpenses) + parseFloat(money);
        let doc = `
        <div class="item clearfix" id="expense-${idExpenses}">
            <div class="item__description">${des}</div>
            <div class="right clearfix">
                <div class="item__value" id="itemNumberExppenses-${idExpenses}">- ${numberExpenses}</div>
                <div class="item__percentage" id="itemPerExppenses-${idExpenses}">${0}%</div>
                <div class="item__delete">
                    <button class="item__delete--btn" onclick={removeItem('expense-${idExpenses}')}>
                        <i class="ion-ios-close-outline"></i>
                    </button>
                </div>
            </div>
        </div>`

        blockExpenses.insertAdjacentHTML( 'beforeend', doc );
        idExpenses++;
        updateSum();
    }

}

function updateSum() {
    income.textContent = new Intl.NumberFormat().format(Number.parseFloat(sumIncome).toFixed(2));
    expenses.textContent = new Intl.NumberFormat().format(Number.parseFloat(sumExpenses).toFixed(2));
    budget.textContent = new Intl.NumberFormat().format(Number.parseFloat(sumIncome - sumExpenses).toFixed(2));
    //percen
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

function removeItem(id) {
    let itemRemove = document.getElementById(id);
    itemRemove.remove();
}

function summit() {
    let selectText = select.options[select.selectedIndex].value === 'inc'
    selectText ? addIncome(number.value,description.value) : addExpenses(number.value,description.value)
   
}

init();