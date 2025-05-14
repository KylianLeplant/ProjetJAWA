package JAWA;

import java.util.ArrayList;

//Vraiment utile???
public class EmployeeList {
    private final ArrayList<Employee> EmpList = new ArrayList<Employee>();

    public void addEmployee(Employee emp) { EmpList.add(emp); }
    public void removeEmployee(Employee emp) { EmpList.remove(emp); }

    public ArrayList<Employee> getEmployeeList() { return EmpList; }
}
