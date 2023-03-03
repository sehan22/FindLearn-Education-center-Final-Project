package lk.ijse.apexeducationcenter.to;

public class EmployeeSalary {
    private String empSalaryId;
    private String empId;
    private String empSalaryPayDate;
    private double empSalaryValue;

    public EmployeeSalary() {
    }

    public EmployeeSalary(String empSalaryId, String empId, String empSalaryPayDate, double empSalaryValue) {
        this.empSalaryId = empSalaryId;
        this.empId = empId;
        this.empSalaryPayDate = empSalaryPayDate;
        this.empSalaryValue = empSalaryValue;
    }

    public String getEmpSalaryId() {
        return empSalaryId;
    }

    public void setEmpSalaryId(String empSalaryId) {
        this.empSalaryId = empSalaryId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpSalaryPayDate() {
        return empSalaryPayDate;
    }

    public void setEmpSalaryPayDate(String empSalaryPayDate) {
        this.empSalaryPayDate = empSalaryPayDate;
    }

    public double getEmpSalaryValue() {
        return empSalaryValue;
    }

    public void setEmpSalaryValue(double empSalaryValue) {
        this.empSalaryValue = empSalaryValue;
    }
}
