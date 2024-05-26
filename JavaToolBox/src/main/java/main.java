import java.util.Scanner;
import functions.*;
public class SupermarketSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 创建各个功能类的实例
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingHistory shoppingHistory = new ShoppingHistory();
        BuyOperate buyOperate = new BuyOperate();
        registrator registrator = new registrator();
        isAdmin isAdmin = new isAdmin();
        ThingOperate thingOperate = new ThingOperate();
        changeManagerPassword changeManagerPassword = new changeManagerPassword();
        login login = new login();

        while (true) {
            System.out.println("Welcome to the Supermarket System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Buy Items");
            System.out.println("4. View Shopping Cart");
            System.out.println("5. View Shopping History");
            System.out.println("6. Change Manager Password");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // 处理登录
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    boolean loginSuccess = login.login(username, password);
                    if (loginSuccess) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed!");
                    }
                    break;
                case 2:
                    // 处理注册
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    System.out.println("Input your phone number： ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Input your fullname： ");
                    String fullName = scanner.nextLine();
                    registrator.register(newUsername, newPassword,fullName, phoneNumber);
                    System.out.println("Registration successful!");
                    break;
                case 3:
                    // 处理购买商品
                    System.out.print("Enter item ID to buy: ");
                    int itemId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    buyOperate.checkoutCartItem(login.getID(username), itemId, quantity);  // Assumes username is logged in
                    System.out.println("Item purchased successfully!");
                    break;
                case 4:
                    // 查看购物车
                    shoppingCart.viewCart(login.getID(username));  // Assumes username is logged in
                    break;
                case 5:
                    // 查看购物历史
                    shoppingHistory.printUserShoppingHistory(login.getID(username));  // Assumes username is logged in
                    break;
                case 6:
                    // 更改管理员密码
                    System.out.print("Enter current manager username: ");
                    String managerUsername = scanner.nextLine();
                    System.out.print("Enter new manager password: ");
                    String newManagerPassword = scanner.nextLine();
                    System.out.print("Are you an admin (true/false): ");
                    boolean isAdminUser = scanner.nextBoolean();
                    changeManagerPassword.changePassword(managerUsername, newManagerPassword, isAdminUser);
                    break;
                case 7:
                    // 退出程序
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
