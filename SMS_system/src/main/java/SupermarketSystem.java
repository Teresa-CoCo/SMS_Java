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
            System.out.println("欢迎使用超市管理系统！");
            System.out.println("1. 登录");
            System.out.println("2. 注册");
            System.out.println("3. 退出");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请输入用户名：");
                    String username = scanner.next();
                    System.out.println("请输入密码：");
                    String password = scanner.next();
                    //管理员菜单
                    if (login.login(username, password) && isAdmin.isAdmin(username)) {
                        System.out.println("登录成功！");
                        int flaggg = 1;
                        while (flaggg == 1) {
                            //管理员操作
                            System.out.println("欢迎管理员" + username + "！");
                            System.out.println("1. 添加商品");
                            System.out.println("2. 删除商品");
                            System.out.println("3. 修改商品数量");
                            System.out.println("4. 查询某个订单号的订单详情");
                            System.out.println("5. 修改某个用户的密码");
                            System.out.println("6. 回到上一级");
                            int choice1 = scanner.nextInt();
                            switch (choice1) {
                                case 1:
                                    System.out.println("请输入商品名称：");
                                    String productName = scanner.next();
                                    System.out.println("请输入商品价格：");
                                    int productPrice = scanner.nextInt();
                                    System.out.println("请输入商品数量：");
                                    int productNum = scanner.nextInt();
                                    thingOperate.addProduct(productName, productNum, productPrice);
                                    break;
                                case 2:
                                    System.out.println("请输入商品名称：");
                                    String productName2 = scanner.next();
                                    thingOperate.deleteProduct(productName2);
                                    break;
                                case 3:
                                    System.out.println("请输入商品名称：");
                                    String productName3 = scanner.next();
                                    System.out.println("请输入新的商品数量：");
                                    int productNum2 = scanner.nextInt();
                                    thingOperate.updateProductAmount(productName3, productNum2);
                                    break;
                                case 4:
                                    System.out.println("请输入订单号：");
                                    String orderID = scanner.next();
                                    ShoppingHistory.printRecordShoppingHistory(orderID);
                                    break;
                                case 5:
                                    System.out.println("请输入用户名：");
                                    String username2 = scanner.next();
                                    System.out.println("请输入新密码：");
                                    String newPassword = scanner.next();
                                    changeManagerPassword.changePassword(username2, newPassword, isAdmin.isAdmin(username));
                                case 6:
                                    flaggg = 0;
                                    break;
                                default:
                                    System.out.println("输入错误！");
                                    break;
                            }
                        }
                    }
                    //一般用户菜单
                    if (login.login(username, password) && isAdmin.isAdmin(username) == false) {
                        System.out.println("登录成功！");
                        int flag = 1;
                        while (flag == 1) {
                            System.out.println("欢迎" + username + "！");
                            System.out.println("1. 搜寻并购买您想购买的商品");
                            System.out.println("2. 查看购物车");
                            System.out.println("3. 结算购物车");
                            System.out.println("4. 查看历史订单");
                            System.out.println("5. 退出登录");
                            System.out.println("6. 修改密码");

                            int choice2 = scanner.nextInt();
                            switch (choice2) {
                                case 1:
                                    System.out.println("请输入商品名称：");
                                    String productName = scanner.next();
                                    thingOperate.findAndPrintProductByName(productName);
                                    System.out.println("您想要购买该商品吗？\n1. 是\n2. 否");
                                    int choice3 = scanner.nextInt();
                                    switch (choice3) {
                                        case 1:
                                            System.out.println("请输入商品数量：");
                                            int productNum = scanner.nextInt();
                                            int uid = login.getID(username);
                                            int thing_id = thingOperate.getProductID(productName);
                                            System.out.println(thing_id);
                                            ShoppingCart.addToCart(uid, thing_id, productNum);
                                    }
                                    break;
                                case 2:
                                    int uid = login.getID(username);
                                    ShoppingCart.viewCart(uid);
                                    System.out.println("是否需要移除/修改购物车内的商品（数量）？\n1. 需要移除某个商品\n2. 需要修改某个商品的数量\n3. 退出");
                                    int choice4 = scanner.nextInt();
                                    switch (choice4) {
                                        case 1:
                                            System.out.println("请输入要移除的商品名称：");
                                            String productName2 = scanner.next();
                                            int thing_id2 = thingOperate.getProductID(productName2);
                                            ShoppingCart.removeFromCart(uid, thing_id2);
                                            break;
                                        case 2:
                                            System.out.println("请输入要修改数量的商品名称：");
                                            String productName3 = scanner.next();
                                            int thing_id3 = thingOperate.getProductID(productName3);
                                            System.out.println("请输入新的数量：");
                                            int productNum2 = scanner.nextInt();
                                            ShoppingCart.updateCartItem(uid, thing_id3, productNum2);
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            System.out.println("输入错误！");
                                            break;
                                    }
                                    break;
                                case 3:
                                    int uid2 = login.getID(username);
                                    ShoppingCart.viewCart(uid2);
                                    System.out.println("请输入您要结算的商品：");
                                    String productName4 = scanner.next();
                                    double discount = DiscountSystem.calculateDiscount(ShoppingHistory.getHistoryCount(username));
                                    BuyOperate.checkoutCartItem(uid2, thingOperate.getProductID(productName4), ShoppingCart.getCartAmount(uid2, thingOperate.getProductID(productName4)),discount);
                                    int flagg = 1;
                                    while (flagg == 1) {
                                        System.out.println("是否继续结算？\n1. 是\n2. 否");
                                        int choice5 = scanner.nextInt();
                                        switch (choice5) {
                                            case 1:
                                                System.out.println("请输入您要结算的商品：");
                                                String productName5 = scanner.next();
                                                BuyOperate.checkoutCartItem(uid2, thingOperate.getProductID(productName5), ShoppingCart.getCartAmount(uid2, thingOperate.getProductID(productName5)),discount);
                                                break;
                                            case 2:
                                                flagg = 0;
                                                break;
                                            default:
                                                System.out.println("输入错误！");
                                                break;
                                        }
                                    }
                                    break;
                                case 4:
                                    int uid3 = login.getID(username);
                                    ShoppingHistory.printUserShoppingHistory(String.valueOf(uid3));
                                    break;
                                case 5:
                                    flag = 0;
                                    break;
                                case 6:
                                    System.out.println("请输入新密码：");
                                    String newPassword = scanner.next();
                                    changeManagerPassword.changePassword(username, newPassword, true);
                                    break;
                                default:
                                    flagg = 0;
                                    System.out.println("输入错误！");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("登录失败！");
                    }
                    break;
                case 2:
                    System.out.println("请输入用户名：");
                    String newUsername = scanner.next();
                    System.out.println("请输入密码：");
                    String newPassword = scanner.next();
                    System.out.println("请输入全名：");
                    String fullName = scanner.next();
                    System.out.println("请输入电话号码：");
                    String phoneNumber = scanner.next();
                    functions.registrator.register(newUsername, newPassword, fullName, phoneNumber);
                    break;

                case 3:
                    System.out.println("欢迎下次使用！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误！");
                    break;
            }
        }
    }
}
