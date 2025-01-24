package LAB2;

public class Account extends Person {

    private String username; // ชื่อผู้ใช้
    private String password; // รหัสผ่าน
    private double balance_TBH;  // จำนวนเงินในบัญชี
    private double btcRate;
   
    public Account (String id, String name, String gender ,String username, String password ,double balance_TBH, double btcRate) {
       super(id, name, gender);
       this.username = username;
       this.password = password;
       this.balance_TBH = balance_TBH;
       this.btcRate = btcRate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance_TBH() {
        return balance_TBH;
    
    }
    public double getBalance_BTC() {
        return balance_TBH / btcRate;
    }

    public void setBalance_BTC(double balance_BTC) {
        this.balance_TBH = balance_BTC * btcRate;
    }

    public void setBalance_TBH(double balance) {
        this.balance_TBH = balance;
    }
}
