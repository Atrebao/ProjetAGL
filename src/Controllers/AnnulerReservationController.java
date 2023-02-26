package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.projet.dao.ClientDao;
import com.projet.dao.DBConnection;
import com.projet.dao.IClient;
import com.projet.dao.INumeroDepart;
import com.projet.dao.IReservation;
import com.projet.dao.ITransaction;
import com.projet.dao.IVillle;
import com.projet.dao.NumeroDepartDao;
import com.projet.dao.ReservationDao;
import com.projet.dao.TransactionDao;
import com.projet.dao.VilleDao;
import com.projet.model.Client;
import com.projet.model.NumeroDepart;
import com.projet.model.Reservation;
import com.projet.model.Transaction;
import com.projet.model.Villes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AnnulerReservationController implements Initializable{
	
	
	 @FXML
	    private TextField nomTextfield;

	    @FXML
	    private TextField telTextfield;

	    @FXML
	    private DatePicker datePickerField;

	    @FXML
	    private TextField prenomTextfield;

	    @FXML
	    private ComboBox<String> comboVilArrive;

	    @FXML
	    private ComboBox<String> villeDepart;

	    @FXML
	    private ComboBox<String> comboSelectCode;
	    
	    @FXML
	    private ComboBox<String> comboNumDepart;
	    
	    private String enventValider;
	    
	    private String vilDepart;
		   
		   private String villeArrive;
		   
		   private String numDepart;
		   
		   private LocalDate localD ;
		   
		   private String datePick;
		   
		   private Integer price;
		   
		   private Integer id_client;
		   
		   private Integer num_reservation;
		   
		   private Integer num_transation;
		   
		   
		   private List<String> listVilles = new ArrayList<>();
		   
		   private List<String> listNumerosDepart = new ArrayList<>();
	    
	    
	    
	    List<String> listCodeReservations = new ArrayList<>();
	    
	  
	    
	    

	    @FXML
	    void annulerButton(ActionEvent event) throws SQLException {
	    	
	    	if(comboSelectCode.getSelectionModel().getSelectedItem() !=null) {
		    	vilDepart = villeDepart.getSelectionModel().getSelectedItem();
		    	String codeReservation = comboSelectCode.getSelectionModel().getSelectedItem();
		    	Integer codeReserv = Integer.parseInt(codeReservation);
		    	
		    	
		    	 villeArrive = comboVilArrive.getSelectionModel().getSelectedItem().toString();
		    	 numDepart= comboNumDepart.getSelectionModel().getSelectedItem().toString();
		    	 localD = datePickerField.getValue();
		    	 //Changer le format de la date
		    	 datePick = localD.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		    	 datePick = datePick.toString();
		    	 
		    	
		    	 
		    	
		    	
	 		IReservation reservationDao = new ReservationDao();	
	 		IClient clientDao = new ClientDao();
	 		ITransaction transactionDao = new TransactionDao();
	 		Reservation reservation = new Reservation();
	 		Client client = new Client();
	 		Transaction transavtion = new Transaction();
	 		
		    	
		    	
		    	String nomTextf = nomTextfield.getText().trim();
		    	String prenomT = prenomTextfield.getText();
//		    	String adresseT = adresseTextfield.getText().trim();
		    	String teltT = telTextfield.getText().trim();
		    	
		    	
	if( this.enventValider !=null) {
		  if(nomTextf.isBlank() == false && prenomT.isBlank() ==false && /*adresseT.isBlank() ==false &&*/ teltT.isBlank() ==false) {
			  if(isNumeric(this.telTextfield.getText()) !=false) {
				if(isInteger(teltT) ==true && /*isInteger(adresseT)==false &&*/ isInteger(nomTextf)==false && isInteger(prenomT)==false) {
					
					recuperInformation();

					
					
					
					Alert alert1 = new Alert(AlertType.CONFIRMATION);
					alert1.setTitle("Annuler reservation");
					alert1.setHeaderText("");
					alert1.setContentText("Etes vous sur de vouloir annuler cette reservation?");
					Optional< ButtonType> result = alert1.showAndWait();
					if(result.get() == ButtonType.OK) {
						 clientDao.supprimerClient(this.id_client);
						    
						 reservationDao.supprimerReservation(this.num_reservation);
						  
						 transactionDao.supprimerTransaction(this.num_transation);
						 
				
						 showInformationAlert("Succes", "","La reservation a été supprimée avec succes!");
					}
					else if(result.get() == ButtonType.CANCEL){
						alert1.close();
					}
					  

				}
			}
		  }
		    		
		    		
		    		
		}
	else {
		System.out.println("Bonjour");
	}

	    	}
	    	else {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Alert ");
				alert.setHeaderText("");
				alert.setContentText("Veuillez selectionner un code de reservation");
				alert.show();
	    	}
	    


	    }
	   

		@FXML
	    void validerButton(ActionEvent event) throws SQLException {
	    	recuperInformation();
	    	this.enventValider = event.getSource().toString();
	    }

	    //Permet de recuperer tout les code de reservation en bb
		
	    public void getAllCodeReservation() throws SQLException{
	    	DBConnection connectNow = new DBConnection();
	    	Connection connectBD = (Connection) connectNow.getConnection();
	    	String query = "select CODE_RESERVATION  from client";
	    	java.sql.Statement stmt= connectBD.createStatement();
	    	ResultSet resultset = stmt.executeQuery(query);
	    	while(resultset.next()) {
	    		String num = resultset.getString("CODE_RESERVATION");
	    		this.listCodeReservations.add(num);
	    			
	    	}
			
			
		}
		
	 /*   
	    public void getReservation(){
	    	IClient clientDao = new ClientDao();
	    	for(Client client : clientDao.getAllClient() ) {
	    		this.listCodeReservations.add(client.getCodeReservation().toString());
	    		
	    	}
			}
			*/
	    
	    public static boolean isNumeric(String strNum) {
	        if (strNum == null) {
	            return false;
	        }
	        try {
	            int d = Integer.parseInt(strNum);
	        } catch (NumberFormatException nfe) {
	            return false;
	        }
	        return true;
	    }
	    
	  //Cette fonction retourne faux si le string n'est pas un entier
	    public static boolean isInteger(String str) {
	    	
	    	return str.matches("-?\\d+");
			
	    	
	    }
	    
	    public static void showInformationAlert(String title, String header, String content) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(title);
			alert.setHeaderText(header);
			alert.setContentText(content);
			alert.show();
		}
		
	    
	    //Recupere toutes les informations relatives a un code reservation
	    public void recuperInformation() throws SQLException {
	    	
	    	
	    	if(comboSelectCode.getSelectionModel().getSelectedItem() !=null) {
	    		String s = comboSelectCode.getSelectionModel().getSelectedItem().toString();
		    	
		    	DBConnection connectNow = new DBConnection();
		    	Connection connectBD = (Connection) connectNow.getConnection();
		    	String query1= "SELECT * FROM  client as c join reservation as r on c.ID_CLIENT = r.NUM_RESERVATION WHERE CODE_RESERVATION = "+s;
		    	
		    	String query3 = "SELECT NUM_RESERVATION FROM reservation";
		    	java.sql.Statement stmt= connectBD.createStatement();
		    	ResultSet resultset = stmt.executeQuery(query1);
		    	//ResultSet result = stmt.executeQuery(query3);
		    	while(resultset.next()) {
		    		String nom = resultset.getString("NOM");
		    		String prenoms = resultset.getString("PRENOM");
		    		Integer telephone = resultset.getInt("NUM_TELEPHONE");
		    		String vilArriv = resultset.getString("VILLE_ARRIVEE");
		    		String vilDepart = resultset.getString("VILLE_DEPART");
		    		String numDepart = resultset.getString("NUM_DEPART");
		    		String date = resultset.getString("DATE_DEPART");
		    		
		    		
		    		
		    		this.villeDepart.setValue(vilDepart);
		    		this.nomTextfield.setText(nom);
		    		this.prenomTextfield.setText(prenoms);
		    		this.telTextfield.setText(telephone.toString());
		    		this.comboNumDepart.setValue(numDepart);
		    		this.comboVilArrive.setValue(vilArriv);
		    		
		    		this.id_client = resultset.getInt("ID_CLIENT");
		    		
		    		this.num_reservation = resultset.getInt("NUM_RESERVATION");
		    		
		    		this.num_transation = resultset.getInt("NUMTRANSACTION");
		    		
		    		
		    		
			    		
		    		IVillle villeDao = new VilleDao();
					
					INumeroDepart numeroDepartDao = new NumeroDepartDao();
					
					for(Villes ville : villeDao.getAllVilles()) {
						if(listVilles.contains(ville.getVille())) {
							
						}
						else {
							this.listVilles.add(ville.getVille());
							//System.out.println(this.listVilles);
						}
						
					}
					
					
					for(NumeroDepart num : numeroDepartDao.getAllNumerosDepart()) {
						
						if(listNumerosDepart.contains(num.getNumero())) {
							
						}
						else {
							this.listNumerosDepart.add(num.getNumero());
						}
						
					}
		    		
		    		
		    		
		    		ObservableList<String> list = FXCollections.observableArrayList(this.listVilles);
		    		this.comboVilArrive.setItems(list);
		    		this.villeDepart.setItems(list);
		    		
		    		ObservableList<String> listD = FXCollections.observableArrayList(this.listNumerosDepart);
		    		this.comboNumDepart.setItems(listD);
		    		
		    		
		    		
		    		
		    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		    		LocalDate localDate = LocalDate.parse(date, formatter);
		    		this.datePickerField.setValue(localDate);
		    		
		    		
		    		
		    		
		    			
		    	}
		    	resultset.close();
	    	}
	    	else {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Alert ");
				alert.setHeaderText("");
				alert.setContentText("Veuillez selectionner un code de reservation");
				alert.show();
	    	}
	    	
	    	
			

	    }
	    
	    //Permet de recupere de prix d'une reservation
	    public Integer recupererPrix() {
	    	
	    	final String  ad = "ABIDJAN-DUEUKOUE";
	    	final String ag = "ABIDJAN-GUIGLO";
	    	final String gd = "GUIGLO-DUEUKOUE";
	    	final String ga = "GUIGLO-ABIDJAN";
	    	final String dg = "DUEUKOUE-GUIGLO";
	    	final String da = "DUEUKOUE-ABIDJAN";
	    	final int prix_AD_DA = 8000;
	    	final int prix_GA_AG = 10000;
	    	final int prix_GD_DG = 2000;
	    	
	    	vilDepart = villeDepart.getSelectionModel().getSelectedItem();
	    	 villeArrive = comboVilArrive.getSelectionModel().getSelectedItem().toString();
	    	 numDepart= comboNumDepart.getSelectionModel().getSelectedItem().toString();
	    	 
	    	
	    	String ligne = villeDepart+"-"+villeArrive;
	    	switch (ligne) {
			case ad: {
				
				price = prix_AD_DA;
				
				break;
			}
			
			case ag: {
				
				price = prix_GA_AG;
				
				break;
			}
			
			case ga: {
				
				price = prix_GA_AG;
				
				break;
			}
			
			case gd: {
				
				price = prix_GD_DG;
				
				break;
			}
			
			case da: {
				
				price = prix_AD_DA;
				
				break;
			}
			
			case dg: {
				
				price = prix_GD_DG;
				
				break;
			}
			
	    	}	
	    	return price;
	    	
	    }
	    	
			
	    	
	   


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method 
		
		
		try {
			getAllCodeReservation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			ObservableList<String> list = FXCollections.observableArrayList(listCodeReservations);
			this.comboSelectCode.setItems(list);
		
		
		
		
		
		
	}

}
