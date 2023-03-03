package lk.ijse.apexeducationcenter.bo.custom;

import lk.ijse.apexeducationcenter.bo.SuperBO;
import lk.ijse.apexeducationcenter.dto.*;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FinancialAffairsDashboardBO extends SuperBO {
    public String generateNextEmployeeSalaryId() throws SQLException, ClassNotFoundException;
    public String generateNextTeacherSalaryId() throws SQLException, ClassNotFoundException;
    public String generateNewPaymentID() throws SQLException, ClassNotFoundException;
    public boolean DecSeat(String batchId) throws SQLException, ClassNotFoundException;
    public boolean addPayment(CoursePaymentDTO coursePayment) throws SQLException, ClassNotFoundException;
    public boolean add(StudentBatchDTO entity) throws SQLException, ClassNotFoundException;

    public boolean addTeacherSalary(TeacherSalaryDTO dto) throws SQLException, ClassNotFoundException;
    public TeacherSalaryDTO getAllTeacherSalary(String code) throws SQLException, ClassNotFoundException;
    public boolean updateTeacherSalary(TeacherSalaryDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteTeacherSalary(String id) throws SQLException, ClassNotFoundException;

    public boolean addEmployeeSalary(EmployeeSalaryDTO dto) throws SQLException, ClassNotFoundException;
    public EmployeeSalaryDTO getAllEmployeeSalary(String code) throws SQLException, ClassNotFoundException;
    public boolean updateEmployeeSalary(EmployeeSalaryDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteEmployeeSalary(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<String> loadTeacherIds() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadEmployeeIds() throws SQLException, ClassNotFoundException;

    public TeacherDTO searchTeacherNames(String teacherId) throws SQLException, ClassNotFoundException;
    public EmployeeDTO searchEmployeeNames(String employeeId) throws SQLException, ClassNotFoundException;
    public StudentDTO searchStudentNames(String studentId) throws SQLException, ClassNotFoundException;
    public BatchDTO searchBatchNames(String batchId) throws SQLException, ClassNotFoundException;
    public CourseDTO searchCourseNames(String courseId) throws SQLException, ClassNotFoundException;
}
