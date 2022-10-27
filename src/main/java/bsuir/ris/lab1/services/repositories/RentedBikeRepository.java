package bsuir.ris.lab1.services.repositories;

import bsuir.ris.lab1.models.Rent;
import bsuir.ris.lab1.models.RentedBike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RentedBikeRepository extends JpaRepository<RentedBike, Short> {
}
