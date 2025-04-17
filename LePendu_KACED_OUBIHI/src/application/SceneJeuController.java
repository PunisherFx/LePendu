package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SceneJeuController {
	   @FXML
    private void handleLettre(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String lettre = btn.getText();
        System.out.println("Lettre cliquée : " + lettre);
    }
  
}
