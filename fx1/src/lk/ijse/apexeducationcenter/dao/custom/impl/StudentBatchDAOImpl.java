package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.StudentBatchDAO;
import lk.ijse.apexeducationcenter.entity.StudentBatch;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBatchDAOImpl implements StudentBatchDAO {

    @Override
    public StudentBatch search(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean add(StudentBatch entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO studentbatch VALUES (?, ?)" , entity.getStudentId() , entity.getBatchId());
    }

    @Override
    public boolean update(StudentBatch entity) {
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
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }
}
