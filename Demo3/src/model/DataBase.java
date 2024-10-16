package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private Connection connection;

    public DataBase() {
        connection = null;
    }

    public void connectToDatabase(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addContact(String name, String phone) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO contacts (name, phone) VALUES (?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, phone);
            statement.executeUpdate();
            System.out.println("Contact added: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateContact(String name, String phone) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE contacts SET phone = ? WHERE name = ?")) {
            statement.setString(1, phone);
            statement.setString(2, name);
            statement.executeUpdate();
            System.out.println("Contact updated: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(String name, String phone) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM contacts WHERE name = ? AND phone = ?")) {
            statement.setString(1, name);
            statement.setString(2, phone);
            statement.executeUpdate();
            System.out.println("Contact deleted: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String queryContact(String name) {
        String contactInfo = "";
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM contacts WHERE name = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                contactInfo = name + "\t" + address + "\t" + phone;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactInfo;
    }

    public List<String> getContactList() {
        List<String> contacts = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM contacts";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                contacts.add(name + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Disconnected from database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
