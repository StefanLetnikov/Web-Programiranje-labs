package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryBalloonRepository {

    //vrati ja samo listata na baloni
    public List<Balloon> findAllBalloons(){
        return DataHolder.balloons;
    }

    //napravi prabaruvanje niz listata na baloni i ke gi vrate onie vo cie ime ili opis se sodrzi tekstot koj se prakja kako argument na metodot
    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloons.stream().filter(r -> r.getName().equals(text) || r.getDescription().contains(text)).collect(
                Collectors.toList());
    }

    public Optional<Balloon> findByName(String name){
        return DataHolder.balloons.stream().filter(i -> i.getName().equals(name)).findFirst();
    }

    public Optional<Balloon> findById(Long id){
            return DataHolder.balloons.stream().filter(i -> i.getId().equals(id)).findFirst();
        }


    public Optional<Balloon> save(String name, String description, Manufacturer manufacturer){
        DataHolder.balloons.removeIf(i -> i.getName().equals(name));
        Balloon balloon = new Balloon(name,description,manufacturer);
        DataHolder.balloons.add(balloon);
        return Optional.of(balloon);
    }

    public void DeleteById(Long id){
        DataHolder.balloons.removeIf(i -> i.getId().equals(id));
    }

}
