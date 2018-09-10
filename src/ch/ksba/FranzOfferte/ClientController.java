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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nico
 */
public class ClientController implements Initializable {

    @FXML
    private TextField txtEnterprise;
    @FXML
    private TextField txtPrénom;
    @FXML
    private TextField txtSalutation;
    @FXML
    private TextField txtNomdeFam;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtCode;
    @FXML
    private TextField txtVille;

    public String enterprise;
    public String prenom;
    public String salutation;
    public String nomDeFam;
    public String adresse;
    public String code;
    public String ville;
    private static ClientController instance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance=this;
    }

    public void getInfoClient() {
        enterprise = txtEnterprise.getText();
        prenom = txtPrénom.getText();
        salutation = txtSalutation.getText();
        nomDeFam = txtNomdeFam.getText();
        adresse = txtAdresse.getText();
        code = txtCode.getText();
        ville = txtVille.getText();
        

    }
    @FXML
    public void btnConfirmer(ActionEvent event) throws IOException {
        getInfoClient();
        
        Parent view3 = FXMLLoader.load(getClass().getResource("Product.fxml"));
        Scene viewScene = new Scene(view3);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show(); 
    }
    public String getEnterprise(){
        return enterprise;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getSalutation(){
        return salutation;
    }
    public String getNomDeFam(){
        return nomDeFam;
    }
    public String getAdresse(){
        return adresse;
    }
    public String getCode(){
        return code;
    }
    public String getVille(){
        return ville;
    }
    
    public static ClientController getInstance(){
        return instance;
    }
    

}
