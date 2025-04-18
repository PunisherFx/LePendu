package application;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;

public class SceneFinControler {
	  @FXML
	    private Label labelAffichage;

	    @FXML
	    private Label labelMessage;
	    @FXML private Pane rootFin;

	    private GestionJeu jeu;

	    public void setJeu(GestionJeu jeu) {
	        this.jeu = jeu;
	    }

	    public void afficherVictoire() {
	    	 rootFin.setStyle("-fx-background-image: url('" + getClass().getResource("/ressources/Victoire.jpg").toExternalForm() + "');"
	                   + "-fx-background-size: cover;"
	                   + "-fx-background-position: center center;");
	        labelAffichage.setText("🎉 Bien joué !\nVous avez réussi à trouver le mot " + jeu.getMotMystere());
	        labelMessage.setText("Pouvez-vous faire mieux ? Un nouveau défi vous attend !");
	    }

	    public void afficherDefaite() {
	    	rootFin.setStyle("-fx-background-image: url('" + getClass().getResource("/ressources/defaite.jpg").toExternalForm() + "');"
	                   + "-fx-background-size: cover;"
	                   + "-fx-background-position: center center;");
	        labelAffichage.setText("😞 Dommage !\nLe mot à trouver était " + jeu.getMotMystere());
	        labelMessage.setText("Pas grave ! Rejouez pour prendre votre revanche !");
	    }
	}
