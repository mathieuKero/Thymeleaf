package com.thymeleaf.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thymeleaf.form.OrdinateurForm;
import com.thymeleaf.model.Ordinateur;

@Controller
@RequestMapping(value = "/ordinateur")
public class OrdinateurController {

	private static List<com.thymeleaf.model.Ordinateur> ordis = new ArrayList<Ordinateur>();

	
    static {

    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	String date1 = "2018-03-17";
    	String date2 = "2019-05-25";
    	
    	Date d1 = null, d2 = null;
    	
    	try {
			d1 = dateFormat.parse(date1); 
			d2 = dateFormat.parse(date2);
		} catch (Exception e) {}
    	
    	ordis.add(new Ordinateur(
    			"DELL OPTIPLEX 7010 SFF - WINDOWS 10"
				, "Intel Core i7-3770 3.40 GHz"
				, "8Go RAM DDR3"
				, "500Go HDD"
				, d1
				));
    	
        ordis.add(new Ordinateur(
        		"HP PC Bureau Gamer OMEN Obelisk 875-0183nf"
				, "Intel Core i5-9400F"
				, "RAM 16Go"
				, "HDD 1To + SSD 128Go"
				, d2
				));
        
    }
	
	//Basic page
	@GetMapping("")
	public String Ordinateur(Model model) {

		model.addAttribute("listordinateur", ordis);
		
		return "listOrdinateur";
	}	
	
	
    @GetMapping(value = { "/ajouter" })
    public String showAddPersonPage(Model model) {
 
        OrdinateurForm ordiForm = new OrdinateurForm();
        model.addAttribute("ordiForm", ordiForm);
 
        return "formOrdinateur";
    }
 
    @PostMapping(value = { "/ajouter" })
    public String savePerson(Model model, @ModelAttribute("ordiForm") OrdinateurForm ordiForm) {
 
    	String nom = ordiForm.getRam();
    	String processeur = ordiForm.getProcesseur();
    	String ram = ordiForm.getRam();
    	String disqueDur = ordiForm.getDisqueDur();
    	Date dateAchat = ordiForm.getDateAchat();
 
        Ordinateur ordi = new Ordinateur(nom, processeur, ram, disqueDur, dateAchat);
        ordis.add(ordi);

        return "redirect:/listOrdinateur";

    }
	
}
