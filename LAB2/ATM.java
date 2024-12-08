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
            System.out.print("Enter amount of all account = ");
            int numberOf_Account = scanner.nextInt();
            if ((numberOf_Account > 0) && (numberOf_Account <= 5)) {
                System.out.println("Enter detail of each account...");
                for (int i = 0; i < numberOf_Account; i++) {

                    System.out.println("No." + (i + 1));
                    System.out.print("ID : ");
                    String U_id = scanner.next();
                    System.out.print("NAME : ");
                    String U_name = scanner.next();
                    System.out.print("GENDER : ");
                    String U_gender = scanner.next();
                    System.out.print("USERNAME : ");
                    String U_username = scanner.next();
                    System.out.print("PASSWORD : ");
                    String U_password = scanner.next();
                    System.out.print("Banlace : ");
                    int balance = scanner.nextInt();

                    atm.account.add(new Account(U_id, U_name, U_gender, U_username, U_password, balance));

                }
            }
        }
        System.out.println("----------------------------------------------");
        System.out.println("ATM Computer Thanyaburi Bank");
        System.out.println("Login Manager Mode");
        System.out.print("Enter Account Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        if ((m.getUsername() == username) && (m.getPassword() == password)) {
            atm.run(atm.account);
        }

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

            for (Account acc : account_List) {
                if (username == acc.getUsername()) {
                    if (password == acc.getPassword()) {
                        // showMenu();
                        System.out.println("password!");
                    } else {
                        System.out.println("Invalid password!");
                    }
                }
            }

        }
    }

    // // แสดงเมนูบริการ
    // private void showMenu() {
    //     while (true) {
    //         System.out.println("\n----------------------------------------------");
    //         System.out.println("ATM ComputerThanyaburi Bank");
    //         System.out.println("Account ID :  " + account.getAccountId());
    //         System.out.println("\nMenu Service");
    //         System.out.println("1. Account Balance");
    //         System.out.println("2. Withdrawal");
    //         System.out.println("3. Exit");
    //         System.out.print("Choose: ");
            

    //         switch (choice) {
    //             case "1":
    //                 System.out.println("Account Balance: " + account.getBalance());
    //                 break;
    //             case "2":
    //                 System.out.print("Enter withdrawal amount: ");
    //                 double amount = Double.parseDouble(scanner.nextLine());
    //                 System.out.println(account.withdraw(amount));
    //                 break;
    //             case "3":
    //                 System.out.println("Exiting...");
    //                 return;
    //             default:
    //                 System.out.println("Invalid choice!");
    //         }
    //     }
    // }

    @Override
    public void Checkable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Checkable'");
    }

    @Override
    public void Withdrawable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Withdrawable'");
    }

    @Override
    public void Depositeable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Depositeable'");
    }

    @Override
    public void Transferable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Transferable'");
    }

}
