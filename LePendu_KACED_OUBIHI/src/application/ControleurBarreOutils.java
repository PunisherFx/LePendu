package application;
import javafx.scene.Node;

import java.awt.Label;
import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	        Alert dialogA = new Alert(Alert.AlertType.INFORMATION);
	        dialogA.getButtonTypes().setAll(ButtonType.OK);
	        dialogA.setTitle("Aide");
	        dialogA.setHeaderText("Bienvenue dans l'aide du jeu");

	        // === Partie support ===
	        Label labelSupport = new Label("Support");
	        TextArea areaSupport = new TextArea("Contact : support@pendu-jeu.com\nTéléphone : 06 12 34 56 78");
	        areaSupport.setEditable(false);
	        areaSupport.setWrapText(true);
	        areaSupport.setPrefSize(200, 100);

	        VBox boxSupport = new VBox();
	        boxSupport.setSpacing(10);
	        boxSupport.getChildren().add(areaSupport);

	        // === Partie règles ===
	        Label labelRegles = new Label("Règles du jeu");
	        TextArea areaRegles = new TextArea(
	            "- Devinez le mot avant d’être pendu.\n" +
	            "- Chaque mauvaise lettre enlève une vie.\n" +
	            "- Vous avez 5 tentatives.\n" +
	            "- Cliquez sur les lettres pour jouer."
	        );
	        areaRegles.setEditable(false);
	        areaRegles.setWrapText(true);
	        areaRegles.setPrefSize(300, 100);

	        VBox boxRegles = new VBox();
	        boxRegles.setSpacing(5);
	        boxRegles.getChildren().add(areaRegles);

	        // === Contenu global ===
	        HBox contenu = new HBox(20);
	        contenu.setPadding(new Insets(10));
	        contenu.getChildren().addAll(boxSupport, boxRegles);

	        dialogA.getDialogPane().setContent(contenu);
	        dialogA.showAndWait();
	    


	    	
	    	  /* try {
	    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("boiteAlert.fxml")); // Remplace par le bon nom
	    	        Parent root = loader.load();

	    	        Stage stage = new Stage();
	    	        stage.setTitle("Aide");
	    	        stage.setScene(new Scene(root));
	    	        stage.setResizable(false);
	    	        stage.show();

	    	    } catch (Exception e) {
	    	        e.printStackTrace();
	    	    }*/
	    }

	    @FXML
	    private void handleQuitter() {
	        System.exit(0);
	    }
	}