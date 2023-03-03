package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.SubjectDAO;
import lk.ijse.apexeducationcenter.entity.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public Subject search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM subject WHERE SubId = ?" , id + "");
        resultSet.next();
        return new Subject(id+"", resultSet.getString(2), resultSet.getString(3));
    }

    @Override
    public boolean add(Subject entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO subject VALUES (? , ? , ?)" , entity.getSubjectId()
                , entity.getSubjectName() , entity.getSubjectCrsId());
    }

    @Override
    public boolean update(Subject entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE subject SET SubName = ? , CrsId = ? WHERE SubId = ?" , entity.getSubjectName(), entity.getSubjectCrsId(), entity.getSubjectId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM subject WHERE SubId = ?" , id);
    }

    @Override
    public String getCounts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select count(1) from subject");
        while (resultSet.next()) {
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
