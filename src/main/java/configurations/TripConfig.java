package configurations;

import domain.Account;
import domain.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import service.TripService;

import javax.annotation.PostConstruct;
import java.util.Date;

@Configuration
public class TripConfig {

    @Autowired
    //may want to create a Depends on AccountConfig here, default Account config is Admin
    TripService tripService;

    @PostConstruct
    //3 default trips autogenerated at different price points for a 7-day length trip, single person
    public void setUp(){
        //low cost
        tripService.create(new Trip(1L, "Sydney, Australia", 364.00, new Account()));
        //medium cost
        tripService.create(new Trip(2L, "Rome,Italy", 1071.00, new Account()));
        //high cost
        tripService.create(new Trip(3L, "Thailand", 2436.00, new Account()));
    }
}
