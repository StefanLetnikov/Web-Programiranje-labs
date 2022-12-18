package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.exeptions.ManufacturerNotFoundExeption;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.jpa.BalloonRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ManufacturerRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAll();
    }

//    @Override
//    public Optional<Balloon> searchByNameOrDescription(String text) {
//        //return balloonRepository.findByNameOrDescription(text);
//        return null;
//    }

    @Override
    public Optional<Balloon> findById(Long id) {
        //return inMemoryBalloonRepository.findById(id);
        return null;
    }

    @Override
    public Optional<Balloon> findByName(String name) {
        //return inMemoryBalloonRepository.findByName(name);
        return null;
    }

    @Override
    @Transactional
    public Optional<Balloon> save(String name, String description, Long manufacturerId) {
        //dali da dodadam proverka i za dali postoe balonot vekje????
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new ManufacturerNotFoundExeption(manufacturerId));
        balloonRepository.deleteByName(name);
        return Optional.of(balloonRepository.save(new Balloon(name, description, manufacturer)));
    }

    @Override
    public void deleteById(Long id) {
        balloonRepository.deleteById(id);
    }

    @Override
    public int getCounter() {
        return DataHolder.counter;
    }
}
