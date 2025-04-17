package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BoiteAlertController {
	@FXML private Button okButton ;
	  @FXML
	    private void handleFermer() {
	        Stage stage = (Stage) okButton.getScene().getWindow();
	        stage.close();
	    }
}
