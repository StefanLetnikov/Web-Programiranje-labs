package mk.finki.ukim.mk.lab.repository.jpa;


import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon, Long> {

//    Optional<Balloon> findByNameOrDescription(String text);

    List<Balloon> findAllByNameOrManufacturer_Country(String text1, String text2);

    void deleteByName(String name);

}
