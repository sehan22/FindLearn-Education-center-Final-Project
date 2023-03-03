package lk.ijse.apexeducationcenter.dto;

import java.io.Serializable;

public class TeacherDTO implements Serializable {
    private String TeacherId;
    private String TeacherName;
    private String TeahcerAddress;
    private int PhoneNumber;

    private String teacherEmail;

    public TeacherDTO() {
    }

    public TeacherDTO(String teacherId, String teacherName, String teahcerAddress, int phoneNumber, String teacherEmail) {
        this.TeacherId = teacherId;
        this.TeacherName = teacherName;
        this.TeahcerAddress = teahcerAddress;
        this.PhoneNumber = phoneNumber;
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getTeahcerAddress() {
        return TeahcerAddress;
    }

    public void setTeahcerAddress(String teahcerAddress) {
        TeahcerAddress = teahcerAddress;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "TeacherId='" + TeacherId + '\'' +
                ", TeacherName='" + TeacherName + '\'' +
                ", TeahcerAddress='" + TeahcerAddress + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                '}';
    }
}
