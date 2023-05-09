package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the komentar database table.
 * 
 */
@Entity
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="komentar_id")
	private int komentarId;

	@Lob
	private String sadrzaj;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnik_id")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Objava
	@ManyToOne
	@JoinColumn(name="objava_id")
	private Objava objava;

	public Komentar() {
	}

	public int getKomentarId() {
		return this.komentarId;
	}

	public void setKomentarId(int komentarId) {
		this.komentarId = komentarId;
	}

	public String getSadrzaj() {
		return this.sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
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