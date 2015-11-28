package skola.controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import skola.model.HibernateSetup;
import skola.model.Trener;
public class TreneriKontroler {

	public Button getNazad() {
		return nazad;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<Trener> tabela;

	@FXML
	private Button dodajTrenera;

	@FXML
	private Button nazad;

	@FXML
	private TableColumn<Trener,String> imeKolona;

	@FXML
	private TableColumn<Trener,String> grupeKolona;

	@FXML
	private TableColumn<Trener, Boolean> brisiKolona;

	@FXML
	private TableColumn<Trener,String> telefonKolona;

	@FXML
	void initialize() {
		assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'treneri.fxml'.";
		assert dodajTrenera != null : "fx:id=\"dodajTrenera\" was not injected: check your FXML file 'treneri.fxml'.";
		assert nazad != null : "fx:id=\"nazad\" was not injected: check your FXML file 'treneri.fxml'.";
		assert imeKolona != null : "fx:id=\"imeKolona\" was not injected: check your FXML file 'treneri.fxml'.";
		assert grupeKolona != null : "fx:id=\"grupeKolona\" was not injected: check your FXML file 'treneri.fxml'.";
		assert brisiKolona != null : "fx:id=\"brisiKolona\" was not injected: check your FXML file 'treneri.fxml'.";
		assert telefonKolona != null : "fx:id=\"telefonKolona\" was not injected: check your FXML file 'treneri.fxml'.";

		Trener[] svi=HibernateSetup.sviTreneri();
		tabela.setItems(FXCollections.observableArrayList(svi));

		imeKolona.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Trener,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Trener, String> param) {
				SimpleStringProperty sp=new SimpleStringProperty(param.getValue().getImeIPrezime());
				sp.addListener(new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
						param.getValue().setImeIPrezime(newValue);
					}
				});
				return sp;
			}
		});
		imeKolona.setCellFactory(new Callback<TableColumn<Trener,String>, TableCell<Trener,String>>() {

			@Override
			public TableCell<Trener, String> call(TableColumn<Trener, String> param) {
				// TODO Auto-generated method stub
				return new TextFieldTableCell<Trener, String>();
			}
		});

		/*brisiKolona.setCellFactory(new Callback<TableColumn<Trener,Boolean>, TableCell<Trener,Boolean>>() {

			@Override
			public TableCell<Trener, Boolean> call(TableColumn<Trener, Boolean> param) {
				BrisiButton brisi=new BrisiButton();
				brisi.dugme.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						int zaBrisanje=brisi.getTableRow().getIndex();
						brisi.getTableView().getItems().remove(zaBrisanje);
						System.out.println("Dugme brisi");
					}
				});
				return null;
			}
		});*/
	}

}
