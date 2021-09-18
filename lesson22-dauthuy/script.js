$(document).ready(function () {
    let item = $('.item');
    let addButton = $('.add__btn');
    let addItems = $('.income__list');
    let subItem = $('.expenses__list');
    let txf = $('.add__description');

    let addValue = $('.add__value');

    let deleteBtn = $('.item__delete--btn');


    //Add element
    addButton.on('click', function () {
        // let txf = $('.add-field');
        let elemAdd = `<div class="item clearfix" id="income-0">
                        <div class="item__description">${txf.val()}</div>
                        <div class="right clearfix">
                            <div class="item__value">+ ${addValue.val()}</div>
                            <div class="item__delete">
                                <button class="item__delete--btn">
                                    <i class="ion-ios-close-outline"></i>
                                </button>
                            </div>
                        </div>
                    </div>`

        addItems.append(elemAdd);
        
        txf.val('');
    });


    function deleteIncomeItem(index) {
        addItems.splice(index, 1);
        renderIncomeList(incomeList);
    }
    
    function deleteExpenseItem(index) {
        subItem.splice(index, 1);
        renderExpenseList(expensesList);
    }
  
})