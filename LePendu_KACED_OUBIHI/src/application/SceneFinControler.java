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
	        labelMessage.setText(" Tu as triomphé… sauras-tu le refaire ? Un nouveau défi vous attend ! "
	        						+ "Tentez de battre ce record et montrez qui est le vrai maître du jeu !");
	    }

	    public void afficherDefaite() {
	    	rootFin.setStyle("-fx-background-image: url('" + getClass().getResource("/ressources/defaite.png").toExternalForm() + "');"
	                   + "-fx-background-size: cover;"
	                   + "-fx-background-position: center center;");
	        labelAffichage.setText("☠️ PENDU !\nLe mot à trouver était " + jeu.getMotMystere());
	        labelMessage.setText("Pouvez-vous faire mieux ? Une fin tragique… ou un nouveau départ ? Clique sur jouer!");
	    }
	}
