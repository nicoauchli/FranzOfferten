/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ksba.FranzOfferte;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import com.itextpdf.text.Document;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nico
 */
public class PrinterController implements Initializable {

    
   CreateOfferController createOffer;
    @FXML
    private TextArea txtOffer;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void showOffer(){
        createOffer = CreateOfferController.getInstance();
        txtOffer.setText(createOffer.getOffer());
    }
    @FXML
    public void retour(ActionEvent event) throws IOException{
        Parent view3 = FXMLLoader.load(getClass().getResource("OverviewPage.fxml"));
        Scene viewScene = new Scene(view3);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show(); 
    }
    
    
   
/*
   @FXML
    private void generatePDF(MouseEvent event) throws IOException, DocumentException {
        
        Document document = new Document(PageSize.A4);
        
        PdfWriter.getInstance(document, new FileOutputStream("Texte d'offre.pdf"));
        
        document.open();
        
        HTMLWorker hw = new HTMLWorker(document);
        hw.parse(new StringReader("<html><p>" + this.getHTMLText().concat(createOffer.getOffer()) + "</p></html>"));
        document.close();
        
        mess.setText(messa);
}*/
}
