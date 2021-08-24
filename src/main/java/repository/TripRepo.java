package repository;

import domain.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepo extends CrudRepository <Trip, Long> {
}
