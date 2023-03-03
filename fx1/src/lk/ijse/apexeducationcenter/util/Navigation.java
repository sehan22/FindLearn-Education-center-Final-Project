package lk.ijse.apexeducationcenter.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();
        //Image image = new Image("/lk/ijse/apexeducationcenter/assets/images/Apexlogo-1.png");

        switch (route) {
            case ADMIN:
                window.setTitle("Apex Education Center");
                /*window.getIcons().add(image);
                window.centerOnScreen();
                window.initStyle(StageStyle.UNDECORATED);*/
                initUI("AdminDashboard.fxml");
                break;
            case FAMANAGER:
                window.setTitle("Apex Education Center");
                /*window.getIcons().add(image);
                window.centerOnScreen();
                window.initStyle(StageStyle.UNDECORATED);*/
                initUI("FinancialAffaairsManagerDashboardForm.fxml");
                break;
            case HRMANAGER:
                window.setTitle("Apex Education Center");
                /*window.getIcons().add(image);
                window.centerOnScreen();
                window.initStyle(StageStyle.UNDECORATED);*/
                initUI("HumanResourseManagerDashboard.fxml");
                break;
            case TEACHER:
                window.setTitle("Apex Education Center");
                /*window.getIcons().add(image);
                window.centerOnScreen();
                window.initStyle(StageStyle.UNDECORATED);*/
                initUI("TeacherDashboardForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR , "Not FXML Found");
        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/apexeducationcenter/view/" + location)));
    }
}
