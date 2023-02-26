package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.projet.dao.DBConnection;
import com.projet.dao.VilleDao;
import com.projet.model.Villes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

	//Definir une class principale portant le nom du controller

public class ModifierDestController implements Initializable {
	@FXML
	private Button butonAjout;
	@FXML
	private Button butonSup;

	@FXML
	private TextField ajoutVill;
	@FXML
	private ComboBox selectVill;
	
	private int id_ville;
	@FXML
	public void supprimer(ActionEvent e) throws SQLException {
		VilleDao villeDao = new VilleDao();
		Villes ville = new Villes();
		String vilCombo = selectVill.getSelectionModel().getSelectedItem().toString();
		DBConnection connectNow = new DBConnection();
    	Connection connectBD = (Connection) connectNow.getConnection();
    	String query1= "SELECT * FROM villes WHERE ville = '"+vilCombo+"'";
    	
    	
    	java.sql.Statement stmt= connectBD.createStatement();
    	ResultSet resultset = stmt.executeQuery(query1);
    	
    	while(resultset.next()) {
    		this.id_ville = resultset.getInt("id_ville");
    		
    		
    	}
    	
    	villeDao.deleteVille(this.id_ville);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("Resultat");
		alert.setContentText("La ville a été supprimée avec succes");
		alert.show();
		
    		
    		
		
		
	}
	
			//Evenement derriere le bouton AJOUTER 
			public void ajouter(ActionEvent e) {
				String nom_ville = ajoutVill.getText().trim().toUpperCase();
				
				if (!nom_ville.isEmpty()) {
					
					VilleDao villeDao = new VilleDao();
					Villes ville = new Villes();
					
					ville.setVille(nom_ville);
					villeDao.saveVille(ville);
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("");
					alert.setHeaderText("Resultat");
					alert.setContentText("La ville a été ajoutée avec succes");
					alert.show();
				}else
					{
						
					}	
			}

	public void afficherVille() {
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		afficherVille();
		
			ObservableList<String> listVILLE = FXCollections.observableArrayList();
		VilleDao villeDao =new VilleDao();
			for(Villes vl : villeDao.getAllVilles()) {
				listVILLE.add(vl.getVille());
			}
		selectVill.setItems(listVILLE);
		
		
		
		
	}

}
