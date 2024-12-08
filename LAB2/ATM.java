package LAB2;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM implements ATMAction {

    private ArrayList<Account> account;

    public static void main(String[] args) {

        ATM atm = new ATM();
        atm.account = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currently, the system does not have an admin account. Please add an admin account.");
        System.out.print("ID : ");
        String A_id = scanner.nextLine();
        System.out.print("NAME : ");
        String A_name = scanner.nextLine();
        System.out.print("GENDER : ");
        String A_gender = scanner.nextLine();
        System.out.print("USERNAME : ");
        String A_username = scanner.nextLine();
        System.out.print("PASSWORD : ");
        String A_password = scanner.nextLine();

        Manager m = new Manager(A_id, A_name, A_gender, A_username, A_password);

        if (m.isMnIsTrue() == true) {
            System.out.println("----------------------------------------------");
            System.out.println("ATM Computer Thanyaburi Bank");
            System.out.println("Login Manager Mode");
            System.out.print("Enter Account Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            if (m.getUsername().equals(username)) {
                if (m.getPassword().equals(password)) {
                    System.out.print("Enter amount of all account = ");
                    int numberOf_Account = scanner.nextInt();
                    if ((numberOf_Account > 0) && (numberOf_Account <= 5)) {
                        System.out.println("Enter detail of each account...");
                        for (int i = 0; i < numberOf_Account; i++) {
                            System.out.println("No." + (i + 1));
                            scanner.nextLine();
                            System.out.print("ID : ");
                            String U_id = scanner.nextLine(); // Add this line to capture the ID input
                            System.out.print("NAME : ");
                            String U_name = scanner.nextLine();
                            System.out.print("GENDER : ");
                            String U_gender = scanner.nextLine();
                            System.out.print("USERNAME : ");
                            String U_username = scanner.nextLine();
                            System.out.print("PASSWORD : ");
                            String U_password = scanner.nextLine();
                            System.out.print("BALANCE : ");
                            int balance = scanner.nextInt();

                            atm.account.add(new Account(U_id, U_name, U_gender, U_username, U_password, balance));
                        }
                    }
                } else {
                    System.out.println("Invalid password!");
                }
            } else {
                System.out.println("Account not found!");
            }
        }

        atm.run(atm.account);

    }

    public void run(ArrayList<Account> account_List) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("ATM Computer Thanyaburi Bank");

        while (true) {
            System.out.print("Enter Account Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            for (int i = 0; i < account_List.size(); i++) {
                if (account_List.get(i).getUsername().equals(username)) {
                    if (account_List.get(i).getPassword().equals(password)) {
                        showMenu(account_List, i, scanner);
                    } else {
                        System.out.println("Invalid password!");
                    }
                } else {
                    System.out.println("Account not found!");
                }
            }

        }
    }

    // แสดงเมนูบริการ
    private void showMenu(ArrayList<Account> account_List, int Index_Account, Scanner scanner) {
        while (true) {
            System.out.println("\n----------------------------------------------");
            System.out.println("ATM ComputerThanyaburi Bank");
            System.out.println("Account ID : " + account_List.get(Index_Account).getId());
            System.out.println("\nMenu Service");
            System.out.println("1. Account Balance");
            System.out.println("2. Withdrawal");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Checkable(account_List, Index_Account);
                    break;
                case "2":
                    Withdrawable(account_List, Index_Account);
                    break;
                case "3":
                    Depositeable(account_List, Index_Account);
                    break;
                case "4":
                    Transferable(account_List, Index_Account);
                    break;
                case "5":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    @Override
    public void Checkable(ArrayList<Account> account_List, int Index_Account) {
        // TODO Auto-generated method stub
        System.out.println("Account Balance: " + account_List.get(Index_Account).getBalance());
    }

    @Override
    public void Withdrawable(ArrayList<Account> account_List, int Index_Account) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        float amount = s.nextInt();
        float balance = account_List.get(Index_Account).getBalance();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            account_List.get(Index_Account).setBalance(balance);
            System.out.println(
                    "Withdrawal successful. \nRemaining balance: " + account_List.get(Index_Account).getBalance());
        }
    }

    @Override
    public void Depositeable(ArrayList<Account> account_List, int Index_Account) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        System.out.print("Fill in the amount to deposit : ");
        float amount = s.nextInt();
        account_List.get(Index_Account).setBalance(account_List.get(Index_Account).getBalance() + amount);
        System.out.println(
                "Depositeable successful. \nRemaining balance: " + account_List.get(Index_Account).getBalance());
    }

    @Override
    public void Transferable(ArrayList<Account> account_List, int Index_Account) {
        // TODO Auto-generated method stub
        boolean found = false;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the account id you want to transfer money to. : ");
        String account_id = s.nextLine();

        for (int i = 0; i < account_List.size(); i++) {
            if (account_List.get(i).getId().equals(account_id)) {
                found = true;
                System.out.print("Please enter the amount you want to transfer. : ");
                float amount = s.nextInt();
                account_List.get(Index_Account).setBalance(account_List.get(Index_Account).getBalance() - amount);
                account_List.get(i).setBalance(account_List.get(i).getBalance() + amount);
                System.out.println("Transferable successful. To account" + account_List.get(i).getName()
                        + " \nRemaining balance: " + account_List.get(Index_Account).getBalance());
                break;
            }
        }
        if (!found) {
            System.out.println("Account not found!");
        }
    }

}
