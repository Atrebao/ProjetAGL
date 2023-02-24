package Controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import org.dom4j.DocumentException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.projet.dao.ClientDao;
//import com.mysql.jdbc.Connection;
import com.projet.dao.DBConnection;
import com.projet.dao.IClient;
import com.projet.dao.IReservation;
import com.projet.dao.IVillle;
import com.projet.dao.ReservationDao;
import com.projet.dao.VilleDao;
import com.projet.model.Client;
import com.projet.model.Reservation;

import javafx.fxml.Initializable;

public class Test implements Initializable{
	
	final static String path2 = "C:\\Users\\HP\\eclipse-workspaces\\ProjetAGL\\src\\image\\logo.png";
	final static String DEST = "D:\\test.pdf";
	final static Font FONT_SIZE_11_BOLD = new Font(Font.getFamily("HELVETICA"), 11f, Font.BOLD);
	
	private static  List<String> data  = new ArrayList<>();
	

	public static void main(String[] args) throws SQLException, IOException, DocumentException, com.itextpdf.text.DocumentException {
		// TODO Auto-generated method stub
			
			
		 Connection connectBD;
		    
		 Statement stmt;
		 ArrayList<Integer> indexAlreadyTaken = new ArrayList<>();
			
	
		    
		    int index2;
		    
 		
 	    	
 	    	do {
 	    		Random rd = new Random();
 	    		index2 = rd.nextInt(99999);
 	    	}while(indexAlreadyTaken.contains(index2));
 	    	indexAlreadyTaken.add(index2);
 	    	//System.out.println(index2);
 	    	
 	       int n = 25;
 	      String str = String.valueOf(n);
 	     // System.out.println(str);
 	      
 	     String str1 = "ABC123";
         String str2 = "123";
         String str3 = "000000009";

         boolean integerOrNot1 = str1.matches("-?\\d+");
         System.out.println("Is "+str1+" an Integer? -> "+integerOrNot1);

         boolean integerOrNot2 = str2.matches("-?\\d+");
         System.out.println("Is "+str2+" an Integer? -> "+integerOrNot2);

         boolean integerOrNot3 = str3.matches("-?\\d+");;
         System.out.println("Is "+str3+" an Integer? -> "+integerOrNot3);
         

	   

         /*
	     
	     DBConnection connectNow = new DBConnection();
			connectBD = (Connection) connectNow.getConnection();
			stmt= connectBD.createStatement();
			String query = "SELECT COUNT(1) NUM_RESERVATION FROM reservation";
			ResultSet queryResult = stmt.executeQuery(query);
			
			while (queryResult.next()) {
				int num = queryResult.getInt("NUM_RESERVATION");
				System.out.println(num);
				}
         */
			
			// Creating the LocalDatetime object
			LocalDate currentLocalDate = LocalDate.now();
			
			// Getting system timezone
			ZoneId systemTimeZone = ZoneId.systemDefault();
			
			// converting LocalDateTime to ZonedDateTime with the system timezone
			ZonedDateTime zonedDateTime = currentLocalDate.atStartOfDay(systemTimeZone);
			
			// converting ZonedDateTime to Date using Date.from() and ZonedDateTime.toInstant()
			Date utilDate = Date.from(zonedDateTime.toInstant());
			
			// Printing the input and output dates
			System.out.println("LocalDate  : "+currentLocalDate);
			System.out.println("Util Date : "+utilDate);

         
			
			
			Font font2 = new Font(FONT_SIZE_11_BOLD);
			File file = new File(DEST);
	        //file.getParentFile().mkdirs();
	       // createBloc4Donnee(DEST);
	        

	    	DBConnection connectNow = new DBConnection();
	    	Connection connectBD1 = (Connection) connectNow.getConnection();
	    	String query1= "SELECT * FROM  client as c join reservation as r on c.ID_CLIENT = r.NUM_RESERVATION.";
	    	String query2 = "SELECT ID_CLIENT FROM ";
	    	String query3 = "SELECT NUM_RESERVATION FROM reservation";
	    	java.sql.Statement stmt1= connectBD1.createStatement();
	    	ResultSet resultset = stmt1.executeQuery(query1);
	    	//ResultSet result = stmt1.executeQuery(query3);
	    	
	    	while(resultset.next()) {
	    		String nom = resultset.getString("NOM");
	    		String prenoms = resultset.getString("PRENOM");
	    		Integer telephone = resultset.getInt("NUM_TELEPHONE");
	    		String vilArriv = resultset.getString("VILLE_ARRIVEE");
	    		String vilDepart = resultset.getString("VILLE_DEPART");
	    		String numDepart = resultset.getString("NUM_DEPART");
	    		String date = resultset.getString("DATE_DEPART");
	    		
	    		//data = FXCollections.observableArrayList();
	    		
	    		try {
	    			//data.add("bonjour");
					data.add( resultset.getString("NUM_DEPART"));
					//data.add(resultset.getString("DATE_DEPART"));
					//data.add(resultset.getString("VILLE_DEPART"));
					//data.add(resultset.getString("VILLE_ARRIVEE"));
					//data.add(""+resultset.getInt("NUMTRANSACTION"));
					//System.out.println("Data1"+data);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
				
						
				
	    		
	    		//System.out.println(vilDepart+"  Bonjour  "+ vilArriv);
	    			
	    	}
	    	System.out.println("Data2"+data);
	    	resultset.close();
	    	
	    	//System.out.println(data);
	    		    	
	    	//CONVERTI UN STRING EN LOCALDATE
	    	/*
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	    	  String date = "16/08/2016";
*/
	    	  //convert String to LocalDate
	    	 // LocalDate localDate = LocalDate.parse(date);
	    	 // System.out.println(localDate);
	    	
	    	IClient clientDao  = new ClientDao();
	    	IReservation reservationDao = new ReservationDao();
	    	
	    	List<Client> listClients = new ArrayList<>();
	    	List<Reservation> listReservations = new ArrayList<>();
	    	listReservations = reservationDao.getAllReservation();
	    	
	    	for(Reservation reserv : reservationDao.getAllReservation()) {
	    		System.out.println(reserv.getIdEmploye());
	    	}
	    	
	    	 
         
         
         
         
     }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 	}
	 
	
	
