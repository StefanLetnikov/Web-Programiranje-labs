package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Manufacturer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
     List<Manufacturer> findAll();
     Optional<Manufacturer> findById(Long id);
     //Optional<Manufacturer> findByName(String name);
     Optional<Manufacturer> save(String name, String country, String address, LocalDate creationDate);
     Optional<Manufacturer> edit(Long id, String name, String country, String address, LocalDate creationDate);
     void deleteById(Long id);

}
