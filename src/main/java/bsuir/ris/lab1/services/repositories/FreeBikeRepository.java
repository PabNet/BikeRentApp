package bsuir.ris.lab1.services.repositories;

import bsuir.ris.lab1.models.FreeBike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FreeBikeRepository extends JpaRepository<FreeBike, Short> {
}
