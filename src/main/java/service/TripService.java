package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TripRepo;

@Service
public class TripService {

    @Autowired
    private TripRepo repo;
}
