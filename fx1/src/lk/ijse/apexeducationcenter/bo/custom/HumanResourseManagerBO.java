package lk.ijse.apexeducationcenter.bo.custom;

import lk.ijse.apexeducationcenter.bo.SuperBO;
import lk.ijse.apexeducationcenter.dto.EmployeeDTO;
import lk.ijse.apexeducationcenter.dto.StudentDTO;
import lk.ijse.apexeducationcenter.dto.TeacherDTO;

import java.sql.SQLException;

public interface HumanResourseManagerBO extends SuperBO {

    public boolean addTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException;
    public TeacherDTO getAllTeacher(String code) throws SQLException, ClassNotFoundException;
    public boolean updateTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteTeacher(String id) throws SQLException, ClassNotFoundException;

    public boolean addStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;
    public StudentDTO getAllStudent(String code) throws SQLException, ClassNotFoundException;
    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;

    public boolean addEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
    public EmployeeDTO getAllEmployee(String code) throws SQLException, ClassNotFoundException;
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;

    public String getCountsTeacher() throws SQLException, ClassNotFoundException;
    public String getCountsStudent() throws SQLException, ClassNotFoundException;
    public String getCountsEmployee() throws SQLException, ClassNotFoundException;
}
