package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.projet.dao.DBConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loginController implements Initializable{
	
	 @FXML
	    private TextField usernameTextfield;

	    @FXML
	    private PasswordField passwordPasswordfield;
	
	  @FXML
	    private AnchorPane parent;

	    @FXML
	    private ComboBox<String> combobox;

	    @FXML
	    private Button Exit;

	    @FXML
	    void ExitButton(ActionEvent event) {}

	    @FXML
	    
	    void buttConnection(ActionEvent event) throws SQLException{
	    	
	    	//String s = combobox.getSelectionModel().getSelectedItem().toString();
	    	
	    
	    	if(usernameTextfield.getText().isBlank()== false && passwordPasswordfield.getText().isBlank()==false) {
	    		validateLogin();
	    	}
	    	else {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Alert ");
				alert.setHeaderText("Veuillez remplir tout les champs");
				alert.setContentText("Le nom d'utilisateur ou le mot de passe est vide");
				alert.show();
	    	}
	    	
	    	
	    	//String s= this.combobox.getValue().toString();
	    	/*
	    	switch (s) {
			case "Employe": {
				try {
		    		Parent root = FXMLLoader.load(getClass().getResource("../FXML_FILES/homepageEmploye.fxml"));
		    		parent.getScene().getWindow().hide();
					Stage stage = new Stage();
					Scene sc = new Scene(root);
					stage.setScene(sc);
					stage.show();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			break;
			
				
			}
			case "Administrateur":{
				parent.getScene().getWindow().hide();
				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("../FXML_FILES/homepageAdmin.fxml"));
					Stage stage = new Stage();
					Scene sc = new Scene(root);
					stage.setScene(sc);
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		break;
				
			}
			
			case "null":{
				parent.getScene().getWindow().hide();
				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("../FXML_FILES/login.fxml"));
					Stage stage = new Stage();
					Scene sc = new Scene(root);
					stage.setScene(sc);
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		break;
				
			}
				
			}
	    	*/
	    	  	
	    	
	    }
	    
	   

	    public void validateLogin() throws SQLException {
	    	String s = combobox.getSelectionModel().getSelectedItem().toString();
	    	String table = s.toLowerCase();
	    	DBConnection connectNow = new DBConnection();
	    	Connection connectBD = (Connection) connectNow.getConnection();
	    	
	    	String userName = usernameTextfield.getText().trim();
	    	String mdp = passwordPasswordfield.getText().trim();
	    	String query = "select * from "+table;
	    	java.sql.Statement stmt= connectBD.createStatement();
			
			ResultSet resultset = stmt.executeQuery(query);
	    	while(resultset.next()) {
	    		
	    		String uName = resultset.getString("NOM_UTILISATEUR");
	    		String mDP = resultset.getString("MDP");
	    		if(uName.equalsIgnoreCase(userName) && mDP.equalsIgnoreCase(mdp)) {
	    			parent.getScene().getWindow().hide();
					Parent root;
					try {
						root = FXMLLoader.load(getClass().getResource("../FXML_FILES/homepage"+s+".fxml"));
						Stage stage = new Stage();
						Scene sc = new Scene(root);
						stage.setScene(sc);
						stage.show();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    		else {
	    			Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Alert ");
					alert.setHeaderText("Erreur");
					alert.setContentText("Le nom d'utilisateur ou le mot de passe est incorrect!");
					alert.show();
	    		}
				
			}
	   
	    }
	    
	    
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList("Employe","Administrateur");
		this.combobox.setItems(list);
		// TODO Auto-generated method stub
		Exit.setOnMouseClicked(event ->{
			System.exit(0);
		});
	}

}