package lk.ijse.apexeducationcenter.model;

import javafx.scene.control.Alert;
import lk.ijse.apexeducationcenter.to.Course;
import lk.ijse.apexeducationcenter.to.Student;
import lk.ijse.apexeducationcenter.to.Teacher;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentModel {
    public static boolean addStudent(Student student) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO student VALUES (? , ? , ? , ? , ? , ?)";
        return CrudUtil.execute(sql , student.getStId() , student.getStName() , student.getStAddress()
                , student.getStDob() , student.getStNumber() , student.getStEmail());
    }

    public static Student searchStudent(String studentId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM student WHERE StId = ?";
        ResultSet resultSet = CrudUtil.execute(sql , studentId);

        if (resultSet.next()) {
            return new Student(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getString(6)
            );
        } else {
            new Alert(Alert.AlertType.WARNING , "Invalid Id,Input correct Id!").show();
        }
        return null;
    }

    public static boolean updateStudent(Student student) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE student SET StName = ? , StAddress = ? , StDOB = ? , PhoneNumber = ? , StEmail = ? WHERE StId = ?";
        return CrudUtil.execute(sql , student.getStName() , student.getStAddress() , student.getStDob()
                , student.getStNumber() , student.getStEmail() , student.getStId());
    }

    public static boolean deleteTeacher(String studentId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM student WHERE StId = ?";
        Boolean isDeleted = CrudUtil.execute(sql,studentId);
        return isDeleted;
    }

    public static String getStudentsCounts() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from student";
        ResultSet resultSet = CrudUtil.execute(sql);

        while(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