	/* 
	   
	 
		public static void createBloc4Donnee(String dest) throws IOException, DocumentException, com.itextpdf.text.DocumentException {
	        Document document = new Document();
	        PdfWriter.getInstance(document, new FileOutputStream(dest));
	        document.open();
	 
			Image image = Image.getInstance(path2);
			image.scalePercent(5);
	 
	 
			Chunk chunk1 = new Chunk("My value to display  : \n Bonjour \n Bonsoir");
			Chunk chunk2 = new Chunk("XXX");
			
			Chunk chunk5 = new Chunk("kkkk");
			Chunk chunk6 = new Chunk("pppp");
	 
			Phrase commentPhrase = new Phrase(2);
			commentPhrase.add(chunk1);
			commentPhrase.add(chunk2);
			
			
			Phrase commentP = new Phrase(2);
			commentP.add(chunk5);
			commentP.add(chunk6);
	 
	 
			Chunk chunk3 = new Chunk("My package to display  : ");
			Chunk chunk4 = new Chunk("1", FONT_SIZE_11_BOLD);
	 
			Phrase packageNumber = new Phrase(2);
			packageNumber.add(chunk3);
			packageNumber.add(chunk4);
	 
			PdfPTable table = new PdfPTable(2);
			table.setWidths(new int[]{5, 5});
	        table.setSpacingBefore(5);
	        table.setWidthPercentage(85);
	        table.getDefaultCell().setColspan(1);
	        table.addCell(commentPhrase);
	        table.addCell(image);
	        table.getDefaultCell().setColspan(2);
	        table.addCell(new Paragraph(""));
	        //table.addCell(new Paragraph(packageNumber));
	 
	 
	        document.add(table);
	        document.close();
	    }
	 
	 
	 
	*/

        
     
 	  
	
	
	
	

}
