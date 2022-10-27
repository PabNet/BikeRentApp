package bsuir.ris.lab1.services.repositories;

import bsuir.ris.lab1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Short> {
    User findByLogin(String login);
}
