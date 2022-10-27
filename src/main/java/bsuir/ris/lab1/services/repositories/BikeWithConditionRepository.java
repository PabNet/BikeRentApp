package bsuir.ris.lab1.services.repositories;

import bsuir.ris.lab1.models.BikeWithCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BikeWithConditionRepository extends JpaRepository<BikeWithCondition, Short> {
}
