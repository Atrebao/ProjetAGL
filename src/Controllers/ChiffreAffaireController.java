package Controllers;

	import javafx.application.Application;
	import javafx.scene.Node;
	import javafx.scene.Scene;
	import javafx.scene.layout.VBox;
	import javafx.stage.Stage;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.ResultSet;
	import javafx.fxml.FXML;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextField;
	import javafx.event.ActionEvent;

	public class ChiffreAffaireController {
		
			@FXML
			private TextField id_Chiffre;
			
		    @FXML
		    private Button id_button_CA;

			private Statement statement;

			private Node scene;
		    

		    @FXML
		    void CalculeChiffre(ActionEvent event) {
		    String spl ="select Prix from reservation";
		    try {
		    	 Connection connection;
			 	    String databaseName= "bd_projet_agl";
			 	    String url = "jdbc:mysql://localhost/"+databaseName+"?characterEncoding=utf8&useConfigs=maxPerformance";
			 	    
			 	   int sum = 0;
			        ResultSet resultSet = statement.executeQuery("SELECT Prix FROM reservation");
			        while (resultSet.next()) {
			            int number = resultSet.getInt("Prix");
			            sum += number;
			        } 
			        Alert alert = new Alert(Alert.AlertType.INFORMATION);
			        alert.setTitle("Sum");
			        alert.setHeaderText(null);
			        TextField id_Chiffre = new TextField();
				    id_Chiffre.setId("myTextField");
				    TextField textFieldById = (TextField) scene.lookup("#sum");
				    
				 // Affichage de la valeur d'une variable dans le TextField
			        textFieldById.setText("le chiffre d'affaire est " + sum);
			        
			        // Création d'une scène
			        VBox root = new VBox();
					root.getChildren().add(id_Chiffre);
			        Scene scene = new Scene(root, 400, 400);
			        
			        Stage primaryStage = null;
					// Affichage de la scène
			        primaryStage.setScene(scene);
			        primaryStage.show();
				
			} catch (Exception e) {
				
				
				// TODO: handle exception
			}
		    
	    }
			 
		 }
		