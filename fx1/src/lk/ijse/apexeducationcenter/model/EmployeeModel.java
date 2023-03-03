package lk.ijse.apexeducationcenter.model;

import javafx.scene.control.Alert;
import lk.ijse.apexeducationcenter.to.Employee;
import lk.ijse.apexeducationcenter.to.Student;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {
    public static boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES (? , ? , ? , ? , ?)";
        return CrudUtil.execute(sql , employee.getEmployeeId() , employee.getEmployeeName() , employee.getEmployeeDob()
                , employee.getEmployeeAddress() , employee.getEmployeePhoneNumber());
    }

    public static Employee searchEmployee(String employeeId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee WHERE EmpId = ?";
        ResultSet resultSet = CrudUtil.execute(sql , employeeId);

        if (resultSet.next()) {
            return new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)
            );
        } else {
            new Alert(Alert.AlertType.WARNING , "Invalid Id,Input correct Id!").show();
        }
        return null;
    }

    public static boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employee SET EmpName = ? , EmpDOB = ? , EmpAddress = ? , PhoneNumber = ? WHERE EmpId = ?";
        return CrudUtil.execute(sql , employee.getEmployeeName() , employee.getEmployeeDob()
                , employee.getEmployeeAddress() , employee.getEmployeePhoneNumber());
    }

    public static boolean deleteEmployee(String employeeId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM employee WHERE EmpId = ?";
        Boolean isDeleted = CrudUtil.execute(sql,employeeId);
        return isDeleted;
    }

    public static ArrayList<String> loadTeacherIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT EmpId FROM employee";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> employeeIdList = new ArrayList<>();

        while (result.next()) {
            employeeIdList.add(result.getString(1));
        }
        return employeeIdList;
    }

    public static String getEmployeesCounts() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from employee";
        ResultSet resultSet = CrudUtil.execute(sql);

        while(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
