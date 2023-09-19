package com.voiture.locationvoiture.controllers;

import com.voiture.locationvoiture.entities.Voiture;
import com.voiture.locationvoiture.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/voiture")
public class VoitureController{

    @Autowired
    private VoitureService service;

    @RequestMapping("/addvoiture")
    public String addVoiture(Model model) {
        Voiture Voiture = new Voiture();
        model.addAttribute("voiture", Voiture);
        return "new_voiture";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveVoiture (@ModelAttribute("voiture") Voiture voiture){
        service.save(voiture);
        return "redirect:/voiture/";
    }


    @RequestMapping("/")
    public String listeVoitures(Model model){
        List<Voiture> listVoitures = service.listAll();
        model.addAttribute("listVoitures", listVoitures);
        return "liste_voitures";
    }


    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Voiture voiture = service.get(id);
        model.addAttribute("voiture", voiture);
        return "update_voiture";
    }

    @PostMapping("update/{id}")
    public String updateVoiture(@PathVariable("id") long id, @Validated Voiture voiture, BindingResult result, Model model){
        if (result.hasErrors()){
            voiture.setId(id);
            return "update_voiture";
        }
        service.save(voiture);
        model.addAttribute("voiture", service.listAll());
        return "redirect:/voiture/";
    }


    @GetMapping("delete/{id}")
    public String deleteVoiture(@PathVariable("id") long id,Model model){

        service.delete(id);
        model.addAttribute("voiture",service.listAll());
        return "redirect:/voiture/";
    }
}
