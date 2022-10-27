package bsuir.ris.lab1.services.repositories;

import bsuir.ris.lab1.models.Bike;
import bsuir.ris.lab1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends JpaRepository<Bike, Short> {
    Bike findByModel(String model);
}
