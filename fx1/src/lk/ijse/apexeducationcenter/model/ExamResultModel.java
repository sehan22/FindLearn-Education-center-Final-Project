package lk.ijse.apexeducationcenter.model;

import javafx.scene.control.Alert;
import lk.ijse.apexeducationcenter.to.Exam;
import lk.ijse.apexeducationcenter.to.ExamResult;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamResultModel {
    public static boolean addExamResult(ExamResult examResult) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO result VALUES (? , ? , ? , ? , ?)";
        return CrudUtil.execute(sql , examResult.getRstId() , examResult.getDiscription() , examResult.getMark()
                , examResult.getExamId() , examResult.getStId());
    }

    public static ExamResult searchExamResult(String resultId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM result WHERE RstId = ?";
        ResultSet resultSet = CrudUtil.execute(sql , resultId);

        if (resultSet.next()) {
            return new ExamResult(
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

    public static boolean updateExamResult(ExamResult examResult) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE result SET Discription = ? , Marks = ?  , ExamId = ? ,  StId = ? WHERE RstId = ?";
        return CrudUtil.execute(sql , examResult.getDiscription() , examResult.getMark() , examResult.getExamId()
                , examResult.getStId() , examResult.getRstId());
    }

    public static boolean deleteExamResult(String examId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM result WHERE RstId = ?";
        Boolean isDeleted = CrudUtil.execute(sql,examId);
        return isDeleted;
    }

    public static String getExamsResultsCounts() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from exam";
        ResultSet resultSet = CrudUtil.execute(sql);

        while(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
