package lk.ijse.apexeducationcenter.entity;

public class ExamResult {
    private String rstId;
    private String discription;
    private int mark;
    private String examId;
    private String stId;

    public ExamResult() {
    }

    public ExamResult(String rstId, String discription, int mark, String examId, String stId) {
        this.rstId = rstId;
        this.discription = discription;
        this.mark = mark;
        this.examId = examId;
        this.stId = stId;
    }

    public String getRstId() {
        return rstId;
    }

    public void setRstId(String rstId) {
        this.rstId = rstId;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "rstId='" + rstId + '\'' +
                ", discription='" + discription + '\'' +
                ", mark=" + mark +
                ", examId='" + examId + '\'' +
                ", stId='" + stId + '\'' +
                '}';
    }
}
