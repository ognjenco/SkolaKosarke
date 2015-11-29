package skola.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
@Entity
public class Trener {
	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	private int id;
	@Column
	private String imeIPrezime;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="trener")
	@Fetch(FetchMode.SUBSELECT)
	private List<Grupa> grupe ;
	@Column
	private String brojTelefona;

	public Trener(){
		grupe=new ArrayList<Grupa>();
	}
	public Trener(List<Grupa> grupe){
		for(Grupa grupa : grupe)
			this.dodajGrupu(grupa);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}

	public List<Grupa> getGrupe() {
		return grupe;
	}

	private void setGrupe(List<Grupa> grupe) {
		this.grupe = grupe;
	}

	public void dodajGrupu(Grupa nova){
		getGrupe().add(nova);
		nova.setTrener(this);
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	@Override
	public String toString() {
		return "Trener [id=" + id + ", imeIPrezime=" + imeIPrezime
				+ ", brojTelefona=" + brojTelefona + "]";
	}

	public String getGrupeString(){
		StringBuffer sb=new StringBuffer();
		for(Grupa a : getGrupe()){
			sb.append(a.getNaziv()+"    ");
		}
		return sb.toString();
	}


}
