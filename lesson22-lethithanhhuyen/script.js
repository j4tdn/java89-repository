function convert(number){
	return number.replace(",", "");
}

function styleNumber(number){
	number = Math.round(number * 100) / 100;
	number = number.toFixed(2);
	number_string = "" + number;

	if (number_string.length > 6){
		pos = (number_string.length - 3) % 3;
		do {
			number_string = number_string.slice(0, pos) + "," + number_string.slice(pos);
			pos += 4;
		} while (number_string.length - 3 - pos + 1> 3);
	}

	return number_string;
}


let div_budget_value = document.querySelector(".budget__value");
let budget_value = + convert(div_budget_value.textContent.slice(2));

let div_budget_income = document.querySelector(".budget__income--value");
let budget_income = + convert(div_budget_income.textContent.slice(1));

let div_budget_expenses = document.querySelector(".budget__expenses--value");
let budget_expenses = + convert(div_budget_expenses.textContent.slice(1));

let div_budget_expenses_percentage = document.querySelector(".budget__expenses--percentage");
let budget_expenses_percentage = + div_budget_expenses_percentage.textContent.replace("%", "");

let income_list = document.querySelector(".income__list");

let incomes = income_list.getElementsByClassName("item clearfix");
for (let income of incomes){
	let btn = income.querySelector("button");
	btn.onclick = function(){
		removeIncomeItem(income);
	}
} 

function removeIncomeItem(income){
	let div_value = income.querySelector(".item__value");
	let value = + convert(div_value.textContent.slice(1));
	console.log(value);
	budget_value -= value;
	if (budget_value <= 0) {
		div_budget_value.textContent = styleNumber(budget_value);
	} else {
		div_budget_value.textContent = "+ " + styleNumber(budget_value);
	}
	budget_income -= value;
	div_budget_income.textContent = "+" + styleNumber(budget_income);
	updatePercentage();

	income_list.removeChild(income);
}

function addIncomeItem(description, value){
	
	let countIncomes = incomes.length;

	let div_wrapper = document.createElement("div");
	div_wrapper.className = "item clearfix";
	div_wrapper.id = `income-${countIncomes++}`;
	income_list.insertBefore(div_wrapper, incomes[0]);

	let div_description = document.createElement("div");
	div_description.className = "item__description";
	div_description.textContent = description;
	div_wrapper.appendChild(div_description);

	let div_right = document.createElement("div");
	div_right.className = "right clearfix";
	div_wrapper.appendChild(div_right);

	let div_value = document.createElement("div");
	div_value.className = "item__value";
	div_value.textContent = `+${value}`;
	div_right.appendChild(div_value);

	let div_delete = document.createElement("div");
	div_delete.className = "item__delete";
	div_right.appendChild(div_delete);

	let btn_delete = document.createElement("button");
	btn_delete.className = "item__delete--btn";
	div_delete.appendChild(btn_delete);
	let i_delete = document.createElement("i");
	i_delete.className = "ion-ios-close-outline";
	btn_delete.appendChild(i_delete);

	btn_delete.onclick = function(){
		removeIncomeItem(div_wrapper);
	}

	//change value on top part
	budget_value += value;
	if (budget_value <= 0) {
		div_budget_value.textContent = styleNumber(budget_value);
	} else {
		div_budget_value.textContent = "+ " + styleNumber(budget_value);
	}

	budget_income += value;
	div_budget_income.textContent = "+" + styleNumber(budget_income);
	updatePercentage();
}

let expenses_list = document.querySelector(".expenses__list");
let expenses = expenses_list.getElementsByClassName("item clearfix"); 

function updatePercentage(){
	budget_expenses_percentage = Math.round(budget_expenses / budget_income * 100);
	div_budget_expenses_percentage.textContent = budget_expenses_percentage + "%";

	for (let expense of expenses){
		let div_value = expense.querySelector(".item__value");
		let value = + convert(div_value.textContent.slice(1));

		let div_percentage = expense.querySelector(".item__percentage");
		let percentage = Math.round(value / budget_income * 100);
		console.log(percentage);
		div_percentage.textContent = percentage + "%";
	}
}


for (let expense of expenses){
	let btn = expense.querySelector("button");
	btn.onclick = function () {
		removeExpenseItem(expense);
	}
}

function removeExpenseItem(expense){
	let div_value = expense.querySelector(".item__value");
	let value = + convert(div_value.textContent.slice(1));
	console.log(value);
	budget_value += value;
	if (budget_value <= 0) {
		div_budget_value.textContent = styleNumber(budget_value);
	} else {
		div_budget_value.textContent = "+ " + styleNumber(budget_value);
	}
	budget_expenses -= value;
	div_budget_expenses.textContent = "-" + styleNumber(budget_expenses);

	let div_percentage = expense.querySelector(".item__percentage");
	let percentage = + div_percentage.textContent.replace("%", "");
	budget_expenses_percentage -= percentage;
	div_budget_expenses_percentage.textContent = budget_expenses_percentage + "%";

	expenses_list.removeChild(expense);
}

function addExpenseItem(description, value){
	let countExpenses = expenses.length;

	let div_wrapper = document.createElement("div");
	div_wrapper.className = "item clearfix";
	div_wrapper.id = `expense-${countExpenses++}`;
	expenses_list.insertBefore(div_wrapper, expenses[0]);

	let div_description = document.createElement("div");
	div_description.className = "item__description";
	div_description.textContent = description;
	console.log(div_description);
	div_wrapper.appendChild(div_description);

	let div_right = document.createElement("div");
	div_right.className = "right clearfix";
	div_wrapper.appendChild(div_right);

	let div_value = document.createElement("div");
	div_value.className = "item__value";
	div_value.textContent = `-${value}`;
	div_right.appendChild(div_value);

	let div_percentage = document.createElement("div");
	div_percentage.className = "item__percentage";
	let percentage = Math.round(value / budget_income * 100);
	div_percentage.textContent = `${percentage}%`;
	div_right.appendChild(div_percentage);

	let div_delete = document.createElement("div");
	div_delete.className = "item__delete";
	div_right.appendChild(div_delete);

	let btn_delete = document.createElement("button");
	btn_delete.className = "item__delete--btn";
	div_delete.appendChild(btn_delete);
	let i_delete = document.createElement("i");
	i_delete.className = "ion-ios-close-outline";
	btn_delete.appendChild(i_delete);

	btn_delete.onclick = function () {
		removeExpenseItem(div_wrapper);
	}

	//change value on top part
	budget_value -= value;
	if (budget_value <= 0) {
		div_budget_value.textContent = styleNumber(budget_value);
	} else {
		div_budget_value.textContent = "+ " + styleNumber(budget_value);
	}
	
	budget_expenses += value;
	div_budget_expenses.textContent = "-" + styleNumber(budget_expenses);

	budget_expenses_percentage += percentage;
	div_budget_expenses_percentage.textContent = `${budget_expenses_percentage}%`;

}

let btn = document.querySelector(".add__btn");
btn.onclick = function(){
	let add_type = document.querySelector(".add__type");
	let input_description = document.querySelector(".add__description");
	let description = input_description.value;
	let input_value = document.querySelector(".add__value");
	let value = +input_value.value;
	if (description !== "" && value !== NaN){
		if (add_type.value === "inc"){
			addIncomeItem(description, value);
		} else addExpenseItem(description, value);
	}
}