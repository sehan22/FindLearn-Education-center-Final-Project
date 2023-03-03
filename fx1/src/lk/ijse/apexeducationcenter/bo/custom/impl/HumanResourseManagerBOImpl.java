package lk.ijse.apexeducationcenter.bo.custom.impl;

import lk.ijse.apexeducationcenter.bo.custom.HumanResourseManagerBO;
import lk.ijse.apexeducationcenter.dao.DAOFactory;
import lk.ijse.apexeducationcenter.dao.custom.EmployeeDAO;
import lk.ijse.apexeducationcenter.dao.custom.StudentDAO;
import lk.ijse.apexeducationcenter.dao.custom.TeacherDAO;
import lk.ijse.apexeducationcenter.dto.EmployeeDTO;
import lk.ijse.apexeducationcenter.dto.StudentDTO;
import lk.ijse.apexeducationcenter.dto.TeacherDTO;
import lk.ijse.apexeducationcenter.entity.Employee;
import lk.ijse.apexeducationcenter.entity.Student;
import lk.ijse.apexeducationcenter.entity.Teacher;

import java.sql.SQLException;

public class HumanResourseManagerBOImpl implements HumanResourseManagerBO {
    TeacherDAO teacherDAO = (TeacherDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.TEACHER);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.EMPLOYEE);

    @Override
    public boolean addTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException {
        return teacherDAO.add(new Teacher(dto.getTeacherId(), dto.getTeacherName(), dto.getTeahcerAddress(), dto.getPhoneNumber(), dto.getTeacherEmail()));
    }

    @Override
    public TeacherDTO getAllTeacher(String code) throws SQLException, ClassNotFoundException {
        Teacher teacher = teacherDAO.search(code);
        return new TeacherDTO(teacher.getTeacherId(), teacher.getTeacherName(), teacher.getTeahcerAddress(), teacher.getPhoneNumber(), teacher.getTeacherEmail());
    }

    @Override
    public boolean updateTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException {
        return teacherDAO.update(new Teacher(dto.getTeacherId(), dto.getTeacherName(), dto.getTeahcerAddress(), dto.getPhoneNumber(), dto.getTeacherEmail()));
    }

    @Override
    public boolean deleteTeacher(String id) throws SQLException, ClassNotFoundException {
        return teacherDAO.delete(id);
    }

    @Override
    public boolean addStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentDAO.add(new Student(dto.getStId(), dto.getStName(), dto.getStAddress(), dto.getStDob(), dto.getStNumber(), dto.getStEmail()));
    }

    @Override
    public StudentDTO getAllStudent(String code) throws SQLException, ClassNotFoundException {
        Student student = studentDAO.search(code);
        return new StudentDTO(student.getStId(), student.getStName(), student.getStAddress(), student.getStDob(), student.getStNumber(), student.getStEmail());
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentDAO.update(new Student(dto.getStId(), dto.getStName(), dto.getStAddress(), dto.getStDob(), dto.getStNumber(), dto.getStEmail()));
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.delete(id);
    }

    @Override
    public boolean addEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.add(new Employee(dto.getEmployeeId(), dto.getEmployeeName(), dto.getEmployeeDob(), dto.getEmployeeAddress(), dto.getEmployeePhoneNumber()));
    }

    @Override
    public EmployeeDTO getAllEmployee(String code) throws SQLException, ClassNotFoundException {
        Employee employee = employeeDAO.search(code);
        return new EmployeeDTO(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeDob(), employee.getEmployeeAddress(), employee.getEmployeePhoneNumber());
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(dto.getEmployeeId(), dto.getEmployeeName(), dto.getEmployeeDob(), dto.getEmployeeAddress(), dto.getEmployeePhoneNumber()));
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    @Override
    public String getCountsTeacher() throws SQLException, ClassNotFoundException {
        return teacherDAO.getCounts();
    }

    @Override
    public String getCountsStudent() throws SQLException, ClassNotFoundException {
        return studentDAO.getCounts();
    }

    @Override
    public String getCountsEmployee() throws SQLException, ClassNotFoundException {
        return employeeDAO.getCounts();
    }
}
