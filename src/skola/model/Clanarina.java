package skola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Clanarina {
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	private int id;
	@OneToOne
	private Clan platio;
	private Mjesec zaMjesec;
	@Column
	private int godina;
	
	public Clanarina(){
		
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Clan getPlatio() {
		return platio;
	}

	public void setPlatio(Clan platio) {
		this.platio = platio;
	}

	public Mjesec getZaMjesec() {
		return zaMjesec;
	}

	public void setZaMjesec(Mjesec zaMjesec) {
		this.zaMjesec = zaMjesec;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	@Override
	public String toString() {
		return "Clanarina [platio=" + platio + ", zaMjesec=" + zaMjesec
				+ ", godina=" + godina + "]";
	}
	
	
}
enum Mjesec{
	JANUAR,FEBRUAR,MART,APRIL,MAJ,JUN,JUL,AVGUST,SEPTEMBAR,OKTOBAR,NOVEMBAR,DECEMBAR
}
