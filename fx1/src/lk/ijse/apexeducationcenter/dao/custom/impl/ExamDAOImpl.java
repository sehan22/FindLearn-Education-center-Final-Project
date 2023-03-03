package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.ExamDAO;
import lk.ijse.apexeducationcenter.entity.Exam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExamDAOImpl implements ExamDAO {

    @Override
    public Exam search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM exam WHERE ExamId = ?" , id + "");
        resultSet.next();
        return new Exam(id+"", resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
    }

    @Override
    public boolean add(Exam entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO exam VALUES (? , ? , ? , ? , ?)" , entity.getExamId()
                , entity.getExamDetails() , entity.getExamDuration() , entity.getBatchId() , entity.getSubjectId());
    }

    @Override
    public boolean update(Exam entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE exam SET Details = ? , Duration = ?  , BatchId = ? ,  SubId = ? WHERE ExamId = ?"
                , entity.getExamDetails(), entity.getExamDuration(), entity.getBatchId(), entity.getSubjectId(), entity.getExamId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM exam WHERE ExamId = ?" , id);
    }

    @Override
    public String getCounts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select count(1) from exam");
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
