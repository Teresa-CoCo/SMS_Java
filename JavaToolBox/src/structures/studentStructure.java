package structures;

public class studentStructure {
    //姓名，学号，年龄，专业，java成绩，数学成绩，数学学分，java学分，平均GPA，生源地，邮箱，违约次数（自习室），共去过次数（自习室），本学期需要的学分（选课系统），课程表（选课系统），
    String name;
    String id;
    int age;
    String major;
    Double javaScore;
    Double mathScore;
    String homeTown;
    String emailAdd;
    Integer uncomingNum;
    Integer totalComingNum;
    Double needPoint;
    String classTable;

public  studentStructure(String name, String id, int age, String major, Double javaScore, Double mathScore,String homeTown, String emailAdd){
    this.name = name;
    this.id = id;
    this.age = age;
    this.major = major;
    this.javaScore = javaScore;
    this.homeTown = homeTown;
    this.emailAdd = emailAdd;
    this.mathScore = mathScore;
}
public double getMathScore(){
    return mathScore;
}
public void setMathScore(double mathScore){
    this.mathScore = mathScore;
}
public int getAge(){
    return age;
}
public void setAge(int age){
    this.age = age;
}
public String getMajor(){
    return major;
}
public void setMajor(String major){
    this.major = major;
}
public double getJavaScore(){
    return javaScore;
}
public void setJavaScore(Double javaScore){
    this.javaScore = javaScore;
}
public String getHomeTown(){
    return homeTown;
}
public void setHomeTown(String homeTown){
    this.homeTown = homeTown;
}
public String getEmailAdd(){
    return emailAdd;
}
public void setEmailAdd(String emailAdd){
    this.emailAdd = emailAdd;
}
public String getName(){
    return name;
}
public void setName(String name){
    this.name = name;
}
public String getId(){
    return id;
}
public void setId(String id){
    this.id = id;
}
@Override
public String toString() {
    return "Student Name: " + name +
            ", ID: " + id +
            ", Age: " + age +
            ", Major: " + major +
            ", Java Score: " + (javaScore == null ? "N/A" : javaScore) +
            ", Math Score: " + (mathScore == null ? "N/A" : mathScore) +
            ", Hometown: " + homeTown +
            ", Email: " + emailAdd;
}
}

