package bsuir.ris.lab1.services.repositories;

import bsuir.ris.lab1.models.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ConditionRepository extends JpaRepository<Condition, Short> {
    Condition findByName(String name);
}
