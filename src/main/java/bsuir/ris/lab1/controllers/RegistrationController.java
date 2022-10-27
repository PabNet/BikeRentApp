package bsuir.ris.lab1.controllers;

import bsuir.ris.lab1.additions.web.Address;
import bsuir.ris.lab1.additions.errors.ErrorContent;
import bsuir.ris.lab1.additions.errors.ErrorHeader;
import bsuir.ris.lab1.additions.web.View;
import bsuir.ris.lab1.controllers.templates.AccountController;
import bsuir.ris.lab1.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(Address.Registration)
public class RegistrationController extends AccountController {

    @GetMapping
    public String transferToRegistrationPage() {
        return View.Registration.Name;
    }

    @PostMapping
    public String registerUser(@RequestParam String name,
                               @RequestParam String passportData,
                               @RequestParam String phone,
                               @RequestParam String email,
                               @RequestParam String login,
                               @RequestParam String password,
                               Model model) {
        var view = "";
        try {
            var user = userRepository.findByLogin(login);
            if (user == null) {
                userRepository.save(new User(login,
                        password,
                        name,
                        email,
                        phone,
                        passportData,
                        roleRepository.findByName(UserRole))
                );
                view = View.Start.Name;
            } else {
                view = RedirectTemplate + errorService.getReadyErrorPage(ErrorHeader.AccountFound.Text,
                        ErrorContent.AccountFound.Text);
            }
        } catch (Exception ex) {
            view = RedirectTemplate + errorService.getReadyErrorPage(ErrorHeader.Common.Text,
                    ErrorContent.Common.Text + ex.getMessage());
        }

        return view;
    }
}
