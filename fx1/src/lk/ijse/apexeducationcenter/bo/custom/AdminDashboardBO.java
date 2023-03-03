package lk.ijse.apexeducationcenter.bo.custom;

import lk.ijse.apexeducationcenter.bo.SuperBO;
import lk.ijse.apexeducationcenter.dto.BatchDTO;
import lk.ijse.apexeducationcenter.dto.CourseDTO;
import lk.ijse.apexeducationcenter.dto.SubjectDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminDashboardBO extends SuperBO {
    public boolean addCourse(CourseDTO dto) throws SQLException, ClassNotFoundException;
    public CourseDTO getAllCourse(String code) throws SQLException, ClassNotFoundException;
    public boolean updateCourse(CourseDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteCourse(String id) throws SQLException, ClassNotFoundException;

    public boolean addBatch(BatchDTO dto) throws SQLException, ClassNotFoundException;
    public BatchDTO getAllBatch(String code) throws SQLException, ClassNotFoundException;
    public boolean updateBatch(BatchDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteBatch(String id) throws SQLException, ClassNotFoundException;

    public boolean addSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException;
    public SubjectDTO getAllSubject(String code) throws SQLException, ClassNotFoundException;
    public boolean updateSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteSubject(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<String> loadCourseIds() throws SQLException, ClassNotFoundException;

    public String getCountsCourse() throws SQLException, ClassNotFoundException;
    public String getCountsBatch() throws SQLException, ClassNotFoundException;
    public String getCountsSubject() throws SQLException, ClassNotFoundException;
}
