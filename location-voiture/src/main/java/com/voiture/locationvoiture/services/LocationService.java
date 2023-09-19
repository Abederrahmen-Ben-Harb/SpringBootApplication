package com.voiture.locationvoiture.services;


import com.voiture.locationvoiture.entities.Client;
import com.voiture.locationvoiture.entities.Location;
import com.voiture.locationvoiture.repositories.ClientRepository;
import com.voiture.locationvoiture.repositories.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LocationService {


    @Autowired
    private LocationRepository repo;
    public List<Location> listAll(){
        return repo.findAll();
    }

    public void save (Location location){
        repo.save(location);
    }

    public Location get(long id){
        return repo.findById(id).get();
    }

    public void delete (long id){
        repo.deleteById(id);
    }
}
