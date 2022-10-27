package bsuir.ris.lab1.services.repositories;

import bsuir.ris.lab1.models.BikeSpeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BikeSpeedRepository extends JpaRepository<BikeSpeed, Short> {
}
