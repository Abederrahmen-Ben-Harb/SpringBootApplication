package com.voiture.locationvoiture.services;


import com.voiture.locationvoiture.entities.Voiture;
import com.voiture.locationvoiture.repositories.VoitureRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VoitureService {

    @Autowired
    private VoitureRepository repo;
    public List<Voiture> listAll(){
        return repo.findAll();
    }

    public void save (Voiture voiture){
        repo.save(voiture);
    }

    public Voiture get(long id){
        return repo.findById(id).get();
    }

    public void delete (long id){
        repo.deleteById(id);
    }

}
