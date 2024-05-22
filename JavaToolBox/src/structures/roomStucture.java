package structures;

public class roomStucture {
    //教室位置，书桌号码，约定时间，结束时间
    String classroomLocation;
    Integer deskNumber;
    Integer bookedTime;
    Integer endTime;

    public roomStucture(String classroomLocation, Integer deskNumber, Integer bookedTime, Integer endTime) {
        this.classroomLocation = classroomLocation;
        this.deskNumber = deskNumber;
        this.bookedTime = bookedTime;
        this.endTime = endTime;
    }

    public String getClassroomLocation() {
        return classroomLocation;
    }

    public void setClassroomLocation(String classroomLocation) {
        this.classroomLocation = classroomLocation;
    }

    public Integer getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(Integer deskNumber) {
        this.deskNumber = deskNumber;
    }

    public Integer getBookedTime() {
        return bookedTime;
    }

    public void setBookedTime(Integer bookedTime) {
        this.bookedTime = bookedTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }


    @Override
    public String toString() {
        return "roomStucture{" +
                "classroomLocation='" + classroomLocation + '\'' +
                ", deskNumber=" + deskNumber +
                ", bookedTime=" + bookedTime +
                ", endTime=" + endTime +
                '}';
    }
    

}
