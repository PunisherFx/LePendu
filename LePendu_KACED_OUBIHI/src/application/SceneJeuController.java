package application;


import java.io.IOException;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;



public class SceneJeuController {

    private GestionJeu jeu;
    @FXML
    private Label labelMot;

    @FXML
    private Label labelVie;

    @FXML
    private Label labelAffichage;
    @FXML private ImageView labelImage;
    private static SceneJeuController sceneJeu;
    @FXML
    private BorderPane rootPane; 


    public static void mettreAJourMode() {
        if (sceneJeu != null) {
        	sceneJeu.appliquerMode();
        }
    }

    private void appliquerMode() {
        boolean sombre = GestionOptions.isModeSombre();
        if (sombre) {
            rootPane.setStyle("-fx-background-color: radial-gradient(center 50% 50%, radius 90%, #1a1a1a, #999999);");
        } else {
            rootPane.setStyle("-fx-background-color: radial-gradient(center 50% 50%, radius 90%, white, #b8d9f3);");
        }
    }
    
    public void initialize() {
    	sceneJeu = this;
        appliquerMode();
        sceneJeu = this;
        appliquerTailleMot();
    }

    public static void mettreAJourTailleMot() {
        if (sceneJeu != null) {
        	sceneJeu.appliquerTailleMot();
        }
    }

    private void appliquerTailleMot() {
        double taille = GestionOptions.getTaillePolice();
        labelMot.setStyle("-fx-font-size: " + taille + "px;");
    }
    
    public void setJeu(GestionJeu jeu) {
        this.jeu = jeu;
        majAffichageMot();
        majAffichageVies();
        labelAffichage.setText("pret pour cette nouvelle aventure");
        labelImage.setImage(new Image(getClass().getResource("/ressources/0.png").toExternalForm()));
    }
    
    @FXML
    private void handleLettre(ActionEvent event) {
        Button boutonClique = (Button) event.getSource();
        String reponse = boutonClique.getText();
        boutonClique.setVisible(false);
        jeu.MemoriserLettreChoisie(reponse.charAt(0));

        Vector<Integer> pos = new Vector<>();
        if (jeu.ChercherLettreDansMot(reponse.charAt(0), pos) == 0) {
        	jeu.MAJNbErreurs();
        	labelAffichage.setText("La lettre n'est pas dans le mot erreur en plus");
        	majAffichageVies();
        	switch(jeu.getNbErreurs()){
        	case 1 :  labelImage.setImage(new Image(getClass().getResource("/ressources/PenduEtape1.png").toExternalForm()));
            break;
           	case 2 :  labelImage.setImage(new Image(getClass().getResource("/ressources/PenduEtape2.png").toExternalForm()));
            break;
           	case 3 :  labelImage.setImage(new Image(getClass().getResource("/ressources/etape 3.png").toExternalForm()));
            break;
           	case 4 :  labelImage.setImage(new Image(getClass().getResource("/ressources/PenduEtape4.png").toExternalForm()));
            break;
           	case 5 :  labelImage.setImage(new Image(getClass().getResource("/ressources/PenduEtape5.png").toExternalForm()));
            break;
        		
        	}
            if (jeu.MaxErreursDepasse()) {
                chargerSceneFin(event, false); 
            }
        } else {
        	majAffichageMot();
        	labelAffichage.setText("Bien joué ! La lettre est dans le mot ");
            if (jeu.ToutTrouve()) {
                chargerSceneFin(event, true);
            }
        }
    }

    private void chargerSceneFin(ActionEvent event, boolean victoire) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sceneDeFin.fxml"));
            Parent root = loader.load();

            SceneFinControler controller = loader.getController();
            controller.setJeu(jeu);
            if (victoire) {
                controller.afficherVictoire();
            } else {
                controller.afficherDefaite();
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void majAffichageMot() {
        StringBuilder affichage = new StringBuilder();
        for (int i = 0; i < jeu.getMotMystere().length(); i++) {
        	char lettre = jeu.getMotMystere().charAt(i);
        	if (jeu.getLettresDejaDonnees().contains(String.valueOf(lettre))) {
        	    affichage.append(lettre).append(' ');
        	} else {
        	    affichage.append("_ ");
        	}
        }
        labelMot.setText(affichage.toString().trim());
    }
    private void majAffichageVies() {
        int restantes = (jeu.getNbMaxErreurs() - jeu.getNbErreurs())+1;
        labelVie.setText("Vies restantes : " + restantes);
    }

}
