package lk.ijse.apexeducationcenter.dao.custom;

import lk.ijse.apexeducationcenter.dao.CrudDAO;
import lk.ijse.apexeducationcenter.entity.Batch;

import java.sql.SQLException;

public interface BatchDAO extends CrudDAO<Batch> {
    public boolean DecSeat(String batchId) throws SQLException, ClassNotFoundException;
}
