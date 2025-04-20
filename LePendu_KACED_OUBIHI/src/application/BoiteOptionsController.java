package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoiteOptionsController {

    @FXML private Slider taillePoliceSlider;
    @FXML private RadioButton sombreRadio;
    @FXML private RadioButton clairRadio;
    @FXML private Button validerButton;
    @FXML private Button annulerButton;
    @FXML private VBox blocA;
    @FXML private VBox blocB;

    @FXML
    private void initialize() {
    	
    	taillePoliceSlider.setValue(GestionOptions.getTaillePolice());

    	taillePoliceSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            double taille = newVal.doubleValue();
            GestionOptions.setTaillePolice(taille);
            SceneJeuController.mettreAJourTailleMot(); // méthode qu’on ajoute juste après
        });
    	
    	
    	
    	
    	String styleBloc = "-fx-background-color: #e0e0e0;" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: #888;" +
                "-fx-padding: 10;";
    	blocA.setStyle(styleBloc);
    	blocB.setStyle(styleBloc);
    	taillePoliceSlider.setStyle(
    		    "-fx-control-inner-background: #cce5ff;" +   
    		    "-fx-accent: #3399ff;"                    
    		);
    	validerButton.setStyle(
    		    "-fx-background-color: #66FF66;" +  // vert clair
    		    "-fx-font-weight: bold;" +
    		    "-fx-border-radius: 8;" +
    		    "-fx-background-radius: 8;"
    		);

    		annulerButton.setStyle(
    		    "-fx-background-color: #FF4444;" +  // rouge vif
    		    "-fx-font-weight: bold;" +
    		    "-fx-border-radius: 8;" +
    		    "-fx-background-radius: 8;"
    		);


    	clairRadio.setText("☀️ Clair");
    	sombreRadio.setText("🌙 Sombre");
        taillePoliceSlider.setMin(10);
        taillePoliceSlider.setMax(30);
        taillePoliceSlider.setValue(16);
        sombreRadio.setSelected(true); 
    }

    @FXML
    private void handleValider() {
            Stage stage = (Stage) validerButton.getScene().getWindow();
            stage.close();
        }


    @FXML
    private void handleAnnuler() {
        fermerFenetre();
    }

    private void fermerFenetre() {
        Stage stage = (Stage) annulerButton.getScene().getWindow();
        stage.close();
    }
}
