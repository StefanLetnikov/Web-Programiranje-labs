package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    //List<Balloon> searchByNameOrDescription(String text);
    Optional<Balloon> findById(Long id);
    Optional<Balloon> findByName(String name);
    Optional<Balloon> save(String name, String description, Long manufacturerId);
    Optional<Balloon> edit(Long id, String name, String description, Long manufacturerId);
    List<Balloon> searchByNameOrManufacturersCountry(String text);
    void deleteById(Long id);
    int getCounter();

}

