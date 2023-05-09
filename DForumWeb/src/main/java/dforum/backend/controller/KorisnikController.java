package dforum.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dforum.backend.repository.KorisnikRepository;
import model.Korisnik;


@Controller
@RequestMapping(value="/korisnici")
public class KorisnikController {

	@Autowired
	KorisnikRepository kr;
	
	
	
	@RequestMapping(value="/saveKorisnik", method=RequestMethod.POST)
	public String saveClan(String korisnickoIme, String lozinka, String email, Model m) {
		Korisnik k = new Korisnik();
		k.setKorisnickoIme(korisnickoIme);
		k.setLozinka(lozinka);
		k.setEmail(email);
		
		kr.save(k);
		
		m.addAttribute("korisnik", k);
		
		return "index";
	}
	
}