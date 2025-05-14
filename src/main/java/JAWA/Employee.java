package JAWA;

public class Employee {
    private int idEmployee;
    private String name;
    private String dept;
    private Hours startTime;
    private Hours endTime;
    private Hours overtime;


    public int getId() {return idEmployee;}
    public void setId(int idEmployee) {this.idEmployee = idEmployee;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDept() {return dept;}
    public void setDept(String paramDept) {dept = paramDept;}

    public Hours getStartTime() {return startTime;}
    public void setStartTime(Hours startTime) {this.startTime = startTime;}

    public Hours getEndTime() {return endTime;}
    public void setEndTime(Hours endTime) {this.endTime = endTime;}

    public Hours getOvertime() {return overtime;}
    public void setOvertime(Hours overtime) {this.overtime = overtime;}
}


