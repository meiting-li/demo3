package controller;

import model.DataBase;
import view.Client;

public class PersonalAddressBookClientController {
    private Client client;
    private DataBase server;

    public PersonalAddressBookClientController(Client client) {
        this.client = client;
        server = new DataBase();
    }

    public void connectToDatabase(String url, String username, String password) {
        server.connectToDatabase(url, username, password);
    }

    public void addContact(String name, String phone) {
        server.addContact(name, phone);  // 现在只传递name和phone
    }

    public void updateContact(String name, String phone) {
        server.updateContact(name, phone);  // 现在只传递name和phone
    }

    public void deleteContact(String name, String phone) {
        server.deleteContact(name, phone);  // 现在只传递name和phone
    }

    public String queryContact(String name) {
        return server.queryContact(name);
    }

    public void refreshContactList() {
        client.setContactList(server.getContactList().toString());
    }

    public void closeConnection() {
        server.closeConnection();
    }
}
