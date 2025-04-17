package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class BoiteOptionsController {

    @FXML private Slider taillePoliceSlider;
    @FXML private RadioButton sombreRadio;
    @FXML private RadioButton clairRadio;
    @FXML private Button validerButton;
    @FXML private Button annulerButton;

    @FXML
    private void initialize() {
        // Valeurs par défaut si tu veux
        taillePoliceSlider.setMin(10);
        taillePoliceSlider.setMax(30);
        taillePoliceSlider.setValue(16);
        sombreRadio.setSelected(true); // Par défaut
    }

    @FXML
    private void handleValider() {
        double taille = taillePoliceSlider.getValue();
        boolean modeSombre = sombreRadio.isSelected();

        System.out.println("Taille sélectionnée : " + taille);
        System.out.println("Mode sombre activé ? " + modeSombre);

        fermerFenetre();
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
