package SupermarketSystem.Seller;

public class admin {
    //上货人名，密码，手机号，是否为超级管理员

    private String name;
    private String password;
    private String phone;
    private boolean isSuperAdmin;


    public admin(String name, String password, String phone, boolean isSuperAdmin) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.isSuperAdmin = isSuperAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public void setSuperAdmin(boolean isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }


    @Override
    public String toString() {
        return "admin{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", isSuperAdmin=" + isSuperAdmin +
                '}';
    }
    
}
