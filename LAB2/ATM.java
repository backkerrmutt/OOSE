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
            boolean isAdmin_login = false;
            do {
                System.out.println("----------------------------------------------");
                System.out.println("ATM Computer Thanyaburi Bank");
                System.out.println("Login Manager Mode");
                System.out.print("Enter Account Username: ");
                String username = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                if (m.getUsername().equals(username)) {
                    if (m.getPassword().equals(password)) {
                        isAdmin_login = true;
                        System.out.print("Enter amount of all account = ");
                        int numberOf_Account = scanner.nextInt();
                        if ((numberOf_Account > 0) && (numberOf_Account <= 5)) {
                            System.out.println("Enter detail of each account...");
                            System.out.print("BTC RATE : ");
                            double btcRate = scanner.nextInt();

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
                                double balance_TBH = scanner.nextInt();
                                atm.account.add(new Account(U_id, U_name, U_gender, U_username, U_password, balance_TBH,
                                        btcRate));
                            }
                        }
                    } else {
                        System.out.println("Invalid password!");
                    }
                } else {
                    System.out.println("Account not found!");
                }
            } while (isAdmin_login == false);

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select currency to check balance:");
        System.out.println("1. THB");
        System.out.println("2. BTC");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println(
                        "Account Balance (THB): " + account_List.get(Index_Account).getBalance_TBH() + " Baht");
                break;
            case 2:
                System.out
                        .println("Account Balance (BTC): " + account_List.get(Index_Account).getBalance_BTC() + " BTC");
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }

    }

    @Override
    public void Withdrawable(ArrayList<Account> account_List, int Index_Account) {
        Scanner s = new Scanner(System.in);
        System.out.println("Select currency to withdraw:");
        System.out.println("1. THB");
        System.out.println("2. BTC");
        int choice = s.nextInt();

        System.out.print("Enter withdrawal amount: ");
        double amount = s.nextDouble();

        switch (choice) {
            case 1:
                double balanceTHB = account_List.get(Index_Account).getBalance_TBH();
                if (amount > balanceTHB) {
                    System.out.println("Insufficient balance.");
                } else {
                    balanceTHB -= amount;
                    account_List.get(Index_Account).setBalance_TBH(balanceTHB);
                    System.out.println("Withdrawal successful. \nRemaining balance (THB): " + balanceTHB + " Baht");
                }
                break;
            case 2:
                double balanceBTC = account_List.get(Index_Account).getBalance_BTC();
                if (amount > balanceBTC) {
                    System.out.println("Insufficient balance.");
                } else {
                    balanceBTC -= amount;
                    account_List.get(Index_Account).setBalance_BTC(balanceBTC);
                    System.out.println("Withdrawal successful. \nRemaining balance (BTC): " + balanceBTC + " BTC");
                }
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    @Override
    public void Depositeable(ArrayList<Account> account_List, int Index_Account) {
        Scanner s = new Scanner(System.in);
        System.out.println("Select currency to deposit:");
        System.out.println("1. THB");
        System.out.println("2. BTC");
        int choice = s.nextInt();

        System.out.print("Fill in the amount to deposit: ");
        double amount = s.nextDouble();

        switch (choice) {
            case 1:
                account_List.get(Index_Account)
                        .setBalance_TBH(account_List.get(Index_Account).getBalance_TBH() + amount);
                System.out.println("Deposit successful. \nRemaining balance (THB): "
                        + account_List.get(Index_Account).getBalance_TBH() + " Baht");
                break;
            case 2:
                account_List.get(Index_Account)
                        .setBalance_BTC(account_List.get(Index_Account).getBalance_BTC() + amount);
                System.out.println("Deposit successful. \nRemaining balance (BTC): "
                        + account_List.get(Index_Account).getBalance_BTC() + " BTC");
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    @Override
    public void Transferable(ArrayList<Account> account_List, int Index_Account) {
        boolean found = false;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the account id you want to transfer money to: ");
        String account_id = s.nextLine();

        for (int i = 0; i < account_List.size(); i++) {
            if (account_List.get(i).getId().equals(account_id)) {
                found = true;
                System.out.println("Select currency to transfer:");
                System.out.println("1. THB");
                System.out.println("2. BTC");
                int choice = s.nextInt();

                System.out.print("Please enter the amount you want to transfer: ");
                double amount = s.nextDouble();

                switch (choice) {
                    case 1:
                        double balanceTHB = account_List.get(Index_Account).getBalance_TBH();
                        if (amount > balanceTHB) {
                            System.out.println("Insufficient balance.");
                        } else {
                            account_List.get(Index_Account).setBalance_TBH(balanceTHB - amount);
                            account_List.get(i).setBalance_TBH(account_List.get(i).getBalance_TBH() + amount);
                            System.out.print(" Baht\nTransfer successful. To account " + account_List.get(i).getName()
                                    + " \nRemaining balance (THB): "
                                    + account_List.get(Index_Account).getBalance_TBH() + " Baht\n");
                        }
                        break;
                    case 2:
                        double balanceBTC = account_List.get(Index_Account).getBalance_BTC();
                        if (amount > balanceBTC) {
                            System.out.println("Insufficient balance.");
                        } else {
                            account_List.get(Index_Account).setBalance_BTC(balanceBTC - amount);
                            account_List.get(i).setBalance_BTC(account_List.get(i).getBalance_BTC() + amount);
                            System.out.print(
                                    amount + " BTC\nTransfer successful. To account " + account_List.get(i).getName()
                                            + " \nRemaining balance (BTC): "
                                            + account_List.get(Index_Account).getBalance_BTC() + " BTC\n");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1 or 2.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Account not found!");
        }
    }
}
// @Override
// public void Withdrawable(ArrayList<Account> account_List, int Index_Account)
// {
// // TODO Auto-generated method stub
// Scanner s = new Scanner(System.in);
// System.out.print("Enter withdrawal amount: ");
// double amount = s.nextInt();
// double balance = account_List.get(Index_Account).getBalance_TBH();
// if (amount > balance) {
// System.out.println("Insufficient balance.");
// } else {
// balance -= amount;
// account_List.get(Index_Account).setBalance(balance);
// System.out.println(
// "Withdrawal successful. \nRemaining balance: " +
// account_List.get(Index_Account).getBalance_TBH());
// }
// }

// @Override
// public void Depositeable(ArrayList<Account> account_List, int Index_Account)
// {
// // TODO Auto-generated method stub
// Scanner s = new Scanner(System.in);
// System.out.print("Fill in the amount to deposit : ");
// double amount = s.nextInt();
// account_List.get(Index_Account).setBalance_TBH(account_List.get(Index_Account).getBalance_TBH()
// + amount);
// System.out.println(
// "Depositeable successful. \nRemaining balance: " +
// account_List.get(Index_Account).getBalance_TBH());
// }

// @Override
// public void Transferable(ArrayList<Account> account_List, int Index_Account)
// {
// // TODO Auto-generated method stub
// boolean found = false;
// Scanner s = new Scanner(System.in);
// System.out.print("Enter the account id you want to transfer money to. : ");
// String account_id = s.nextLine();

// for (int i = 0; i < account_List.size(); i++) {
// if (account_List.get(i).getId().equals(account_id)) {
// found = true;
// System.out.print("Please enter the amount you want to transfer. : ");
// double amount = s.nextInt();
// account_List.get(Index_Account).setBalance_TBH(account_List.get(Index_Account).getBalance_TBH()
// - amount);
// account_List.get(i).setBalance_TBH(account_List.get(i).getBalance_TBH() +
// amount);
// System.out.println("Transferable successful. To account" +
// account_List.get(i).getName()
// + " \nRemaining balance: " +
// account_List.get(Index_Account).getBalance_TBH());
// break;
// }
// }
// if (!found) {
// System.out.println("Account not found!");
// }
// }
