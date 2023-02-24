package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.projet.dao.DBConnection;
import com.projet.model.Client;
import com.projet.model.Reservation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class verifierReservationController<T> implements Initializable{
	
	 @FXML
	    private TextField rechercTextfield;

	    @FXML
	    private TableView<Reservation> tableInformation;
	    
	    @FXML
	    private TableView<Client> tableClient;


	    @FXML
	    private TableColumn<Reservation, Integer> numReserv;

	    @FXML
	    private TableColumn<Reservation, Integer> codeReserv;

	    @FXML
	    private TableColumn<Reservation, String> dateDepart;

	    @FXML
	    private TableColumn<Reservation, String> numDepart;

	    @FXML
	    private TableColumn<Reservation, String> villeDepart;

	    @FXML
	    private TableColumn<Reservation, String> villeArrivee;

	    @FXML
	    private TableColumn<Client, String> nom;

	    
	    
	    public static final ObservableList<Reservation> reservations  = FXCollections.observableArrayList();
	    public static final ObservableList<Client> clients  = FXCollections.observableArrayList();

	    public  ObservableList<Reservation> reservationList= FXCollections.observableArrayList();
	    
	    public  ObservableList<Client> clientList =FXCollections.observableArrayList();
	    
	    private  ObservableList<String> data ;
	    
	    
	    
	    
	    
	    
	    
	    //Permet de rechercher un client et sa reservation avec le code de reservation
	    public void rechercherReservation() {
	    	String search = rechercTextfield.getText();
	    	
	    	
	    }
	    
	    
	    
	    public void getAll() {
	    	
	    
	    	PreparedStatement prepa = null;
	    	ResultSet resultset = null;
	    	DBConnection connectNow = new DBConnection();
	    	Connection connectBD = null;
			try {
				connectBD = (Connection) connectNow.getConnection();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	String query1= "SELECT * FROM  client as c join reservation as r on c.ID_CLIENT = r.NUM_RESERVATION";
	    	
	    	
	    	try {
	    		prepa = (PreparedStatement) connectBD.prepareStatement(query1);
	    		resultset = prepa.executeQuery(query1);
				while(resultset.next()) {
					
					try {
						String name = resultset.getString("NOM");
						String prenoms = resultset.getString("PRENOM");
						int telephone = resultset.getInt("NUM_TELEPHONE");
						String vilA = resultset.getString("VILLE_ARRIVEE");
						String vilDep = resultset.getString("VILLE_DEPART");
						String numDep = resultset.getString("NUM_DEPART");
						String date = resultset.getString("DATE_DEPART");
						
						
								
						
					this.reservationList.add( new Reservation(resultset.getInt("NUMTRANSACTION"), resultset.getString("DATE_DEPART"), resultset.getString("NUM_DEPART"), resultset.getString("VILLE_DEPART"),resultset.getString("VILLE_ARRIVEE")/*,resultset.getString("NOM"),resultset.getInt("CODE_RESERVATION")*/)); 
					this.reservations.add( new Reservation(resultset.getInt("NUMTRANSACTION"), resultset.getString("DATE_DEPART"), resultset.getString("NUM_DEPART"), resultset.getString("VILLE_DEPART"),resultset.getString("VILLE_ARRIVEE")/*,resultset.getString("NOM"),resultset.getInt("CODE_RESERVATION")*/)); ;
					this.clientList.add(new Client(resultset.getString("NOM"),resultset.getInt("CODE_RESERVATION")));
					this.clients.add(new Client(resultset.getString("NOM"),resultset.getInt("CODE_RESERVATION")));
						//this.reservationList.add((T) new Client(resultset.getString("NOM"),resultset.getInt("CODE_RESERVATION")));
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    
	    		
			
			
			// TODO Auto-generated method stub
		
	    	//ObservableList<Client> clientList = FXCollections.observableArrayList();
	    	
	    	/*
			
			IClient clientDao = new ClientDao();
			
			IReservation reservationDao = new ReservationDao();
			
			clientList = FXCollections.observableArrayList();
			
			 //ObservableList<Reservation> reservationList;
			
			reservationList = FXCollections.observableArrayList();
			
			//this.data = FXCollections.observableArrayList();
			
			for(Client client : clientDao.getAllClient()) {
				clientList.add(new Client(client.getNom(), client.getCodeReservation()));
				//System.out.println(this.listVilles);
			}
			
			
			
			for(Reservation reserv : reservationDao.getAllReservation()) {
				reservationList.add(new Reservation(reserv.getNumtransaction() , reserv.getDateDepart(), reserv.getNumDepart(), reserv.getVilleDepart(), reserv.getVilleArrivee()));	
				
			}
			
			
			
			*/
			
			
			
			 
		     numReserv.setCellValueFactory(new PropertyValueFactory<>("numtransaction"));
		     numDepart.setCellValueFactory(new PropertyValueFactory<>("numDepart"));
		     dateDepart.setCellValueFactory(new PropertyValueFactory<>("dateDepart"));
		     villeDepart.setCellValueFactory(new PropertyValueFactory<>("villeDepart"));
		     villeArrivee.setCellValueFactory(new PropertyValueFactory<>("villeArrivee"));
		     nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		     
		     codeReserv.setCellValueFactory(new PropertyValueFactory<>("codeReservation"));
		     
		     
		     tableInformation.setItems(null);
		     tableInformation.setItems(reservationList);
		     tableClient.setItems(clientList);
		     	   
			
	    	
	    }
	    
	    
	    @FXML
	    void clickItem(MouseEvent event) {

	    }
	    
	    @FXML
	    void clickItem2(MouseEvent event) {

	    }


	    @FXML
	    void handleSearchKey(KeyEvent event) throws SQLException {
	    	if (event.getEventType() == KeyEvent.KEY_RELEASED) {
	            String s = rechercTextfield.getText();
	           // searchByNumberReservation(reservations, s);
	           // searchByReservationNumberClients(clients , s);
	          //  searchByCodeReservation();
	          
	            
	        }

		     tableInformation.setItems(null);
		     tableClient.setItems(null);
		     tableInformation.setItems(reservations);
		     tableClient.setItems(clients);
	    }
	    
	    private void searchByNumberReservation(ObservableList<Reservation> res, String s) {
	        res.clear();
	        for (int i = 0; i < reservationList.size(); i++) {
	            if (Integer.toString(reservationList.get(i).getNumtransaction()).indexOf(s) == 0) {
	                res.add(reservationList.get(i));
	            }
	        }
	    }
	    
	    public void searchByCodeReservation(ObservableList<T> list, String s) throws SQLException {
	    	DBConnection connectNow = new DBConnection();
	    	Connection connectBD = (Connection) connectNow.getConnection();
	    	
	    	String query1= "SELECT * FROM  client as c join reservation as r on c.ID_CLIENT = r.NUM_RESERVATION join transaction as t"
	    			+ " on t.NUMTRANSACTION = r.NUM_RESERVATION WHERE CODE_RESERVATION  = "+s;
	    	java.sql.Statement stmt= connectBD.createStatement();
	    	ResultSet resultset = stmt.executeQuery(query1);
	    	//ResultSet result = stmt.executeQuery(query3);
	    	list.clear();
	    	while(resultset.next()) {
	    		
	    		String nom = resultset.getString("NOM");
	    		String prenoms = resultset.getString("PRENOM");
	    		Integer telephone = resultset.getInt("NUM_TELEPHONE");
	    		String vilArriv = resultset.getString("VILLE_ARRIVEE");
	    		String vilDepart = resultset.getString("VILLE_DEPART");
	    		String numDepart = resultset.getString("NUM_DEPART");
	    		String date = resultset.getString("DATE_DEPART");
	    		
	    		
	    		
	    		
	    	}
	    	
	    }
	    
	    
	    private void searchByReservationNumberClients(ObservableList<Client> res, String s) {
	        res.clear();
	        for (int i = 0; i < reservationList.size(); i++) {
	            if (Integer.toString(clientList.get(i).getCodeReservation()).indexOf(s) == 0) {
	                res.add(clientList.get(i));
	            }
	        }
	    }
	    
	    
	    
	    
	    
	     

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		getAll();
		
		
		
	}

}
