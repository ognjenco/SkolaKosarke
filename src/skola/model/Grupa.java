package skola.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Grupa {
	@Id
	private String naziv;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="grupa")
	private List<Clan> clanovi;
	@ManyToOne(fetch=FetchType.EAGER)
	private Trener trener;
	@OneToMany(mappedBy="grupa")
	private List<Termin> terminiTreninga;
	
	public Grupa(){
		clanovi = new ArrayList<Clan>();
		terminiTreninga=new LinkedList<Termin>();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Clan> getClanovi() {
		return clanovi;
	}

	public void setClanovi(List<Clan> clanovi) {
		this.clanovi = clanovi;
	}

	public Trener getTrener() {
		return trener;
	}

	public void setTrener(Trener trener) {
		this.trener = trener;
	}

	public List<Termin> getTerminiTreninga() {
		return terminiTreninga;
	}

	public void setTerminiTreninga(List<Termin> terminiTreninga) {
		this.terminiTreninga = terminiTreninga;
	}

	@Override
	public String toString() {
		return "Grupa [naziv=" + naziv + ", trener=" + trener + "]";
	}
	
	
}
