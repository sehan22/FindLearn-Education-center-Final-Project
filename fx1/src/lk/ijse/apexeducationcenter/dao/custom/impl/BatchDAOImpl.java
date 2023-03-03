package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.BatchDAO;
import lk.ijse.apexeducationcenter.entity.Batch;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BatchDAOImpl implements BatchDAO {

    @Override
    public Batch search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM batch WHERE BatchId = ?" , id + "");
        resultSet.next();
        return new Batch(id+"",resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5));
    }

    @Override
    public boolean add(Batch entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO batch VALUES (? , ? , ? , ? , ?)" , entity.getBatchId()
                , entity.getBatchName() , entity.getCrsId() , entity.getBatchYear() , entity.getBatchSeats());
    }

    @Override
    public boolean update(Batch entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE batch SET BatchName = ? , CrsId = ? , BatchYear = ? , BatchSeats = ? WHERE BatchId = ?"
                , entity.getBatchName() , entity.getCrsId() , entity.getBatchYear() , entity.getBatchSeats() , entity.getBatchId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM batch WHERE BatchId = ?" , id);
    }

    @Override
    public String getCounts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select count(1) from batch");
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

    public boolean DecSeat(String batchId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE batch SET BatchSeats = BatchSeats - 1 WHERE BatchId = ?" , batchId);
    }
}
