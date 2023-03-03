package lk.ijse.apexeducationcenter.model;

import javafx.scene.control.Alert;
import lk.ijse.apexeducationcenter.to.Student;
import lk.ijse.apexeducationcenter.to.StudentBatch;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentBatchModel {
    public static StudentBatch searchfromBatchIdInStudentBatch(String searchBatchId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM studentbatch WHERE BatchId = ?";

        ResultSet resultSet = CrudUtil.execute(sql , searchBatchId);

        if (resultSet.next()) {
            return new StudentBatch(
                    resultSet.getString(1),
                    resultSet.getString(2)
            );
        } else {
            new Alert(Alert.AlertType.WARNING , "Invalid Id,Input correct Id!").show();
        }
        return null;
    }
    public static StudentBatch searchFromStudentIdInStudentBatch(String searchStudentId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM studentbatch WHERE StId = ?";
        ResultSet resultSet = CrudUtil.execute(sql , searchStudentId);
        if (resultSet.next()) {
            return new StudentBatch(
                resultSet.getString(1),
                resultSet.getString(2)
            );
        }
        return null;
    }

    public  static  boolean addStudentBatch(StudentBatch studentBatch) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO studentbatch VALUES (?, ?)";
        return CrudUtil.execute(sql, studentBatch.getStudentId(), studentBatch.getBatchId());
    }
}
