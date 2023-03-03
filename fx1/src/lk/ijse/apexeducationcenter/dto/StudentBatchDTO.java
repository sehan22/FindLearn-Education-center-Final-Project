package lk.ijse.apexeducationcenter.dto;

import java.io.Serializable;

public class StudentBatchDTO implements Serializable {
    private String studentId;
    private String batchId;

    public StudentBatchDTO() {
    }

    public StudentBatchDTO(String studentId, String batchId) {
        this.studentId = studentId;
        this.batchId = batchId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }
}
