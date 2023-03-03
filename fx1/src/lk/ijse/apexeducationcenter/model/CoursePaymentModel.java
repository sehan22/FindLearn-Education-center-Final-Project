package lk.ijse.apexeducationcenter.model;

import lk.ijse.apexeducationcenter.to.CoursePayment;
import lk.ijse.apexeducationcenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoursePaymentModel {
    public static String generateNextPaymentMethod() throws SQLException, ClassNotFoundException {
        String sql = "SELECT PayId FROM payment ORDER BY PayId DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);

        if (resultSet.next()) {
            return generateNextCoursePaymentId(resultSet.getString(1));
        }
        return generateNextCoursePaymentId(resultSet.getString(null));
    }

    private static String generateNextCoursePaymentId(String currentCoursePaymentd) {
        if (currentCoursePaymentd!=null){
            String[] split = currentCoursePaymentd.split("P00");
            int id = Integer.parseInt(split[1]);
            id +=1;
            return "P00"+id;
        }
        return "O001";
    }

    public static boolean addPayment(CoursePayment coursePayment) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO payment VALUES (?, ?, ?, ?)";

        return CrudUtil.execute(sql, coursePayment.getPaymentId(), coursePayment.getStudentId(), coursePayment.getCourseId(), coursePayment.getCourseFees());
    }
}
