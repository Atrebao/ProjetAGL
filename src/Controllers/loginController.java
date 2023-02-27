package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.projet.dao.DBConnection;
import com.projet.dao.EmployeDao;
import com.projet.dao.IEmploye;
import com.projet.model.Employe;

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
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
	    
	    private List<Employe> listEmp = new ArrayList<>();

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
	    /*	
	    	IEmploye employeDao = new EmployeDao();
	    	//Employe employe = new Employe();
	    	
	    	for(Employe emp : employeDao.getAllEmploye() ) {
	    		if(emp.getNomUtilisateur().equalsIgnoreCase(userName) && emp.getMdp().equalsIgnoreCase(mdp)) {
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
	    	*/
	    	
		
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
						stage.initStyle(StageStyle.UNDECORATED);
						Scene sc = new Scene(root);
						Image icon = new Image(getClass()
			                    .getResourceAsStream("../image/logo.png"));
						stage.getIcons().add(icon);
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
