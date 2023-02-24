package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.projet.dao.DBConnection;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class dashbordController implements Initializable{
	
	@FXML
    private Label totalplace;

    @FXML
    private Label placeReserve;

    @FXML
    private Label placeDispo;
    
    private Connection connectBD;
    
    private Statement stmt;
    
    
    
    
    
    
    @FXML
    private Label date;

    @FXML
    private Label heure;

    
  public void dateHeure() {
	 Date d = new Date();
	 SimpleDateFormat dat = new SimpleDateFormat("EEEE-dd-MMM-yyyy");
	 SimpleDateFormat heur = new SimpleDateFormat("MM:mm");
	 date.setText(dat.format(d));
	// heure.setText(heur.format(d));
	 
  }  
    
    
    
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		// TODO Auto-generated method stub
		
		dateHeure();
		
		try {
			DBConnection connectNow = new DBConnection();
			connectBD = (Connection) connectNow.getConnection();
			stmt= connectBD.createStatement();
			String query = "SELECT COUNT(1) NUM_RESERVATION FROM reservation";
			ResultSet queryResult = stmt.executeQuery(query);
			int total = 200;
			while (queryResult.next()) {
				Integer num = queryResult.getInt("NUM_RESERVATION");
				
					
					/*
					String totalPlaces = this.totalplace.getText().toString();
					Integer totalP = Integer.parseInt(totalPlaces);
					totalP =total;
					this.totalplace.setText(totalP.toString());
					*/
					
					this.placeReserve.setText(num.toString());
					
					this.totalplace.setText(num.toString());
					
					
					String placeDis = this.totalplace.getText().toString();
					Integer placeD = Integer.parseInt(placeDis);
					placeD =total-num ;
					this.totalplace.setText(placeD.toString());
			
				/*
				if( num > total) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Alert ");
					alert.setHeaderText("");
					alert.setContentText("Le nombre de reservation a été atteint!");
					alert.show();
				}
				*/	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
