package lk.ijse.apexeducationcenter.controller;

import animatefx.animation.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.apexeducationcenter.util.Navigation;
import lk.ijse.apexeducationcenter.util.Routes;
import org.controlsfx.control.Notifications;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApexLoginFormController {
    public AnchorPane sliderpane1;
    public Label lblapexEduCen;
    public Separator spr;
    public JFXButton btngoogle;
    public JFXButton btnLinkIn;
    public JFXButton btnFb;
    public JFXTextField txtUserName;
    public Hyperlink hplForgotPassword;
    public JFXPasswordField txtPassword;
    public JFXButton btnSignUp;
    public JFXButton btnSignIn;
    public Label lblCreateNewAcc;
    public Label lblSignIntoAcc;
    public AnchorPane sliderpane2;
    public ImageView imgApexLogo;
    public Label lblWelcomeBack;
    public Label lbldis;
    public Label lbldis2;
    public JFXButton btnSliderSignIn;
    public JFXButton btnSliderSignUp;
    public Label lblWelcome;
    public AnchorPane mainContextPane;
    public JFXTextField txtEmail;
    public ImageView imgEmail;

    public void initialize() {

        hideSignUpOptions();

        DropShadow shadow = new DropShadow();
        shadow.setBlurType(BlurType.GAUSSIAN);
        shadow.setColor(Color.GREY);
        shadow.setHeight(50);
        shadow.setWidth(20);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);
        shadow.setSpread(0.5);
        shadow.setRadius(1);

        lblapexEduCen.setEffect(shadow);

    }


    public void slidinToSignInOnAction(MouseEvent mouseEvent) {
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.seconds(0.7));
        slider.setNode(sliderpane2);

        slider.setToX(0);
        slider.play();

        FadeIn fadeIn = new FadeIn(sliderpane2);
        fadeIn.setSpeed(1.5);
        fadeIn.play();

        slider.setOnFinished(event -> {
            new ZoomIn(imgApexLogo).play();
        });

        TranslateTransition slider1 = new TranslateTransition();
        slider1.setDuration(Duration.seconds(0.4));
        slider1.setNode(sliderpane1);

        slider1.setToX(0);
        slider1.play();

        new FadeIn(sliderpane1).play();
        //sliderpane1.setTranslateX(0);

        lblSignIntoAcc.setVisible(true);
        hplForgotPassword.setVisible(true);
        lblWelcomeBack.setVisible(true);
        btnSignIn.setVisible(true);
        btnSliderSignUp.setVisible(true);

        Shadow shadow = new Shadow();
        shadow.setRadius(5);

        btnSignUp.setVisible(false);
        lblCreateNewAcc.setVisible(false);
        lblWelcome.setVisible(false);
        btnSliderSignIn.setVisible(false);
        imgEmail.setVisible(false);
        txtEmail.setVisible(false);

        slider1.setOnFinished(event -> {

        });
    }
    public void slidingToSignUpOnAction(MouseEvent mouseEvent) {
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.seconds(0.7));
        slider.setNode(sliderpane2);

        slider.setToX(-468);
        slider.play();

        FadeIn fadeIn = new FadeIn(sliderpane2);
        fadeIn.setSpeed(1.5);
        fadeIn.play();

        slider.setOnFinished(event -> {
            new ZoomIn(imgApexLogo).play();
        });

        TranslateTransition slider1 = new TranslateTransition();
        slider1.setDuration(Duration.seconds(0.4));
        slider1.setNode(sliderpane1);

        slider1.setToX(408);
        slider1.play();

        new FadeIn(sliderpane1).play();
        //sliderpane1.setTranslateX(408);

        lblSignIntoAcc.setVisible(false);
        hplForgotPassword.setVisible(false);
        lblWelcomeBack.setVisible(false);
        btnSignIn.setVisible(false);
        btnSliderSignUp.setVisible(false);

        btnSignUp.setVisible(true);
        lblCreateNewAcc.setVisible(true);
        lblWelcome.setVisible(true);
        btnSliderSignIn.setVisible(true);
        imgEmail.setVisible(true);
        txtEmail.setVisible(true);

        slider1.setOnFinished(event -> {

        });
    }

    public void validUserNameOnAction(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(txtUserName.getText());

        boolean isMatch = matcher.matches();

        if (isMatch) {
            txtUserName.setFocusColor(Paint.valueOf("green"));
        } else {
            txtUserName.setFocusColor(Paint.valueOf("red"));
        }
    }
    public void validPasswordOnAction(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("[a-zA-Z1-9]*$");
        Matcher matcher = pattern.matcher(txtPassword.getText());

        boolean isMatch = matcher.matches();

        if (isMatch) {
            txtPassword.setFocusColor(Paint.valueOf("green"));
        } else {
            txtPassword.setFocusColor(Paint.valueOf("red"));
        }
    }
    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        if ((txtUserName.getText().equals("admin"))) {
            if (txtPassword.getText().equals("admin1234")) {
                makeFadeOutInTransition(mainContextPane ,"AdminDashboard");
            } else {
                new BounceIn(txtPassword).play();
                txtPassword.requestFocus();
                txtPassword.setFocusColor(Paint.valueOf("Red"));
                setNotification("Login" , "Incorret UserName or Password!");
            }
        }

        else if ((txtUserName.getText().equals("hrm"))) {
            if (txtPassword.getText().equals("hrm1234")) {
                makeFadeOutInTransition(mainContextPane ,"HumanResourseManagerDashboard");
            } else {
                new BounceIn(txtPassword).play();
                txtPassword.requestFocus();
                txtPassword.setFocusColor(Paint.valueOf("Red"));
            }
        }

        else if ((txtUserName.getText().equals("teacher"))) {
            if (txtPassword.getText().equals("teacher1234")) {
                makeFadeOutInTransition(mainContextPane , "TeacherDashboardForm");
            } else {
                new BounceIn(txtPassword).play();
                txtPassword.requestFocus();
                txtPassword.setFocusColor(Paint.valueOf("Red"));
            }
        }

       else if ((txtUserName.getText().equals("fam"))) {
            if (txtPassword.getText().equals("fam1234")) {
                makeFadeOutInTransition(mainContextPane , "FinancialAffaairsManagerDashboardForm");
            } else {
                new BounceIn(txtPassword).play();
                txtPassword.requestFocus();
                txtPassword.setFocusColor(Paint.valueOf("Red"));
            }

        } else {
            new BounceIn(txtUserName).play();
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Paint.valueOf("Red"));
        }
    }


    public void forgotYourPasswordOnAction(ActionEvent actionEvent) {

    }


    public void googleOnAction(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://apexbusiness.lk/"));
    }
    public void linkedInOnAction(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.linkedin.com/company/apex-education-llc"));
    }
    public void facebbookOnAction(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/apex.matara/"));
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
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished((ActionEvent event) ->{
            closeStage(paneId);
            System.exit(0);
        });

        fadeTransition.play();
    }


    private void hideSignUpOptions() {
        lblWelcome.setVisible(false);
        lblCreateNewAcc.setVisible(false);
        btnSignUp.setVisible(false);
        btnSliderSignIn.setVisible(false);
    }

    public void exitOnAction(ActionEvent actionEvent) {
        makeFadeOutInClose(mainContextPane);
    }

    private void setNotification(String post , String massege) {


        javafx.scene.image.Image image = new Image("lk/ijse/apexeducationcenter/assets/images/icons8-box-important-48.png");
        Notifications notifications = Notifications.create();
        notifications.graphic(new ImageView(image));
        notifications.text(massege);
        notifications.title("Apex Education Center - " + post);
        notifications.hideAfter(Duration.seconds(2));
        notifications.darkStyle();
        notifications.show();
    }
}
