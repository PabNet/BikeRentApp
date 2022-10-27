package bsuir.ris.lab1.controllers;

import bsuir.ris.lab1.additions.web.Address;
import bsuir.ris.lab1.additions.errors.ErrorContent;
import bsuir.ris.lab1.additions.errors.ErrorHeader;
import bsuir.ris.lab1.additions.web.Attribute;
import bsuir.ris.lab1.additions.web.View;
import bsuir.ris.lab1.controllers.templates.AccountController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(Address.Authorization)
public class AuthorizationController extends AccountController {

    @GetMapping
    public String transferToAuthorizationPage() {
        return View.Authorization.Name;
    }

    @PostMapping
    public String authorizeUser(@RequestParam String login,
                                @RequestParam String password,
                                HttpServletResponse response,
                                Model model) {
        var view = "";
        try {
            var user = userRepository.findByLogin(login);
            if (user != null && user.getPassword().equals(password)) {
                switch (user.getRole().getName()) {
                    case UserRole -> {
                        view = View.UserMenu.Name;
                    }
                    case AdminRole -> {
                        view = View.AdminMenu.Name;
                    }
                }

                cookieService.rememberValue(Attribute.UserLogin.Name, user.getLogin(), response);
            } else {
                view = RedirectTemplate + errorService.getReadyErrorPage(ErrorHeader.AccountNotFound.Text,
                                                        ErrorContent.AccountNotFound.Text);
            }
        } catch (Exception ex) {
            view = RedirectTemplate + errorService.getReadyErrorPage(ErrorHeader.Common.Text,
                    ErrorContent.Common.Text + ex.getMessage());
        }

        return view;
    }
}
