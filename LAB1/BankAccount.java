
public class BankAccount {
    private String accountId;
    private String accountName;
    private String password;
    private double balance;

    // Constructor
    public BankAccount(String accountId, String accountName, String password, double balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.password = password;
        this.balance = balance;
    }

    // ตรวจสอบรหัสผ่าน
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    // แสดงยอดเงินคงเหลือ
    public double getBalance() {
        return balance;
    }

    // ถอนเงิน
    public String withdraw(double amount) {
        if (amount > balance) {
            return "Insufficient balance.";
        } else {
            balance -= amount;
            return "Withdrawal successful. \nRemaining balance: " + balance;
        }
    }

    public String getAccountId() {
        return accountId;
    }

    public String getname (){
        return accountName;
    }
}

