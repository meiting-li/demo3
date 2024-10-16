function viewContact(button) {
    // 获取联系人所在的表格行
    var row = button.parentNode.parentNode;

    // 从行中获取姓名和电话信息
    var name = row.cells[1].innerHTML;
    var phone = row.cells[2].innerHTML;

    // 显示联系人信息
    alert("姓名: " + name + "\n联系电话: " + phone);
}
