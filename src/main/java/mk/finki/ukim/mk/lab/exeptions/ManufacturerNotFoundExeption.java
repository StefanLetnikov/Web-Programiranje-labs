package mk.finki.ukim.mk.lab.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ManufacturerNotFoundExeption extends RuntimeException{
    public ManufacturerNotFoundExeption(Long id) {
        super(String.format("Manufacturer with id %d was not found",id));
    }
}
