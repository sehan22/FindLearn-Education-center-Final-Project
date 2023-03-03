package lk.ijse.apexeducationcenter.to;

public class CoursePayment {
    private String paymentId;
    private String studentId;
    private String courseId;
    private double courseFees;

    public CoursePayment() {
    }

    public CoursePayment(String paymentId, String studentId, String courseId, double courseFees) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.courseFees = courseFees;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public double getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(double courseFees) {
        this.courseFees = courseFees;
    }
}
