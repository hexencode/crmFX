package com.hexenwerk.tutorial.javafx.crm.client.mvvc.main.top;

import com.hexenwerk.tutorial.javafx.crm.client.StageManager;
import com.hexenwerk.tutorial.javafx.crm.client.ViewController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("MenuBarView.fxml")
public class MenuBarVC implements ViewController {

    private final StageManager stageManager;

    public Menu languageMenu;

    public MenuBarVC(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void clear() {
        // not applicable
    }
}
