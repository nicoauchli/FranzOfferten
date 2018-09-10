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
public class ProductController implements Initializable {

    @FXML
    private TextField txtNomDeProduit;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPDR;
    @FXML
    private TextField txtPrix;

    public String NDP;
    public String Nombre;
    public String PDR;
    public String Prix;
    public Integer nombre;
    public Integer prix;
    public Integer totalpreis;
    public String total;
    public Integer rabatt;
    public Integer pdr;
    public String rabattotal;
    
    
    
    private static ProductController instance;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         instance=this;
    }

    public void getInfoProduct() {
        NDP = txtNomDeProduit.getText();
        Nombre = txtNombre.getText();
        PDR = txtPDR.getText();
        Prix = txtPrix.getText();
        nombre = Integer.parseInt(Nombre);
        prix = Integer.parseInt(Prix);
        totalpreis = nombre * prix;
        total = String.valueOf(totalpreis);
        
        rabatt = totalpreis / 100;
        pdr = Integer.parseInt(PDR);
        rabatt = rabatt * pdr;
        rabattotal = String.valueOf(rabatt);
        
        
    }

    public void btnConfirmer(ActionEvent event) throws IOException {
        getInfoProduct();

        Parent view3 = FXMLLoader.load(getClass().getResource("CreateOffer.fxml"));
        Scene viewScene = new Scene(view3);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();
    }
    public String getNomDeProduit(){
        return NDP;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getPDR(){
        return PDR;
    }
    public String getPrix(){
        return Prix;
    }
    public String getTotal(){
        return total;
    }
    public String getrabattotal(){
        return rabattotal;
    }
    public static ProductController getInstance(){
        return instance;
    }
    
    
}
