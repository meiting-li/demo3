import model.PersonalAddressBookClientController;
import view.Client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        PersonalAddressBookClientController controller = new PersonalAddressBookClientController(client);
        client.setController(controller);
        client.setVisible(true);
        controller.connectToDatabase("jdbc:mysql://localhost:3306/personalCall", "root", "123456");
        controller.refreshContactList();
    }
}
