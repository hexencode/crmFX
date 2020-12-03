package com.hexenwerk.tutorial.javafx.crm.client.mvvc.login;


import com.hexenwerk.tutorial.javafx.crm.client.StageManager;
import com.hexenwerk.tutorial.javafx.crm.client.ViewController;
import com.hexenwerk.tutorial.javafx.crm.client.mvvc.bpmonitor.BPMonitorController;
import com.hexenwerk.tutorial.javafx.crm.client.mvvc.main.MainPaneVC;
import com.hexenwerk.tutorial.javafx.crm.service.PersonService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("LoginPane.fxml")
public class LoginPaneController implements ViewController {

    private final StageManager stageManager;
    private final PersonService userService;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label lblLogin;

    public LoginPaneController(StageManager stageManager, PersonService userService) {
        this.stageManager = stageManager;
        this.userService = userService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EventHandler<ActionEvent> loginEventHandler = event -> {

            if (userService.authenticate(username.getText(), password.getText()))
                stageManager.displayScene(BPMonitorController.class, "Blood Pressure Monitor APP");
            else
                getLblLogin().setText("Login Failed.");
        };

        password.setOnAction(loginEventHandler);
        btnLogin.setOnAction(loginEventHandler);
    }

    public Label getLblLogin() {
        return lblLogin;
    }

    @Override
    public void clear() {
        password.textProperty().setValue("");
        username.textProperty().setValue("");
    }
}
