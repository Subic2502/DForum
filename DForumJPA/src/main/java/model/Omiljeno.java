package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the omiljeno database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljeno.findAll", query="SELECT o FROM Omiljeno o")
public class Omiljeno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="omiljeno_id")
	private int omiljenoId;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnik_id")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Objava
	@ManyToOne
	@JoinColumn(name="objava_id")
	private Objava objava;

	public Omiljeno() {
	}

	public int getOmiljenoId() {
		return this.omiljenoId;
	}

	public void setOmiljenoId(int omiljenoId) {
		this.omiljenoId = omiljenoId;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Objava getObjava() {
		return this.objava;
	}

	public void setObjava(Objava objava) {
		this.objava = objava;
	}

}