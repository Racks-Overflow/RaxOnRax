package com.staxoverflow.demo.controller;

import com.staxoverflow.demo.domain.Account;
import com.staxoverflow.demo.domain.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.staxoverflow.demo.service.AccountService;
import com.staxoverflow.demo.service.TripService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tripcontroller")
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/create")
    public ResponseEntity<Trip> createTrip(
            @RequestBody Trip trip) {
        return new ResponseEntity<>(tripService.create(trip),
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/see-all")
    public ResponseEntity<List<Trip>> getAllTrips() {
        return new ResponseEntity<>(tripService.readAll(),
                HttpStatus.OK);
    }

    @GetMapping(value = "/find-trip/{id}")
    public ResponseEntity<Trip> getTripById(
            @PathVariable Long id) {
        return new ResponseEntity<>(tripService.read(id),
                HttpStatus.OK);
    }

    @GetMapping(value = "/find-destination/{destination}")
    public ResponseEntity<List<Trip>> getTripsByLocation(
            @PathVariable String destination) {
        return new ResponseEntity<>(tripService.findByLocation(destination),
                HttpStatus.OK);
    }

    @PutMapping(value = "/{trip_id}/invite/{accountId}")
    public ResponseEntity<Trip> addGuest(
            @PathVariable Long trip_id,
            @PathVariable Long accountId){
        Account newGuest = accountService.read(accountId);
        return new ResponseEntity<>(tripService.addGuest(trip_id, newGuest), HttpStatus.OK);
    }

    @PutMapping(value = "/{trip_id}/assign-admin/{accountId}")
    public ResponseEntity<Trip> assignAdmin(
            @PathVariable Long trip_id,
            @PathVariable Long accountId){
        Account newGuest = accountService.read(accountId);
        return new ResponseEntity<>(tripService.assignAdmin(trip_id, newGuest),
                HttpStatus.OK);
    }

    @PutMapping(value = "/{tripId}/remove/{accountId}")
    public ResponseEntity<Trip> removeGuest(
            @PathVariable Long tripId,
            @PathVariable Long accountId){
        Account newGuest = accountService.read(accountId);
        return new ResponseEntity<>(tripService.removeGuest(tripId, newGuest),
                HttpStatus.OK);
    }

    //these methods need exception handling for balances < 0
    @PutMapping(value = "/{id}/pool-funds") //admin access only
    public ResponseEntity<Trip> depositFundsFromAllAccounts(@PathVariable Long id){
        Trip original = tripService.read(id);
        Set<Account> guests = original.getGuestsInvited();
        Double sum = 0.0;
        for (Account guest : guests) {
            sum += guest.getBalance();
        }
        return new ResponseEntity<>(tripService.poolFunds(id, sum), HttpStatus.OK);

    }

    @PutMapping(value = "/{id}/pay") //admin access only
    public ResponseEntity<Trip> payBill(@PathVariable Long id, @RequestBody Double cost){
        return new ResponseEntity<>(tripService.withdrawFromGroupBalance(id, cost), HttpStatus.OK);

    }

    @PutMapping(value = "/{id}/return-trip-funds")
    public ResponseEntity<Trip> endTrip(@PathVariable Long id) {
        return new ResponseEntity<>(tripService.distributeFunds(id), HttpStatus.OK);
    }



//add an admin will be a read method
}
