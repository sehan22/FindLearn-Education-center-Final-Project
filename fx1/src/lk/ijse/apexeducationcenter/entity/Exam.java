package lk.ijse.apexeducationcenter.entity;

public class Exam {
    private String examId;
    private String examDetails;
    private int examDuration;
    private String batchId;
    private String subjectId;

    public Exam() {
    }

    public Exam(String examId, String examDetails, int examDuration, String batchId, String subjectId) {
        this.examId = examId;
        this.examDetails = examDetails;
        this.examDuration = examDuration;
        this.batchId = batchId;
        this.subjectId = subjectId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamDetails() {
        return examDetails;
    }

    public void setExamDetails(String examDetails) {
        this.examDetails = examDetails;
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId='" + examId + '\'' +
                ", examDetails='" + examDetails + '\'' +
                ", examDuration=" + examDuration +
                ", batchId='" + batchId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                '}';
    }
}
