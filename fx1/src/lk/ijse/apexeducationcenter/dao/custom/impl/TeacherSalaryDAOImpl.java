package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.TeacherSalaryDAO;
import lk.ijse.apexeducationcenter.entity.TeacherSalary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherSalaryDAOImpl implements TeacherSalaryDAO {

    @Override
    public TeacherSalary search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM teachersalary WHERE SalaryId = ?" , id + "");
        resultSet.next();
        return new TeacherSalary(id+"", resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4));

    }

    @Override
    public boolean add(TeacherSalary entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO teachersalary VALUES (? , ? , ? , ?)" , entity.getTeacherSalaryId()
                , entity.getTeacherId() , entity.getTeacherSalaryPayDate() , entity.getTeacherSalaryValue());
    }

    @Override
    public boolean update(TeacherSalary entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE teachersalary SET TeacherId = ? , payDate = ? , VALUE = ? WHERE SalaryId = ?"
                , entity.getTeacherId() , entity.getTeacherSalaryPayDate() , entity.getTeacherSalaryValue() , entity.getTeacherSalaryId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM teachersalary WHERE SalaryId = ?" , id+"");
    }

    @Override
    public String getCounts() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT SalaryId FROM teachersalary ORDER BY SalaryID DESC LIMIT 1");
            String lastId = null;

            if (rst.next()) {
                lastId = rst.getString(1);
            }
            String[] strings = lastId.split("S00");

            for (String s : strings) {
                lastId = s;
            }

            int i = Integer.parseInt(lastId);
            lastId = "S00" + (i + 1);
            return lastId;
    }
}
