package SMS;
import structures.*;
import java.util.ArrayList;
import java.util.Scanner;

public class function {
    public static void main(String[] args) {
        ArrayList<studentStructure> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        //为方便这里指定学生信息，直接使用键盘录入
        students.add(new studentStructure("张三", "2019001", 20, "计算机科学与技术", 90.0, 85.0, "北京", "123@qq.com"));
        students.add(new studentStructure("李四", "2019002", 21, "软件工程", 80.0, 88.0, "上海", "456@126.com"));
        students.add(new studentStructure("王五", "2019003", 22, "通信工程", 90.0, 85.0, "广州", "789@163.com"));
        students.add(new studentStructure("郭叔", "2019004", 21, "软件工程", 85.0, 90.0, "上海", "456@163.com"));
        students.add(new studentStructure("王红", "2019005", 21, "软件工程", 90.0, 85.0, "上海", "888@163.com"));
//        //使用键盘录入5个学生信息
//        for (int i = 0; i < 5; i++) {
//            System.out.println("请输入第" + (i + 1) + "个学生的信息：");
//            System.out.print("姓名：");
//            String name = sc.next();
//            System.out.print("学号：");
//            String id = sc.next();
//            System.out.print("年龄：");
//            int age = sc.nextInt();
//            System.out.print("专业：");
//            String major = sc.next();
//            sc.nextLine();
//            System.out.print("Java成绩（留空请输入'-'）：");
//            String javaScore = sc.nextLine();
//
//
//            //判断是否输入了空成绩
//
//            Double scoreJava = null;
//            if (javaScore.equals("-")) {
//                javaScore = null;
//            } else {
//                try {
//                    scoreJava = Double.parseDouble(javaScore);
//                } catch (NumberFormatException e) {
//                    System.out.println("输入无效，请输入一个数或'-'");
//                }
//            }
//
//            System.out.print("数学成绩（留空请输入'-'）：");
//            String mathScore = sc.nextLine();
//            Double scoremath = null;
//            if (mathScore.equals("-")) {
//                mathScore = null;
//            } else {
//                scoremath = Double.parseDouble(mathScore);
//            }
//            System.out.print("生源地：");
//            String homeTown = sc.next();
//            System.out.print("邮箱：");
//            String emailAdd = sc.next();
//            students.add(new studentStructure(name, id, age, major, scoreJava, scoremath, homeTown, emailAdd));
//        }

        //学生管理系统功能菜单

        while (true){
            System.out.println("欢迎使用学生管理系统！\n请选择您想要进入的子系统：");
            System.out.println("1.学生基本信息系统");
            System.out.println("2.成绩管理系统");
            System.out.println("3.返回上一级（重新运行）");
            //子系统的if结构
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("学生基本信息系统：");
                    System.out.println("请输入您要进行的操作：");
                    System.out.println("1.添加学生信息");
                    System.out.println("2.删除学生信息");
                    System.out.println("3.修改学生信息");
                    System.out.println("4.查询学生信息");
                    System.out.println("5.返回上一级");
                    int subChoice = sc.nextInt();
                    switch (subChoice) {
                        case 1:
                            System.out.println("请输入学生信息：");
                            System.out.print("姓名：");
                            String name = sc.next();
                            System.out.print("学号：");
                            String id = sc.next();
                            System.out.print("年龄：");
                            int age = sc.nextInt();
                            System.out.print("专业：");
                            String major = sc.next();
                            sc.nextLine();
                            System.out.print("Java成绩（留空请输入'-'）：");
                            String javaScore = sc.nextLine();
                            //判断是否输入了空成绩
                            Double scoreJava = null;
                            if (javaScore.equals("-")) {
                                javaScore = null;
                            } else {
                                try {
                                    scoreJava = Double.parseDouble(javaScore);
                                } catch (NumberFormatException e) {
                                    System.out.println("输入无效，请输入一个数或'-'");
                                }
                            }
                            System.out.print("数学成绩（留空请输入'-'）：");
                            String mathScore = sc.nextLine();
                            Double scoremath = null;
                            if (mathScore.equals("-")) {
                                mathScore = null;
                            } else {
                                scoremath = Double.parseDouble(mathScore);
                            }

                            System.out.print("生源地：");
                            String homeTown = sc.next();
                            System.out.print("邮箱：");
                            String emailAdd = sc.next();
                            students.add(new studentStructure(name, id, age, major, scoreJava, scoremath, homeTown, emailAdd));
                            System.out.println("添加成功！");
                            printInfo(students);
                            break;
                        case 2:
                            System.out.println("请输入要删除的学生学号：");
                            String delId = sc.next();
                            delInfo(students, delId);
                            break;
                        case 3:
                            System.out.println("请输入要修改的学生姓名：");
                            String changeName = sc.next();
                            changeInfo(students, changeName);
                            break;
                        case 4:
                            System.out.println("请输入要查询的种类名：学号/姓名/年龄/生源地");
                            String searchType = sc.next();
                            System.out.println("请输入要查询的条件：");
                            String searchCondition = sc.next();
                            if (searchType.equals("学号")) {
                                searchInfoByID(students, searchCondition);
                            } else if (searchType.equals("姓名")) {
                                searchInfoByName(students, searchCondition);
                            } else if (searchType.equals("年龄")) {
                                for (int j = 0; j < students.size(); j++) {
                                    if (students.get(j).getAge() == Integer.parseInt(searchCondition)) {
                                        System.out.println(students.get(j).toString());
                                    }
                                }
                            } else if (searchType.equals("生源地")) {
                                for (int j = 0; j < students.size(); j++) {
                                    if (students.get(j).getHomeTown().equals(searchCondition)) {
                                        System.out.println(students.get(j).toString());
                                    }
                                }
                            } else {
                                System.out.println("输入错误！");
                            }
                            break;
                        case 5:
                            //返回上一级,而不是直接停掉程序
                            break;

                        default:
                            System.out.println("输入错误！");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("成绩管理系统：");
                    System.out.println("请输入您要进行的操作：");
                    System.out.println("1.添加一位学生的成绩");
                    System.out.println("2.删除一位学生的成绩");
                    System.out.println("3.修改一位学生的成绩");
                    System.out.println("4.查询一位学生的成绩");
                    System.out.println("5.返回上一级");
                    int subChoice2 = sc.nextInt();
                    if (subChoice2 == 1) {
                        System.out.println("请输入学生姓名：");
                        String name = sc.next();
                        System.out.println("请输入要添加成绩的科目：Java/数学");
                        String subJava = sc.next();
                        if (subJava.equals("Java")) {
                            System.out.println("请输入Java成绩：");
                            Double javaScore = sc.nextDouble();
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getName().equals(name)) {
                                    students.get(i).setJavaScore(javaScore);
                                    System.out.println("添加成功！");
                                    printInfo(students);
                                    return;
                                }
                            }
                            System.out.println("输入错误！");
                        } else if (subJava.equals("数学")) {
                            System.out.println("请输入数学成绩：");
                            int mathScore = sc.nextInt();
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getName().equals(name)) {
                                    students.get(i).setMathScore(mathScore);
                                    System.out.println("添加成功！");
                                }
                            }
                        } else {
                            System.out.println("输入错误！");
                        }
                    } else if (subChoice2 == 2) {
                        System.out.println("请输入学生姓名：");
                        String name = sc.next();
                        System.out.println("请输入要删除成绩的科目：Java/数学");
                        String subJava = sc.next();
                        if (subJava.equals("Java")) {
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getName().equals(name)) {
                                    students.get(i).setJavaScore(null);
                                    System.out.println("删除成功！");
                                    printInfo(students);
                                    return;
                                }
                            }
                            System.out.println("输入错误！");
                        } else if (subJava.equals("数学")) {
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getName().equals(name)) {
                                    students.get(i).setMathScore(0);
                                    System.out.println("删除成功！");
                                    return;
                                }
                            }
                        }
                    } else if (subChoice2 == 3) {
                        System.out.println("请输入学生姓名：");
                        String name = sc.next();
                        System.out.println("请输入要修改成绩的科目：Java/数学");
                        String subJava = sc.next();
                        if (subJava.equals("Java")) {
                            System.out.println("请输入新的Java成绩：");
                            Double newJavaScore = sc.nextDouble();
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getName().equals(name)) {
                                    students.get(i).setJavaScore(newJavaScore);
                                    System.out.println("修改成功！");
                                    printInfo(students);
                                    return;
                                }
                            }
                            System.out.println("输入错误！");
                        } else if (subJava.equals("数学")) {
                            System.out.println("请输入新的数学成绩：");
                            int newMathScore = sc.nextInt();
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getName().equals(name)) {
                                    students.get(i).setMathScore(newMathScore);
                                    System.out.println("修改成功！");
                                    printInfo(students);
                                    return;
                                }
                            }
                        }
                    } else if (subChoice2 == 4) {
                        System.out.println("请输入要按什么进行查询：1.学号2.姓名3.科目4.总成绩区间");
                        int choice2 = sc.nextInt();
                        if (choice2 == 1) {
                            System.out.println("请输入要查询的学生学号：");
                            String id = sc.next();
                            searchInfoByID(students, id);
                        } else if (choice2 == 2) {
                            System.out.println("请输入要查询的学生姓名：");
                            String name = sc.next();
                            searchInfoByName(students, name);
                        } else if (choice2 == 3) {
                            System.out.println("请输入要查询的科目：Java/数学");
                            String subject = sc.next();
                            System.out.println("请输入要查询的分数：");
                            double score = sc.nextDouble();
                            searchInfoBySubjectScore(students, subject, score);
                        } else if (choice2 == 4) {
                            System.out.println("请输入要查询的总分区间：");
                            double score1 = sc.nextDouble();
                            double score2 = sc.nextDouble();
                            searchInfoByTotalScore(students, score1, score2);
                        } else {
                            System.out.println("输入错误！");
                        }
                    } else {
                        //返回上一级
                        break;
                    }
                    break;
                case 3:
                    //重新运行
                    break;
                default:
                    System.out.println("输入错误！");
                    break;
            }
        }

    }

    public static void printInfo(ArrayList<studentStructure> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
    }

    public static void delInfo(ArrayList<studentStructure> students, String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                System.out.println("删除成功！");
                printInfo(students);
                return;
            }
        }
    }

    public static void changeInfo(ArrayList<studentStructure> students, String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                System.out.println("请输入您要修改后的种类：1.姓名 2.学号 3.年龄 4.专业 5.Java成绩 6.生源地 7.邮箱 8.数学成绩");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("请输入新的姓名：");
                        String newName = sc.next();
                        students.get(i).setName(newName);
                        System.out.println("修改成功！");
                        printInfo(students);
                        break;
                    case 2:
                        System.out.println("请输入新的学号：");
                        String newId = sc.next();
                        students.get(i).setId(newId);
                        System.out.println("修改成功！");
                        printInfo(students);
                        break;
                    case 3:
                        System.out.println("请输入新的年龄：");
                        int newAge = sc.nextInt();
                        students.get(i).setAge(newAge);
                        System.out.println("修改成功！");
                        printInfo(students);
                        break;
                    case 4:
                        System.out.println("请输入新的专业：");
                        String newMajor = sc.next();
                        students.get(i).setMajor(newMajor);
                        System.out.println("修改成功！");
                        printInfo(students);
                        break;
                    case 5:
                        System.out.println("请输入新的成绩：");
                        Double newScore = sc.nextDouble();
                        students.get(i).setJavaScore(newScore);
                        System.out.println("修改成功！");
                        printInfo(students);
                        break;
                    case 6:
                        System.out.println("请输入新的生源地：");
                        String newOrigin = sc.next();
                        students.get(i).setHomeTown(newOrigin);
                        System.out.println("修改成功！");
                        printInfo(students);
                        break;
                    case 7:
                        System.out.println("请输入新的邮箱：");
                        String newEmail = sc.next();
                        students.get(i).setEmailAdd(newEmail);
                        System.out.println("修改成功！");
                        printInfo(students);
                        break;
                    case 8:
                        System.out.println("请输入新的数学成绩：");
                        int newMathScore = sc.nextInt();
                        students.get(i).setMathScore(newMathScore);
                        System.out.println("修改成功！");
                        printInfo(students);
                        break;
                    default:
                        System.out.println("输入错误！");
                        break;
                }
                return;
            }
        }
    }

    public static void searchInfoByID(ArrayList<studentStructure> students, String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                System.out.println(students.get(i).toString());
                return;
            }
            else{
                System.out.println("未找到该学生！");
            }
        }
    }

    public static void searchInfoByName(ArrayList<studentStructure> students, String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                System.out.println(students.get(i).toString());
                return;
            }
            else{
                System.out.println("未找到该学生！");
            }
        }
    }

    public static void searchInfoBySubjectScore(ArrayList<studentStructure> students, String subject, double score) {
        if (subject.equals("Java")) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getJavaScore() >= score) {
                    System.out.println(students.get(i).toString());
                }
                else {
                    System.out.println("未找到该学生！");
                }
            }
        } else if (subject.equals("数学")) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getMathScore() >= score) {
                    System.out.println(students.get(i).toString());
                }
                else {
                    System.out.println("未找到该学生！");
                }
            }
        } else {
            System.out.println("输入错误！");

        }
    }

    public static void searchInfoByTotalScore(ArrayList<studentStructure> students, double score1, double score2) {
        //先对每个同学两门成绩求和
        double[] sum = new double[students.size()];
        for (int i = 0; i < students.size(); i++) {
            sum[i] = students.get(i).getJavaScore() + students.get(i).getMathScore();
        }
        if(score1 > score2){
            System.out.println("输入错误！");
            System.exit(0);
        }
        for (int i = 0; i < students.size(); i++) {
            if (sum[i] >= score1 && sum[i] <= score2) {
                System.out.println(students.get(i).toString());
            }
            else {
                System.out.println("未找到该学生！");
            }
        }
    }
}