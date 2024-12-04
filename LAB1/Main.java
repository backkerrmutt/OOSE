import java.util.Scanner;

public class Main {
    static String result_name;
    public static void main(String[] args) {

        
        ATM atm = new ATM();

        // เพิ่มบัญชีธนาคาร
        System.out.print("Enter amount of all account = ");
        Scanner scanner = new Scanner(System.in);
        int numberOf_Account = scanner.nextInt();
        if ((numberOf_Account > 0) && (numberOf_Account <= 5)) {
            System.err.println("Enter detail of each account...");
            for (int i = 0; i < numberOf_Account; i++) {
                System.out.println("No."+(i+1));
                result_name = getname(i);
                
                System.out.print("Account ID : ");
                String account_id = scanner.next();
                
                System.out.print("Account Name : ");
                String account_name = scanner.next();
                
                System.out.print("Password : ");
                String account_password = scanner.next();

                System.out.print("Balance : ");
                int balance = scanner.nextInt();
                System.out.println();


                BankAccount result_name = new BankAccount(account_id, account_name, account_password, balance);
                atm.addAccount(result_name);
            }
        }
       
        // BankAccount account1 = new BankAccount("112312345678-9", "C","1234", 800000);
        // atm.addAccount(account1);
        
        // BankAccount account2 = new BankAccount("112433847392-7", "Lucas","1111", 1000000);
        // atm.addAccount(account2);
        
        
        atm.run();


    }

    public static String getname(int number) {
        return "account" + number;
    }

}