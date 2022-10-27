package bsuir.ris.lab1.controllers;

import bsuir.ris.lab1.additions.errors.ErrorContent;
import bsuir.ris.lab1.additions.errors.ErrorHeader;
import bsuir.ris.lab1.additions.web.Address;
import bsuir.ris.lab1.additions.web.Attribute;
import bsuir.ris.lab1.additions.web.View;
import bsuir.ris.lab1.controllers.templates.BaseController;
import bsuir.ris.lab1.models.FreeBike;
import bsuir.ris.lab1.models.RentedBike;
import bsuir.ris.lab1.services.TimeService;
import bsuir.ris.lab1.services.repositories.BikeRepository;
import bsuir.ris.lab1.services.repositories.FreeBikeRepository;
import bsuir.ris.lab1.services.repositories.RentedBikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class BikeController extends BaseController {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private FreeBikeRepository freeBikeRepository;

    @Autowired
    private RentedBikeRepository rentedBikeRepository;

    @Autowired
    private TimeService timeService;

    @RequestMapping(value = {Address.BikeDescription}, method = RequestMethod.GET)
    public String transferToBikeDescriptionPage(@PathVariable Short id,
                                                Model model) {
        return showViewWithTable(View.BikeDescription.Name,
                errorService.getReadyErrorPage(ErrorHeader.BikeNotFound.Text,
                        ErrorContent.BikeNotFound.Text),
                Attribute.Bike.Name,
                bikeRepository.findById(id).get(),
                model
        );
    }

    @RequestMapping(value = {Address.FreeBikes}, method = RequestMethod.GET)
    public String transferToFreeBikesPage(Model model) {
        var freeBikes = (ArrayList<FreeBike>)freeBikeRepository.findAll();
        freeBikes.removeIf(freeBike->freeBike.getCount() < 1);

        return showViewWithTable(View.FreeBikes.Name,
                new HashMap<>() {{
                    put(Attribute.FreeBikes.Name, freeBikes);
                }},
                model
        );
    }

    @RequestMapping(value = {Address.RentedBikes}, method = RequestMethod.GET)
    public String transferToRentedBikesPage(Model model) {
        var rentedBikes = (ArrayList<RentedBike>) rentedBikeRepository.findAll();
        rentedBikes.removeIf(rentedBike -> !timeService.checkIfTimeIsUp(rentedBike));

        return showViewWithTable(View.RentedBikes.Name,
                new HashMap<>() {{
                    put(Attribute.RentedBikes.Name, rentedBikes);
                }},
                model
        );
    }

}
