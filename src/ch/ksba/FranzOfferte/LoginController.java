/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ksba.FranzOfferte;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nico
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button btnConfirm;
    private static LoginController instance;
    public String vorname;
    public String nachname;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          instance=this;
    }
    @FXML
    private void switcher(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("OverviewPage.fxml"));
        Scene viewScene = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();  
        
    }
     public static LoginController getInstance(){
        return instance;
     }
     public void getInfo(){
         vorname = usernameField.getText();
         nachname = passwordField.getText();
     }

    


}
