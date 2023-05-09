package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the poruka database table.
 * 
 */
@Entity
@NamedQuery(name="Poruka.findAll", query="SELECT p FROM Poruka p")
public class Poruka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="poruka_id")
	private int porukaId;

	@Lob
	private String sadrzaj;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="posaljilac_id")
	private Korisnik korisnik1;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="primalac_id")
	private Korisnik korisnik2;

	public Poruka() {
	}

	public int getPorukaId() {
		return this.porukaId;
	}

	public void setPorukaId(int porukaId) {
		this.porukaId = porukaId;
	}

	public String getSadrzaj() {
		return this.sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public Korisnik getKorisnik1() {
		return this.korisnik1;
	}

	public void setKorisnik1(Korisnik korisnik1) {
		this.korisnik1 = korisnik1;
	}

	public Korisnik getKorisnik2() {
		return this.korisnik2;
	}

	public void setKorisnik2(Korisnik korisnik2) {
		this.korisnik2 = korisnik2;
	}

}