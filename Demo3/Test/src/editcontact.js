function editContact(button) {
    // 获取联系人所在的表格行
    var row = button.parentNode.parentNode;

    // 从行中获取当前的姓名和电话
    var name = row.cells[1].innerHTML;
    var phone = row.cells[2].innerHTML;

    // 提示用户输入新的姓名和电话
    var newName = prompt("修改姓名:", name);
    var newPhone = prompt("修改联系电话:", phone);

    // 如果用户输入了新值，更新表格中的数据
    if (newName !== null && newName !== "") {
        row.cells[1].innerHTML = newName;
    }
    if (newPhone !== null && newPhone !== "") {
        row.cells[2].innerHTML = newPhone;
    }
}
