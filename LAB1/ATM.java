
import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    private HashMap<String, BankAccount> accounts = new HashMap<>();

    // เพิ่มบัญชีธนาคาร
    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountId(), account);
    }

    // เริ่มการทำงานของ ATM
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("ATM Computer Thanyaburi Bank");

        while (true) {
            System.out.print("Enter Account ID: ");
            String accountId = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (accounts.containsKey(accountId)) {
                BankAccount account = accounts.get(accountId);
                if (account.checkPassword(password)) {
                    showMenu(account, scanner);
                } else {
                    System.out.println("Invalid password!");
                }
            } else {
                System.out.println("Account not found!");
            }
        }
    }

    // แสดงเมนูบริการ
    private void showMenu(BankAccount account, Scanner scanner) {
        while (true) {
            System.out.println("\n----------------------------------------------");
            System.out.println("ATM ComputerThanyaburi Bank");
            System.out.println("Account ID :  " + account.getAccountId());
            System.out.println("\nMenu Service");
            System.out.println("1. Account Balance");
            System.out.println("2. Withdrawal");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Account Balance: " + account.getBalance());
                    break;
                case "2":
                    System.out.print("Enter withdrawal amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    System.out.println(account.withdraw(amount));
                    break;
                case "3":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
