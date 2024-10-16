function deleteContact(button) {
    // 获取当前联系人所在的表格行
    var row = button.parentNode.parentNode;

    // 从表格中删除该行
    row.parentNode.removeChild(row);
}
