package com.staxoverflow.demo.service;


import com.staxoverflow.demo.domain.Account;
import com.staxoverflow.demo.domain.Trip;
import com.staxoverflow.demo.exception.ResourceNotFoundException;
import com.staxoverflow.demo.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.staxoverflow.demo.repository.TripRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
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


    public Trip activate(Long id, Boolean active) {
        Trip original = read(id);
        original.setActive(active);
        return repo.save(original);
    }


    //update balance logic
    public Trip withdrawFromGroupBalance(Long id, Double cost){
            Trip original = read(id);
            original.setGroupBalance(original.getGroupBalance() - cost);
            original.setTotalSpent(original.getGroupBalance() + cost);
            return repo.save(original);
    }

    public Trip poolFunds(Long id, Double groupDeposit){
        Trip original = read(id);
        original.setGroupBalance(groupDeposit);
        original.setActive(true);
        return repo.save(original);
    }


    //thread errors
    public Trip sumAllAccountBalances(Long id) {
        Trip original = read(id);
        Set<Account> guests = original.getGuestsInvited();
        for (Account guest : guests) {
            Double deposit = guest.getBalance();
        }
//        original.getGuestsInvited().stream()
//                .filter(Account::getGoing)
//                .forEach(acc -> depositToGroupBalance(id, acc, acc.getBalance()));
        return repo.save(original);
    }

    public Trip distributeFunds(Long id){
        Trip original = read(id);
        original.setGroupBalance(0.00);
        original.setActive(false);
        return repo.save(original);
    }



    public Trip addGuest(Long id, Account account){
        Trip original = read(id);
        original.inviteGuest(account);
        return repo.save(original);
    }

    public Trip assignAdmin(Long id, Account account){
        Trip original = read(id);
        original.assignAdmin(account);
        return repo.save(original);
    }


    public Trip removeGuest(Long id, Account account) {
        Trip original = read(id);
        original.removeGuest(account);
        return repo.save(original);
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
               .stream().filter(trip -> trip.getDestination().equalsIgnoreCase(destination))
               .collect(Collectors.toList());
    }
}
