package mk.finki.ukim.mk.lab.bootstrap;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Order> orderList = new ArrayList<>();
    public static int counter;

    // inicijalna lista so baloni (napravena kako snimkite od auditoriiskite)!
    @PostConstruct
    public void init(){

        Manufacturer manufacturer1 = new Manufacturer("Manufacturer_1","Country_1","Address_1");
        Manufacturer manufacturer2 = new Manufacturer("Manufacturer_2","Country_2","Address_2");
        Manufacturer manufacturer3 = new Manufacturer("Manufacturer_3","Country_3","Address_3");
        Manufacturer manufacturer4 = new Manufacturer("Manufacturer_4","Country_4","Address_4");
        Manufacturer manufacturer5 = new Manufacturer("Manufacturer_5","Country_5","Address_5");
        manufacturers.add(manufacturer1);
        manufacturers.add(manufacturer2);
        manufacturers.add(manufacturer3);
        manufacturers.add(manufacturer4);
        manufacturers.add(manufacturer5);

        balloons.add(new Balloon("Balloon_1","Baloon_1 description",manufacturer1));
        balloons.add(new Balloon("Balloon_2","Baloon_2 description",manufacturer1));
        balloons.add(new Balloon("Balloon_3","Baloon_3 description",manufacturer2));
        balloons.add(new Balloon("Balloon_4","Baloon_4 description",manufacturer2));
        balloons.add(new Balloon("Balloon_5","Baloon_5 description",manufacturer3));
        balloons.add(new Balloon("Balloon_6","Baloon_6 description",manufacturer3));
        balloons.add(new Balloon("Balloon_7","Baloon_7 description",manufacturer4));
        balloons.add(new Balloon("Balloon_8","Baloon_8 description",manufacturer4));
        balloons.add(new Balloon("Balloon_9","Baloon_9 description",manufacturer5));
        balloons.add(new Balloon("Balloon_10","Baloon_10 description",manufacturer5));
    }
}
