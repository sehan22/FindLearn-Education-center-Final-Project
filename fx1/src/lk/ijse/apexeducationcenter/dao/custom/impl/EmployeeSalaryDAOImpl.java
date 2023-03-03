package lk.ijse.apexeducationcenter.dao.custom.impl;

import lk.ijse.apexeducationcenter.dao.SQLUtil;
import lk.ijse.apexeducationcenter.dao.custom.EmployeeSalaryDAO;
import lk.ijse.apexeducationcenter.entity.EmployeeSalary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeSalaryDAOImpl implements EmployeeSalaryDAO {

    @Override
    public EmployeeSalary search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM employeesalary WHERE SalaryId = ?" , id + "");
        resultSet.next();
        return new EmployeeSalary(id+"", resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4));

    }

    @Override
    public boolean add(EmployeeSalary entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employeesalary VALUES (? , ? , ? , ?)" , entity.getEmpSalaryId()
                , entity.getEmpId() , entity.getEmpSalaryPayDate() , entity.getEmpSalaryValue());
    }

    @Override
    public boolean update(EmployeeSalary entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employeesalary SET EmpId = ? , payDate = ? , VALUE = ? WHERE SalaryId = ?"
                , entity.getEmpId() , entity.getEmpSalaryPayDate() , entity.getEmpSalaryValue() , entity.getEmpSalaryId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employeesalary WHERE SalaryId = ?" , id);
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
        ResultSet rst = SQLUtil.execute("SELECT SalaryId FROM employeesalary ORDER BY SalaryID DESC LIMIT 1");
        String lastId = null;

        if (rst.next()) {
            lastId = rst.getString(1);
        }
        String[] strings = lastId.split("S00");

        for (String s : strings) {
            lastId = s;
        }

        int i = Integer.parseInt(lastId);
        lastId = "S00" + (i + 1);
        return lastId;
    }
}
