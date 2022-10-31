package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    //vrati ja samo listata na baloni
    public List<Balloon> findAllBalloons(){
        return DataHolder.balloons;
    }

    //napravi prabaruvanje niz listata na baloni i ke gi vrate onie vo cie ime ili opis se sodrzi tekstot koj se prakja kako argument na metodot
    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloons.stream().filter(r -> r.getName().equals(text) || r.getDescription().contains(text)).collect(
                Collectors.toList());
    }

}
