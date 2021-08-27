package com.staxoverflow.demo.service;


import com.staxoverflow.demo.domain.Account;
import com.staxoverflow.demo.domain.Trip;
import com.staxoverflow.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.staxoverflow.demo.repository.TripRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    private TripRepo repo;

    //start trip button-front end
    //create newAdminAccount
    public Trip create(Trip trip) {
        return repo.save(trip);
    }

    public Trip read(Long id) {
       return  repo.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("There is no trip with that id"));

    }

    public List<Trip> readAll() {
        Iterable<Trip> tripIterable = repo.findAll();
        List<Trip> result = new ArrayList<>();
        tripIterable.forEach(result::add);
        return result;
    }


    public Trip updateDate(Long id, Date date) {
        Trip original = read(id);
        original.setDate(date);
        return repo.save(original);
    }

    public Trip updateTripLength(Long id, Integer days) {
        Trip original = read(id);
        original.setTripLength(days);
        return repo.save(original);
    }

    public Trip updateEstimate(Long id, Double estimate) {
        Trip original = read(id);
        original.setTripEstimate(estimate);
        return repo.save(original);
    }

    public Trip updateSize(Long id, Integer size) {
        Trip original = read(id);
        original.setGroupSize(size);
        return repo.save(original);
    }

    public Trip updateStatus(Long id, Boolean active) {
        Trip original = read(id);
        original.setActive(active);
        return repo.save(original);
    }

    public Trip updateGroupBalance(Long id, Double deposit) {
        Trip original = read(id);
        original.setGroupBalance(original.getGroupBalance() + deposit);
        return repo.save(original);
    }

    public Trip updateTotalSpent(Long id, Double expenses) {
        Trip original = read(id);
        original.setGroupBalance(original.getGroupBalance() + expenses);
        return repo.save(original);
    }

    public Trip addGuest(Long id, Account account){
        Trip original = read(id);
        original.inviteGuest(account);
        return updateSize(id, original.getGroupSize());
    } //revert this to repo.save if com.staxoverflow.demo.controller doesn't work

    public Trip assignAdmin(Long id, Account account){
        try {
            Trip original = read(id);
            if (account.getGoing()) {
                original.assignAdmin(account);
            }
            return repo.save(original);

        } catch (Exception e){
            throw new UnsupportedOperationException("Account is not admin");
        }
    }

    public Trip removeGuest(Long id, Account account) {
        Trip original = read(id);
        try {
            if (original.getGuestsInvited().contains(account)) {
                original.removeGuest(account);
            }
            return repo.save(original);
        } catch (Exception e){
            throw new ResourceNotFoundException("Trip does not contain that account");
        }
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

    public List<Trip> findByLocation(String destination) {
      return readAll()
               .stream().filter(trip -> trip.getDestination().equals(destination))
               .collect(Collectors.toList());
    }
}
