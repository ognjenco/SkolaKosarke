package skola.controller;
/**
 * Sample Skeleton for 'izgledPocetni.fxml' Controller Class
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import skola.model.Clan;
import skola.model.HibernateSetup;
import skola.model.Trener;

public class PocetniController implements EventHandler<ActionEvent> {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="rodjendani"
    private Label rodjendani; // Value injected by FXMLLoader


    @FXML
    private VBox citavPanel;



    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException {
        assert rodjendani != null : "fx:id=\"rodjendani\" was not injected: check your FXML file 'izgledPocetni.fxml'.";
        assert citavPanel != null : "fx:id=\"citavPanel\" was not injected: check your FXML file 'izgledPocetni.fxml'.";

        Clan[] treneri=HibernateSetup.sviClanovi();
        StringBuilder sb=new StringBuilder();
        for(Clan tr : treneri){
        	sb.append(tr.toString()+System.lineSeparator());
        }
        rodjendani.setText(sb.toString());
        FXMLLoader lo=new FXMLLoader();
        VBox p=lo.load(this.getClass().getClassLoader().getResourceAsStream("dugmad.fxml"));
        p.setFillWidth(true);
        ScrollPane spp=new ScrollPane(p);
        spp.setFitToWidth(true);
        citavPanel.getChildren().add(spp);
        for(Node n : p.getChildren()){
			if(n.getClass().equals(Button.class)){
				((Button)n).setOnAction(this);
				System.out.println("Ukapiran: "+((Button)n).getText());
			}
        }
    }



	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		citavPanel.getChildren().remove(citavPanel.getChildren().size()-1);
		Button src=(Button)event.getSource();
		if(src.getText().equals("Treneri")){
			Label l=new Label("Treneri");
			citavPanel.getChildren().add(l);
		}
	}
}
