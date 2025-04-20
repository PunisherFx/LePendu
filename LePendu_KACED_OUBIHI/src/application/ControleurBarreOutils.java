package application;
import javafx.scene.Node;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Platform;

public class ControleurBarreOutils {
	  @FXML private Button jouerButton;
	    @FXML private Button optionsButton;
	    @FXML private Button aideButton;
	    @FXML private Button quitterButton;
	    private Stage boiteOptionsStage;
	    private GestionJeu jeu;
	    private Stage primaryStage;
	    
	    @FXML
	    private void handleJouer(ActionEvent event) {
	    	    try {
	    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("sceneJeu.fxml"));
	    	        Parent root = loader.load();
	    	        SceneJeuController controller = loader.getController();
	    	        GestionJeu jeu = new GestionJeu(getClass().getResource("Dico.txt").getFile());
	    	        jeu.InitialiserPartie();
	    	        controller.setJeu(jeu);
	    	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	        stage.setScene(new Scene(root));
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
	                root.setStyle("-fx-background-color: #FFD966;");
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
	        dialogA.getDialogPane().setStyle(
	        	    "-fx-background-color: #FFD966;"
	        	);
	      
	        TextArea Support = new TextArea("        SUPPORT\n\nContact : support@pendu-jeu.com\n Téléphone : 06 12 34 56 78");
	        Support.setEditable(false);
	        Support.setWrapText(true);
	        Support.setPrefSize(200, 200);
	        Support.setFont(Font.font("Arial", 13));
	        Support.setStyle(
	            "-fx-background-color: #B3B3B3;" +
	            "-fx-border-radius: 15;" +
	            "-fx-background-radius: 15;" +
	            "-fx-border-color: #888;" +
	            "-fx-padding: 10;"
	        );
	        
	        TextArea areaRegles = new TextArea(
	            "- Devinez le mot avant d’être pendu.\n" +
	            "- Chaque mauvaise lettre enlève une vie.\n" +
	            "- Vous avez 5 tentatives.\n" +
	            "- Cliquez sur les lettres pour jouer."
	        );
	        areaRegles.setEditable(false);
	        areaRegles.setWrapText(true);
	        areaRegles.setPrefSize(250, 180);
	        areaRegles.setFont(Font.font("Arial", 13));
	        areaRegles.setStyle(
	            "-fx-background-color: #B3B3B3;" +
	            "-fx-border-radius: 15;" +
	            "-fx-background-radius: 15;" +
	            "-fx-border-color: #888;" +
	            "-fx-padding: 10;"
	        );
	        
	        HBox contenu = new HBox(20);
	        contenu.setPadding(new Insets(10));
	        contenu.getChildren().addAll(Support, areaRegles);
	        contenu.setStyle(
	        		"-fx-background-color: #FFD966;");

	        dialogA.getDialogPane().setContent(contenu);
	        dialogA.showAndWait();
	    }

	    @FXML
	    private void handleQuitter() {
	    	Platform.exit();
	    }
	}