package Controllers;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.projet.dao.IReservation;
import com.projet.dao.ReservationDao;
import com.projet.model.Reservation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class enregistrerReservController implements Initializable{
	
	 @FXML
	    private DatePicker dateDepart;

	    @FXML
	    private Label price;

	    @FXML
	    private ComboBox<String> ComboNumDepart;

	    @FXML
	    private ComboBox<String> comboVilleDepart;

	    @FXML
	    private TextField NumTransacTextfield;

	    @FXML
	    private Label price1;

	    @FXML
	    private ComboBox<String> ComboVilleArrive;

	    @FXML
	    private Label codeReserv;

	    @FXML
	    private Label prix;

	    @FXML
	    private TextField nomTextfield;

	    @FXML
	    private TextField prenomTextfield;

	    @FXML
	    private TextField adresseTextfield;

	    @FXML
	    private TextField teltTextfield;

	    
	   
	    @FXML
	    void EnregistrerButton(ActionEvent event) throws ParseException {
	    	
	    
	    	
	    	
	    	
	    	try {
	    		String villeDepart = comboVilleDepart.getSelectionModel().getSelectedItem().toString();
		    	String villeArrive = ComboVilleArrive.getSelectionModel().getSelectedItem().toString();
		    	String numReserv = ComboNumDepart.getSelectionModel().getSelectedItem().toString();
		    	
		    	
		    	IReservation reservationDao = new ReservationDao();			    	
				  Reservation reservation = new Reservation(); 
				  
				  reservation.setIdClient(0);
				  reservation.setIdEmploye(0);
				  reservation.setNumDepart(123);
				  reservation.setNumReservation(1);
				  reservation.setNumtransaction(134);
				  reservation.setPrix(1342);
				  reservation.setVilleArrivee("Abidjan");
				  reservation.setVilleDepart("Guiglo");
				  reservation.setDateDepart(null);
				  reservationDao.enregistrerReservation(reservation);
				  
				 /* 
				  SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
				  String strDate = dateDepart.getEditor().toString();
				  reservation.setDateDepart(sdf.parse(strDate));
				  reservation.setNumReservation(Integer.parseInt(numReserv));
				  reservation.setNumDepart(Integer.parseInt(numReserv));
				  
				  reservation.setPrix(Integer.parseInt(""));
				  reservation.setNumReservation(Integer.parseInt(NumTransacTextfield.getText()));
				  reservation.setVilleArrivee(villeArrive);
				  reservation.setVilleDepart(villeDepart);
				  reservation.setIdEmploye((Integer) null);
				  reservation.setIdClient((Integer) null);
				 
				  reservation.setNumtransaction(Integer.parseInt(NumTransacTextfield.getText().trim()));
				  reservationDao.enregistrerReservation(reservation);
				  */
				  //System.out.println("==== Enregistrement effectu� avec succ�s!");
				  
			} catch (Exception e) {
				e.printStackTrace();
			}

	    }

	    @FXML
	    void ValiderButton(ActionEvent event) {
	    	prix.setText("12300");

	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			ObservableList<String> listVilleDepart = FXCollections.observableArrayList("Guiglo","Abidjan","Dieukoue");
			this.comboVilleDepart.setItems(listVilleDepart);
			
			ObservableList<String> listVilleArrive= FXCollections.observableArrayList("Guiglo","Abidjan","Dieukoue");
			this.ComboVilleArrive.setItems(listVilleArrive);
			
			ObservableList<String> listNumDepart = FXCollections.observableArrayList("1","2","3");
			this.ComboNumDepart.setItems(listNumDepart);
			
		}

}
