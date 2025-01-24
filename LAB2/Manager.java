package LAB2;

// คลาส Manager ที่สืบทอดจาก Person
class Manager extends Person {
    private String username; // ชื่อผู้ใช้
    private String password; // รหัสผ่าน
    private boolean MnIsTrue = false;

    // Constructor
    public Manager(String id, String name, String gender, String username, String password) {
        super(id, name, gender);
        this.username = username;
        this.password = password;
        this.MnIsTrue = true;
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

    public boolean isMnIsTrue() {
        return MnIsTrue;
    }

    public void setMnIsTrue(boolean mnIsTrue) {
        MnIsTrue = mnIsTrue;
    }
}