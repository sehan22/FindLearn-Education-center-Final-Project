package lk.ijse.apexeducationcenter.to;

public class StudentBatch {
    private String studentId;
    private String batchId;

    public StudentBatch() {
    }

    public StudentBatch(String studentId, String batchId) {
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
