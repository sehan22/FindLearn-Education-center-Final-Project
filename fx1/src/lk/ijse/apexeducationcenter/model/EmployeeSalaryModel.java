package lk.ijse.apexeducationcenter.model;

import javafx.scene.control.Alert;
import lk.ijse.apexeducationcenter.to.Batch;
import lk.ijse.apexeducationcenter.to.EmployeeSalary;
import lk.ijse.apexeducationcenter.to.TeacherSalary;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeSalaryModel {
    public static boolean addEmployeeSalary(EmployeeSalary employeeSalary) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employeesalary VALUES (? , ? , ? , ?)";
        return CrudUtil.execute(sql , employeeSalary.getEmpSalaryId() , employeeSalary.getEmpId()
                , employeeSalary.getEmpSalaryPayDate() , employeeSalary.getEmpSalaryValue());
    }

    public static EmployeeSalary searchEmployeeSalary(String salaryId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employeesalary WHERE SalaryId = ?";

        ResultSet resultSet = CrudUtil.execute(sql , salaryId);
        if (resultSet.next()) {
            return new EmployeeSalary(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            );
        } else {
            new Alert(Alert.AlertType.WARNING , "Invalid Id,Input correct Id!").show();
        }
        return null;
    }

    public static boolean updateEmployeeSalary(EmployeeSalary employeeSalary) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employeesalary SET EmpId = ? , payDate = ? , VALUE = ? WHERE SalaryId = ?";
        return CrudUtil.execute(sql , employeeSalary.getEmpId() , employeeSalary.getEmpSalaryPayDate()
                , employeeSalary.getEmpSalaryValue() , employeeSalary.getEmpSalaryId());
    }

    public static boolean deleteEmployeeSalary(String salaryId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM employeesalary WHERE SalaryId = ?";
        Boolean isDeleted = CrudUtil.execute(sql,salaryId);
        return isDeleted;
    }

    public static String generateNextEmployeeSalaryId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT SalaryId FROM employeesalary ORDER BY SalaryID DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);

        if (resultSet.next()){
            return generateNextEmployeeSalaryId(resultSet.getString(1));
        }
        return generateNextEmployeeSalaryId(resultSet.getString(null));
    }

    private static String generateNextEmployeeSalaryId(String currentOrderId){
        if (currentOrderId!=null){
            String[] split = currentOrderId.split("S00");
            int id = Integer.parseInt(split[1]);
            id +=1;
            return "S00"+id;
        }
        return "O001";
    }
}
