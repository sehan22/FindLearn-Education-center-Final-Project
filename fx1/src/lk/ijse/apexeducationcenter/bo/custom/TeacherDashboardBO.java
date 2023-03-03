package lk.ijse.apexeducationcenter.bo.custom;

import lk.ijse.apexeducationcenter.bo.SuperBO;
import lk.ijse.apexeducationcenter.dto.ExamDTO;
import lk.ijse.apexeducationcenter.dto.ExamResultDTO;

import java.sql.SQLException;

public interface TeacherDashboardBO extends SuperBO {
    public boolean addExam(ExamDTO dto) throws SQLException, ClassNotFoundException;
    public ExamDTO getAllExam(String code) throws SQLException, ClassNotFoundException;
    public boolean updateExam(ExamDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteExam(String id) throws SQLException, ClassNotFoundException;

    public boolean addExamResult(ExamResultDTO dto) throws SQLException, ClassNotFoundException;
    public ExamResultDTO getAllExamResult(String code) throws SQLException, ClassNotFoundException;
    public boolean updateExamResult(ExamResultDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteExamResult(String id) throws SQLException, ClassNotFoundException;

    public String getCountsExam() throws SQLException, ClassNotFoundException;
    public String getCountsExamResult() throws SQLException, ClassNotFoundException;
}
