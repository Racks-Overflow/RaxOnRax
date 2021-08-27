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

    @PutMapping(value = "/{trip_id}/invite/{id}")
    public ResponseEntity<Trip> addGuest(@PathVariable Long tripId, @PathVariable Long accountId){
        Account newGuest = accountService.read(accountId);
        return new ResponseEntity<>(tripService.addGuest(tripId, newGuest), HttpStatus.OK);
    }

    @PutMapping(value = "/{trip_id}/assign-admin/{id}")
    public ResponseEntity<Trip> assignAdmin(
            @PathVariable Long tripId,
            @PathVariable Long accountId){
        Account newAdmin = accountService.read(accountId);
        return new ResponseEntity<>(tripService.assignAdmin(tripId, newAdmin),
                HttpStatus.OK);
    }

    @PutMapping(value = "/{trip_id}/remove/{id}")
    public ResponseEntity<Trip> removeGuest(@PathVariable Long tripId, @PathVariable Long accountId){
        Account byeGuest = accountService.read(accountId);
        return new ResponseEntity<>(tripService.removeGuest(tripId, byeGuest), HttpStatus.OK);
    }






//add an admin will be a read method
}
