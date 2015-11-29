package skola.controller;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
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
	private SwingNode swingNode;


	@FXML
	private Button dodajTrenera;

	@FXML
	private Button nazad;



	@FXML
	void initialize() {
		assert dodajTrenera != null : "fx:id=\"dodajTrenera\" was not injected: check your FXML file 'treneri.fxml'.";
		assert nazad != null : "fx:id=\"nazad\" was not injected: check your FXML file 'treneri.fxml'.";
		assert swingNode != null : "fx:id=\"swingNode\" was not injected: check your FXML file 'treneri.fxml'.";
		Trener[] svi=HibernateSetup.sviTreneri();
		DefaultTableModel model=new DefaultTableModel(){
			public List<Trener> podaci=Arrays.asList(svi);
			String[] kolone={"Ime i prezime","Broj telefona","Grupe","Izbriši"};

			@Override
			public void removeRow(int row) {
				// TODO Auto-generated method stub
				super.removeRow(row);
				podaci.remove(row);
			}

			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				if(podaci!=null)
					return podaci.size();
				return 0;
			}

			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return 4;
			}

			@Override
			public String getColumnName(int column) {

				return kolone[column];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				if(column<=1)
					return true;
				else
					return false;
			}

			@Override
			public Object getValueAt(int row, int column) {
				Trener p=podaci.get(row);
				switch(column){
				case 0:
					return p.getImeIPrezime();
				case 1:
					return p.getBrojTelefona();
				case 2:
					return p.getGrupeString();
				case 3:
					return true;
				}
				return p;
			}

			@Override
			public void setValueAt(Object aValue, int row, int column) {
				Trener p=podaci.get(row);
				switch(column){
				case 0:
					p.setImeIPrezime((String)aValue);
					break;
				case 1:
					p.setBrojTelefona((String)aValue);
					break;
				case 2:
					break;
				}
				fireTableRowsUpdated(row, row);
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
					return String.class;

			}
		};

		JTable tabela=new JTable(model);
		tabela.setCellSelectionEnabled(true);
		TableCellRenderer tc=new TableCellRenderer() {
			JButton dugme=new JButton("Izbriši");

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				dugme.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(java.awt.event.ActionEvent e) {
						((DefaultTableModel)table.getModel()).removeRow(row);
					}
				});
				return dugme;
			}
		};
		tabela.getColumnModel().getColumn(3).setCellRenderer(tc);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				swingNode.setContent(new JScrollPane(tabela));
			}
		});


	}

}
