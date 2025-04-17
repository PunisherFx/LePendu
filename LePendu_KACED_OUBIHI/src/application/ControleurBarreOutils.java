package application;
import javafx.scene.Node;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ControleurBarreOutils {
	  @FXML private Button jouerButton;
	    @FXML private Button optionsButton;
	    @FXML private Button aideButton;
	    @FXML private Button quitterButton;
	    private Stage boiteOptionsStage;
	    private GestionJeu jeu;
	    private Stage primaryStage;
	    public void setJeu(GestionJeu jeu) {
	    	this.jeu = jeu;
	    }
	    public void setStage(Stage stage) {
	    	this.primaryStage = stage;
	    }
	    
	    @FXML
	    private void handleJouer(ActionEvent event) {
	    	    try {
	    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("sceneJeu.fxml"));
	    	        Parent root = loader.load();

	    	        SceneJeuController controller = loader.getController();

	    	        GestionJeu jeu = new GestionJeu(getClass().getResource("Dico.txt").getFile());
	    	        jeu.InitialiserPartie();

	    	        controller.setJeu(jeu); // 💥 TRÈS IMPORTANT !

	    	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	        stage.setScene(new Scene(root));
	    	        stage.show();
	    	    } catch (IOException e) {
	    	        e.printStackTrace();
	    	    }
	    	}

	    @FXML
	    private void handleOptions() {
			if (boiteOptionsStage == null) {
	            try {
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("boitStandard.fxml"));
	                Parent root = loader.load();

	                boiteOptionsStage = new Stage();
	                boiteOptionsStage.setTitle("Options");
	                boiteOptionsStage.setScene(new Scene(root));
	                boiteOptionsStage.setResizable(false);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        boiteOptionsStage.show();
	    }

	    @FXML
	    private void handleAide() {
	    	   try {
	    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("boiteAlert.fxml")); // Remplace par le bon nom
	    	        Parent root = loader.load();

	    	        Stage stage = new Stage();
	    	        stage.setTitle("Aide");
	    	        stage.setScene(new Scene(root));
	    	        stage.setResizable(false);
	    	        stage.show();

	    	    } catch (Exception e) {
	    	        e.printStackTrace();
	    	    }
	    }

	    @FXML
	    private void handleQuitter() {
	        System.exit(0);
	    }
	}