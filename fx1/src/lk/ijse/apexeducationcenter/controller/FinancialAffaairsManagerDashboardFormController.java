package lk.ijse.apexeducationcenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.apexeducationcenter.bo.BOFactory;
import lk.ijse.apexeducationcenter.bo.custom.FinancialAffairsDashboardBO;
import lk.ijse.apexeducationcenter.db.DBConnection;
import lk.ijse.apexeducationcenter.dto.*;
import lk.ijse.apexeducationcenter.entity.CoursePayment;
import lk.ijse.apexeducationcenter.entity.EmployeeSalary;
import lk.ijse.apexeducationcenter.entity.TeacherSalary;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class FinancialAffaairsManagerDashboardFormController {
    public AnchorPane SecPaneContext;
    public AnchorPane secPaneContexct;
    public AnchorPane courseManageContextPaneContext;
    public Label lblTopic;
    public AnchorPane viewStaticsPaneContext;
    public Label lblTopic1;
    public AnchorPane viewStaticsPaneContext1;
    public Label lblTopic11;
    public TableView tblViewAllCourses1;
    public Label lblTopic111;
    public AnchorPane paymentDetailsPaneContext;
    public AnchorPane mainPaneContext;
    public JFXButton btnPayments;
    public AnchorPane teacherSalaryContextPane;
    public AnchorPane employeeSalaryContextPane;
    public Label lblTopic121;
    public JFXTextField txtEmployeeSalaryValue;
    public Label lblnextTeacherSalaryId;
    public AnchorPane updatePaneContext;
    public TableView tblViewAllEmployeeSalary;
    public TableColumn colEmployeeSalaryId;
    public TableColumn colEmployeeId;
    public TableColumn colEmployeeDate;
    public TableColumn colEmployeeSalaryValue;
    public Label lblEmployeeSalaryId;
    public Label lblEmployeeSalaryDate;
    public Label lblCommand;
    public TableView tblViewAllTeacherSalary;
    public TableColumn colTeacherSalaryId;
    public TableColumn colTeacherId;
    public TableColumn colTeacherDate;
    public TableColumn colTeacherValue;
    public Label lblResultId;
    public JFXTextField txtTeacherSalaryValue;
    public Label lblTeacherSalaryPayDate;
    public JFXTextField txtUpdateEmployeeId;
    public JFXTextField txtUpdateEmployeeSalaryPayDate;
    public Label lblUpdateEmployeeSalaryId;
    public JFXTextField txtUpdateEmployeeSalaryValue;
    public JFXTextField txtSearchEmployeeSalaryId;
    public JFXTextField txtSearchTeacherSalaryId;
    public JFXTextField txtUpdateTeacherId;
    public JFXTextField txtUpdateTeacherSalaryPayDate;
    public JFXTextField txtUpdateTeacherSalaryValue;
    public Label lblUpdateTeacherSalaryId;
    public AnchorPane updateEmployeeSalaryContextPane;
    public AnchorPane updateTeacherSalaryContextPane;
    public JFXComboBox cmbTeacherIds;
    public JFXTextField txtLoadTeacherName;
    public JFXTextField txtLoadEmployeeName;
    public JFXComboBox cmbEmployeeIds;
    public Label lblPaymentId;
    public Label lblPaymentDate;
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtBatchName;
    public JFXTextField txtBatchId;
    public JFXTextField txtCourseId;
    public JFXTextField txtCourseName;
    public JFXTextField txtCourseFees;
    public JFXTextField txtAvailableSeats;
    public TableView tblCoursePayment;
    public TableColumn colPaymentId;
    public TableColumn colBatchId;
    public TableColumn colCourseId;
    public TableColumn colCourseFees;
    public Label lblTopic1211;
    FinancialAffairsDashboardBO financialAffairsDashboardBO = (FinancialAffairsDashboardBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.FINANCIAL);

    public void initialize(){
        getNextEmployeeSalaryId();
        getNextTeacherSalaryId();
        getNextCoursePaymentId();

        setTeacherPaymentDate();
        setEmployeePaymentDate();
        setCoursePaymentDate();

        colEmployeeSalaryId.setCellValueFactory(new PropertyValueFactory<>("empSalaryId"));
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colEmployeeDate.setCellValueFactory(new PropertyValueFactory<>("empSalaryPayDate"));
        colEmployeeSalaryValue.setCellValueFactory(new PropertyValueFactory<>("empSalaryValue"));
        getAllEmployeeSalary();

        colTeacherSalaryId.setCellValueFactory(new PropertyValueFactory<>("teacherSalaryId"));
        colTeacherId.setCellValueFactory(new PropertyValueFactory<>("teacherId"));
        colTeacherDate.setCellValueFactory(new PropertyValueFactory<>("teacherSalaryPayDate"));
        colTeacherValue.setCellValueFactory(new PropertyValueFactory<>("teacherSalaryValue"));
        getAllTeacherSalary();

        colPaymentId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        colBatchId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colCourseFees.setCellValueFactory(new PropertyValueFactory<>("courseFees"));
        getAllCoursePayment();

        loadTeacherIds();
        loadEmployeeIds();
    }


    private void closeStage(AnchorPane paneId) {
        Stage stage = (Stage) paneId.getScene().getWindow();
        stage.close();
    }
    private void loadFxmlToStage(String fxmlFileName) throws IOException {
        String URL = "/lk/ijse/apexeducationcenter/view/";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(URL + fxmlFileName + ".fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.initStyle(StageStyle.UNDECORATED);
        stage1.show();
    }
    private void makeFadeOutInTransition(AnchorPane anchorPane , String fxmlName) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(0.2));
        fadeTransition.setNode(anchorPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished((ActionEvent event) ->{
            try {
                closeStage(anchorPane);
                loadFxmlToStage(fxmlName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        fadeTransition.play();
    }
    private void makeFadeOutInClose(AnchorPane paneId) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(0.2));
        fadeTransition.setNode(paneId);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished((ActionEvent event) ->{
            closeStage(paneId);
            System.exit(0);
        });

        fadeTransition.play();
    }


    public void MouseEnterOnAction(MouseEvent mouseEvent) {
    }


    public void viewTeacherSalaryOnAction(ActionEvent event) {
        if (true) {
            teacherSalaryContextPane.setVisible(true);

            employeeSalaryContextPane.setVisible(false);
            courseManageContextPaneContext.setVisible(false);
            viewStaticsPaneContext.setVisible(false);
            paymentDetailsPaneContext.setVisible(false);
            updatePaneContext.setVisible(false);

            setTeacherPaymentDate();
        }
    }
    public void viewEmployeeSalaryOnAction(ActionEvent event) {
        if (true) {
            employeeSalaryContextPane.setVisible(true);

            teacherSalaryContextPane.setVisible(false);
            courseManageContextPaneContext.setVisible(false);
            viewStaticsPaneContext.setVisible(false);
            paymentDetailsPaneContext.setVisible(false);
            updatePaneContext.setVisible(false);

            setEmployeePaymentDate();

        }
    }
    public void paymentsOnAction(ActionEvent actionEvent) {
        if (true) {
            courseManageContextPaneContext.setVisible(true);

            viewStaticsPaneContext.setVisible(false);
            paymentDetailsPaneContext.setVisible(false);
            employeeSalaryContextPane.setVisible(false);
            teacherSalaryContextPane.setVisible(false);
            updatePaneContext.setVisible(false);
        }
    }
    public void viewStaticsOnAction(ActionEvent actionEvent) {
        if (true) {
            viewStaticsPaneContext.setVisible(true);

            courseManageContextPaneContext.setVisible(false);
            paymentDetailsPaneContext.setVisible(false);
            employeeSalaryContextPane.setVisible(false);
            teacherSalaryContextPane.setVisible(false);
            updatePaneContext.setVisible(false);
        }
    }

    private void viewReportsPanes() throws IOException {
        String URL = "/lk/ijse/apexeducationcenter/view/";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/ijse/apexeducationcenter/view/ReportsForm.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.setX(700);
        stage1.setY(580);
        stage1.setScene(new Scene(root1));
        stage1.initStyle(StageStyle.UNDECORATED);
        stage1.show();
    }
    public void viewAllOnAction(ActionEvent actionEvent) throws IOException {
/*        if (true) {
            paymentDetailsPaneContext.setVisible(true);

            viewStaticsPaneContext.setVisible(false);
            courseManageContextPaneContext.setVisible(false);
            employeeSalaryContextPane.setVisible(false);
            teacherSalaryContextPane.setVisible(false);
            updatePaneContext.setVisible(false);
        }*/

        viewReportsPanes();

    }
    public void updateOnAction(ActionEvent actionEvent) {
        if (true) {
            updatePaneContext.setVisible(true);

            paymentDetailsPaneContext.setVisible(false);
            viewStaticsPaneContext.setVisible(false);
            courseManageContextPaneContext.setVisible(false);
            employeeSalaryContextPane.setVisible(false);
            teacherSalaryContextPane.setVisible(false);

        }
    }
    public void updateTeacherSalaryOnAction(ActionEvent event) {
        if (true) {
            updateTeacherSalaryContextPane.setVisible(true);
            updateEmployeeSalaryContextPane.setVisible(false);
            lblCommand.setVisible(false);
        }
    }
    public void updateEmployeeSalaryOnAction(ActionEvent event) {
        if (true) {
            updateEmployeeSalaryContextPane.setVisible(true);
            updateTeacherSalaryContextPane.setVisible(false);
            lblCommand.setVisible(false);
        }
    }
    public void logOutOnAction(ActionEvent actionEvent) {
        makeFadeOutInTransition(mainPaneContext , "ApexLoginForm");
    }

    public void exitOnAction(ActionEvent actionEvent) {
        makeFadeOutInClose(mainPaneContext);
    }



    private void setTeacherPaymentDate() {
        LocalDate date = LocalDate.now();
        lblTeacherSalaryPayDate.setText(String.valueOf(date));
    }
    private void setEmployeePaymentDate() {
        LocalDate date = LocalDate.now();
        lblEmployeeSalaryDate.setText(String.valueOf(date));
    }
    private void setCoursePaymentDate() {
        LocalDate date = LocalDate.now();
        lblPaymentDate.setText(String.valueOf(date));
    }
    private void getNextEmployeeSalaryId() {
        try {
            String employeeSalaryId = financialAffairsDashboardBO.generateNextEmployeeSalaryId();
            lblEmployeeSalaryId.setText(employeeSalaryId);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    private void getNextTeacherSalaryId() {
        try {
            String teacherSalaryId = financialAffairsDashboardBO.generateNextTeacherSalaryId();
            lblnextTeacherSalaryId.setText(teacherSalaryId);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    private void getNextCoursePaymentId() {
        try {
            String coursePaymentId = financialAffairsDashboardBO.generateNewPaymentID();
            lblPaymentId.setText(coursePaymentId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void payTeacherSalaryOnAction(ActionEvent event) {
        String teacherSalaryId = lblnextTeacherSalaryId.getText();
        String teacherId = String.valueOf(cmbTeacherIds.getValue());
        String teacherSalaryPayDate = lblTeacherSalaryPayDate.getText();
        double teacherSalaryValue = Double.parseDouble(txtTeacherSalaryValue.getText());

        TeacherSalaryDTO teacherSalary = new TeacherSalaryDTO(teacherSalaryId , teacherId , teacherSalaryPayDate , teacherSalaryValue);
        try {
            boolean isAdded = financialAffairsDashboardBO.addTeacherSalary(teacherSalary);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION , "Teacher Salary Details Added Successfuly!").show();
                getAllTeacherSalary();
            } else {
                new Alert(Alert.AlertType.ERROR , "Error").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void searchTeacherSalaryDetailsOnAction(ActionEvent event) {
        String salaryId = txtSearchTeacherSalaryId.getText();

        try {
            TeacherSalaryDTO teacherSalary = financialAffairsDashboardBO.getAllTeacherSalary(salaryId);

            lblUpdateTeacherSalaryId.setText(teacherSalary.getTeacherSalaryId());
            txtUpdateTeacherId.setText(teacherSalary.getTeacherId());
            txtUpdateTeacherSalaryPayDate.setText(teacherSalary.getTeacherSalaryPayDate());
            txtUpdateTeacherSalaryValue.setText(String.valueOf(teacherSalary.getTeacherSalaryValue()));

            getAllTeacherSalary();

        } catch (SQLException e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void updateTeacherSalaryDetailsOnAction(ActionEvent event) {
        String salaryId = lblUpdateTeacherSalaryId.getText();
        String teacherId = txtUpdateTeacherId.getText();
        String salarPayDate = txtUpdateTeacherSalaryPayDate.getText();
        double salaryValue = Double.parseDouble(txtUpdateTeacherSalaryValue.getText());

        TeacherSalaryDTO teacherSalary = new TeacherSalaryDTO(salaryId , teacherId , salarPayDate , salaryValue);

        try {
            boolean isUpdated = financialAffairsDashboardBO.updateTeacherSalary(teacherSalary);

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION , "Update Teacher Salary Details Successfuly!").show();
                getAllTeacherSalary();
            } else {
                new Alert(Alert.AlertType.ERROR , "Error").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void deleteTeacherSalaryDtailsOnAction(ActionEvent event) {
        String salaryId = lblUpdateTeacherSalaryId.getText();
        try {
            boolean isDelete = financialAffairsDashboardBO.deleteTeacherSalary(salaryId);
            if(isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Teacher Salary Details Details Successfully!").show();
                getAllTeacherSalary();
            } else {
                new Alert(Alert.AlertType.WARNING, "Error!").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void getAllTeacherSalary(){
        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM teachersalary");
            ResultSet allSalary = statement.executeQuery();

            while (allSalary.next()){
                data.add(new TeacherSalary(allSalary.getString(1) , allSalary.getString(2) , allSalary.getString(3)
                        ,allSalary.getDouble(4)));
            }

        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblViewAllTeacherSalary.setItems(data);
    }


    public void payEmployeeSalaryOnAction(ActionEvent event) {
        String employeeSalaryId = lblEmployeeSalaryId.getText();
        String employeeId = String.valueOf(cmbEmployeeIds.getValue());
        String employeeSalaryPayDate = lblEmployeeSalaryDate.getText();
        double employeeSalaryValue = Double.parseDouble(txtEmployeeSalaryValue.getText());

        EmployeeSalaryDTO employeeSalary = new EmployeeSalaryDTO(employeeSalaryId , employeeId
                , employeeSalaryPayDate , employeeSalaryValue);
        try {
            boolean isAdded = financialAffairsDashboardBO.addEmployeeSalary(employeeSalary);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION , "Employee Salary Details Added Successfuly!").show();
                getAllEmployeeSalary();
            } else {
                new Alert(Alert.AlertType.ERROR , "Error").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void searchEmployeeSalaryDetailsOnAction(ActionEvent event) {
        String salaryId = txtSearchEmployeeSalaryId.getText();

        try {
            EmployeeSalaryDTO employeeSalary = financialAffairsDashboardBO.getAllEmployeeSalary(salaryId);

            lblUpdateEmployeeSalaryId.setText(employeeSalary.getEmpSalaryId());
            txtUpdateEmployeeId.setText(employeeSalary.getEmpId());
            txtUpdateEmployeeSalaryPayDate.setText(employeeSalary.getEmpSalaryPayDate());
            txtUpdateEmployeeSalaryValue.setText(String.valueOf(employeeSalary.getEmpSalaryValue()));

            getAllEmployeeSalary();

        } catch (SQLException e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void updateEmployeeSalaryDetailsOnAction(ActionEvent event) {
        String salaryId = lblUpdateEmployeeSalaryId.getText();
        String employeeId = txtUpdateEmployeeId.getText();
        String salarPayDate = txtUpdateEmployeeSalaryPayDate.getText();
        double salaryValue = Double.parseDouble(txtUpdateEmployeeSalaryValue.getText());

        EmployeeSalaryDTO employeeSalary = new EmployeeSalaryDTO(salaryId , employeeId , salarPayDate , salaryValue);

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to update this subject?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isUpdated = financialAffairsDashboardBO.updateEmployeeSalary(employeeSalary);

                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION , "Update Employee Salary Details Successfuly!").show();
                    getAllEmployeeSalary();
                } else {
                    new Alert(Alert.AlertType.ERROR , "Somthing Went Wrong.Please Try Again!").show();
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void deleteEmployeeSalaryDetailsOnAction(ActionEvent event) {
        String batchId = lblUpdateEmployeeSalaryId.getText();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to update this subject?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isDelete = financialAffairsDashboardBO.deleteEmployeeSalary(batchId);

                if(isDelete) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Delete Employee Salary Details Details Successfully!").show();
                    getAllEmployeeSalary();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Somthing Went Wrong.Please Try Again!").show();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void getAllEmployeeSalary(){
        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM employeesalary");
            ResultSet allSalary = statement.executeQuery();

            while (allSalary.next()){
                data.add(new EmployeeSalary(allSalary.getString(1) , allSalary.getString(2) , allSalary.getString(3)
                        ,allSalary.getDouble(4)));
            }

        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblViewAllEmployeeSalary.setItems(data);
    }


    public void selectTeacherIdsOnAction(ActionEvent event) {
        loadTeacherNames();
    }
    private void loadTeacherIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> teacherIdsList = financialAffairsDashboardBO.loadTeacherIds();

            for (String teacherId : teacherIdsList) {
                observableList.add(teacherId);
            }
            cmbTeacherIds.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadEmployeeIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> employeeIdsList = financialAffairsDashboardBO.loadEmployeeIds();

            for (String employeeId : employeeIdsList) {
                observableList.add(employeeId);
            }
            cmbEmployeeIds.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadEmployeeNames() {
        String ids = String.valueOf(cmbEmployeeIds.getValue());
        try {
            EmployeeDTO employee = financialAffairsDashboardBO.searchEmployeeNames(ids);
            txtLoadEmployeeName.setText(employee.getEmployeeName());
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    private void loadTeacherNames() {
        String ids = String.valueOf(cmbTeacherIds.getValue());
        try {
            TeacherDTO teacher = financialAffairsDashboardBO.searchTeacherNames(ids);
            txtLoadTeacherName.setText(teacher.getTeacherName());
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    private void loadStudentNames() {
        String studentId = txtStudentId.getText();

        try {
            StudentDTO student = financialAffairsDashboardBO.searchStudentNames(studentId);
            txtStudentName.setText(student.getStName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadBatchNames() {
        String batchBatch = txtBatchId.getText();

        try {

            BatchDTO batch = financialAffairsDashboardBO.searchBatchNames(batchBatch);
            txtBatchName.setText(batch.getBatchName());
            txtAvailableSeats.setText(String.valueOf(batch.getBatchSeats()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadCourseNames() {
        String courseName = txtCourseId.getText();

        try {
            CourseDTO course = financialAffairsDashboardBO.searchCourseNames(courseName);
            txtCourseName.setText(course.getCrsName());
            txtCourseFees.setText(String.valueOf(course.getCrsFee()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void selectEmployeeIdsOnAction(ActionEvent event) {
        loadEmployeeNames();
    }
    public void loadStudentNameOnAction(ActionEvent actionEvent) {
        loadStudentNames();
    }
    public void loadBatchNameOnAction(ActionEvent actionEvent) {
        loadBatchNames();
    }
    public void loadCourseNameOnAction(ActionEvent actionEvent) {
        loadCourseNames();
    }

    public void payCourseOnAction(ActionEvent actionEvent) {
        CoursePaymentDTO coursePayment = new CoursePaymentDTO(lblPaymentId.getText(), txtStudentId.getText(), txtCourseId.getText(), Double.valueOf(txtCourseFees.getText()));

        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);

            boolean isUpdateBatchSeat = financialAffairsDashboardBO.DecSeat(txtBatchId.getText());
            if(isUpdateBatchSeat){

                boolean isUpdateCoursePayment = financialAffairsDashboardBO.addPayment(coursePayment);

                if(isUpdateCoursePayment){
                    String stId = txtStudentId.getText();
                    String batchId = txtBatchId.getText();

                    StudentBatchDTO studentBatch = new StudentBatchDTO(stId , batchId);

                    boolean isUpdateStudentBatch = financialAffairsDashboardBO.add(studentBatch);

                    if(isUpdateStudentBatch){
                        System.out.println("Done");
                        getAllCoursePayment();
                        DBConnection.getInstance().getConnection().commit();
                        new Alert(Alert.AlertType.INFORMATION , "Course Payment Successfully!").show();
                        clearTextField();
                        getNextCoursePaymentId();
                        setCoursePaymentDate();
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
        } catch (SQLException e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR , "Duplicate Entry, Check Your IDs").show();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void getAllCoursePayment() {
        ObservableList coursePayments = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM payment");
            ResultSet allCoursePayment = statement.executeQuery();

            while (allCoursePayment.next()){
                coursePayments.add(new CoursePayment(allCoursePayment.getString(1), allCoursePayment.getString(2),
                        allCoursePayment.getString(3), allCoursePayment.getDouble(4)));
            }

        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblCoursePayment.setItems(coursePayments);
    }

    private void clearTextField() {
        lblPaymentDate.setText("");
        lblPaymentId.setText("");
        txtAvailableSeats.clear();
        txtCourseFees.clear();
        txtCourseName.clear();
        txtCourseId.clear();
        txtBatchName.clear();
        txtBatchId.clear();
        txtStudentName.clear();
        txtStudentId.clear();
    }
}
