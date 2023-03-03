package lk.ijse.apexeducationcenter.controller;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.apexeducationcenter.bo.BOFactory;
import lk.ijse.apexeducationcenter.bo.custom.AdminDashboardBO;
import lk.ijse.apexeducationcenter.db.DBConnection;
import lk.ijse.apexeducationcenter.dto.BatchDTO;
import lk.ijse.apexeducationcenter.dto.CourseDTO;
import lk.ijse.apexeducationcenter.dto.SubjectDTO;
import lk.ijse.apexeducationcenter.entity.Batch;
import lk.ijse.apexeducationcenter.entity.Course;
import lk.ijse.apexeducationcenter.entity.Subject;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class AdminDashboardController {
    public AnchorPane CoursePaneContexct;
    public AnchorPane batchPaneContexct;
    public AnchorPane secPaneContexct;
    public AnchorPane coursePaneContexct;
    public AnchorPane SubjectPaneContexct;
    public Label lblTitle;
    public AnchorPane viewPaneContexct;
    public TableView tblViewAllCourses;
    public Label lblTitle1;
    public AnchorPane mainPaneContext;
    public AnchorPane dashboardPaneContext;
    public JFXTextField txtCrsId;
    public JFXTextField txtCrsName;
    public JFXTextField txtCrsDuration;
    public JFXTextField txtBatchId;
    public JFXTextField txtBatchName;
    public JFXTextField txtBatchYear;
    public JFXTextField txtSubjectId;
    public JFXTextField txtSubjectName;
    public JFXTextField txtCourseId;
    public AnchorPane updatePaneContext;
    public AnchorPane updateCourseContextPane;
    public AnchorPane updateBatchContextPane;
    public AnchorPane updateSubjectContextPane1;
    public Label lblCommand;
    public JFXTextField txtSearchCourseId;
    public JFXTextField txtUpdateCourseName;
    public JFXTextField txtUpdateCrsDuration;
    public Label lblCourseId;
    public JFXTextField txtSearchBatchiDOnAction;
    public JFXTextField txtUpdateBatchName;
    public JFXTextField txtUpdateBatchYear;
    public Label lblBatchId;
    public JFXTextField txtSearchSubjectId;
    public JFXTextField txtUpdateSubjectName;
    public JFXTextField txtUpdateCourseId;
    public Label lblSubjectId;
    public Label lblUpdatePaneCourseId;
    public TableColumn colCourseId;
    public TableColumn colCourseName;
    public TableColumn colCourseDuration;
    public TableView tblViewAllBatch;
    public TableColumn colBatchId;
    public TableColumn colBatchName;
    public TableColumn colBatchYear;
    public TableView tblViewAllSubjects;
    public TableColumn colSubjectId;
    public TableColumn colSubCourseId;
    public TableColumn colSubjectName;
    public JFXTextField txtCrsFees;
    public JFXTextField txtUpdateCrsFees;
    public TableColumn colCourseFees;
    public JFXComboBox cmbCourseIds;
    public JFXTextField txtCourseName;
    public TableColumn colCourseSubjectName;
    public JFXTextField txtSelectCourseId;
    public JFXTextField txtselectedCourseName;
    public JFXTextField txtBatchSeats;
    public TableColumn colSelectCourseId;
    public TableColumn colBatchSeats;
    public JFXTextField txtUpdateBatchSeats;
    public JFXTextField txtUpdateBatchCourseId;
    public Label lblAllCourses;
    public Label lblAllBatches;
    public Label lblAllSubjects;

    AdminDashboardBO adminDashboardBO = (AdminDashboardBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ADMIN);

    public void initialize() {
        loadDashboardPane();
        getCourseCount();
        getBatchCount();
        getSubjectsCount();


            colCourseId.setCellValueFactory(new PropertyValueFactory<>("CrsId"));
            colCourseName.setCellValueFactory(new PropertyValueFactory<>("CrsName"));
            colCourseDuration.setCellValueFactory(new PropertyValueFactory<>("Duration"));
            colCourseFees.setCellValueFactory(new PropertyValueFactory<>("crsFee"));
            getAllICourse();

            colBatchId.setCellValueFactory(new PropertyValueFactory<>("batchId"));
            colBatchName.setCellValueFactory(new PropertyValueFactory<>("batchName"));
            colSelectCourseId.setCellValueFactory(new PropertyValueFactory<>("crsId"));
            colBatchYear.setCellValueFactory(new PropertyValueFactory<>("batchYear"));
            colBatchSeats.setCellValueFactory(new PropertyValueFactory<>("batchSeats"));
            getAllBatch();

            colSubjectId.setCellValueFactory(new PropertyValueFactory<>("subjectId"));
            colSubjectName.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
            colSubCourseId.setCellValueFactory(new PropertyValueFactory<>("subjectCrsId"));
            getAllSubjects();

            loadCourseIds();

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
    private void makeFadeOutInTransitionWithClose(AnchorPane anchorPane , String fxmlName) {
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


    public void updateOnAction(ActionEvent event) throws IOException {
        if (true) {
            updatePaneContext.setVisible(true);


            SubjectPaneContexct.setVisible(false);
            coursePaneContexct.setVisible(false);
            batchPaneContexct.setVisible(false);
            dashboardPaneContext.setVisible(false);
            viewPaneContexct.setVisible(false);
        }
    }
    private void loadDashboardPane() {
        coursePaneContexct.setVisible(false);

        batchPaneContexct.setVisible(false);
        SubjectPaneContexct.setVisible(false);
        viewPaneContexct.setVisible(false);
        dashboardPaneContext.setVisible(true);
        updatePaneContext.setVisible(false);
    }
    public void coursesOnAction(ActionEvent actionEvent) throws IOException {
        if (true) {
            coursePaneContexct.setVisible(true);

            batchPaneContexct.setVisible(false);
            SubjectPaneContexct.setVisible(false);
            viewPaneContexct.setVisible(false);
            dashboardPaneContext.setVisible(false);
            updatePaneContext.setVisible(false);
        }
    }
    public void batchOnAction(ActionEvent actionEvent) {
        if (true) {
            batchPaneContexct.setVisible(true);

            coursePaneContexct.setVisible(false);
            SubjectPaneContexct.setVisible(false);
            viewPaneContexct.setVisible(false);
            dashboardPaneContext.setVisible(false);
            updatePaneContext.setVisible(false);

        }
    }
    public void subjectOnAction(ActionEvent actionEvent) {
        if (true) {
            SubjectPaneContexct.setVisible(true);

            coursePaneContexct.setVisible(false);
            batchPaneContexct.setVisible(false);
            viewPaneContexct.setVisible(false);
            dashboardPaneContext.setVisible(false);
            updatePaneContext.setVisible(false);

        }
    }
    public void dashboardBoardOnAction(ActionEvent actionEvent) {
        dashboardPaneContext.setVisible(true);

        SubjectPaneContexct.setVisible(false);
        coursePaneContexct.setVisible(false);
        batchPaneContexct.setVisible(false);
        viewPaneContexct.setVisible(false);
        updatePaneContext.setVisible(false);
    }
    public void viewAllOnAction(ActionEvent actionEvent) {
        if (true) {
            viewPaneContexct.setVisible(true);

            SubjectPaneContexct.setVisible(false);
            coursePaneContexct.setVisible(false);
            batchPaneContexct.setVisible(false);
            dashboardPaneContext.setVisible(false);
            updatePaneContext.setVisible(false);
        }
    }
    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        makeFadeOutInTransitionWithClose(mainPaneContext , "ApexLoginForm");

    }

    public void exitOnAction(ActionEvent actionEvent) {
        makeFadeOutInClose(mainPaneContext);
    }


    public void updateCourseOnAction(ActionEvent event) {
        if (true) {
            updateCourseContextPane.setVisible(true);

            updateBatchContextPane.setVisible(false);
            updateSubjectContextPane1.setVisible(false);
            lblCommand.setVisible(false);
        }
    }
    public void updateBatchOnAction(ActionEvent event) {
        if (true) {
            updateBatchContextPane.setVisible(true);

            updateCourseContextPane.setVisible(false);
            updateSubjectContextPane1.setVisible(false);
            lblCommand.setVisible(false);
        }
    }
    public void updateSubjectOnAction(ActionEvent event) {
        if (true) {
            updateSubjectContextPane1.setVisible(true);

            updateCourseContextPane.setVisible(false);
            updateBatchContextPane.setVisible(false);
            lblCommand.setVisible(false);

        }
    }


    public void saveCourseOnAction(ActionEvent event) {
        String crsId = txtCrsId.getText();
        String crsName = txtCrsName.getText();
        int crsDuration = Integer.parseInt(txtCrsDuration.getText());
        double crsFees = Double.parseDouble(txtCrsFees.getText());

      //  Course course = new Course(crsId , crsName , crsDuration , crsFees);
        try {
            boolean isAdded = adminDashboardBO.addCourse(new CourseDTO(crsId,crsName,crsDuration,crsFees));

            if (isAdded) {
                new Alert(Alert.AlertType.INFORMATION ,"Course Details Added Successfuly!").show();
                getAllICourse();
                loadCourseIds();
                getCourseCount();
                clearTextFied();
            } else {
                new Alert(Alert.AlertType.ERROR , "Somthing Went Wrong.Please Try Again!").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void searchCourseOnAction(ActionEvent event) {
        String courseId = txtSearchCourseId.getText();

        try {
            CourseDTO course = adminDashboardBO.getAllCourse(courseId);

            lblCourseId.setText(course.getCrsId());
            txtUpdateCourseName.setText(course.getCrsName());
            txtUpdateCrsDuration.setText(Integer.toString(course.getDuration()));
            txtUpdateCrsFees.setText(Double.toString(course.getCrsFee()));

            getAllICourse();

        } catch (SQLException e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void updateCourseDetailsOnAction(ActionEvent event) {
        String courseId = lblCourseId.getText();
        String courseName = txtUpdateCourseName.getText();
        int courseDuration = Integer.parseInt(txtUpdateCrsDuration.getText());
        double courseFees = Double.parseDouble(txtUpdateCrsFees.getText());

//        Course course = new Course(courseId , courseName , courseDuration , courseFees);

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to update this course?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isUpdated = adminDashboardBO.updateCourse(new CourseDTO(courseId, courseName, courseDuration, courseFees));

                if (isUpdated) {
                    new Alert(Alert.AlertType.INFORMATION , "Update Course Details Successfuly!").show();
                    getAllICourse();
                    clearUpdateTextFields();
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
    public void deleteCourseDetailsOnAction(ActionEvent event) {
        String batchId = txtSearchCourseId.getText();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to delete this course?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isDelete = adminDashboardBO.deleteCourse(batchId);

                if(isDelete) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Delete Course Details Successfully!").show();
                    getAllICourse();
                    getCourseCount();
                    clearUpdateTextFields();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Somthing Went Wrong.Please Try Again!").show();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void getAllICourse(){
        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM course");
            ResultSet allCoourses = statement.executeQuery();


            while (allCoourses.next()){
                data.add(new Course(allCoourses.getString(1), allCoourses.getString(2),
                        allCoourses.getInt(3) , allCoourses.getDouble(4)));
            }


        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        tblViewAllCourses.setItems(data);
    }


    public void saveBatchOnAction(ActionEvent event) {
        getAllBatch();

        String batchId = txtBatchId.getText();
        String batchName = txtBatchName.getText();
        String crsId = txtSelectCourseId.getText();
        int batchYear = Integer.parseInt(txtBatchYear.getText());
        int batchSeats = Integer.parseInt(txtBatchSeats.getText());

        //Batch batch = new Batch(batchId , batchName , crsId , batchYear , batchSeats);
        try {
            boolean isAdded = adminDashboardBO.addBatch(new BatchDTO(batchId, batchName, crsId, batchYear, batchSeats));

            if (isAdded) {
                new Alert(Alert.AlertType.INFORMATION , "Batch Details Added Successfuly!").show();
                getAllBatch();
                getBatchCount();
                clearTextFied();
            } else {
                new Alert(Alert.AlertType.ERROR , "Somthing Went Wrong.Please Try Again!").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void searchBatchDetailsOnAction(ActionEvent event) {
        String batchId = txtSearchBatchiDOnAction.getText();

        try {
            BatchDTO batch = adminDashboardBO.getAllBatch(batchId);

            lblBatchId.setText(batch.getBatchId());
            txtUpdateBatchCourseId.setText(batch.getCrsId());
            txtUpdateBatchName.setText(batch.getBatchName());
            txtUpdateBatchYear.setText(String.valueOf(batch.getBatchYear()));
            txtUpdateBatchSeats.setText(String.valueOf(batch.getBatchSeats()));

            getAllBatch();

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void updateBatchDetailsOnACTION(ActionEvent event) {
        String batchId = lblBatchId.getText();
        String batchCrsName = txtUpdateBatchCourseId.getText();
        String batchName = txtUpdateBatchName.getText();
        int batchYear = Integer.parseInt(txtUpdateBatchYear.getText());
        int batchSeats = Integer.parseInt(txtUpdateBatchSeats.getText());


        //Batch batch = new Batch(batchId , batchName ,  batchCrsName , batchYear , batchSeats);

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to update this batch?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isUpdated = adminDashboardBO.updateBatch(new BatchDTO(batchId, batchName, batchCrsName, batchYear, batchSeats));

                if (isUpdated) {
                    new Alert(Alert.AlertType.INFORMATION , "Update Batch Details Successfuly!").show();
                    getAllBatch();
                    clearUpdateTextFields();
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
    public void deleteBatchDetailsOnAction(ActionEvent event) {
        String batchId = txtSearchBatchiDOnAction.getText();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to delete this batch?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isDelete = adminDashboardBO.deleteBatch(batchId);

                if(isDelete) {
                    new Alert(Alert.AlertType.INFORMATION , "Delete Batch Details Successfully!").show();
                    getAllBatch();
                    getBatchCount();
                    clearUpdateTextFields();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Somthing Went Wrong.Please Try Again!").show();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void getAllBatch(){
        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM batch");
            ResultSet allBatch = statement.executeQuery();


            while (allBatch.next()){
                data.add(new Batch(allBatch.getString(1), allBatch.getString(2),
                        allBatch.getString(3), allBatch.getInt(4), allBatch.getInt(5)));
            }


        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblViewAllBatch.setItems(data);
    }


    public void saveSubjectOnAction(ActionEvent event) {
        String subjectId = txtSubjectId.getText();
        String subjectName = txtSubjectName.getText();
        /*String crsId = txtCourseId.getText();*/
        String crsId = String.valueOf(cmbCourseIds.getValue());

        //Subject subject = new Subject(subjectId , subjectName , crsId);
        try {
            boolean isAdded = adminDashboardBO.addSubject(new SubjectDTO(subjectId, subjectName, crsId));

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION , "Subject Details Added Successfuly!").show();
                getAllSubjects();
                getSubjectsCount();
                clearTextFied();
            } else {
                new Alert(Alert.AlertType.ERROR , "Error").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void serachSubjectDetailsOnAction(ActionEvent event) {
        String subjectId = txtSearchSubjectId.getText();

        try {
            SubjectDTO subject = adminDashboardBO.getAllSubject(subjectId);

            lblSubjectId.setText(subject.getSubjectId());
            txtUpdateSubjectName.setText(subject.getSubjectName());
            lblUpdatePaneCourseId.setText(subject.getSubjectCrsId());

            getAllSubjects();

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void updateSubjectDetailsOnAction(ActionEvent event) {
        String subjectId = lblSubjectId.getText();
        String subjectName = lblUpdatePaneCourseId.getText();
        String subjectCourseId = txtUpdateSubjectName.getText();

        //Subject subject = new Subject(subjectId , subjectName , subjectCourseId);

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to update this subject?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isUpdated = adminDashboardBO.updateSubject(new SubjectDTO(subjectId, subjectCourseId, subjectName));

                if (isUpdated) {
                    new Alert(Alert.AlertType.INFORMATION , "Update Subject Details Successfuly!").show();
                    getAllSubjects();
                    clearUpdateTextFields();
                } else {
                    new Alert(Alert.AlertType.ERROR , "Somthing Went Wrong.Please Try Again!").show();
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception);
            new Alert(Alert.AlertType.ERROR ,exception.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void deleteSubjectDetalsOnAction(ActionEvent event) {
        String batchId = txtSearchSubjectId.getText();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to delete this subject?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isDelete = adminDashboardBO.deleteSubject(batchId);

                if(isDelete) {
                    new Alert(Alert.AlertType.INFORMATION, "Delete Subject Details Successfully!").show();
                    getAllSubjects();
                    getSubjectsCount();
                    clearUpdateTextFields();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Somthing Went Wrong.Please Try Again!").show();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void getAllSubjects(){
        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM subject");
            ResultSet allSubjects = statement.executeQuery();

            while (allSubjects.next()){
                data.add(new Subject(allSubjects.getString(1), allSubjects.getString(3),
                        allSubjects.getString(2)));
            }

        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblViewAllSubjects.setItems(data);
    }


    private void loadCourseIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> itemList = adminDashboardBO.loadCourseIds();

            for (String courseId : itemList) {
                observableList.add(courseId);
            }
            cmbCourseIds.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadCourseNames() {
        String ids = String.valueOf(cmbCourseIds.getValue());
        try {
            CourseDTO course = adminDashboardBO.getAllCourse(ids);
            txtCourseName.setText(course.getCrsName());
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    private void loadCourseName() {
        String ids = txtSelectCourseId.getText();
        try {
            CourseDTO course = adminDashboardBO.getAllCourse(ids);
            txtselectedCourseName.setText(course.getCrsName());
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void selectCmbItemOnAction(ActionEvent event) {
        loadCourseNames();
    }
    public void selectCourseNameOnAction(ActionEvent actionEvent) {
        loadCourseName();
    }
    public void getCourseCount(){
        try {
            String cusCount= adminDashboardBO.getCountsCourse();
            lblAllCourses.setText(cusCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void getBatchCount(){
        try {
            String cusCount= adminDashboardBO.getCountsBatch();
            lblAllBatches.setText(cusCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void getSubjectsCount(){
        try {
            String cusCount= adminDashboardBO.getCountsSubject();
            lblAllSubjects.setText(cusCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearTextFied() {
        txtCrsId.clear();
        txtCrsName.clear();
        txtCrsDuration.clear();
        txtCrsFees.clear();
        txtBatchId.clear();
        txtBatchName.clear();
        txtBatchYear.clear();
        txtSubjectId.clear();
        txtSubjectName.clear();
        txtCourseName.clear();
    }
    private void clearUpdateTextFields() {
        txtSearchCourseId.clear();
        txtUpdateCourseName.clear();
        txtUpdateCrsDuration.clear();
        txtUpdateCrsFees.clear();
        txtSearchBatchiDOnAction.clear();
        txtUpdateBatchName.clear();
        txtUpdateBatchYear.clear();
        txtSearchSubjectId.clear();
        txtUpdateSubjectName.clear();
        lblSubjectId.setText("");
        lblUpdatePaneCourseId.setText("");
        lblBatchId.setText("");
        lblCourseId.setText("");
    }
}
