package lk.ijse.apexeducationcenter.to;

public class Subject {
    private String subjectId;
    private String subjectName;
    private String subjectCrsId;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName, String subjectCrsId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCrsId = subjectCrsId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCrsId() {
        return subjectCrsId;
    }

    public void setSubjectCrsId(String subjectCrsId) {
        this.subjectCrsId = subjectCrsId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCrsId='" + subjectCrsId + '\'' +
                '}';
    }
}
