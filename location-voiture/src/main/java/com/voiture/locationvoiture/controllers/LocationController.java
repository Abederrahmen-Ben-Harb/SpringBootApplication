package com.voiture.locationvoiture.controllers;


import com.voiture.locationvoiture.entities.Location;
import com.voiture.locationvoiture.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService service;

    @RequestMapping("/addlocation")
    public String addLocation(Model model) {
        Location Location = new Location();
        model.addAttribute("location", Location);
        return "new_location";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLocation (@ModelAttribute("location") Location location){
        service.save(location);
        return "redirect:/location/";
    }


    @RequestMapping("/")
    public String listLocations(Model model){
        List<Location> listLocations = service.listAll();
        model.addAttribute("listLocations", listLocations);
        return "liste_locations";
    }


    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Location location = service.get(id);
        model.addAttribute("location", location);
        return "update_location";
    }

    @PostMapping("update/{id}")
    public String updateLocation(@PathVariable("id") long id, @Validated Location location, BindingResult result, Model model){
        if (result.hasErrors()){
            location.setId(id);
            return "update_location";
        }
        service.save(location);
        model.addAttribute("location", service.listAll());
        return "redirect:/location/";
    }


    @GetMapping("delete/{id}")
    public String deleteLocation(@PathVariable("id") long id,Model model){

        service.delete(id);
        model.addAttribute("location",service.listAll());
        return "redirect:/location/";
    }
}
