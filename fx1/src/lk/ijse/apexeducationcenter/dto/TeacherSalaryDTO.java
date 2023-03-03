package lk.ijse.apexeducationcenter.dto;

import java.io.Serializable;

public class TeacherSalaryDTO implements Serializable {
    private String teacherSalaryId;
    private String teacherId;
    private String teacherSalaryPayDate;
    private double teacherSalaryValue;

    public TeacherSalaryDTO() {
    }

    public TeacherSalaryDTO(String teacherSalaryId, String teacherId, String teacherSalaryPayDate, double teacherSalaryValue) {
        this.teacherSalaryId = teacherSalaryId;
        this.teacherId = teacherId;
        this.teacherSalaryPayDate = teacherSalaryPayDate;
        this.teacherSalaryValue = teacherSalaryValue;
    }

    public String getTeacherSalaryId() {
        return teacherSalaryId;
    }

    public void setTeacherSalaryId(String teacherSalaryId) {
        this.teacherSalaryId = teacherSalaryId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherSalaryPayDate() {
        return teacherSalaryPayDate;
    }

    public void setTeacherSalaryPayDate(String teacherSalaryPayDate) {
        this.teacherSalaryPayDate = teacherSalaryPayDate;
    }

    public double getTeacherSalaryValue() {
        return teacherSalaryValue;
    }

    public void setTeacherSalaryValue(double teacherSalaryValue) {
        this.teacherSalaryValue = teacherSalaryValue;
    }

    @Override
    public String toString() {
        return "TeacherSalary{" +
                "teacherSalaryId='" + teacherSalaryId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", teacherSalaryPayDate='" + teacherSalaryPayDate + '\'' +
                ", teacherSalaryValue=" + teacherSalaryValue +
                '}';
    }
}
