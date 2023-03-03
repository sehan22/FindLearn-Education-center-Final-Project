package lk.ijse.apexeducationcenter.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.apexeducationcenter.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportsFormController {
    public AnchorPane reportsPaneContext;

    public void viewTeacherSalaryReportOnAction(ActionEvent event) {
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/apexeducationcenter/reports/teacherSalary.jrxml");

        HashMap<String , Object> hm = new HashMap<>();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport , hm , DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint , false);
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewEmployeeSplaryReportOnAction(ActionEvent event) {
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/apexeducationcenter/reports/employee.jrxml");

        HashMap<String , Object> hm = new HashMap<>();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport , hm , DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint , false);
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewPaymentReportOnAction(ActionEvent event) {
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/apexeducationcenter/reports/payment.jrxml");

        HashMap<String , Object> hm = new HashMap<>();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport , hm , DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint , false);
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeOnAction(ActionEvent event) {
        Stage stage = (Stage) reportsPaneContext.getScene().getWindow();
        stage.close();

    }
}
