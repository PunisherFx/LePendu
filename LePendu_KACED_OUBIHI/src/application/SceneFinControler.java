package application;

import javafx.scene.control.Label;


import javafx.fxml.FXML;

public class SceneFinControler {
	  @FXML
	    private Label labelAffichage;

	    @FXML
	    private Label labelMessage;

	    private GestionJeu jeu;

	    public void setJeu(GestionJeu jeu) {
	        this.jeu = jeu;
	    }

	    public void afficherVictoire() {
	        labelAffichage.setText("🎉 Bien joué !\nVous avez réussi à trouver le mot " + jeu.getMotMystere());
	        labelMessage.setText("Pouvez-vous faire mieux ? Un nouveau défi vous attend !");
	    }

	    public void afficherDefaite() {
	        labelAffichage.setText("😞 Dommage !\nLe mot à trouver était " + jeu.getMotMystere());
	        labelMessage.setText("Pas grave ! Rejouez pour prendre votre revanche !");
	    }
	}
