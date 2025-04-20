package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void init() throws IOException {
		 GestionJeu jeu = new GestionJeu(getClass().getResource("Dico.txt").getFile());
		 jeu.InitialiserPartie();
	}

    @Override
    public void start(Stage primaryStage) {
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("premiereScene.fxml"));
        	Parent root = loader.load();
        	ControleurBarreOutils controller = loader.getController();
        	
        	

        	primaryStage.setScene(new Scene(root));
        	primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
   /* public static void setScene(File fichierFXML) {
        try {
        	FXMLLoader loader = new FXMLLoader(Main.class.getResource(fichierFXML));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stagePrincipal.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    public static void main(String[] args) {
        launch(args);
    }
}
