import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of Accounts you want to create:");
        int numAccounts = Integer.parseInt(reader.readLine());

        Account[] accounts = new Account[numAccounts];

        for (int i = 0; i < numAccounts; i++) {
            System.out.println("\nEnter details for Account " + (i + 1) + ":");

            System.out.print("ID: ");
            String id = reader.readLine();

            System.out.print("Name: ");
            String name = reader.readLine();

            System.out.print("Initial Balance (optional, press Enter for 0): ");
            String balanceStr = reader.readLine();
            int balance = balanceStr.isEmpty() ? 0 : Integer.parseInt(balanceStr);

            accounts[i] = new Account(id, name, balance);
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n\nMenu:");
            System.out.println("1. View Account Details");
            System.out.println("2. Credit Account");
            System.out.println("3. Debit Account");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    viewAccounts(accounts);
                    break;
                case 2:
                    creditAccount(accounts, reader);
                    break;
                case 3:
                    debitAccount(accounts, reader);
                    break;
                case 4:
                    transferFunds(accounts, reader);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        reader.close();
    }

    public static void viewAccounts(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("\nAccount " + (i + 1) + " details:");
            System.out.println(accounts[i]);
        }
    }
    public static void creditAccount(Account[] accounts, BufferedReader reader) throws IOException {
        System.out.print("Enter the account number (1-" + accounts.length + "): ");
        int accountIndex = Integer.parseInt(reader.readLine()) - 1;
    
        if (accountIndex < 0 || accountIndex >= accounts.length) {
            System.out.println("Invalid account number.");
            return;
        }
    
        System.out.print("Enter the amount to credit: ");
        int amount = Integer.parseInt(reader.readLine());
    
        accounts[accountIndex].credit(amount);
        System.out.println("Credited $" + amount + " to Account " + (accountIndex + 1));
    }
    
    public static void debitAccount(Account[] accounts, BufferedReader reader) throws IOException {
        System.out.print("Enter the account number (1-" + accounts.length + "): ");
        int accountIndex = Integer.parseInt(reader.readLine()) - 1;
    
        if (accountIndex < 0 || accountIndex >= accounts.length) {
            System.out.println("Invalid account number.");
            return;
        }
    
        System.out.print("Enter the amount to debit: ");
        int amount = Integer.parseInt(reader.readLine());
    
        accounts[accountIndex].debit(amount);
        System.out.println("Debited $" + amount + " from Account " + (accountIndex + 1));
    }
    
    public static void transferFunds(Account[] accounts, BufferedReader reader) throws IOException {
        System.out.print("Enter the account number to debit (1-" + accounts.length + "): ");
        int fromIndex = Integer.parseInt(reader.readLine()) - 1;
    
        if (fromIndex < 0 || fromIndex >= accounts.length) {
            System.out.println("Invalid account number.");
            return;
        }
    
        System.out.print("Enter the account number to credit (1-" + accounts.length + "): ");
        int toIndex = Integer.parseInt(reader.readLine()) - 1;
    
        if (toIndex < 0 || toIndex >= accounts.length) {
            System.out.println("Invalid account number.");
            return;
        }
    
        System.out.print("Enter the amount to transfer: ");
        int amount = Integer.parseInt(reader.readLine());
    
        accounts[fromIndex].transferTo(accounts[toIndex], amount);
        System.out.println("Transferred $" + amount + " from Account " + (fromIndex + 1) + " to Account " + (toIndex + 1));
    }
        
}