package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {

    public List<Manufacturer> findAll(){
        return DataHolder.manufacturers;
    }

    public Optional<Manufacturer> findByname(String name){
        return DataHolder.manufacturers.stream().filter(i -> i.getName().equals(name)).findFirst();
    }

    public Optional<Manufacturer> findById(Long id){
        return DataHolder.manufacturers.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Optional<Manufacturer> save(String name, String country, String address){
        DataHolder.manufacturers.removeIf(i -> i.getName().equals(name));
        Manufacturer manufacturer = new Manufacturer(name,country,address);
        DataHolder.manufacturers.add(manufacturer);
        return Optional.of(manufacturer);
    }

    public void DeleteById(Long id){
        DataHolder.manufacturers.removeIf(i -> i.getId().equals(id));
    }
}
