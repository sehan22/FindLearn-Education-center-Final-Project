package lk.ijse.apexeducationcenter.dao;

import lk.ijse.apexeducationcenter.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType {
        BATCH,COURSE,COURSEPAYMENT,EMPLOYEE,EMPLOYEESALARY,EXAM,EXAMRESULT,QUERY_DAO,STUDENTBATCH,STUDENT,SUBJECT,TEACHER,TEACHERSALARY
    }

    public SuperDAO getDAO(DAOType daoType){
        switch (daoType) {
            case BATCH:
                return new BatchDAOImpl();
            case COURSE:
                return new CourseDAOImpl();
            case COURSEPAYMENT:
                return new CoursePaymentDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case EMPLOYEESALARY:
                return new EmployeeSalaryDAOImpl();
            case EXAM:
                return new ExamDAOImpl();
            case EXAMRESULT:
                return new ExamResultDAOImpl();
            case QUERY_DAO:
                return new QuaryDAOImpl();
            case STUDENTBATCH:
                return new StudentBatchDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case SUBJECT:
                return new SubjectDAOImpl();
            case TEACHER:
                return new TeacherDAOImpl();
            case TEACHERSALARY:
                return new TeacherSalaryDAOImpl();
            default:
                return null;
        }
    }
}

