package lk.ijse.apexeducationcenter.bo.custom.impl;

import lk.ijse.apexeducationcenter.bo.custom.AdminDashboardBO;
import lk.ijse.apexeducationcenter.dao.DAOFactory;
import lk.ijse.apexeducationcenter.dao.custom.BatchDAO;
import lk.ijse.apexeducationcenter.dao.custom.CourseDAO;
import lk.ijse.apexeducationcenter.dao.custom.SubjectDAO;
import lk.ijse.apexeducationcenter.dto.BatchDTO;
import lk.ijse.apexeducationcenter.dto.CourseDTO;
import lk.ijse.apexeducationcenter.dto.SubjectDTO;
import lk.ijse.apexeducationcenter.entity.Batch;
import lk.ijse.apexeducationcenter.entity.Course;
import lk.ijse.apexeducationcenter.entity.Subject;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDashboardBOImpl implements AdminDashboardBO {

    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.COURSE);
    BatchDAO batchDAO = (BatchDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BATCH);
    SubjectDAO subjectDAO = (SubjectDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.SUBJECT);

    @Override
    public boolean addCourse(CourseDTO dto) throws SQLException, ClassNotFoundException {
        return courseDAO.add(new Course(dto.getCrsId(), dto.getCrsName(), dto.getDuration(), dto.getCrsFee()));
    }

    @Override
    public CourseDTO getAllCourse(String code) throws SQLException, ClassNotFoundException {
        Course search =courseDAO.search(code);
        return new CourseDTO(search.getCrsId(),search.getCrsName(),search.getDuration(),search.getCrsFee());
    }

    @Override
    public boolean updateCourse(CourseDTO dto) throws SQLException, ClassNotFoundException {
        return courseDAO.update(new Course(dto.getCrsId(), dto.getCrsName(), dto.getDuration(), dto.getCrsFee()));
    }

    @Override
    public boolean deleteCourse(String id) throws SQLException, ClassNotFoundException {
        return courseDAO.delete(id);
    }

    @Override
    public boolean addBatch(BatchDTO dto) throws SQLException, ClassNotFoundException {
        return batchDAO.add(new Batch(dto.getBatchId(), dto.getBatchName(), dto.getCrsId(), dto.getBatchYear(), dto.getBatchSeats()));
    }

    @Override
    public BatchDTO getAllBatch(String code) throws SQLException, ClassNotFoundException {
        Batch batch = batchDAO.search(code);
        return new BatchDTO(batch.getBatchId(), batch.getBatchName(), batch.getCrsId(), batch.getBatchYear(), batch.getBatchSeats());
    }

    @Override
    public boolean updateBatch(BatchDTO dto) throws SQLException, ClassNotFoundException {
        return batchDAO.update(new Batch(dto.getBatchId(), dto.getBatchName(), dto.getCrsId(), dto.getBatchYear(), dto.getBatchSeats()));
    }

    @Override
    public boolean deleteBatch(String id) throws SQLException, ClassNotFoundException {
        return batchDAO.delete(id);
    }

    @Override
    public boolean addSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException {
        return subjectDAO.add(new Subject(dto.getSubjectId(), dto.getSubjectName(), dto.getSubjectCrsId()));
    }

    @Override
    public SubjectDTO getAllSubject(String code) throws SQLException, ClassNotFoundException {
        Subject subject = subjectDAO.search(code);
        return new SubjectDTO(subject.getSubjectId(), subject.getSubjectName(), subject.getSubjectCrsId());
    }

    @Override
    public boolean updateSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException {
        return subjectDAO.update(new Subject(dto.getSubjectId(), dto.getSubjectName(), dto.getSubjectCrsId()));
    }

    @Override
    public boolean deleteSubject(String id) throws SQLException, ClassNotFoundException {
        return subjectDAO.delete(id);
    }

    @Override
    public ArrayList<String> loadCourseIds() throws SQLException, ClassNotFoundException {
        return courseDAO.loadIds();
    }

    @Override
    public String getCountsCourse() throws SQLException, ClassNotFoundException {
        return courseDAO.getCounts();
    }

    @Override
    public String getCountsBatch() throws SQLException, ClassNotFoundException {
        return batchDAO.getCounts();
    }

    @Override
    public String getCountsSubject() throws SQLException, ClassNotFoundException {
        return subjectDAO.getCounts();
    }
}
