package skola.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Termin {
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	private int id;
	@ManyToOne(fetch=FetchType.EAGER)
	private Sala sala;
	@OneToOne
	private Grupa grupa;
	@Column
	@Temporal(TemporalType.DATE)
	private Date pocetak;
	
	public Termin(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Grupa getGrupa() {
		return grupa;
	}

	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}

	public Date getPocetak() {
		return pocetak;
	}

	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}

	@Override
	public String toString() {
		return "Termin [id=" + id + ", sala=" + sala + ", grupa=" + grupa
				+ ", pocetak=" + pocetak + "]";
	}
	
	
}
