package Controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import com.projet.model.Employe;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class enregistrerReservController implements Initializable{
	
	 @FXML
	    private DatePicker dateDepart;

	   

	    @FXML
	    private ComboBox<String> ComboNumDepart;

	    @FXML
	    private ComboBox<String> comboVilleDepart;

	    @FXML
	    private TextField NumTransacTextfield;

	    

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
	    private Label cfa;
	    
	    ArrayList<Integer> indexAlreadyTaken = new ArrayList<>();
	    
	    private int price;
	    
	    private int index;
	    
	    private String enventValider;
	    
	   
	   private LocalDate selectDate ;
	   private String date;
	   
	   private String villeDepart;
	   
	   private String villeArrive;
	   
	   private String numDepart;
	   
	   private String code;
	   
	   private List<String> listVilles = new ArrayList<>();
	   private List<String> listNumDepart = new ArrayList<>();
	   
	  // final static String path2 = "C:\\Users\\HP\\eclipse-workspaces\\ProjetAGL\\src\\image\\logo.png";
	   final static String path2 = "D:\\ProjetAGL\\src\\image\\logo.png";
	   final static String DEST = "D:\\ticket.pdf";
	   final static Font FONT_SIZE_11_BOLD = new Font(Font.getFamily("HELVETICA"), 11f, Font.BOLD);
	   
	   
	    
	    
	   
	    @FXML
	    void EnregistrerButton(ActionEvent event) throws ParseException, IOException, DocumentException, com.itextpdf.text.DocumentException {
	    	
	    	
 	    	getPrix();
	    	
	    	
	    		IReservation reservationDao = new ReservationDao();	
	    		IClient clientDao = new ClientDao();
	    		ITransaction transactionDao = new TransactionDao();
	    		Reservation reservation = new Reservation();
	    		Client client = new Client();
	    		Employe employe = new Employe();
	    		Transaction transavtion = new Transaction();
	    		
		    	
		    	
		    	String nomTextf = nomTextfield.getText().trim();
		    	String prenomT = prenomTextfield.getText();
		    	String adresseT = adresseTextfield.getText().trim();
		    	String teltT = teltTextfield.getText().trim();
		    	
		    	
		    
		    	
		    	 
				 /*
				  reservation.setDateDepart(null);
				  reservation.setIdClient(03);
				  reservation.setIdEmploye(0);
				  reservation.setNumDepart(1);
				  reservation.setNumtransaction(234);
				  reservation.setPrix(1342);
				  reservation.setVilleArrivee("Duekoue");
				  reservation.setVilleDepart("Guiglo"); 
				  reservation.setNumReservation(2);
				*/  
				   
				// reservationDao.enregistrerReservation(reservation);
				 
//				 dateDepart.setValue(LocalDate.now());
//				 LocalDate date = 
				  
				  //System.out.println(strDate);
				  
				  
		    	
			  
				  if(this.enventValider != null) {
					  if(nomTextf.isBlank() == false && prenomT.isBlank() ==false && adresseT.isBlank() ==false && teltT.isBlank() ==false) {
						  if(isInteger(teltT) ==true && isInteger(adresseT)==false && isInteger(nomTextf)==false && isInteger(prenomT)==false) {
							  int NumTransac = Integer.parseInt(NumTransacTextfield.getText().trim());
						    	String pri = prix.getText();
						    	Integer prixs = Integer.parseInt(pri);   	
						    	System.out.println(prixs);
						    	
						    	client.setCodeReservation(Integer.parseInt(this.code));
								  client.setDomicile(adresseT.toUpperCase());
								  client.setNom(nomTextf.toUpperCase());
								  client.setPrenom(prenomT.toUpperCase());
								  client.setNumTelephone(teltT);
								  clientDao.enregistrerClient(client);
								  
							 // reservation.setNumReservation(NumTransac);
							  reservation.setNumDepart(numDepart);
							  reservation.setPrix(prixs);
							  reservation.setVilleArrivee(villeArrive.toUpperCase());
							  reservation.setVilleDepart(villeDepart.toUpperCase());
							  reservation.setIdEmploye(1);
							  reservation.setIdClient(client.getIdClient());
							  reservation.setDateDepart(date);
							  reservation.setNumtransaction(NumTransac);
							  
							  
							  transavtion.setDateTransaction(date);
							  transavtion.setMontant(prixs);
							  //transavtion.setNumtransaction(NumTransac);
							  
							transactionDao.enregistrerTransaction(transavtion);
							  
							reservationDao.enregistrerReservation(reservation);
							
							
							
							Font font2 = new Font(FONT_SIZE_11_BOLD);
							File file = new File(DEST);
					        file.getParentFile().mkdirs();
					        
					        
					        createBloc4Donnee(DEST, nomTextf, prenomT, numDepart, villeDepart, villeArrive, this.code, prixs.toString());
							 showInformationAlert("", "Le client a été enregistré avec succes!"
							 		+ "\n\nLe ticket de la reservation se trouve sur le disque D");
							 
							 
							 nomTextfield.setText(null);
							 prenomTextfield.setText(null);
						     adresseTextfield.setText(null);
						    teltTextfield.setText(null);
						    
						    prix.setText("");
						    comboVilleDepart.setValue("Selectionner ville de depart");
						    comboVilleDepart.setValue("");
						    NumTransacTextfield.setText(null);
						    cfa.setText("???");
						    codeReserv.setText("???");
						    dateDepart.setValue(null);
						    
						    
							 
							 
						  }
						  else {
							  showInformationAlert("Donnees invalide", "Veuillez entrer des donnees correct");
						  }
					  }
					  else {
						  showErrorAlert("L'un des champs est vide", "Veuillez remplir tout les champs");
					  }
					  
				  }
				  else {
					  showErrorAlert("", "Veuillez clicke sur le boutton valider avant d'enregistrer la reservation");
				  }				 
				
				  
				

	    }

	    //Permet de valider les informations de la reservation sans l'enregistrer
	    @FXML
	    void ValiderButton(ActionEvent event) throws ParseException {
	    	
	    	
	    	
	    	
	    	if( dateDepart.getValue() !=null  && comboVilleDepart.getSelectionModel().getSelectedItem() !=null && ComboVilleArrive.getSelectionModel().getSelectedItem() !=null && ComboNumDepart.getSelectionModel().getSelectedItem()!=null && this.NumTransacTextfield.getText().isBlank() ==false) {
	    		
	    		if(isNumeric(this.NumTransacTextfield.getText()) !=false) {
	    			this.enventValider = event.getSource().toString();
	    			//System.out.println("e = "+enventValider);
	    			//System.out.println("event = "+event);
	    			
	    			this.selectDate = dateDepart.getValue();
	    			//Permet de convertir un locoldate en date
			    	 date = selectDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			    	 date = date.toString();
			    	//System.out.println(date);
			    	 
		    		
		    		do {
		    			//Permet de generer un nombre entier de maximum 5 chiffres differents a chaque fois
		 	    		Random rd = new Random();
		 	    		
		 	    		index = rd.nextInt(99999);
		 	    		
		 	    	}while(indexAlreadyTaken.contains(index));
		    		
		 	    	indexAlreadyTaken.add(index);
		 	    	
		 	    	 this.code = String.valueOf(index);//Converti un entier en chaine de caractere
		 	    	 
		 	    	codeReserv.setText(this.code);
		 	    	
		 	    	getPrix();
		 	    	
		 	    	cfa.setText("FCFA");;
	    		}
	    		else {
	    			showErrorAlert("Numero invalide", "Veuillez entrer un numero de transaction correct");
	    			
	    		}
	    		 
	    	}
	    	else {
	    		
	    		showErrorAlert("L'un des champs est vide", "Veuillez remplir tout les champs");
	    		
	    	}
	    	
	    	
	    	
 	    	
			
 	    	
 	    	
	    }
	    
	    @FXML
	    void datePickerButton(ActionEvent event) {
	    	
	    }
	    
	    //Permet de verifier si c'est une valeur numerique elle retourne vrai
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
	    
	    
	    //Un fonction pour les alertes de type erreur
	    private void showErrorAlert(String head, String cont) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Alert ");
			alert.setHeaderText(head);
			alert.setContentText(cont);
			alert.show();
		}
	    
	    //Alerte de confirmation
	    private void showInformationAlert(String head, String cont) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Enregistrement");
			alert.setHeaderText(head);
			alert.setContentText(cont);
			alert.show();
		}
	    
	    public void getPrix() {
	    	final String  ad = "ABIDJAN-DUEUKOUE";
	    	final String ag = "ABIDJAN-Guiglo";
	    	final String gd = "GUIGLO-DUEUKOUE";
	    	final String ga = "GUIGLO-ABIDJAN";
	    	final String dg = "DUEUKOUE-GUIGLO";
	    	final String da = "DUEUKOUE-ABIDJAN";
	    	final int prix_AD_DA = 8000;
	    	final int prix_GA_AG = 10000;
	    	final int prix_GD_DG = 2000;
	    	
	    	villeDepart = comboVilleDepart.getSelectionModel().getSelectedItem().toString();
	    	 villeArrive = ComboVilleArrive.getSelectionModel().getSelectedItem().toString();
	    	 numDepart= ComboNumDepart.getSelectionModel().getSelectedItem().toString();
	    	
	    	String ligne = villeDepart+"-"+villeArrive;
	    	switch (ligne) {
			case ad: {
				
				price = prix_AD_DA;
				prix.setText(String.valueOf(price));
				break;
			}
			
			case ag: {
				
				price = prix_GA_AG;
				prix.setText(String.valueOf(price));
				break;
			}
			
			case ga: {
				
				price = prix_GA_AG;
				prix.setText(String.valueOf(price));
				break;
			}
			
			case gd: {
				
				price = prix_GD_DG;
				prix.setText(String.valueOf(price));
				break;
			}
			
			case da: {
				
				price = prix_AD_DA;
				prix.setText(String.valueOf(price));
				break;
			}
			
			case dg: {
				
				price = prix_GD_DG;
				prix.setText(String.valueOf(price));
				break;
			}
			
			default:
				showErrorAlert("Message d'erreur", "Veuillez selectionner des villes differentes");
			
	    	}	
	    	
	    }
	    
	    
		 //Fonction pour creer un ticket
			public static void createBloc4Donnee(String dest,String nom,String prenom,String numDepart,String vilDep, String vilArr,String codRes, String prix) throws IOException, DocumentException, com.itextpdf.text.DocumentException {
		        Document document = new Document();
		        PdfWriter.getInstance(document, new FileOutputStream(dest));
		        document.open();
		 
				Image image = Image.getInstance(path2);
				image.scalePercent(5);
		 
		 
				Chunk chunk1 = new Chunk("NOM  : "+nom.toUpperCase()
						+ "\n\nPRENOMS  :"+prenom.toUpperCase()
						+ "\n\nNUMERO DE DEPART  :"+numDepart.toUpperCase()
						+ "\n\nVILLE DE DEPART  :"+vilDep.toUpperCase()
						+ "\n\nVILLE D'ARRIVEE  :"+vilArr.toUpperCase()
						+ "\n\nCODE DE RESERVATION  :"+codRes.toUpperCase()
						+ "\n\nMONTANT DE LA RESERVATION  :"+prix,  FONT_SIZE_11_BOLD);
				
		 
				Phrase commentPhrase = new Phrase(2);
				commentPhrase.add(chunk1);
				
		 
		 
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
	    
	  
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			IVillle villeDao = new VilleDao();
			
			INumeroDepart numeroDepartDao = new NumeroDepartDao();
			
			for(Villes ville : villeDao.getAllVilles()) {
				this.listVilles.add(ville.getVille());
				//System.out.println(this.listVilles);
			}
			
			for(NumeroDepart num : numeroDepartDao.getAllNumerosDepart()) {
				this.listNumDepart.add(num.getNumero());
			}
			
			// TODO Auto-generated method stub
			ObservableList<String> listVilleDepart = FXCollections.observableArrayList(this.listVilles);
			this.comboVilleDepart.setItems(listVilleDepart);
			
			ObservableList<String> listVilleArrive= FXCollections.observableArrayList(this.listVilles);
			this.ComboVilleArrive.setItems(listVilleArrive);
			
			ObservableList<String> listNumDep = FXCollections.observableArrayList(this.listNumDepart);
			this.ComboNumDepart.setItems(listNumDep);
			
		}

}
