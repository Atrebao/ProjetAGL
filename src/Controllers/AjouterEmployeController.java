package Controllers;

import java.io.IOException;

import com.projet.dao.EmployeDao;
import com.projet.dao.IEmploye;
import com.projet.model.Employe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AjouterEmployeController {

    @FXML
    private TextField domiciletextfield;

    @FXML
    private TextField emailtextfield;

    @FXML
    private Button idAjouter;

    @FXML
    private TextField mpdtextfield;

    @FXML
    private TextField nomtextfield;

    @FXML
    private TextField nomutilisateurtextfield;

    @FXML
    private TextField prenomtextfield;

    @FXML
    private TextField sextextfield;

    @FXML
    private TextField telephonetextfield;

	@FXML
    void ajouter(ActionEvent event)  throws IOException {
    		  
    		    
    			
    	    	IEmploye employeDao = new EmployeDao();
    			Employe employe = new Employe();
    			
    			
    			
    			String nomT = nomtextfield.getText().trim();
    	    	String prenomT = prenomtextfield.getText();
    	    	String sexeT = sextextfield.getText().trim();
    	    	String telephoneT = telephonetextfield.getText().trim();
    	    	String domicileT = domiciletextfield.getText().trim();
    	    	String emailT = emailtextfield.getText().trim();
    	    	String nomutilisateurT = nomutilisateurtextfield.getText().trim();
    	    	String mpdT = mpdtextfield.getText().trim();

    	    	            
    	    	
    	    	
    	    	

    	    	employe.setNom(nomT.toUpperCase());
    	    	employe.setPrenom(prenomT.toUpperCase());
    	    	employe.setTelephone(telephoneT.toUpperCase());
    	    	employe.setDomicile(domicileT.toUpperCase());
    	    	employe.setSexe(sexeT.toUpperCase());
    	    	employe.setEmail(emailT.toUpperCase());
    	    	employe.setNomUtilisateur(nomutilisateurT.toUpperCase());
    	    	employe.setMdp(mpdT.toUpperCase());
    	    	
    	    	employeDao.ajouterEmploye(employe);
    	    	
    	    	
    	    	Alert alert = new Alert(AlertType.INFORMATION);
    	    	alert.setTitle("Ajout effectué");
    	    	alert.setHeaderText(null);
    	    	alert.setContentText("L'ajout a été effectué avec succes.");
    	    	alert.showAndWait();

    }

    }


