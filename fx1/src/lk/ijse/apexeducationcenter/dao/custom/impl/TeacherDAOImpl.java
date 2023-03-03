package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.TeacherDAO;
import lk.ijse.apexeducationcenter.entity.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public Teacher search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM teacher WHERE TeacherId = ?" , id + "");
        resultSet.next();
        return new Teacher(id+"", resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getNString(5));
    }

    @Override
    public boolean add(Teacher entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO teacher VALUES (? , ? , ? , ? , ?)" , entity.getTeacherId()
                , entity.getTeacherName() , entity.getTeahcerAddress() , entity.getPhoneNumber() , entity.getTeacherEmail());
    }

    @Override
    public boolean update(Teacher entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE teacher SET TeacherName = ? , TeahcerAddress = ? , PhoneNumber = ? , Email = ? WHERE TeacherId = ?"
                , entity.getTeacherName() , entity.getTeahcerAddress() , entity.getPhoneNumber() , entity.getTeacherEmail() , entity.getTeacherId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM teacher WHERE TeacherId = ?" , id);
    }

    @Override
    public String getCounts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select count(1) from teacher");
        while (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> ids = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT TeacherId FROM teacher");
        while (resultSet.next()) {
            ids.add(resultSet.getString(1));
        }
        return ids;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }
}
