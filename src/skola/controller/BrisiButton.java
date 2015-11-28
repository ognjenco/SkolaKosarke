package skola.controller;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.css.PseudoClass;
import javafx.scene.control.Button;
import javafx.scene.control.Skin;
import javafx.scene.control.TableCell;
import skola.model.Trener;

public class BrisiButton extends TableCell<Trener, Boolean> {
	public Button dugme;
	public BrisiButton() {
		dugme=new Button("Izbriši");

	}

	@Override
	protected void updateItem(Boolean item, boolean empty) {
		// TODO Auto-generated method stub
		super.updateItem(item, empty);
		if(!empty){
			setGraphic(dugme);
		}
	}

}
