package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class splashScreen_Controller implements Initializable{
	
	 @FXML
	    private AnchorPane rootParent;

	    @FXML
	    private StackPane rootPane;

	
	public class SplashScreen extends Thread{
		Parent root=null;
		
		@Override
		public void run() {
			try {
				
				Thread.sleep(3000);
				
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						
						try {
							root = FXMLLoader.load(getClass().getResource("../FXML_FILES/login.fxml"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Stage stage = new Stage();
						Scene scene = new Scene(root);
						stage.setScene(scene);
						rootParent.getScene().getWindow().hide();
						stage.initStyle(StageStyle.UNDECORATED);
						stage.show();
						
					}
				});
					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			super.run();
		}
		
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		new SplashScreen().start();
	}

}
