package SupermarketSystem.Buyer;

public class buyerStruct {
    //昵称, 密码, 余额, 购物车, 手机号
    private String name;
    private String password;
    private double balance;
    private String[] shoppingCart;
    private String phone;


    public buyerStruct(String name, String password, double balance, String[] shoppingCart, String phone) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.shoppingCart = shoppingCart;
        this.phone = phone;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String[] getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(String[] shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


    @Override
    public String toString() {
        return "buyerStruct{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", shoppingCart=" + shoppingCart +
                ", phone='" + phone + '\'' +
                '}';
    }
    
}
