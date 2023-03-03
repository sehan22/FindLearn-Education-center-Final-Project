package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.EmployeeDAO;
import lk.ijse.apexeducationcenter.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM employee WHERE EmplName = ?" , id + "");
        resultSet.next();
        return new Employee(id+"", resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));

    }

    @Override
    public boolean add(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES (? , ? , ? , ? , ?)" , entity.getEmployeeId()
                , entity.getEmployeeName() , entity.getEmployeeDob() , entity.getEmployeeAddress() , entity.getEmployeePhoneNumber());
    }

    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET EmpName = ? , EmpDOB = ? , EmpAddress = ? , PhoneNumber = ? WHERE EmpId = ?"
                , entity.getEmployeeName() , entity.getEmployeeDob() , entity.getEmployeeAddress() , entity.getEmployeePhoneNumber() , entity.getEmployeeId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE EmpId = ?" , id);
    }

    @Override
    public String getCounts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select count(1) from employee");
        while (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT EmpId FROM employee");
        ArrayList<String> ids = new ArrayList<>();
        while (resultSet.next()) {
            ids.add(resultSet.getString(1));
        }
        return ids;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }
}
