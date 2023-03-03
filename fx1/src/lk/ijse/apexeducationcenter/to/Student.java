package lk.ijse.apexeducationcenter.to;

import java.util.Date;

public class Student {
    private String stId;
    private String stName;
    private String stAddress;
    private String stDob;
    private int stNumber;
    private String stEmail;

    public Student() {
    }

    public Student(String stId, String stName, String stAddress, String stDob, int stNumber, String stEmail) {
        this.stId = stId;
        this.stName = stName;
        this.stAddress = stAddress;
        this.stDob = stDob;
        this.stNumber = stNumber;
        this.stEmail = stEmail;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStAddress() {
        return stAddress;
    }

    public void setStAddress(String stAddress) {
        this.stAddress = stAddress;
    }

    public String getStDob() {
        return stDob;
    }

    public void setStDob(String stDob) {
        this.stDob = stDob;
    }

    public int getStNumber() {
        return stNumber;
    }

    public void setStNumber(int stNumber) {
        this.stNumber = stNumber;
    }

    public String getStEmail() {
        return stEmail;
    }

    public void setStEmail(String stEmail) {
        this.stEmail = stEmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stId='" + stId + '\'' +
                ", stName='" + stName + '\'' +
                ", stAddress='" + stAddress + '\'' +
                ", stDob='" + stDob + '\'' +
                ", stNumber=" + stNumber +
                '}';
    }
}
