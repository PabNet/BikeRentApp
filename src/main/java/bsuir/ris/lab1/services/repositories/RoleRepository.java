package bsuir.ris.lab1.services.repositories;

import bsuir.ris.lab1.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends JpaRepository<Role, Short> {
    Role findByName(String name);
}
