import java.io.*;
import java.util.*;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class ContactManagementSystem {

    private static final String CONTACTS_FILE = "contacts.txt";
    private static List<Contact> contacts = new ArrayList<>();

    public static void main(String args[]){
        loadContacts();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact(scanner);
                    break;
                case 4:
                    deleteContact(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
    private static void loadContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONTACTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    contacts.add(new Contact(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load contacts.");
        }
    }
    private static void saveContacts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CONTACTS_FILE))) {
            for (Contact contact : contacts) {
                writer.println(contact.getName() + "," + contact.getPhone() + "," + contact.getEmail());
            }
        } catch (IOException e) {
            System.out.println("Could not save contacts.");
        }
    }
    private static void addContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, phone, email));
        saveContacts();
        System.out.println("Contact added.");
    }
    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\nContact List:");
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.printf("%d. %s - %s - %s%n", i + 1, contact.getName(), contact.getPhone(), contact.getEmail());
            }
        }
    }
    private static void editContact(Scanner scanner) {
        viewContacts();
        if (!contacts.isEmpty()) {
            System.out.print("\nEnter the number of the contact you want to edit: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume the newline character
            if (index >= 0 && index < contacts.size()) {
                Contact contact = contacts.get(index);
                System.out.print("Enter new name (leave blank to keep '" + contact.getName() + "'): ");
                String name = scanner.nextLine();
                System.out.print("Enter new phone (leave blank to keep '" + contact.getPhone() + "'): ");
                String phone = scanner.nextLine();
                System.out.print("Enter new email (leave blank to keep '" + contact.getEmail() + "'): ");
                String email = scanner.nextLine();

                if (!name.isEmpty()) contact.setName(name);
                if (!phone.isEmpty()) contact.setPhone(phone);
                if (!email.isEmpty()) contact.setEmail(email);

                saveContacts();
                System.out.println("Contact updated.");
            } else {
                System.out.println("Invalid contact number.");
            }
        }
    }
    private static void deleteContact(Scanner scanner) {
        viewContacts();
        if (!contacts.isEmpty()) {
            System.out.print("\nEnter the number of the contact you want to delete: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume the newline character
            if (index >= 0 && index < contacts.size()) {
                Contact removed = contacts.remove(index);
                saveContacts();
                System.out.println("Deleted contact for " + removed.getName() + ".");
            } else {
                System.out.println("Invalid contact number.");
            }
        }
    }
    
}
