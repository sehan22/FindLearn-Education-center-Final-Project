package lk.ijse.apexeducationcenter.controller;

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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.apexeducationcenter.bo.BOFactory;
import lk.ijse.apexeducationcenter.bo.custom.HumanResourseManagerBO;
import lk.ijse.apexeducationcenter.db.DBConnection;
import lk.ijse.apexeducationcenter.dto.EmployeeDTO;
import lk.ijse.apexeducationcenter.dto.StudentDTO;
import lk.ijse.apexeducationcenter.dto.TeacherDTO;
import lk.ijse.apexeducationcenter.to.Employee;
import lk.ijse.apexeducationcenter.to.Student;
import lk.ijse.apexeducationcenter.to.Teacher;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HumanResourseManagerDashboardController {
    public AnchorPane secPaneContexct;
    public AnchorPane TeacherPaneContext;
    public AnchorPane studentPaneContext;
    public AnchorPane employeePaneContext;
    public Label lblTitle;
    public AnchorPane viewPaneContexct;
    public TableView tblViewAllCourses;
    public Label lblTitle1;
    public AnchorPane dashboardPaneContext;
    public AnchorPane mainPaneContext;
    public JFXTextField txtTeacherId;
    public JFXTextField txtTeacherName;
    public JFXTextField txtTeacherAddress;
    public JFXTextField txtTeacherTelephone;
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentDob;
    public JFXTextField txtStudentTelephone;
    public JFXTextField txtEmpId;
    public JFXTextField txtEmpName;
    public JFXTextField txtEmpAddress;
    public JFXTextField txtEmpDob;
    public JFXTextField txtEmpTelephone;
    public AnchorPane updatePaneContext;
    public AnchorPane updateTeacherContextPane;
    public AnchorPane updateStudentContextPane;
    public AnchorPane updateEmployeeContextPane1;
    public Label lblCommand;
    public JFXTextField txtTeacherEmail;
    public TableView tblViewAllTeacher;
    public TableColumn colTeacherId;
    public TableColumn colTeacherName;
    public TableColumn colTeacherAddress;
    public TableColumn colTeacherTelephone;
    public TableColumn colTeacherEmail;
    public Label lblCommand1;
    public AnchorPane updateEmployeeContextPane;
    public JFXTextField txtStudentEmail;
    public TableView tblViewAllStudents;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colStudentAddress;
    public TableColumn colStudentDob;
    public TableColumn colStudentTelephone;
    public TableColumn colStudentEmail;
    public TableView tblViewAllEmployee;
    public TableColumn colEmployeeId;
    public TableColumn colEmployeeName;
    public TableColumn colEmployeeAddress;
    public TableColumn colEmployeeTelephone;
    public TableColumn colEmployeeDob;
    public JFXTextField txtStudentTelephone1;
    public JFXTextField txtSearchTeacherId;
    public JFXTextField txtUpdateTeacherName;
    public JFXTextField txtUpdateTeacherAddress;
    public Label lblTeacherId;
    public JFXTextField txtUpdateTeacherTelephone;
    public JFXTextField txtUpdateTeacherEmail;
    public JFXTextField txtSearchStudentId;
    public JFXTextField txtUpdateStudentName;
    public JFXTextField txtUpdateStudentAddress;
    public Label lblStudentId;
    public JFXTextField txtUpdateStudentDob;
    public JFXTextField txtUpdateStudentTelephone;
    public JFXTextField txtUpdateStudentEmail;
    public JFXTextField txtUpdateEmployeeDob;
    public Label lblEmployeeId;
    public JFXTextField txtUpdateEmployeeName;
    public JFXTextField txtUpdateEmployeeAddress;
    public JFXTextField txtUpdateEmployeeTelephone;
    public JFXTextField txtSearchEmployeeId;
    public Label lblAllTeachers;
    public Label lblAllStudents;
    public Label lblAllEmployees;

    HumanResourseManagerBO humanResourseManagerBO = (HumanResourseManagerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.HUMANRESOURSE);

    public void initialize() {
        getTeachersCount();
        getEmployeesCount();
        getStudentsCount();

        colTeacherId.setCellValueFactory(new PropertyValueFactory<>("TeacherId"));
        colTeacherName.setCellValueFactory(new PropertyValueFactory<>("TeacherName"));
        colTeacherAddress.setCellValueFactory(new PropertyValueFactory<>("TeahcerAddress"));
        colTeacherTelephone.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        colTeacherEmail.setCellValueFactory(new PropertyValueFactory<>("teacherEmail"));
        getAllTeachers();

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("stId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("stName"));
        colStudentAddress.setCellValueFactory(new PropertyValueFactory<>("stAddress"));
        colStudentDob.setCellValueFactory(new PropertyValueFactory<>("stDob"));
        colStudentTelephone.setCellValueFactory(new PropertyValueFactory<>("stNumber"));
        colStudentEmail.setCellValueFactory(new PropertyValueFactory<>("stEmail"));
        getAllStudents();

        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colEmployeeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        colEmployeeDob.setCellValueFactory(new PropertyValueFactory<>("employeeDob"));
        colEmployeeAddress.setCellValueFactory(new PropertyValueFactory<>("employeeAddress"));
        colEmployeeTelephone.setCellValueFactory(new PropertyValueFactory<>("employeePhoneNumber"));
        getAllEmployees();
    }

    public void dashboardBoardOnAction(ActionEvent actionEvent) {
        if (true) {
            dashboardPaneContext.setVisible(true);

            TeacherPaneContext.setVisible(false);
            studentPaneContext.setVisible(false);
            employeePaneContext.setVisible(false);
            viewPaneContexct.setVisible(false);
            updatePaneContext.setVisible(false);
        }
    }

    public void teacherOnAction(ActionEvent actionEvent) {
        if (true) {
            TeacherPaneContext.setVisible(true);

            studentPaneContext.setVisible(false);
            employeePaneContext.setVisible(false);
            viewPaneContexct.setVisible(false);
            dashboardPaneContext.setVisible(false);
            updatePaneContext.setVisible(false);
        }
    }

    public void studentOnAction(ActionEvent actionEvent) {
        if (true) {
            studentPaneContext.setVisible(true);

            TeacherPaneContext.setVisible(false);
            employeePaneContext.setVisible(false);
            viewPaneContexct.setVisible(false);
            dashboardPaneContext.setVisible(false);
            updatePaneContext.setVisible(false);
        }
    }

    public void employeeOnAction(ActionEvent actionEvent) {
        if (true) {
            employeePaneContext.setVisible(true);

            studentPaneContext.setVisible(false);
            TeacherPaneContext.setVisible(false);
            viewPaneContexct.setVisible(false);
            dashboardPaneContext.setVisible(false);
            updatePaneContext.setVisible(false);
        }


    }

    public void logOutOnAction(ActionEvent actionEvent) {
        makeFadeOutInTransition(mainPaneContext , "ApexLoginForm");
    }

    public void exitOnAction(ActionEvent actionEvent) {
        makeFadeOutInClose(mainPaneContext);
    }

    public void viewAllOnAction(ActionEvent actionEvent) {
/*        if (true) {
            viewPaneContexct.setVisible(true);

            employeePaneContext.setVisible(false);
            studentPaneContext.setVisible(false);
            TeacherPaneContext.setVisible(false);
            dashboardPaneContext.setVisible(false);

        }*/

        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/apexeducationcenter/reports/student.jrxml");

        HashMap<String , Object> hm = new HashMap<>();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport , hm , DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint);
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        if (true) {
            updatePaneContext.setVisible(true);

            viewPaneContexct.setVisible(false);
            employeePaneContext.setVisible(false);
            studentPaneContext.setVisible(false);
            TeacherPaneContext.setVisible(false);
            dashboardPaneContext.setVisible(false);
        }
    }

    public void lblTopic(MouseEvent mouseEvent) {
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

    public void saveTeacherOnAction(ActionEvent event) {
        String teacherId = txtTeacherId.getText();
        String teacherName = txtTeacherName.getText();
        String teacherAddress = txtTeacherAddress.getText();
        int telNumber = Integer.parseInt(txtTeacherTelephone.getText());
        String teacherEmail = txtTeacherEmail.getText();

        //Teacher teacher  = new Teacher(teacherId , teacherName , teacherAddress , telNumber , teacherEmail);
        try {
            boolean isAdded = humanResourseManagerBO.addTeacher(new TeacherDTO(teacherId, teacherName, teacherAddress, telNumber, teacherEmail));

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION , "Teacher Details Added Successfuly!").show();
                getAllTeachers();
                getTeachersCount();
                clearTextFields();
            } else {
                new Alert(Alert.AlertType.ERROR , "Error").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void searchTeacherOnAction(ActionEvent event) {
        String teacherId = txtSearchTeacherId.getText();

        try {
            TeacherDTO teacher = humanResourseManagerBO.getAllTeacher(teacherId);

            lblTeacherId.setText(teacher.getTeacherId());
            txtUpdateTeacherName.setText(teacher.getTeacherName());
            txtUpdateTeacherAddress.setText(teacher.getTeahcerAddress());
            txtUpdateTeacherTelephone.setText(String.valueOf(teacher.getPhoneNumber()));
            txtUpdateTeacherEmail.setText(teacher.getTeacherEmail());

            getAllTeachers();

        } catch (SQLException e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void updateTeacherDetailsOnAction(ActionEvent event) {
        String teacherId = lblTeacherId.getText();
        String teacherName = txtUpdateTeacherName.getText();
        String teacherAddress = txtUpdateTeacherAddress.getText();
        int teacherTelephone = Integer.parseInt(txtUpdateTeacherTelephone.getText());
        String teacherEmail = txtUpdateTeacherEmail.getText();


        //Teacher teacher = new Teacher(teacherId , teacherName , teacherAddress , teacherTelephone , teacherEmail);

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to update this course?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isUpdated = humanResourseManagerBO.updateTeacher(new TeacherDTO(teacherId, teacherName, teacherAddress, teacherTelephone, teacherEmail));

                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION , "Update Teacher Details Successfuly!").show();
                    getAllTeachers();
                    clearUpdateTextFields();
                } else {
                    new Alert(Alert.AlertType.ERROR , "Error").show();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void deleteTeacherDetailsOnAction(ActionEvent event) {
        String teacherId = txtSearchTeacherId.getText();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to update this course?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isDelete = humanResourseManagerBO.deleteTeacher(teacherId);

                if(isDelete) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Delete Teacher Details Successfully!").show();
                    getAllTeachers();
                    getTeachersCount();
                    clearUpdateTextFields();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Error!").show();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveStudentOnAction(ActionEvent event) {
        String studentId = txtStudentId.getText();
        String studentName = txtStudentName.getText();
        String studentAddress = txtStudentAddress.getText();
        String studentDob = txtStudentDob.getText();
        int studentTelNumber = Integer.parseInt(txtStudentTelephone.getText());
        String studentEmail = txtStudentEmail.getText();

        //Student student = new Student(studentId , studentName , studentAddress , studentDob , studentTelNumber , studentEmail);

        StudentDTO student = new StudentDTO(studentId , studentName , studentAddress , studentDob , studentTelNumber , studentEmail);
        try {
            //boolean isAdded = humanResourseManagerBO.addStudent(new StudentDTO(studentId, studentName, studentAddress, studentDob, studentTelNumber, studentEmail));

            boolean isAdded = humanResourseManagerBO.addStudent(student);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION , "Student Details Added Successfuly!").show();
                getAllStudents();
                getStudentsCount();
                clearTextFields();
            } else {
                new Alert(Alert.AlertType.ERROR , "Error").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void searchStudentDetailsOnAction(ActionEvent event) {
        String studentId = txtSearchStudentId.getText();

        try {
            StudentDTO student = humanResourseManagerBO.getAllStudent(studentId);

            lblStudentId.setText(student.getStId());
            txtUpdateStudentName.setText(student.getStName());
            txtUpdateStudentAddress.setText(student.getStAddress());
            txtUpdateStudentDob.setText(student.getStDob());
            txtUpdateStudentTelephone.setText(String.valueOf(student.getStNumber()));
            txtUpdateStudentEmail.setText(student.getStEmail());

            getAllStudents();

        } catch (SQLException e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void updateStudentDetailsOnAction(ActionEvent event) {
        String studentId = lblStudentId.getText();
        String studentName = txtUpdateStudentName.getText();
        String studentAddress = txtUpdateStudentAddress.getText();
        String studentDob = txtUpdateStudentDob.getText();
        int studentTelephone = Integer.parseInt(txtUpdateStudentTelephone.getText());
        String studentEmail = txtUpdateStudentEmail.getText();

        //Student student = new Student(studentId , studentName , studentAddress , studentDob ,studentTelephone , studentEmail);

        try {
            boolean isUpdated = humanResourseManagerBO.updateStudent(new StudentDTO(studentId, studentName, studentAddress, studentDob, studentTelephone, studentEmail));

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION , "Update Student Details Successfuly!").show();
                getAllStudents();
                clearUpdateTextFields();
            } else {
                new Alert(Alert.AlertType.ERROR , "Error").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void deleteStudentDetailsOnAction(ActionEvent event) {
        String studentId = txtSearchStudentId.getText();
        try {
            boolean isDelete = humanResourseManagerBO.deleteStudent(studentId);

            if(isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Student Details Successfully!").show();
                getAllStudents();
                getStudentsCount();
                clearUpdateTextFields();
            } else {
                new Alert(Alert.AlertType.WARNING, "Error!").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void saveEmployeeOnAction(ActionEvent event) {
        String employeeId = txtEmpId.getText();
        String employeeName = txtEmpName.getText();
        String employeeDob = txtEmpDob.getText();
        String employeeAddress = txtEmpAddress.getText();
        int employeePhoneNumber = Integer.parseInt(txtEmpTelephone.getText());

        //Employee employee = new Employee(employeeId , employeeName , employeeDob , employeeAddress , employeePhoneNumber);
        try {
            boolean isAdded = humanResourseManagerBO.addEmployee(new EmployeeDTO(employeeId, employeeName, employeeDob, employeeAddress, employeePhoneNumber));

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION , "Employee Details Added Successfuly!").show();
                getAllEmployees();
                getEmployeesCount();
                clearTextFields();
            } else {
                new Alert(Alert.AlertType.ERROR , "Error").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void searchEmployeeDetailsOnAction(ActionEvent event) {
        String employeeId = txtSearchEmployeeId.getText();

        try {
            EmployeeDTO employee = humanResourseManagerBO.getAllEmployee(employeeId);

            lblEmployeeId.setText(employee.getEmployeeId());
            txtUpdateEmployeeName.setText(employee.getEmployeeName());
            txtUpdateEmployeeDob.setText(employee.getEmployeeDob());
            txtUpdateEmployeeAddress.setText(employee.getEmployeeAddress());
            txtUpdateEmployeeTelephone.setText(String.valueOf(employee.getEmployeePhoneNumber()));

            getAllEmployees();

        } catch (SQLException e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void updateEmployeeDetailsOnAction(ActionEvent event) {
        String employeeId = lblEmployeeId.getText();
        String employeeName = txtUpdateEmployeeName.getText();
        String employeeDob = txtUpdateEmployeeDob.getText();
        String employeeAddress = txtUpdateEmployeeAddress.getText();
        int employeeTelephone = Integer.parseInt(txtUpdateEmployeeTelephone.getText());

        //Employee employee = new Employee(employeeId , employeeName , employeeDob , employeeAddress , employeeTelephone);

        try {
            boolean isUpdated = humanResourseManagerBO.updateEmployee(new EmployeeDTO(employeeId, employeeName, employeeDob, employeeAddress, employeeTelephone));

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION , "Update Employee Details Successfuly!").show();
                getAllStudents();
                clearUpdateTextFields();
            } else {
                new Alert(Alert.AlertType.ERROR , "Error").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void deleteEmployeeDetailsOnAction(ActionEvent event) {
        String employeeId = txtSearchEmployeeId.getText();
        try {
            boolean isDelete = humanResourseManagerBO.deleteEmployee(employeeId);

            if(isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Employee Details Successfully!").show();
                getAllStudents();
                getEmployeesCount();
                clearUpdateTextFields();
            } else {
                new Alert(Alert.AlertType.WARNING, "Error!").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void updateTeacherOnAction(ActionEvent event) {
        if (true) {
            updateTeacherContextPane.setVisible(true);

            updateStudentContextPane.setVisible(false);
            updateEmployeeContextPane.setVisible(false);
            lblCommand.setVisible(false);
        }
    }

    public void updateStudentOnAction(ActionEvent event) {
        if (true) {
            updateStudentContextPane.setVisible(true);

            updateTeacherContextPane.setVisible(false);
            updateEmployeeContextPane.setVisible(false);
            lblCommand.setVisible(false);
        }
    }

    public void updateEmployeeOnAction(ActionEvent event) {
        if (true) {
            updateEmployeeContextPane.setVisible(true);

            updateTeacherContextPane.setVisible(false);
            updateStudentContextPane.setVisible(false);
            lblCommand.setVisible(false);
        }
    }

    public void getAllTeachers(){
        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM teacher");
            ResultSet allTeachers = statement.executeQuery();

            while (allTeachers.next()){
                data.add(new Teacher(allTeachers.getString(1), allTeachers.getString(2),
                        allTeachers.getString(3), allTeachers.getInt(4) , allTeachers.getString(5)));
            }

        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblViewAllTeacher.setItems(data);
    }

    public void getAllStudents(){
        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM student");
            ResultSet allStudents = statement.executeQuery();

            while (allStudents.next()){
                data.add(new Student(allStudents.getString(1), allStudents.getString(2),
                        allStudents.getString(3), allStudents.getString(4)
                        , allStudents.getInt(5), allStudents.getString(6)));
            }

        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblViewAllStudents.setItems(data);
    }

    public void getAllEmployees(){
        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM employee");
            ResultSet allEmployees = statement.executeQuery();

            while (allEmployees.next()){
                data.add(new Employee(allEmployees.getString(1), allEmployees.getString(2),
                        allEmployees.getString(3), allEmployees.getString(4)
                        , allEmployees.getInt(5)));
            }

        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblViewAllEmployee.setItems(data);
    }
    public void getStudentsCount(){
        try {
            String cusCount= humanResourseManagerBO.getCountsStudent();
            lblAllStudents.setText(cusCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void getEmployeesCount(){
        try {
            String cusCount= humanResourseManagerBO.getCountsEmployee();
            lblAllEmployees.setText(cusCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void getTeachersCount(){
        try {
            String cusCount= humanResourseManagerBO.getCountsTeacher();
            lblAllTeachers.setText(cusCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearUpdateTextFields() {
        txtSearchTeacherId.clear();
        txtUpdateTeacherName.clear();
        txtUpdateTeacherAddress.clear();
        txtUpdateTeacherTelephone.clear();
        txtUpdateTeacherEmail.clear();
        txtSearchStudentId.clear();
        txtUpdateStudentName.clear();
        txtUpdateStudentAddress.clear();
        txtUpdateStudentDob.clear();
        txtUpdateStudentTelephone.clear();
        txtUpdateStudentEmail.clear();
        txtUpdateStudentName.clear();
        txtUpdateStudentAddress.clear();
        txtUpdateStudentDob.clear();
        txtUpdateStudentTelephone.clear();
        txtUpdateStudentEmail.clear();
        txtSearchEmployeeId.clear();
        txtUpdateEmployeeName.clear();
        txtUpdateEmployeeDob.clear();
        txtUpdateEmployeeAddress.clear();
        txtUpdateEmployeeTelephone.clear();
        lblEmployeeId.setText("");
        lblStudentId.setText("");
        lblTeacherId.setText("");
    }
    private void clearTextFields() {
        txtTeacherId.clear();
        txtTeacherName.clear();
        txtTeacherAddress.clear();
        txtTeacherEmail.clear();
        txtTeacherTelephone.clear();
        txtStudentId.clear();
        txtStudentName.clear();
        txtStudentAddress.clear();
        txtStudentEmail.clear();
        txtStudentDob.clear();
        txtStudentTelephone.clear();
        txtEmpId.clear();
        txtEmpName.clear();
        txtEmpAddress.clear();
        txtEmpDob.clear();
        txtEmpTelephone.clear();
    }

    public void validTeacherTelephoneOnAction(KeyEvent keyEvent) {
        Pattern contactPattern = Pattern.compile("^(07)([0-9]{8})$");
        Matcher matcher = contactPattern.matcher(txtTeacherTelephone.getText());

        boolean isMatch =matcher.matches();

        if (!isMatch) {
            txtTeacherTelephone.setFocusColor(Paint.valueOf("red"));
            System.out.println("invalid");

            //Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtTeacherTelephone.setFocusColor(Paint.valueOf("green"));
        }
    }

    public void validEmailOnAction(KeyEvent keyEvent) {
        Pattern contactPattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = contactPattern.matcher(txtTeacherEmail.getText());

        boolean isMatch =matcher.matches();

        if (!isMatch) {
            txtTeacherEmail.setFocusColor(Paint.valueOf("red"));
            System.out.println("invalid");

            //Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtTeacherEmail.setFocusColor(Paint.valueOf("green"));
        }
    }

    public void validStudentTelephoneOnAction(KeyEvent keyEvent) {
        Pattern contactPattern = Pattern.compile("^(07)([0-9]{8})$");
        Matcher matcher = contactPattern.matcher(txtStudentTelephone.getText());

        boolean isMatch =matcher.matches();

        if (!isMatch) {
            txtStudentTelephone.setFocusColor(Paint.valueOf("red"));
            System.out.println("invalid");

            //Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtStudentTelephone.setFocusColor(Paint.valueOf("green"));
        }
    }

    public void validStudentEmailOnAction(KeyEvent keyEvent) {
        Pattern contactPattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = contactPattern.matcher(txtStudentEmail.getText());

        boolean isMatch =matcher.matches();

        if (!isMatch) {
            txtStudentEmail.setFocusColor(Paint.valueOf("red"));
            System.out.println("invalid");

            //Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtStudentEmail.setFocusColor(Paint.valueOf("green"));
        }
    }

    public void validEmployeeTelephoneOnAction(KeyEvent keyEvent) {
        Pattern contactPattern = Pattern.compile("^(07)([0-9]{8})$");
        Matcher matcher = contactPattern.matcher(txtEmpTelephone.getText());

        boolean isMatch =matcher.matches();

        if (!isMatch) {
            txtEmpTelephone.setFocusColor(Paint.valueOf("red"));
            System.out.println("invalid");

            //Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtEmpTelephone.setFocusColor(Paint.valueOf("green"));
        }
    }
}
