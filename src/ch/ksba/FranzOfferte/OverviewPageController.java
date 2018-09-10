/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ksba.FranzOfferte;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nico
 */
public class OverviewPageController implements Initializable {

    @FXML
    private Button btnCreateOffer;
    LoginController login;
    private Label lblVorname;
    private Label lblNachname;
    @FXML
    private Button btnPrinter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void switcherOffer(ActionEvent event) throws IOException {
       Parent view3 = FXMLLoader.load(getClass().getResource("Client.fxml"));
        Scene viewScene = new Scene(view3);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();  
        
    }
    @FXML
    private void switcherOffer2(ActionEvent event) throws IOException {
       Parent view3 = FXMLLoader.load(getClass().getResource("Printer.fxml"));
        Scene viewScene = new Scene(view3);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();  
        
    }
  
}
