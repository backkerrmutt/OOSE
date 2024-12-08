package LAB2;

public class Account extends Person {

    private String username; // ชื่อผู้ใช้
    private String password; // รหัสผ่าน
    private float balance;  // จำนวนเงินในบัญชี
   
    public Account (String id, String name, String gender ,String username, String password ,float balance) {
       super(id, name, gender);
       this.username = username;
       this.password = password;
       this.balance = balance;
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

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
