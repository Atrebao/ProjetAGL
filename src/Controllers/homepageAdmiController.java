package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

@SuppressWarnings("unused")
public class homepageAdmiController implements Initializable{

    @FXML
    private Button Dashboard;

    @FXML
    private AnchorPane Pane;

    @FXML
    private Label admiName;

    @FXML
    private AnchorPane holdPane;

    @FXML
    private Button idChiffreAff;

    @FXML
    private Button idClientFidel;
    

    @FXML
    private Button idModifierDest;
    
    @FXML
    private Button Exit;
    

    @FXML
    private Button idAjoutEmploye;

    @FXML
    private ImageView logout;

    @FXML
    private AnchorPane parent;
    
    @FXML
    void voirChiffreAff(ActionEvent event) {
    	try {
    		idAjoutEmploye.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
        	 idModifierDest.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
        	 idClientFidel.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
               // bill.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
                Pane = FXMLLoader.load(getClass().getResource("../FXML_FILES/ChiffreAffaire.fxml"));
                setNode(Pane);
             idChiffreAff.setStyle("-fx-background-color:  #04826c; -fx-text-fill: #000000");
            } catch (IOException e) {
                e.printStackTrace();            
    }

    }
    
    @FXML
    void handleLogout(MouseEvent event) {
    	// bill.getScene().getWindow().hide();
         Stage login = new Stage();
         Parent root;
        
		try {
			Parent r = FXMLLoader.load(getClass().getResource("../FXML_FILES/homepageAdministrateur.fxml"));
		 	parent.getScene().getWindow().hide();
			root = FXMLLoader.load(getClass().getResource("../FXML_FILES/login.fxml"));
			Scene scene = new Scene(root);
	         login.setScene(scene);
	         login.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         

    }
    @FXML
    void ModifierEmp(ActionEvent event){
    	try {
          	 idChiffreAff.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
          	 idModifierDest.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
          	 idClientFidel.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
                 // bill.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
                  Pane = FXMLLoader.load(getClass().getResource("../FXML_FILES/AjouterEmploye.fxml"));
                  setNode(Pane);
                  idAjoutEmploye.setStyle("-fx-background-color:  #04826c; -fx-text-fill: #000000");
              } catch (IOException e) {
                  e.printStackTrace();
              }
 }
  

  



	@FXML
    void modifierDest(ActionEvent event) {
		try {
         	 idChiffreAff.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
         	idAjoutEmploye.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
         	 idClientFidel.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
                // bill.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
                 Pane = FXMLLoader.load(getClass().getResource("../FXML_FILES/ModifierDest.fxml"));
                 setNode(Pane);
             idModifierDest.setStyle("-fx-background-color:  #04826c; -fx-text-fill: #000000");
             } catch (IOException e) {
                 e.printStackTrace();
             }


    }
	
	  @FXML
	    void ClientFidel(ActionEvent event) {
	    	try {
	       	 idChiffreAff.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
	       	 idModifierDest.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
	       	idAjoutEmploye.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
	              // bill.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
	               Pane = FXMLLoader.load(getClass().getResource("../FXML_FILES/ClientFidel.fxml"));
	               setNode(Pane);
	         idClientFidel.setStyle("-fx-background-color:  #04826c; -fx-text-fill: #000000");
	           } catch (IOException e) {
	               e.printStackTrace();
	           }

	    }
	  
		 private void setNode(Node node) {
		        holdPane.getChildren().clear();
		        holdPane.getChildren().add((Node) node);
		        FadeTransition ft = new FadeTransition(Duration.millis(1000));
		        ft.setNode(node);
		        ft.setFromValue(0.1);
		        ft.setToValue(1);
		        ft.setCycleCount(1);
		        ft.setAutoReverse(false);
		        ft.play();

		    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Exit.setOnMouseClicked(event ->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Exit");
			alert.setHeaderText("");
			alert.setContentText("Etes vous sur de vouloir quitter l'application?");
			Optional< ButtonType> result = alert.showAndWait();
			if(result.get() == ButtonType.OK) {
				System.exit(0);
			}
			else if(result.get() == ButtonType.CANCEL){
				alert.close();
			}
			
		});
	}
	
}
