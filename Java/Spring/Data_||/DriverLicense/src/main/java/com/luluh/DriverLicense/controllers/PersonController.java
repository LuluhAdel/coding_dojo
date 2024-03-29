package com.luluh.DriverLicense.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luluh.DriverLicense.models.License;
import com.luluh.DriverLicense.models.Person;
import com.luluh.DriverLicense.services.LicenseService;
import com.luluh.DriverLicense.services.PersonService;

@Controller
public class PersonController {
private final PersonService personService;
private final LicenseService licenseService;   
    public PersonController(PersonService personService,LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }
    
    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/persons/new.jsp";
    }
    
    @RequestMapping(value="/persons/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "/persons/new.jsp";
        } else {
            personService.createPerson(person);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/persons/{id}")
    public String showPerson(@PathVariable Long id, Model model){
    	License person_license = licenseService.LicenseforPerson(id);
    	if(person_license == null) {
    		return "/persons/new.jsp";
    	}
    	model.addAttribute("license",person_license );
    	return "/persons/show.jsp";
    }
    

    
}
