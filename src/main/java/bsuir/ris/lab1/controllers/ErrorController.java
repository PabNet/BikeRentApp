package bsuir.ris.lab1.controllers;

import bsuir.ris.lab1.additions.web.Address;
import bsuir.ris.lab1.additions.web.Attribute;
import bsuir.ris.lab1.additions.web.View;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
public class ErrorController {

    @RequestMapping(value = {Address.Error}, method = RequestMethod.GET)
    public String transferToRunTimeErrorPage(@PathVariable String header,
                                             @PathVariable String content,
                                             Model model) {
        model.addAllAttributes(new HashMap<>() {
            {
                put(Attribute.ErrorHeader.Name, header);
                put(Attribute.ErrorContent.Name, content);
            }
        });

        return View.Error.Name;
    }

}
