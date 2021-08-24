package service;


import domain.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TripRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepo repo;

    public Trip create(Trip trip) {
        return repo.save(trip);
    }

    public Trip read(Long id) {
        return repo.findById(id).get();
    }

    public List<Trip> readAll() {
        Iterable<Trip> tripIterable = repo.findAll();
        List<Trip> result = new ArrayList<>();
        tripIterable.forEach(result::add);
        return result;
    }

    public Trip update(Long id, Trip newTripData) {
        return null;
    }

    public Trip delete(Trip trip) {
        repo.delete(trip);
        return trip;
    }

    public Trip delete(Long id) {
        return delete(read(id));
    }
}
