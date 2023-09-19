package com.voiture.locationvoiture.controllers;

import com.voiture.locationvoiture.entities.Client;
import com.voiture.locationvoiture.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @RequestMapping("/addclient")
    public String addClient(Model model) {
        Client Client = new Client();
        model.addAttribute("client", Client);
        return "new_client";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient (@ModelAttribute("client") Client client){
        service.save(client);
        return "redirect:/client/";
    }


    @RequestMapping("/")
    public String listClients(Model model){
        List<Client> listClients = service.listAll();
        model.addAttribute("listClients", listClients);
        return "liste_clients";
    }


    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Client client = service.get(id);
        model.addAttribute("client", client);
        return "update_client";
    }

    @PostMapping("update/{id}")
    public String updateClient(@PathVariable("id") long id, @Validated Client client, BindingResult result, Model model){
        if (result.hasErrors()){
            client.setId(id);
            return "update_client";
        }
        service.save(client);
        model.addAttribute("client", service.listAll());
        return "redirect:/client/";
    }


    @GetMapping("delete/{id}")
    public String deleteClient(@PathVariable("id") long id,Model model){

        service.delete(id);
        model.addAttribute("client",service.listAll());
        return "redirect:/client/";
    }
}
