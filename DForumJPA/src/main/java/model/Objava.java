package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the objava database table.
 * 
 */
@Entity
@NamedQuery(name="Objava.findAll", query="SELECT o FROM Objava o")
public class Objava implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="objava_id")
	private int objavaId;

	private String kategorija;

	private String naslov;

	@Lob
	private String sadrzaj;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="objava")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnik_id")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Omiljeno
	@OneToMany(mappedBy="objava")
	private List<Omiljeno> omiljenos;

	public Objava() {
	}

	public int getObjavaId() {
		return this.objavaId;
	}

	public void setObjavaId(int objavaId) {
		this.objavaId = objavaId;
	}

	public String getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getSadrzaj() {
		return this.sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setObjava(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setObjava(null);

		return komentar;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Omiljeno> getOmiljenos() {
		return this.omiljenos;
	}

	public void setOmiljenos(List<Omiljeno> omiljenos) {
		this.omiljenos = omiljenos;
	}

	public Omiljeno addOmiljeno(Omiljeno omiljeno) {
		getOmiljenos().add(omiljeno);
		omiljeno.setObjava(this);

		return omiljeno;
	}

	public Omiljeno removeOmiljeno(Omiljeno omiljeno) {
		getOmiljenos().remove(omiljeno);
		omiljeno.setObjava(null);

		return omiljeno;
	}

}