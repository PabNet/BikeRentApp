package bsuir.ris.lab1.services.repositories;

import bsuir.ris.lab1.models.RentalPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RentalPriceRepository extends JpaRepository<RentalPrice, Short> {
}
