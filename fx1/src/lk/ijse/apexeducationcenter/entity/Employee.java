package lk.ijse.apexeducationcenter.entity;

public class Employee {
    private String employeeId;
    private String employeeName;
    private String employeeDob;
    private String employeeAddress;
    private int employeePhoneNumber;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String employeeDob, String employeeAddress, int employeePhoneNumber) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDob = employeeDob;
        this.employeeAddress = employeeAddress;
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDob() {
        return employeeDob;
    }

    public void setEmployeeDob(String employeeDob) {
        this.employeeDob = employeeDob;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public int getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(int employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeDob='" + employeeDob + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeePhoneNumber=" + employeePhoneNumber +
                '}';
    }
}
