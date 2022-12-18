package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Manufacturer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
     List<Manufacturer> findAll();
     Optional<Manufacturer> findbyId(Long id);
     //Optional<Manufacturer> findByName(String name);
     Optional<Manufacturer> save(String name, String country, String address, LocalDate creationDate);
     void deleteById(Long id);

}
