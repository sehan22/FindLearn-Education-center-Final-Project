package lk.ijse.apexeducationcenter.model;
import javafx.scene.control.Alert;
import lk.ijse.apexeducationcenter.to.Course;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseModel {
    public static boolean addCourse(Course course) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Course VALUES (? , ? , ? , ?)";
        return CrudUtil.execute(sql , course.getCrsId() , course.getCrsName() , course.getDuration() , course.getCrsFee());
    }

    public static Course searchCourse(String courseId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM course WHERE CrsId = ?";
        ResultSet resultSet = CrudUtil.execute(sql , courseId);

        if (resultSet.next()) {
            return new Course(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)
            );
        } else {
            new Alert(Alert.AlertType.WARNING , "Invalid Id,Input correct Id!").show();
        }
        return null;
    }

    public static boolean updateCourse(Course course) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE course SET CrsName = ? , Duration = ?  , courseFee = ? WHERE CrsId = ?";
        return CrudUtil.execute(sql , course.getCrsName() , course.getDuration() , course.getCrsFee() , course.getCrsId());
    }

    public static boolean deleteCourse(String courseId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM course WHERE CrsId = ?";
        Boolean isDeleted = CrudUtil.execute(sql,courseId);
        return isDeleted;
    }

    public static ArrayList<String> loadCorseIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT CrsId FROM course";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> courseIdList = new ArrayList<>();

        while (result.next()) {
            courseIdList.add(result.getString(1));
        }
        return courseIdList;
    }

    public static String getCourseCounts() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from course";
        ResultSet resultSet = CrudUtil.execute(sql);

        while(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
