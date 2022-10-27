package bsuir.ris.lab1.controllers;

import bsuir.ris.lab1.additions.web.Address;
import bsuir.ris.lab1.additions.web.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Address.Base)
public class StartController {

    @GetMapping
    public String transferToStartPage() {
        return View.Start.Name;
    }

}
