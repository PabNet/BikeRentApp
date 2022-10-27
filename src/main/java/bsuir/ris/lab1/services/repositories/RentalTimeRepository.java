package bsuir.ris.lab1.services.repositories;

import bsuir.ris.lab1.models.RentalTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RentalTimeRepository extends JpaRepository<RentalTime, Short> {
}
