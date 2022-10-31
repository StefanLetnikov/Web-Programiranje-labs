package mk.finki.ukim.mk.lab.bootstrap;

import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Balloon> balloons = new ArrayList<>();

    // inicijalna lista so baloni (napravena kako snimkite od auditoriiskite)!
    @PostConstruct
    public void init(){
        balloons.add(new Balloon("Balloon_1","Baloon_1 description"));
        balloons.add(new Balloon("Balloon_2","Baloon_2 description"));
        balloons.add(new Balloon("Balloon_3","Baloon_3 description"));
        balloons.add(new Balloon("Balloon_4","Baloon_4 description"));
        balloons.add(new Balloon("Balloon_5","Baloon_5 description"));
        balloons.add(new Balloon("Balloon_6","Baloon_6 description"));
        balloons.add(new Balloon("Balloon_7","Baloon_7 description"));
        balloons.add(new Balloon("Balloon_8","Baloon_8 description"));
        balloons.add(new Balloon("Balloon_9","Baloon_9 description"));
        balloons.add(new Balloon("Balloon_10","Baloon_10 description"));
    }
}
