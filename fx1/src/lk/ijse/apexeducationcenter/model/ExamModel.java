package lk.ijse.apexeducationcenter.model;

import javafx.scene.control.Alert;
import lk.ijse.apexeducationcenter.to.Course;
import lk.ijse.apexeducationcenter.to.Employee;
import lk.ijse.apexeducationcenter.to.Exam;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamModel {
    public static boolean addExam(Exam exam) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO exam VALUES (? , ? , ? , ? , ?)";
        return CrudUtil.execute(sql , exam.getExamId() , exam.getExamDetails() , exam.getExamDuration()
                , exam.getBatchId() , exam.getSubjectId());
    }

    public static Exam searchExam(String examId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM exam WHERE ExamId = ?";
        ResultSet resultSet = CrudUtil.execute(sql , examId);

        if (resultSet.next()) {
            return new Exam(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        } else {
            new Alert(Alert.AlertType.WARNING , "Invalid Id,Input correct Id!").show();
        }
        return null;
    }

    public static boolean updateExam(Exam exam) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE exam SET Details = ? , Duration = ?  , BatchId = ? ,  SubId = ? WHERE ExamId = ?";
        return CrudUtil.execute(sql , exam.getExamDetails() , exam.getExamDuration() , exam.getBatchId()
                , exam.getSubjectId() , exam.getExamId());
    }

    public static boolean deleteExam(String examId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM exam WHERE ExamId = ?";
        Boolean isDeleted = CrudUtil.execute(sql,examId);
        return isDeleted;
    }

    public static String getExamsCounts() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from result";
        ResultSet resultSet = CrudUtil.execute(sql);

        while(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
