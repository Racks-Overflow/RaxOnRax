package domain;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class AccountTest {

    @Test
    public void constructorTest() {
        Trip trip = new Trip();
        List<Trip> tripList = new ArrayList<>();
        tripList.add(trip);
        Account acc = new Account(1L, "wally",
                "jjj.jj@hotmail.com", 1234123422,
                "123413", 1234.0,
                false, false,
                tripList);

        //decided to hold off on testing domains
    }
}
