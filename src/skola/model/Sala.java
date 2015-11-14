package skola.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Sala {
	@Id
	private String naziv;
	@OneToMany(mappedBy="sala")
	private List<Termin> terminiUSali;
	
	public Sala(){
		terminiUSali=new LinkedList<Termin>();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Termin> getTerminiUSali() {
		return terminiUSali;
	}

	public void setTerminiUSali(List<Termin> terminiUSali) {
		this.terminiUSali = terminiUSali;
	}

	@Override
	public String toString() {
		return "Sala [naziv=" + naziv + ", terminiUSali=" + terminiUSali + "]";
	}
	
	
}
