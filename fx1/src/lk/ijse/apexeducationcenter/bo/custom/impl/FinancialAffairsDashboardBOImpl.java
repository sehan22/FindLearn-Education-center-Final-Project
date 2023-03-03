package lk.ijse.apexeducationcenter.bo.custom.impl;

import lk.ijse.apexeducationcenter.bo.custom.FinancialAffairsDashboardBO;
import lk.ijse.apexeducationcenter.dao.DAOFactory;
import lk.ijse.apexeducationcenter.dao.custom.*;
import lk.ijse.apexeducationcenter.dto.*;
import lk.ijse.apexeducationcenter.entity.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class FinancialAffairsDashboardBOImpl implements FinancialAffairsDashboardBO {

    BatchDAO batchDAO = (BatchDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BATCH);
    CoursePaymentDAO coursePaymentDAO = (CoursePaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.COURSEPAYMENT);
    StudentBatchDAO studentBatchDAO = (StudentBatchDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENTBATCH);
    EmployeeSalaryDAO employeeSalaryDAO = (EmployeeSalaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.EMPLOYEESALARY);
    TeacherSalaryDAO teacherSalaryDAO = (TeacherSalaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.TEACHERSALARY);
    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.COURSE);
    TeacherDAO teacherDAO = (TeacherDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.TEACHER);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.EMPLOYEE);

    @Override
    public String generateNextEmployeeSalaryId() throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.generateNewID();
    }

    @Override
    public String generateNextTeacherSalaryId() throws SQLException, ClassNotFoundException {
        return teacherSalaryDAO.generateNewID();
    }

    @Override
    public String generateNewPaymentID() throws SQLException, ClassNotFoundException {
        return coursePaymentDAO.generateNewID();
    }

    @Override
    public boolean DecSeat(String batchId) throws SQLException, ClassNotFoundException {
        return batchDAO.DecSeat(batchId);
    }

    @Override
    public boolean addPayment(CoursePaymentDTO coursePaymentDTO) throws SQLException, ClassNotFoundException {
        return coursePaymentDAO.add(new CoursePayment(coursePaymentDTO.getPaymentId(), coursePaymentDTO.getStudentId(),
                coursePaymentDTO.getCourseId(), coursePaymentDTO.getCourseFees()));
    }

    @Override
    public boolean add(StudentBatchDTO entity) throws SQLException, ClassNotFoundException {
        return studentBatchDAO.add(new StudentBatch(entity.getStudentId(), entity.getBatchId()));
    }

    @Override
    public boolean addTeacherSalary(TeacherSalaryDTO dto) throws SQLException, ClassNotFoundException {
        return teacherSalaryDAO.add(new TeacherSalary(dto.getTeacherSalaryId(), dto.getTeacherId(), dto.getTeacherSalaryPayDate(), dto.getTeacherSalaryValue()));
    }

    @Override
    public TeacherSalaryDTO getAllTeacherSalary(String code) throws SQLException, ClassNotFoundException {
        TeacherSalary teacherSalary = teacherSalaryDAO.search(code);
        return new TeacherSalaryDTO(teacherSalary.getTeacherSalaryId(), teacherSalary.getTeacherId(), teacherSalary.getTeacherSalaryPayDate(), teacherSalary.getTeacherSalaryValue());
    }

    @Override
    public boolean updateTeacherSalary(TeacherSalaryDTO dto) throws SQLException, ClassNotFoundException {
        return teacherSalaryDAO.update(new TeacherSalary(dto.getTeacherSalaryId(), dto.getTeacherId(), dto.getTeacherSalaryPayDate(), dto.getTeacherSalaryValue()));
    }

    @Override
    public boolean deleteTeacherSalary(String id) throws SQLException, ClassNotFoundException {
        return teacherSalaryDAO.delete(id);
    }

    @Override
    public boolean addEmployeeSalary(EmployeeSalaryDTO dto) throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.add(new EmployeeSalary(dto.getEmpSalaryId(), dto.getEmpId(), dto.getEmpSalaryPayDate(), dto.getEmpSalaryValue()));
    }

    @Override
    public EmployeeSalaryDTO getAllEmployeeSalary(String code) throws SQLException, ClassNotFoundException {
        EmployeeSalary employeeSalary = employeeSalaryDAO.search(code);
        return new EmployeeSalaryDTO(employeeSalary.getEmpSalaryId(), employeeSalary.getEmpId(), employeeSalary.getEmpSalaryPayDate(), employeeSalary.getEmpSalaryValue());
    }

    @Override
    public boolean updateEmployeeSalary(EmployeeSalaryDTO dto) throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.update(new EmployeeSalary(dto.getEmpSalaryId(), dto.getEmpId(), dto.getEmpSalaryPayDate(), dto.getEmpSalaryValue()));
    }

    @Override
    public boolean deleteEmployeeSalary(String id) throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.delete(id);
    }

    @Override
    public ArrayList<String> loadTeacherIds() throws SQLException, ClassNotFoundException {
        return teacherDAO.loadIds();
    }

    @Override
    public ArrayList<String> loadEmployeeIds() throws SQLException, ClassNotFoundException {
        return employeeDAO.loadIds();
    }

    @Override
    public TeacherDTO searchTeacherNames(String code) throws SQLException, ClassNotFoundException {
        Teacher teacher = teacherDAO.search(code);
        return new TeacherDTO(teacher.getTeacherId(), teacher.getTeacherName(), teacher.getTeahcerAddress(), teacher.getPhoneNumber(), teacher.getTeacherEmail());
    }

    @Override
    public EmployeeDTO searchEmployeeNames(String code) throws SQLException, ClassNotFoundException {
        Employee employee = employeeDAO.search(code);
        return new EmployeeDTO(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeDob(), employee.getEmployeeAddress(), employee.getEmployeePhoneNumber());

    }

    @Override
    public StudentDTO searchStudentNames(String code) throws SQLException, ClassNotFoundException {
        Student student = studentDAO.search(code);
        return new StudentDTO(student.getStId(), student.getStName(), student.getStAddress(), student.getStDob(), student.getStNumber(), student.getStEmail());
    }

    @Override
    public BatchDTO searchBatchNames(String code) throws SQLException, ClassNotFoundException {
        Batch batch = batchDAO.search(code);
        return new BatchDTO(batch.getBatchId(), batch.getBatchName(), batch.getCrsId(), batch.getBatchYear(), batch.getBatchSeats());
    }

    @Override
    public CourseDTO searchCourseNames(String code) throws SQLException, ClassNotFoundException {
        Course search =courseDAO.search(code);
        return new CourseDTO(search.getCrsId(),search.getCrsName(),search.getDuration(),search.getCrsFee());
    }
}
