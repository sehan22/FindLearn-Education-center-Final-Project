package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.CourseDAO;
import lk.ijse.apexeducationcenter.entity.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public Course search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM course WHERE CrsId = ?" , id + "");
        resultSet.next();
        return new Course(id+"",resultSet.getString(2),resultSet.getInt(3), resultSet.getDouble(4));
    }

    @Override
    public boolean add(Course entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Course VALUES (? , ? , ? , ?)" , entity.getCrsId()
                , entity.getCrsName() , entity.getDuration() , entity.getCrsFee());
    }

    @Override
    public boolean update(Course entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE course SET CrsName = ? , Duration = ?  , courseFee = ? WHERE CrsId = ?"
                , entity.getCrsName() , entity.getDuration() , entity.getCrsFee() , entity.getCrsId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM course WHERE CrsId = ?" , id+"");
    }

    @Override
    public String getCounts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select count(1) from course");
        while (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> crsIds = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT CrsId FROM course");
        while (resultSet.next()) {
            crsIds.add(resultSet.getString(1));
        }
        return crsIds;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }
}
