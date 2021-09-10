package com.staxoverflow.demo.repository;

import com.staxoverflow.demo.domain.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
//    @Query(value = "SELECT trip_id FROM trip_guest_invited t JOIN account_trips acct ON t.trip_id = acct.trip_id WHERE t.trip_id = :tripId", nativeQuery = true)
//    List<Long> findTripsIdsByAccount(@Param("tripId") Long tripId);
}
