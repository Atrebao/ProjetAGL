package Controllers;

	import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.poi.ss.formula.functions.T;

import com.projet.dao.DBConnection;
import com.projet.model.Client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

		public class ClientFidelController implements Initializable{

		    @FXML
		    private TableColumn<Client, String> IdNom_Client;

		    @FXML
		    private TableColumn<Client, Integer> Id_Client;

		    @FXML
		    private TableColumn<Client, Integer> idCode_Reservation;

		    @FXML
		    private TableColumn<Client, String> idDomicile;

		    @FXML
		    private TableColumn<Client, String> idNum_Telephone;

		    @FXML
		    private TableColumn<Client, String> idPrenom_Client;

		    @FXML
		    private ImageView idRecherche;

		    @FXML
		    private TableView<Client> idTableview;

		    @FXML
		    private TextField rechercTextfield;

		    public static final ObservableList<Client> clients  = FXCollections.observableArrayList();
		    
		    public  ObservableList<Client> clientList =FXCollections.observableArrayList();
		    
		   
		
		    
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
				int nbre_fidelite = 5;
		    	String query1= "SELECT * FROM  client";
		    	String query2 = "select * from client  HAVING COUNT(*) >"+nbre_fidelite;
		    	
		    	
		    	try {
		    		prepa = (PreparedStatement) connectBD.prepareStatement(query2);
		    		resultset = prepa.executeQuery(query2);
					while(resultset.next()) {
						
						try {
					
									
							
					this.clientList.add( new Client(resultset.getString("NOM"),  resultset.getString("PRENOM"), resultset.getString("NUM_TELEPHONE"), resultset.getString("DOMICILE")));	
					this.clients.add( new Client(resultset.getString("NOM"),  resultset.getString("PRENOM"), resultset.getString("NUM_TELEPHONE"), resultset.getString("DOMICILE")));				
								
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    
		    	//Id_Client.setCellValueFactory(new PropertyValueFactory<>("Id_Client"));
		    	IdNom_Client.setCellValueFactory(new PropertyValueFactory<>("nom"));
		    	idPrenom_Client.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		    	idNum_Telephone.setCellValueFactory(new PropertyValueFactory<>("numTelephone"));
		    	idDomicile.setCellValueFactory(new PropertyValueFactory<>("domicile"));
		    	//idCode_Reservation.setCellValueFactory(new PropertyValueFactory<>("Code_Reservation"));
			     
		    	 idTableview.setItems(null);
			     idTableview.setItems(this.clientList);

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
		    		searchByIdClient(clients,  s);
	          
		            
		        }

		    	idTableview.setItems(null);
			    idTableview.setItems(clientList);

		    }
		    
		    
		    private void searchByIdClient(ObservableList<Client> clt, String s) {
		        clt.clear();
		        for (int i = 0; i < clientList.size(); i++) {
		            if (clientList.get(i).getNom().indexOf(s) == 0) {
		                clt.add(clientList.get(i));
		            }
		        }
		    }
		  
		  
		    
		    
		    
		    
		    
		    
		    
		     

		public void initialize(URL location, ResourceBundle resources) {
			getAll();
			

			
			
			
		}
	}

