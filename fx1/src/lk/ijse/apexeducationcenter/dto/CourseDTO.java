package lk.ijse.apexeducationcenter.dto;

public class CourseDTO {
    private String crsId;
    private String crsName;
    private int duration;

    private double crsFee;

    public CourseDTO() {
    }

    public CourseDTO(String crsId, String crsName, int duration, double crsFee) {
        this.crsId = crsId;
        this.crsName = crsName;
        this.duration = duration;
        this.crsFee = crsFee;
    }

    public CourseDTO(String crsName) {
        this.crsName = crsName;
    }

    public String getCrsId() {
        return crsId;
    }

    public void setCrsId(String crsId) {
        this.crsId = crsId;
    }

    public String getCrsName() {
        return crsName;
    }

    public void setCrsName(String crsName) {
        this.crsName = crsName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getCrsFee() {
        return crsFee;
    }

    public void setCrsFee(double crsFee) {
        this.crsFee = crsFee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "crsId='" + crsId + '\'' +
                ", crsName='" + crsName + '\'' +
                ", duration=" + duration +
                '}';
    }
}
