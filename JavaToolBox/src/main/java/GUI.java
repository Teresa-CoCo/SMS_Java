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
    //                System.out.println("欢迎"+username+"！");
    //                System.out.println("1. 搜寻并购买您想购买的商品");
    //                System.out.println("2. 查看购物车");
    //                System.out.println("3. 结算购物车");
    //                System.out.println("4. 查看历史订单");
    //                System.out.println("5. 退出登录");
    //                System.out.println("6. 修改密码");
                    JFrame frame = new JFrame("登陆成功");
                    JPanel panel1 = new JPanel();
                    JLabel label3 = new JLabel("欢迎管理员"+username+"登录系统！");
                    panel1.add(label3);
                    frame.add(panel1);
                    frame.setBounds(300,200,400,200);
                    frame.setVisible(true);
                }
                if(login.login(username,password) && isAdmin.isAdmin(username) == false){
                    JFrame frame = new JFrame("登陆成功");
                    JPanel panel1 = new JPanel();
                    JLabel label3 = new JLabel("欢迎用户"+username+"登录系统！");
                    panel1.add(label3);
                    frame.add(panel1);
                    frame.setBounds(300,200,400,200);
                    frame.setVisible(true);
                    //                            System.out.println("欢迎管理员"+username+"！");
                    //                            System.out.println("1. 添加商品");
                    //                            System.out.println("2. 删除商品");
                    //                            System.out.println("3. 修改商品数量");
                    //                            System.out.println("4. 查询某个订单号的订单详情");
                    //                            System.out.println("5. 修改某个用户的密码");
                    //                            System.out.println("6. 回到上一级");
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
    public static void main(String[] args) {
        new GUI();
        GUI();
    }
}