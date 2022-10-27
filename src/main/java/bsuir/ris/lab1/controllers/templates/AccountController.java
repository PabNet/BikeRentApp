package bsuir.ris.lab1.controllers.templates;

import bsuir.ris.lab1.services.repositories.RoleRepository;
import bsuir.ris.lab1.services.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountController extends BaseController {

    protected final String UserRole = "User", AdminRole = "Admin";

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected RoleRepository roleRepository;
}
