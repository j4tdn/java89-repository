var items=[];
var date = new Date()
$('#date').text(`${date.toLocaleString('default', { month: 'long' })}  ${date.getFullYear()}`)

$("#addBtn").click(() => {
  let item = {};
  let addMathType = $("#type").val();
  console.log(addMathType);
  let taskName = $("#task_name").val();
  let addValue = $("#value").val();
  if (taskName === "" || addValue === "") {
      return;
  }
  if(addMathType==="inc"){
    item.item = taskName;
    item.value = parseInt(+ + addValue);
    items.push(item);
    render();
  }
  if(addMathType==="exp"){
    item.item = taskName;
    item.value = parseInt(- + addValue);
    items.push(item);
    render();
  }
});


function showIncome() {
  let income = "";
  items.forEach((item, index) => {
      if (item.value > 0) {
          income += `<div class="item clearfix">
                      <div class="item__description">${item.item}</div>
                      <div class="right clearfix">
                          <div class="item__value">+${item.value}</div>
                          <div class="item__delete">
                              <button class="item__delete--btn" onclick="deleteItem(${index})">
                                      <i class="ion-ios-close-outline"></i>
                              </button>
                          </div>
                      </div>
                  </div>`
      }
  });
  $('#incomeList').html(income);
};
function showExpense() {
  let expenses = "";
  items.forEach((item, index) => {
      if (item.value < 0) {
          expenses += `<div class="item clearfix">
                          <div class="item__description">${item.item}</div>
                          <div class="right clearfix">
                              <div class="item__value">${item.value}</div>
                              <div class="item__delete">
                                  <button class="item__delete--btn" onclick="deleteItem(${index})"><i class="ion-ios-close-outline"></i></button>
                              </div>
                          </div>
                      </div>`
      }
  });

  $('#expensesList').html(expenses);
};


function showTotalMoney() {
  let sumIncome = items.filter(item => item.value > 0).reduce((currentValue, item) => currentValue + item.value, 0);
  let sumExpense = items.filter(item => item.value < 0).reduce((currentValue, item) => currentValue + item.value, 0);
  $(".budget__income--value").html(sumIncome);
  $(".budget__expenses--value").html(sumExpense);
  console.log(sumIncome - sumExpense);
  $(".budget__value").html(sumIncome + sumExpense);
};


function deleteItem(index) {
  items.splice(index, 1);
  render();
};

function render() {
  showIncome();
  showExpense();
  showTotalMoney();
}