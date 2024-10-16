package view;

import model.PersonalAddressBookClientController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame {
    private JTextField nameField;
    private JTextField phoneField;
    private JTextArea contactListArea;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton queryButton;
    private PersonalAddressBookClientController controller;

    public Client() {
        super("个人通讯录系统");

        // 创建界面组件
        nameField = new JTextField(50);
        phoneField = new JTextField(50);
        contactListArea = new JTextArea(20, 30);
        addButton = new JButton("添加");
        updateButton = new JButton("更新");
        deleteButton = new JButton("删除");
        queryButton = new JButton("查询");

        // 添加事件监听器
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.addContact(nameField.getText(), phoneField.getText());
                clearFields();
                refreshContactList();
                JOptionPane.showMessageDialog(Client.this, "添加成功!");
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.updateContact(nameField.getText(), phoneField.getText());
                clearFields();
                refreshContactList();
                JOptionPane.showMessageDialog(Client.this, "更新成功!");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.deleteContact(nameField.getText(), phoneField.getText());
                clearFields();
                refreshContactList();
                JOptionPane.showMessageDialog(Client.this, "删除成功!");
            }
        });

        queryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String queryResult =  controller.queryContact(nameField.getText());
                if (!queryResult.isEmpty()) {
                    contactListArea.setText(queryResult);
                } else {
                    JOptionPane.showMessageDialog(Client.this, "未找到相关联系人!");
                }
            }
        });

        // 构建用户界面
        JPanel inputPanel = new JPanel(new GridLayout(2, 2)); // 现在只需要4列
        inputPanel.add(new JLabel("姓名:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("电话:"));
        inputPanel.add(phoneField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(queryButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(contactListArea), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 设置窗口属性
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);

        // 设置字体大小
        setFontSize(16);
    }

    public void setController(PersonalAddressBookClientController controller) {
        this.controller = controller;
    }

    public void setContactList(String contactList) {
        contactListArea.setText(contactList);
    }

    public void clearFields() {
        nameField.setText("");
        phoneField.setText("");
    }

    public void refreshContactList() {
        controller.refreshContactList();
    }

    public void setFontSize(int size) {
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, size);
        nameField.setFont(font);
        phoneField.setFont(font);
        contactListArea.setFont(font);
    }
}
