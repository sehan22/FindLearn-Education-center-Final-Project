package lk.ijse.apexeducationcenter.util;

import lk.ijse.apexeducationcenter.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static lk.ijse.apexeducationcenter.db.DBConnection.getInstance;

public class CrudUtil {
    public static <T>T execute(String sql , Object...args) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = getInstance().getConnection().prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            pstm.setObject((i + 1) , args[i]);
        }

        if(sql.startsWith("SELECT") || sql.startsWith("select")) {
            return (T) pstm.executeQuery();
        }

        return (T)(Boolean)(pstm.executeUpdate() > 0);
    }
}
