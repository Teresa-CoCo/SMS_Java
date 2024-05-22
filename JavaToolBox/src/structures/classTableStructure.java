package structures;


public class classTableStructure {
    //课程名，课程描述，教师，上课节数，周几上课，上课周数，上课时间表，课程学分，总需要学分，课程容量
    String className;
    String classDesribtion;
    String teacherName;
    Integer classTime;
    Integer classWeekly;
    Integer classTotalWeek;
    Integer[][] classTimeTable;
    Double classPoint;
    Double totalNeedPoint;
    Integer classCapacity;

    public classTableStructure(String className, String classDesribtion, String teacherName, Integer classTime, Integer classWeekly, Integer classTotalWeek, Integer[][] classTimeTable, Double classPoint, Double totalNeedPoint, Integer classCapacity) {
        this.className = className;
        this.classDesribtion = classDesribtion;
        this.teacherName = teacherName;
        this.classTime = classTime;
        this.classWeekly = classWeekly;
        this.classTotalWeek = classTotalWeek;
        this.classTimeTable = classTimeTable;
        this.classPoint = classPoint;
        this.totalNeedPoint = totalNeedPoint;
        this.classCapacity = classCapacity;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDesribtion() {
        return classDesribtion;
    }

    public void setClassDesribtion(String classDesribtion) {
        this.classDesribtion = classDesribtion;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getClassTime() {
        return classTime;
    }

    public void setClassTime(Integer classTime) {
        this.classTime = classTime;
    }

    public Integer getClassWeekly() {
        return classWeekly;
    }

    public void setClassWeekly(Integer classWeekly) {
        this.classWeekly = classWeekly;
    }

    public Integer getClassTotalWeek() {
        return classTotalWeek;
    }

    public void setClassTotalWeek(Integer classTotalWeek) {
        this.classTotalWeek = classTotalWeek;
    }

    public Integer[][] getClassTimeTable() {
        return classTimeTable;
    }

    public void setClassTimeTable(Integer[][] classTimeTable) {
        this.classTimeTable = classTimeTable;
    }

    public Double getClassPoint() {
        return classPoint;
    }

    public void setClassPoint(Double classPoint) {
        this.classPoint = classPoint;
    }

    public Double getTotalNeedPoint() {
        return totalNeedPoint;
    }

    public void setTotalNeedPoint(Double totalNeedPoint) {
        this.totalNeedPoint = totalNeedPoint;
    }

    public Integer getClassCapacity() {
        return classCapacity;
    }

    public void setClassCapacity(Integer classCapacity) {
        this.classCapacity = classCapacity;
    }


    @Override
    public String toString() {
        return "classTableStructure{" +
                "className='" + className + '\'' +
                ", classDesribtion='" + classDesribtion + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", classTime=" + classTime +
                ", classWeekly=" + classWeekly +
                ", classTotalWeek=" + classTotalWeek +
                ", classTimeTable=" + classTimeTable +
                ", classPoint=" + classPoint +
                ", totalNeedPoint=" + totalNeedPoint +
                ", classCapacity=" + classCapacity +
                '}';
    }


}
