package com.luluh.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luluh.languages.models.Language;
import com.luluh.languages.services.LanguageService;


@Controller
public class LanguagesApi {
	
    private final LanguageService languageService;
    public LanguagesApi(LanguageService languageService){
        this.languageService = languageService;
    }
    
    @RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }

    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("languages") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/index.jsp";
        } else {
        	languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/show.jsp";
    }
  
    @RequestMapping(value="/languages/{id}/remove")
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
    
    @RequestMapping(value="/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Language language_to_update = languageService.findLanguage(id);
    	model.addAttribute("language", language_to_update);
    
    	return "/languages/edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}/edit",  method=RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @ModelAttribute("language_updated") Language language_updated) {
    	languageService.updateLanguage(language_updated);
    	return "redirect:/languages";
    }
    
//    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
//    public String destroy(@PathVariable("id") Long id) {
//        languageService.deleteLanguage(id);
//        return "redirect:/languages";
//    }

   
}
