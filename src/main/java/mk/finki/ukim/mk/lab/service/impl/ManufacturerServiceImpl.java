package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Service;

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
    public Optional<Manufacturer> findbyId(Long id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public Optional<Manufacturer> findByName(String name) {
        return manufacturerRepository.findByname(name);
    }

    @Override
    public Optional<Manufacturer> save(String name, String country, String address) {
        return this.manufacturerRepository.save(name,country,address);
    }

    @Override
    public void deleteById(Long id) {
        this.manufacturerRepository.DeleteById(id);

    }
}
