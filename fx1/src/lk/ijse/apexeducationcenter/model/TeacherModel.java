package lk.ijse.apexeducationcenter.model;

import javafx.scene.control.Alert;
import lk.ijse.apexeducationcenter.db.DBConnection;
import lk.ijse.apexeducationcenter.to.Course;
import lk.ijse.apexeducationcenter.to.Teacher;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherModel {
    public static boolean addTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO teacher VALUES (? , ? , ? , ? , ?)";
        return CrudUtil.execute(sql , teacher.getTeacherId() , teacher.getTeacherName() , teacher.getTeahcerAddress()
                , teacher.getPhoneNumber() , teacher.getTeacherEmail());
    }

    public static Teacher searchTeacher(String teacherId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM teacher WHERE TeacherId = ?";
        ResultSet resultSet = CrudUtil.execute(sql , teacherId);

        if (resultSet.next()) {
            return new Teacher(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            );
        } else {
            new Alert(Alert.AlertType.WARNING , "Invalid Id,Input correct Id!").show();
        }
        return null;
    }

    public static boolean updateTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE teacher SET TeacherName = ? , TeacherAddress = ? , PhoneNumber = ? , Email = ? WHERE TeacherId = ?";
        return CrudUtil.execute(sql , teacher.getTeacherName() , teacher.getTeahcerAddress() , teacher.getPhoneNumber()
                , teacher.getTeacherEmail() , teacher.getTeacherId());
    }

    public static boolean deleteTeacher(String teacherId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM teacher WHERE TeacherId = ?";
        Boolean isDeleted = CrudUtil.execute(sql,teacherId);
        return isDeleted;
    }

    public static ArrayList<String> loadTeacherIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT TeacherId FROM teacher";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> teacherIdList = new ArrayList<>();

        while (result.next()) {
            teacherIdList.add(result.getString(1));
        }
        return teacherIdList;
    }

    public static String getTeacherCounts() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from teacher";
        ResultSet resultSet = CrudUtil.execute(sql);

        while(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
