package lk.ijse.apexeducationcenter.model;

import javafx.scene.control.Alert;
import lk.ijse.apexeducationcenter.to.EmployeeSalary;
import lk.ijse.apexeducationcenter.to.TeacherSalary;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherSalaryModel {


    public static boolean addTeacherSalary(TeacherSalary teacherSalary) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO teachersalary VALUES (? , ? , ? , ?)";
        return CrudUtil.execute(sql , teacherSalary.getTeacherSalaryId() , teacherSalary.getTeacherId()
                , teacherSalary.getTeacherSalaryPayDate() , teacherSalary.getTeacherSalaryValue());
    }

    public static TeacherSalary searchTeacherSalary(String salaryId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM teachersalary WHERE SalaryId = ?";

        ResultSet resultSet = CrudUtil.execute(sql , salaryId);
        if (resultSet.next()) {
            return new TeacherSalary(
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

    public static boolean updateTeacherSalary(TeacherSalary teacherSalary) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE teachersalary SET TeacherId = ? , payDate = ? , VALUE = ? WHERE SalaryId = ?";
        return CrudUtil.execute(sql , teacherSalary.getTeacherId() , teacherSalary.getTeacherSalaryPayDate()
                , teacherSalary.getTeacherSalaryValue() , teacherSalary.getTeacherSalaryId());
    }

    public static boolean deleteTeacherSalary(String salaryId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM teachersalary WHERE SalaryId = ?";
        Boolean isDeleted = CrudUtil.execute(sql,salaryId);
        return isDeleted;
    }

    public static String generateNextTeacherSalaryId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT SalaryId FROM teachersalary ORDER BY SalaryID DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);

        if (resultSet.next()){
            return generateNextTeacherSalaryId(resultSet.getString(1));
        }
        return generateNextTeacherSalaryId(resultSet.getString(null));
    }

    private static String generateNextTeacherSalaryId(String currentOrderId){
        if (currentOrderId!=null){
            String[] split = currentOrderId.split("S00");
            int id = Integer.parseInt(split[1]);
            id +=1;
            return "S00"+id;
        }
        return "O001";
    }
}
