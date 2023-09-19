package com.voiture.locationvoiture.services;

import com.voiture.locationvoiture.entities.Client;
import com.voiture.locationvoiture.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClientService {


    @Autowired
    private ClientRepository repo;
    public List<Client> listAll(){
        return repo.findAll();
    }

    public void save (Client client){
        repo.save(client);
    }

    public Client get(long id){
        return repo.findById(id).get();
    }

    public void delete (long id){
        repo.deleteById(id);
    }
}
