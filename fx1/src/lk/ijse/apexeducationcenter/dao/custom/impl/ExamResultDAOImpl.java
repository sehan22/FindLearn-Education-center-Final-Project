package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.ExamResultDAO;
import lk.ijse.apexeducationcenter.entity.ExamResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExamResultDAOImpl implements ExamResultDAO {

    @Override
    public ExamResult search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM result WHERE RstId = ?" , id + "");
        resultSet.next();
        return new ExamResult(id+"", resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
    }

    @Override
    public boolean add(ExamResult entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO result VALUES (? , ? , ? , ? , ?)" , entity.getRstId()
                , entity.getDiscription() , entity.getMark() , entity.getExamId() , entity.getStId());
    }

    @Override
    public boolean update(ExamResult entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE result SET Discription = ? , Marks = ?  , ExamId = ? ,  StId = ? WHERE RstId = ?"
                , entity.getDiscription() , entity.getMark() , entity.getExamId() , entity.getStId(), entity.getRstId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM result WHERE RstId = ?" , id);
    }

    @Override
    public String getCounts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select count(1) from result");
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
