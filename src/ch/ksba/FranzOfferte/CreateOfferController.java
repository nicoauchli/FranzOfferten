/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ksba.FranzOfferte;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nico
 */
public class CreateOfferController implements Initializable {

    private String textOffer;
    private String df;
    private String Termin1;
    private double MWST = 7.7;
    private String vendor;
    private String NA;
    private String NC;
    private String ajouter1;
    private String ajouter2;
    private String ajouter3;
    private String DDP;
    private String PDV;
    private String zahlungsart;
     private static CreateOfferController instance;
    
    ClientController client;
    ProductController product;
    @FXML
    private TextArea txtArea;
    @FXML
    private DatePicker dateTimePicker;
    @FXML
    private TextField txtNA;
    @FXML
    private TextField txtNC;
    @FXML
    private Pane btnCreateOffer;
    
    @FXML
    private TextField txtAjouter1;
    @FXML
    private TextField txtAjouter2;
    @FXML
    private TextField txtAjouter3;
    @FXML
    private TextField txtVendor;
    @FXML
    private TextField txtDDP;
    @FXML
    private TextField txtPDV;
    @FXML
    private TextField txtMDP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance=this;
    }

    private void getInfo() {
        vendor = txtVendor.getText();
        NA = txtNA.getText();
        NC = txtNC.getText();
        ajouter1 = txtAjouter1.getText();
        ajouter2 = txtAjouter2.getText();
        ajouter3 = txtAjouter3.getText();
        DDP = txtDDP.getText();
        PDV = txtPDV.getText();
        zahlungsart = txtMDP.getText();
        
        

        if (dateTimePicker.getValue() != null) {
            LocalDate ld = dateTimePicker.getValue();
            Calendar c = Calendar.getInstance();
            c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
            Date date = c.getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");
            Termin1 = dateFormat.format(date);
        }

    }

    @FXML
    private void btnCreateOffer(ActionEvent event) {
        client=ClientController.getInstance();
        product = ProductController.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");
        Date date = new Date();
        df = dateFormat.format(date);
        
        

        getInfo();
        textOffer = "";
        textOffer += "VIN de LausanneSA \n" + "3, Rue de la Piquette \n2000 Lausanne\n\n";
        textOffer += client.getEnterprise() + "\n" + client.getPrenom() + " " 
                  + client.getNomDeFam() + "\n" + client.getAdresse() + "\n" + client.getCode()+ " " + client.ville + "\n\n";
        textOffer += "Lausanne " + "" + df + "\n\n";
        textOffer += "Offre pour " + product.getNomDeProduit() + "\n\n";
        textOffer += client.getSalutation() + "\n\n";
        textOffer += "Nous avons bien reçu votre demande du" + " " + Termin1 + "  " + "et nous vous en remercions vivement." + "\n";
        textOffer += "Nous avons le plaisir de soumettre l'offre suivante." + "\n\n";
        textOffer += product.getNombre() + "      " + product.getNomDeProduit() + "    " + product.getTotal() + " CHF" + "    " + MWST + "MWST" + "\n\n";
        textOffer += "Nous vous proposons le " + product.getNomDeProduit() + " au prix de " + product.getPrix() + " CHF " + MWST + " par bouteille « »." + "\n"
               + "En outre, vous pouvez profiter d’une remise spéciale de " + product.getPDR() + " % pour toute commande" + "\n" + "supérieure à " + product.getrabattotal() + " CHF." + "\n\n";
        textOffer+= "Nous promettons de vous livrer la commande sous 7 jours." + "\n" + "Le délai de paiement est de " + DDP + " jours après réception de la marchandise." + "\n"
                + "Nous vous prions de payer " + zahlungsart + "Cette offre est valable jusqu'au " + Termin1 + "." + "\n\n  ";
        textOffer += "" + NA + "\n\n  ";
        textOffer += "" + NC + "\n\n";
        textOffer += "Si vous avec encore des questions, n'hésitez pas de nous contacter." + "\n\n";
        textOffer += "Dans l’attente de votre commande, nous vous prions d'agréer " + client.getSalutation() + " nos meilleures salutations." + "\n\n  ";
        textOffer += "" + vendor + " " + PDV + "\n";
        textOffer += "Annexe:" + "\n\n" + ajouter1 + "\n" + ajouter2 + "\n" + ajouter3;
     
        txtArea.setText(textOffer);
    }
    public String getOffer(){
        return textOffer;
    }
      public static CreateOfferController getInstance(){
        return instance;
    }
       @FXML
    private void switcherOffer3(ActionEvent event) throws IOException {
       Parent view3 = FXMLLoader.load(getClass().getResource("OverviewPage.fxml"));
        Scene viewScene = new Scene(view3);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();  
        
    }
   

}
