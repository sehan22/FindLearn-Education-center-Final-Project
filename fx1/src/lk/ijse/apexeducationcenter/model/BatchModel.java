package lk.ijse.apexeducationcenter.model;

import javafx.scene.control.Alert;
import lk.ijse.apexeducationcenter.to.Batch;
import lk.ijse.apexeducationcenter.to.Course;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BatchModel {
    public static boolean addBatch(Batch batch) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO batch VALUES (? , ? , ? , ? , ?)";
        return CrudUtil.execute(sql , batch.getBatchId()  , batch.getBatchName() , batch.getCrsId(), batch.getBatchYear() , batch.getBatchSeats());
    }

    public static Batch searchBatch(String batchId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM batch WHERE BatchId = ?";

        ResultSet resultSet = CrudUtil.execute(sql , batchId);
        if (resultSet.next()) {
            return new Batch(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5)
            );
        } else {
            new Alert(Alert.AlertType.WARNING , "Invalid Id,Input correct Id!").show();
        }
        return null;
    }

    public static boolean updateBatch(Batch batch) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE batch SET BatchName = ? , CrsId = ? , BatchYear = ? , BatchSeats = ? WHERE BatchId = ?";
        return CrudUtil.execute(sql , batch.getBatchName() , batch.getCrsId() , batch.getBatchYear()
                , batch.getBatchSeats() , batch.getBatchId());
    }

    public static boolean deleteBatch(String batchId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM batch WHERE BatchId = ?";
        Boolean isDeleted = CrudUtil.execute(sql,batchId);
        return isDeleted;
    }

    public static boolean DecSeat(String batchId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE batch SET BatchSeats = BatchSeats - 1 WHERE BatchId = ?";
        return CrudUtil.execute(sql, batchId);
    }

    public static String getBatchCounts() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from batch";
        ResultSet resultSet = CrudUtil.execute(sql);

        while(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
