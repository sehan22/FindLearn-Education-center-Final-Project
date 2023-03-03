package lk.ijse.apexeducationcenter.bo.custom.impl;

import lk.ijse.apexeducationcenter.bo.custom.TeacherDashboardBO;
import lk.ijse.apexeducationcenter.dao.DAOFactory;
import lk.ijse.apexeducationcenter.dao.custom.ExamDAO;
import lk.ijse.apexeducationcenter.dao.custom.ExamResultDAO;
import lk.ijse.apexeducationcenter.dto.ExamDTO;
import lk.ijse.apexeducationcenter.dto.ExamResultDTO;
import lk.ijse.apexeducationcenter.entity.Exam;
import lk.ijse.apexeducationcenter.entity.ExamResult;

import java.sql.SQLException;

public class TeacherDashboardBOImpl implements TeacherDashboardBO {

    ExamDAO examDAO = (ExamDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.EXAM);
    ExamResultDAO examResultDAO = (ExamResultDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.EXAMRESULT);

    @Override
    public boolean addExam(ExamDTO dto) throws SQLException, ClassNotFoundException {
        return examDAO.add(new Exam(dto.getExamId(), dto.getExamDetails(), dto.getExamDuration(), dto.getBatchId(), dto.getSubjectId()));
    }

    @Override
    public ExamDTO getAllExam(String code) throws SQLException, ClassNotFoundException {
        Exam exam = examDAO.search(code);
        return new ExamDTO(exam.getExamId(), exam.getExamDetails(), exam.getExamDuration(), exam.getBatchId(), exam.getSubjectId());
    }

    @Override
    public boolean updateExam(ExamDTO dto) throws SQLException, ClassNotFoundException {
        return examDAO.update(new Exam(dto.getExamId(), dto.getExamDetails(), dto.getExamDuration(), dto.getBatchId(), dto.getSubjectId()));
    }

    @Override
    public boolean deleteExam(String id) throws SQLException, ClassNotFoundException {
        return examDAO.delete(id);
    }

    @Override
    public boolean addExamResult(ExamResultDTO dto) throws SQLException, ClassNotFoundException {
        return examResultDAO.add(new ExamResult(dto.getRstId(), dto.getDiscription(), dto.getMark(), dto.getExamId(), dto.getStId()));
    }

    @Override
    public ExamResultDTO getAllExamResult(String code) throws SQLException, ClassNotFoundException {
        ExamResult examResult = examResultDAO.search(code);
        return new ExamResultDTO(examResult.getRstId(), examResult.getDiscription(), examResult.getMark(), examResult.getExamId(), examResult.getStId());
    }

    @Override
    public boolean updateExamResult(ExamResultDTO dto) throws SQLException, ClassNotFoundException {
        return examResultDAO.update(new ExamResult(dto.getRstId(), dto.getDiscription(), dto.getMark(), dto.getExamId(), dto.getStId()));
    }

    @Override
    public boolean deleteExamResult(String id) throws SQLException, ClassNotFoundException {
        return examResultDAO.delete(id);
    }

    @Override
    public String getCountsExam() throws SQLException, ClassNotFoundException {
        return examDAO.getCounts();
    }

    @Override
    public String getCountsExamResult() throws SQLException, ClassNotFoundException {
        return examResultDAO.getCounts();
    }
}
