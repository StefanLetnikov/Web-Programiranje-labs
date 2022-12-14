package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.exeptions.ManufacturerNotFoundExeption;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private  final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository){
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findById(id);
    }

    @Override
    public Optional<Balloon> findByName(String name) {
        return balloonRepository.findByName(name);
    }

    @Override
    public Optional<Balloon> save(String name, String description, Long manufacturerId) {
        //dali da dodadam proverka i za dali postoe balonot vekje????
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId).orElseThrow(()->new ManufacturerNotFoundExeption(manufacturerId));
        return this.balloonRepository.save(name,description,manufacturer);
    }

    @Override
    public void deleteById(Long id) {
        this.balloonRepository.DeleteById(id);
    }
}
