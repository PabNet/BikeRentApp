package bsuir.ris.lab1.controllers;

import bsuir.ris.lab1.additions.errors.ErrorContent;
import bsuir.ris.lab1.additions.errors.ErrorHeader;
import bsuir.ris.lab1.additions.web.Address;
import bsuir.ris.lab1.additions.web.Attribute;
import bsuir.ris.lab1.additions.web.View;
import bsuir.ris.lab1.controllers.templates.AccountController;
import bsuir.ris.lab1.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(Address.UserDescription)
public class UserController extends AccountController {

    @GetMapping
    public String transferToUserDescriptionPage(@PathVariable Short id,
                                                Model model) {
        return showViewWithTable(View.UserDescription.Name,
                errorService.getReadyErrorPage(ErrorHeader.UserNotFound.Text,
                        ErrorContent.UserNotFound.Text),
                Attribute.User.Name,
                userRepository.findById(id).get(),
                model);
    }

}
