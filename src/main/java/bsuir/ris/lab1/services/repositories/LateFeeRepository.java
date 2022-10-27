package bsuir.ris.lab1.services.repositories;

import bsuir.ris.lab1.models.LateFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LateFeeRepository extends JpaRepository<LateFee, Short> {
}
