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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class homepageController implements Initializable{
	

	  @FXML
	  private AnchorPane parent;
	  
    @FXML
    private ImageView logout;

    @FXML
    private Label emplName;

    @FXML
    private Button idEnregiReserv;

    @FXML
    private Button idVerifReserv;

    @FXML
    private Button idModifReserv;
    
    @FXML
    private Button idAnnulerReserv;

    @FXML
    private Button dash;

    @FXML
    private AnchorPane holdPane;

    private AnchorPane Pane;
    
    @FXML
    private Button Exit;

    @FXML
    void annulerReserv(ActionEvent event) {
    	 try {
    		 idEnregiReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
    		 idVerifReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
    		 idModifReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
             dash.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
             Pane = FXMLLoader.load(getClass().getResource("../FXML_FILES/annulerReservation.fxml"));
             setNode(Pane);
             idAnnulerReserv.setStyle("-fx-background-color:  #2D3347; -fx-text-fill: #ffffff");
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    @FXML
    void createDash(ActionEvent event) {
    	 try {
    		 idEnregiReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
    		 idVerifReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
    		 idModifReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
    		 idAnnulerReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
             Pane = FXMLLoader.load(getClass().getResource("../FXML_FILES/dashboard.fxml"));
             setNode(Pane);
             dash.setStyle("-fx-background-color:  #2D3347; -fx-text-fill: #ffffff");
         } catch (IOException e) {
             e.printStackTrace();
         }

    }

    @FXML
    void enregistrerReserv(ActionEvent event) {
    	try {
   		 idVerifReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
   		 idModifReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
   		idAnnulerReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
            dash.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
            Pane = FXMLLoader.load(getClass().getResource("../FXML_FILES/enregistrerReservation.fxml"));
            setNode(Pane);
            idEnregiReserv.setStyle("-fx-background-color:  #2D3347; -fx-text-fill: #ffffff");
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
			Parent r = FXMLLoader.load(getClass().getResource("../FXML_FILES/homepageEmploye.fxml"));
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
    void modifierReserv(ActionEvent event) throws IOException {
    	  try {
    		  idEnregiReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
    		  idVerifReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
    		  idAnnulerReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
              dash.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
              Pane = FXMLLoader.load(getClass().getResource("../FXML_FILES/modifierReservation.fxml"));
              setNode(Pane);
              idModifReserv.setStyle("-fx-background-color:  #2D3347; -fx-text-fill: #ffffff");
          } catch (IOException e) {
              e.printStackTrace();
          }
    	

    }

    @FXML
    void verifierReserv(ActionEvent event) {
    	 try {
    		 idEnregiReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
    		 idModifReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
    		 idAnnulerReserv.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
             Pane = FXMLLoader.load(getClass().getResource("../FXML_FILES/verifierReservation.fxml"));
             dash.setStyle("-fx-background-color:  #ffffff; -fx-text-fill: #000000");
             setNode(Pane);
             idVerifReserv.setStyle("-fx-background-color:  #2D3347; -fx-text-fill: #ffffff");
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
		public void initialize(URL location, ResourceBundle resources) {
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
