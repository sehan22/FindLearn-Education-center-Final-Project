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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.apexeducationcenter.bo.BOFactory;
import lk.ijse.apexeducationcenter.bo.custom.TeacherDashboardBO;
import lk.ijse.apexeducationcenter.db.DBConnection;
import lk.ijse.apexeducationcenter.dto.ExamDTO;
import lk.ijse.apexeducationcenter.dto.ExamResultDTO;
import lk.ijse.apexeducationcenter.entity.Exam;
import lk.ijse.apexeducationcenter.entity.ExamResult;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class TeacherDashboardFormController {
    public AnchorPane SecPaneContext;
    public AnchorPane secPaneContexct;
    public AnchorPane examResultsPaneContext;
    public AnchorPane viewPaneContexct;
    public TableView tblViewAllCourses;
    public Label lblTitle1;
    public Label lblTopic;
    public AnchorPane examPaneContext;
    public AnchorPane dashboardPaneContext;
    public AnchorPane mainPaneContext;
    public JFXTextField txtExamId;
    public JFXTextField txtDuration;
    public JFXTextField txtExamDetails;
    public JFXTextField txtSubjectId;
    public JFXTextField txtBatchId;
    public JFXTextField txtResultId;
    public JFXTextField txtResultExamId;
    public JFXTextField txtStudentId;
    public JFXTextField txtDisposition;
    public JFXTextField txtMark;
    public JFXTextField txtResultStudentId;
    public JFXTextField txtResultDisposition;
    public TableView tblViewAllExam;
    public TableColumn colExamId;
    public TableColumn colBatchId;
    public TableColumn colSubjectId;
    public TableColumn colExamDetails;
    public TableColumn colExamDuration;
    public AnchorPane updatePaneContext;
    public AnchorPane updateExamContextPane;
    public AnchorPane updateExamResultContextPane;
    public JFXTextField txtSearchExamId;
    public JFXTextField txtUpdateBatchId;
    public JFXTextField txtUpdateSubjectId;
    public Label lblExamId;
    public JFXTextField txtUpdateExamDetails;
    public JFXTextField txtUpdateExamDuration;
    public Label lblCommand;
    public TableView tblViewAllExamResults;
    public TableColumn colResultId;
    public TableColumn colResultExamId;
    public TableColumn colResultStudentId;
    public TableColumn colResultDiscription;
    public TableColumn colResultMark;
    public JFXTextField txtSearchExamResultId;
    public JFXTextField txtUpdateStudentId;
    public Label lblResultId;
    public JFXTextField txtUpdateExamId;
    public JFXTextField txtUpdateResultDiscription;
    public JFXTextField txtUpdateMark;
    public Label lblAllExams;
    public Label lblAllExamsResults;

    TeacherDashboardBO teacherDashboardBO = (TeacherDashboardBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.TEACHER);

    public void initialize() {
        getExamCount();
        getExamResultsCount();

        colExamId.setCellValueFactory(new PropertyValueFactory<>("examId"));
        colBatchId.setCellValueFactory(new PropertyValueFactory<>("batchId"));
        colSubjectId.setCellValueFactory(new PropertyValueFactory<>("subjectId"));
        colExamDetails.setCellValueFactory(new PropertyValueFactory<>("examDetails"));
        colExamDuration.setCellValueFactory(new PropertyValueFactory<>("examDuration"));
        getAllExams();

        colResultId.setCellValueFactory(new PropertyValueFactory<>("rstId"));
        colResultExamId.setCellValueFactory(new PropertyValueFactory<>("examId"));
        colResultStudentId.setCellValueFactory(new PropertyValueFactory<>("stId"));
        colResultDiscription.setCellValueFactory(new PropertyValueFactory<>("discription"));
        colResultMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        getAllExamsResult();
    }

    public void dashboardBoardOnAction(ActionEvent actionEvent) {
        if (true) {
            dashboardPaneContext.setVisible(true);

            examPaneContext.setVisible(false);
            examResultsPaneContext.setVisible(false);
            viewPaneContexct.setVisible(false);
            updatePaneContext.setVisible(false);
        }
    }

    public void examOnAction(ActionEvent actionEvent) {
        if (true) {
            examPaneContext.setVisible(true);

            examResultsPaneContext.setVisible(false);
            viewPaneContexct.setVisible(false);
            dashboardPaneContext.setVisible(false);
            updatePaneContext.setVisible(false);
        }
    }

    public void resultOnAction(ActionEvent actionEvent) {
        if (true) {
            examResultsPaneContext.setVisible(true);

            examPaneContext.setVisible(false);
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
        if (true) {
            viewPaneContexct.setVisible(true);

            examPaneContext.setVisible(false);
            examPaneContext.setVisible(false);
            dashboardPaneContext.setVisible(false);
            updatePaneContext.setVisible(false);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        if (true) {
            updatePaneContext.setVisible(true);

            viewPaneContexct.setVisible(false);
            examPaneContext.setVisible(false);
            examPaneContext.setVisible(false);
            dashboardPaneContext.setVisible(false);
        }
    }

    public void updateExamOnAction(ActionEvent event) {
        if (true) {
            updateExamContextPane.setVisible(true);
            updateExamResultContextPane.setVisible(false);
            lblCommand.setVisible(false);
        }
    }

    public void updateExamResultsOnAction(ActionEvent event) {
        if (true) {
            updateExamResultContextPane.setVisible(true);
            updateExamContextPane.setVisible(false);
            lblCommand.setVisible(false);
        }
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

    public void saveExamOnAction(ActionEvent event) {
        String examId = txtExamId.getText();
        String examDetails = txtExamDetails.getText();
        int examDuration = Integer.parseInt(txtDuration.getText());
        String batchId = txtBatchId.getText();
        String subjectId = txtSubjectId.getText();

        //Exam exam = new Exam(examId , examDetails , examDuration , batchId , subjectId);
        try {
            boolean isAdded = teacherDashboardBO.addExam(new ExamDTO(examId, examDetails, examDuration, batchId, subjectId));

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION , "Exam Details Added Successfuly!").show();
                getAllExams();
                getExamCount();
                clearTextField();
            } else {
                new Alert(Alert.AlertType.ERROR , "Error").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void searchExamOnAction(ActionEvent event) {
        String examId = txtSearchExamId.getText();

        try {
            ExamDTO exam = teacherDashboardBO.getAllExam(examId);

            lblExamId.setText(exam.getExamId());
            txtUpdateExamDetails.setText(exam.getExamDetails());
            txtUpdateExamDuration.setText(String.valueOf(exam.getExamDuration()));
            txtUpdateBatchId.setText(exam.getBatchId());
            txtUpdateSubjectId.setText(exam.getSubjectId());

            getAllExams();

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void updateExamDetailsOnAction(ActionEvent event) {
        String examId = lblExamId.getText();
        String batchId = txtUpdateBatchId.getText();
        String subjectId = txtUpdateSubjectId.getText();
        String examDetails = txtUpdateExamDetails.getText();
        int examDuration = Integer.parseInt(txtUpdateExamDuration.getText());

        //Exam exam = new Exam(examId , examDetails , examDuration , batchId , subjectId);

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to update this subject?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isUpdated = teacherDashboardBO.updateExam(new ExamDTO(examId, examDetails, examDuration, batchId, subjectId));

                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION , "Update Exam Details Successfuly!").show();
                    getAllExams();
                    clearUpdateTextField();
                } else {
                    new Alert(Alert.AlertType.ERROR , "Error").show();
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception);
            new Alert(Alert.AlertType.ERROR ,exception.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void deleteExamDetailsOnAction(ActionEvent event) {
        String examId = txtSearchExamId.getText();

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to update this subject?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isDelete = teacherDashboardBO.deleteExam(examId);

                if(isDelete) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Delete Exam Details Successfully!").show();
                    getAllExams();
                    getExamCount();
                    clearUpdateTextField();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Error!").show();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void saveResultOnAction(ActionEvent event) {
        String examResultId = txtResultId.getText();
        String resultDiscription = txtResultDisposition.getText();
        int resultMark = Integer.parseInt(txtMark.getText());
        String resultExamId = txtResultExamId.getText();
        String studentId = txtResultStudentId.getText();

        //ExamResult examResult = new ExamResult(examResultId , resultDiscription , resultMark , resultExamId , studentId);
        try {
            boolean isAdded = teacherDashboardBO.addExamResult(new ExamResultDTO(examResultId, resultDiscription, resultMark, resultExamId, studentId));

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION , "Exam Result Details Added Successfuly!").show();
                getAllExamsResult();
                getExamResultsCount();
                clearTextField();
            } else {
                new Alert(Alert.AlertType.ERROR , "Error").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void searchExamResultDetailsOnAction(ActionEvent event) {
        String resultId = txtSearchExamResultId.getText();

        try {
            ExamResultDTO examResult = teacherDashboardBO.getAllExamResult(resultId);

            lblResultId.setText(examResult.getRstId());
            txtUpdateResultDiscription.setText(examResult.getDiscription());
            txtUpdateMark.setText(String.valueOf(examResult.getMark()));
            txtUpdateExamId.setText(examResult.getExamId());
            txtUpdateStudentId.setText(examResult.getStId());

            getAllExamsResult();

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void updateExamResultDetailsOnAction(ActionEvent event) {
        String resultId = lblResultId.getText();
        String resultDiscription = txtUpdateResultDiscription.getText();
        int resultMark = Integer.parseInt(txtUpdateMark.getText());
        String resultExamId = txtUpdateExamId.getText();
        String studentId = (txtUpdateStudentId.getText());

        //ExamResult examResult = new ExamResult(resultId , resultDiscription , resultMark , resultExamId , studentId);

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION , "Are sure do you want to update this subject?" , ButtonType.YES , ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.YES) {
                boolean isUpdated = teacherDashboardBO.updateExamResult(new ExamResultDTO(resultId, resultDiscription, resultMark, resultExamId, studentId));

                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION , "Update Exam Result Details Successfuly!").show();
                    getAllExamsResult();
                    clearUpdateTextField();
                } else {
                    new Alert(Alert.AlertType.ERROR , "Error").show();
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception);
            new Alert(Alert.AlertType.ERROR ,exception.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void deleteExamResultDetailsOnAction(ActionEvent event) {
        String resultId = txtSearchExamResultId.getText();
        try {
            boolean isDelete = teacherDashboardBO.deleteExamResult(resultId);

            if(isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Exam Result Details Successfully!").show();
                getAllExamsResult();
                getExamResultsCount();
                clearUpdateTextField();
            } else {
                new Alert(Alert.AlertType.WARNING, "Error!").show();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void getAllExams(){
        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM exam");
            ResultSet allExams = statement.executeQuery();

            while (allExams.next()){
                data.add(new Exam(allExams.getString(1), allExams.getString(2),
                        allExams.getInt(3) , allExams.getString(4) , allExams.getString(5)));
            }

        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblViewAllExam.setItems(data);
    }

    public void getAllExamsResult(){
        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM result");
            ResultSet allExamsResults = statement.executeQuery();

            while (allExamsResults.next()){
                data.add(new ExamResult(allExamsResults.getString(1), allExamsResults.getString(2),
                        allExamsResults.getInt(3) , allExamsResults.getString(4) , allExamsResults.getString(5)));
            }

        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblViewAllExamResults.setItems(data);
    }
    public void getExamCount(){
        try {
            String cusCount= teacherDashboardBO.getCountsExam();
            lblAllExams.setText(cusCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void getExamResultsCount(){
        try {
            String cusCount= teacherDashboardBO.getCountsExamResult();
            lblAllExamsResults.setText(cusCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearTextField() {
        txtExamId.clear();
        txtExamDetails.clear();
        txtBatchId.clear();
        txtDuration.clear();
        txtSubjectId.clear();
        txtResultId.clear();
        txtResultDisposition.clear();
        txtResultExamId.clear();
        txtMark.clear();
        txtResultStudentId.clear();
    }
    private void clearUpdateTextField() {
        txtSearchExamId.clear();
        txtUpdateBatchId.clear();
        txtUpdateSubjectId.clear();
        txtUpdateExamDetails.clear();
        txtUpdateExamDuration.clear();
        txtSearchExamResultId.clear();
        txtUpdateExamId.clear();
        txtUpdateStudentId.clear();
        txtUpdateResultDiscription.clear();
        txtUpdateMark.clear();
        lblResultId.setText("");
        lblExamId.setText("");
    }
}
