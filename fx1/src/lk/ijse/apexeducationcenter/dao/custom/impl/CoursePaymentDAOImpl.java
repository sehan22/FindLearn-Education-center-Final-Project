package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.CoursePaymentDAO;
import lk.ijse.apexeducationcenter.entity.CoursePayment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoursePaymentDAOImpl implements CoursePaymentDAO {

    @Override
    public CoursePayment search(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean add(CoursePayment entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO payment VALUES (?, ?, ?, ?)" , entity.getPaymentId()
                , entity.getStudentId() , entity.getCourseId() , entity.getCourseFees());
    }

    @Override
    public boolean update(CoursePayment entity) {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("This feature is not implemented yet");
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
        ResultSet rst = SQLUtil.execute("SELECT PayId FROM payment ORDER BY PayId DESC LIMIT 1");
            String lastId = null;

            if (rst.next()) {
                lastId = rst.getString(1);
            }
            String[] strings = lastId.split("P00");

            for (String s : strings) {
                lastId = s;
            }

            int i = Integer.parseInt(lastId);
            lastId = "P00" + (i + 1);
            return lastId;
    }
}
