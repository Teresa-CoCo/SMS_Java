import functions.*;

import javax.swing.*;
import java.awt.event.*;//Need add this module
import java.io.IOException;

public class GUI{
    public static void GUI(){
    JFrame frame = new JFrame("欢迎使用超市售货系统");
    JPanel panel1 = new JPanel();
    JButton button1 = new JButton("登录");
    JButton button2 = new JButton("注册");
    JButton button3 = new JButton("退出");
    button1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            login();
        }
    });
    button2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            register();
        }
    });
    button3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    });
    panel1.add(button1);
    panel1.add(button2);
    panel1.add(button3);
    frame.add(panel1);
    frame.setBounds(300,200,400,200);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void login(){
        JFrame frame = new JFrame("登录");
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("用户名:");
        JTextField textField1 = new JTextField(10);
        JLabel label2 = new JLabel("密码:");
        JPasswordField passwordField1 = new JPasswordField(10);
        JButton pressbutton1 = new JButton("登录");

        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(label2);
        panel1.add(passwordField1);
        panel1.add(pressbutton1);
        frame.add(panel1);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);

        pressbutton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username = textField1.getText();
                String password = String.valueOf(passwordField1.getPassword());
                if(login.login(username,password) && isAdmin.isAdmin(username)){
                    JFrame frame = new JFrame("登陆成功");
                    JPanel panel1 = new JPanel();
                    JLabel label3 = new JLabel("欢迎管理员"+username+"登录系统！");
                    panel1.add(label3);
                    frame.add(panel1);
                    frame.setBounds(300,200,400,200);
                    frame.setVisible(true);
                    admin();
                }
                if(login.login(username,password) && isAdmin.isAdmin(username) == false){
                    JFrame frame = new JFrame("登陆成功");
                    JPanel panel1 = new JPanel();
                    JLabel label3 = new JLabel("欢迎用户"+username+"登录系统！");
                    panel1.add(label3);
                    frame.add(panel1);
                    frame.setBounds(300,200,400,200);
                    frame.setVisible(true);
                    user();
                }
            }
        });
    }

    public static void register(){
        JFrame frame = new JFrame("注册");
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("用户名:");
        JTextField textField1 = new JTextField(15);
        JLabel label2 = new JLabel("密码:");
        JPasswordField passwordField1 = new JPasswordField(15);
        JLabel label3 = new JLabel("请输入全名:");
        JTextField textField2 = new JTextField(15);
        JLabel label4 = new JLabel("请输入手机号码:");
        JTextField textField3 = new JTextField(15);
        JButton pressbutton1 = new JButton("登录");

        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(label2);
        panel1.add(passwordField1);
        panel1.add(label3);
        panel1.add(textField2);
        panel1.add(label4);
        panel1.add(textField3);
        panel1.add(pressbutton1);
        frame.add(panel1);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pressbutton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = String.valueOf(passwordField1.getPassword());
                String fullname = textField2.getText();
                String phone = textField3.getText();
                functions.registrator.register(username,password,fullname,phone);
                JFrame frame = new JFrame("注册成功");
                JPanel panel1 = new JPanel();
                JLabel label3 = new JLabel(username+"注册成功");
                panel1.add(label3);
                frame.add(panel1);
                frame.setBounds(300,200,400,200);
                frame.setVisible(true);
            }
        });
    }
    public static void admin(){
        JFrame frame = new JFrame("欢迎使用超市管理系统");
        JPanel panel1 = new JPanel();
        JButton button1 = new JButton("添加商品");
        JButton button2 = new JButton("删除商品");
        JButton button3 = new JButton("修改商品数量");
        JButton button4 = new JButton("查询某个订单号的订单详情");
        JButton button5 = new JButton("修改某个用户的密码");
        JButton button6 = new JButton("回到上一级");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                addthing();
            }
        });
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                delthing();
            }
        });
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                modifything();
            }
        });
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                searchbyrecord();
            }
        });
        button5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                changeuserpassword();
            }
        });
        button6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                login();
            }
        });
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        frame.add(panel1);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
    }
    public static void user(){
        JFrame frame = new JFrame("欢迎使用超市售货系统");
        JPanel panel1 = new JPanel();
        JButton button1 = new JButton("搜索商品");
        JButton button2 = new JButton("购物车");
        JButton button3 = new JButton("历史订单");
        JButton button4 = new JButton("回到上一级");
        JButton button5 = new JButton("修改密码");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                searchthings();
            }
        });
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                shoppingcart();
            }
        });
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                history();
            }
        });
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                login();
            }
        });
        button5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                modifypassword();
            }
        });
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        frame.add(panel1);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
    }
    public static void addthing(){
        JPanel panel1 = new JPanel();
        JFrame frame = new JFrame("添加商品");
        JLabel label1 = new JLabel("商品名称");
        JTextField textField1 = new JTextField(15);
        JLabel label2 = new JLabel("商品价格");
        JTextField textField2 = new JTextField(15);
        JLabel label3 = new JLabel("商品数量");
        JTextField textField3 = new JTextField(15);
        JButton button1 = new JButton("添加商品");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String thingName = textField1.getText();
                int productPrice = Integer.parseInt(textField2.getText());
                int quantity = Integer.parseInt(textField3.getText());
                ThingOperate.addProduct(thingName,productPrice,quantity);
            }
        });
        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(label2);
        panel1.add(textField2);
        panel1.add(label3);
        panel1.add(textField3);
        panel1.add(button1);
        frame.add(panel1);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
    }
    public static void delthing(){
        JPanel panel1 = new JPanel();
        JFrame frame = new JFrame("删除货物");
        JLabel label = new JLabel("商品名称");
        JTextField textField1 = new JTextField(15);
        JButton button = new JButton("删除");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String thingName = textField1.getText();
                ThingOperate.deleteProduct(thingName);
            }
        });
        panel1.add(label);
        panel1.add(textField1);
        panel1.add(button);
        frame.add(panel1);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
    }
    public static void modifything(){
        JPanel panel1 = new JPanel();
        JFrame frame = new JFrame("修改商品");
        JLabel label = new JLabel("商品名称");
        JTextField textField1 = new JTextField(15);
        JLabel label1 = new JLabel("新的商品数量");
        JTextField textField2 = new JTextField(15);
        JButton button = new JButton("修改");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String thingName = textField1.getText();
                int productPrice = Integer.parseInt(textField2.getText());
                ThingOperate.updateProductAmount(thingName,productPrice);
            }
        });
        panel1.add(label);
        panel1.add(textField1);
        panel1.add(label1);
        panel1.add(textField2);
        panel1.add(button);
        frame.add(panel1);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
    }
    public static void searchbyrecord(){
        JPanel panel1 = new JPanel();
        JFrame frame = new JFrame("查询订单");
        JLabel label1 = new JLabel("订单号");
        JTextField textField1 = new JTextField(15);
        JButton button = new JButton("搜索");
        JLabel label2 = new JLabel();
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String thingName = textField1.getText();
                String label = ShoppingHistory.printReturnShoppingHistory(thingName);
                label2.setText(label);
            }
        });
        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(button);
        panel1.add(label2);
        frame.add(panel1);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
    }
    public static void changeuserpassword(){
        JPanel panel1 = new JPanel();
        JFrame frame = new JFrame("修改用户密码");
        JLabel label1 = new JLabel("用户用户名");
        JTextField textField1 = new JTextField(15);
        JLabel label2 = new JLabel("用户新密码");
        JTextField textField2 = new JTextField(15);
        JButton button = new JButton("修改");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String userName = textField1.getText();
                String password = textField2.getText();
                changeManagerPassword.changePassword(userName,password,true);
            }
        });
        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(label2);
        panel1.add(textField2);
        panel1.add(button);
        frame.add(panel1);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
    }
    public static void searchthings(){
        JPanel panel1 = new JPanel();
        JFrame frame = new JFrame("搜索");
        JLabel label1 = new JLabel("要搜索的商品名称");
        JTextField textField1 = new JTextField(15);
        JButton button = new JButton("搜索");
        JLabel label2 = new JLabel();
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String thingName = textField1.getText();
                label2.setText(ThingOperate.findAndReturnProductByName(thingName));
            }
        });
        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(label2);
        panel1.add(button);
        frame.add(panel1);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
    }
    public static void shoppingcart(){

    }
    public static void history(){

    }
    public static void modifypassword(){

    }
    public static void main(String[] args) {
        new GUI();
        GUI();
    }
}