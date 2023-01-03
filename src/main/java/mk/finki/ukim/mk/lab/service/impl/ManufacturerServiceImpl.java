package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.exeptions.ManufacturerNotFoundExeption;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.InMemoryManufacturerRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ManufacturerRepository;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl  implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(id);
    }

//    @Override
//    public Optional<Manufacturer> findByName(String name) {
//        return manufacturerRepository.findByname(name);
//    }

    @Override
    @Transactional
    public Optional<Manufacturer> save(String name, String country, String address, LocalDate creationDate) {
        manufacturerRepository.deleteByName(name);
        return Optional.of(manufacturerRepository.save(new Manufacturer(name, country, address, creationDate)));
    }

    @Override
    @Transactional
    public Optional<Manufacturer> edit(Long id, String name, String country, String address, LocalDate creationDate) {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new ManufacturerNotFoundExeption(id));
        manufacturer.setName(name);
        manufacturer.setCountry(country);
        manufacturer.setAddress(address);
        manufacturer.setCreationDate(creationDate);
        return Optional.of(manufacturerRepository.save(new Manufacturer(name, country, address, creationDate)));
    }

    @Override
    public void deleteById(Long id) {
        this.manufacturerRepository.deleteById(id);

    }
}
