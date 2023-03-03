package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.StudentDAO;
import lk.ijse.apexeducationcenter.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public Student search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM student WHERE StId = ?" , id + "");
        resultSet.next();
        return new Student(id+"", resultSet.getString(2), resultSet.getString(3),
                resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6));

    }

    @Override
    public boolean add(Student entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO student VALUES (? , ? , ? , ? , ? , ?)" , entity.getStId()
                , entity.getStName() , entity.getStAddress() , entity.getStDob() , entity.getStNumber() , entity.getStEmail());
    }

    @Override
    public boolean update(Student entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE student SET StName = ? , StAddress = ? , StDOB = ? , PhoneNumber = ? , StEmail = ? WHERE StId = ?"
                , entity.getStName() , entity.getStAddress() , entity.getStDob() , entity.getStNumber() , entity.getStEmail() , entity.getStId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM student WHERE StId=?" , id);
    }

    public String getCounts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("select count(1) from student");
        while(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }
}
