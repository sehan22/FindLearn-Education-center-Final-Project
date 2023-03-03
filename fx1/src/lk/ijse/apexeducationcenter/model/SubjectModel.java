package lk.ijse.apexeducationcenter.model;

import javafx.scene.control.Alert;
import lk.ijse.apexeducationcenter.to.Batch;
import lk.ijse.apexeducationcenter.to.Course;
import lk.ijse.apexeducationcenter.to.Subject;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectModel {
    public static boolean addSubject(Subject subject) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO subject VALUES (? , ? , ?)";
        return CrudUtil.execute(sql , subject.getSubjectId() , subject.getSubjectName() , subject.getSubjectCrsId());
    }

    public static Subject searchSubject(String subjectId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM subject WHERE SubId = ?";
        ResultSet resultSet = CrudUtil.execute(sql , subjectId);

        if (resultSet.next()) {
            return new Subject(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
        } else {
            new Alert(Alert.AlertType.WARNING , "Invalid Id,Input correct Id!").show();
        }
        return null;
    }

    public static boolean updateBatch(Subject subject) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE subject SET SubName = ? , CrsId = ? WHERE SubId = ?";
        return CrudUtil.execute(sql , subject.getSubjectName() , subject.getSubjectCrsId() , subject.getSubjectId());
    }

    public static boolean deleteBatch(String subjectId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM subject WHERE SubId = ?";
        Boolean isDeleted = CrudUtil.execute(sql,subjectId);
        return isDeleted;
    }

    public static String getSubjectsCounts() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from subject";
        ResultSet resultSet = CrudUtil.execute(sql);

        while(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
