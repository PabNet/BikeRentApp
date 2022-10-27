package bsuir.ris.lab1.controllers;

import bsuir.ris.lab1.additions.errors.ErrorContent;
import bsuir.ris.lab1.additions.errors.ErrorHeader;
import bsuir.ris.lab1.additions.web.Address;
import bsuir.ris.lab1.additions.web.Attribute;
import bsuir.ris.lab1.additions.web.View;
import bsuir.ris.lab1.controllers.templates.BaseController;
import bsuir.ris.lab1.models.BikeMaterial;
import bsuir.ris.lab1.models.RentalTime;
import bsuir.ris.lab1.services.RentService;
import bsuir.ris.lab1.services.repositories.BikeMaterialRepository;
import bsuir.ris.lab1.services.repositories.BikeRepository;
import bsuir.ris.lab1.services.repositories.RentalTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class RentController extends BaseController {

    @Autowired
    private RentService rentService;

    @RequestMapping(value = {Address.RentalHistory}, method = RequestMethod.GET)
    public String transferToRentalHistoryPage(Model model, HttpServletRequest request) {
        return showViewWithTable(View.RentalHistory.Name,
                errorService.getReadyErrorPage(ErrorHeader.RentalHistoryIsEmpty.Text,
                        ErrorContent.RentalHistoryIsEmpty.Text),
                Attribute.RentalHistory.Name,
                rentService.getRentalHistoryOfUser(cookieService.getValue(Attribute.UserLogin.Name, request)),
                model
        );
    }

    @RequestMapping(value = {Address.CurrentRent}, method = RequestMethod.GET)
    public String transferToCurrentRentPage(Model model, HttpServletRequest request) {
        return showViewWithTable(View.CurrentRent.Name,
                errorService.getReadyErrorPage(ErrorHeader.CurrentRentListNotFound.Text,
                        ErrorContent.CurrentRentListNotFound.Text),
                Attribute.CurrentRentList.Name,
                rentService.getCurrentRentOfUser(cookieService.getValue(Attribute.UserLogin.Name, request)),
                model
        );
    }

    @RequestMapping(value = {Address.Debtors}, method = RequestMethod.GET)
    public String transferToDebtorsPage(Model model) {
        return showViewWithTable(View.Debtors.Name,
                errorService.getReadyErrorPage(ErrorHeader.ListOfDebtorsIsEmpty.Text,
                        ErrorContent.ListOfDebtorsIsEmpty.Text),
                Attribute.Debtors.Name,
                rentService.getDebtorsList(),
                model
        );
    }

    @RequestMapping(value = {Address.Rent}, method = RequestMethod.GET)
    public String transferToRentPage(Model model, @PathVariable Short id) {
        return showViewWithTable(View.Rent.Name,
                new HashMap<>() {{
                    put(Attribute.Bike.Name, rentService.getBikeByFreeBikeId(id));
                    put(Attribute.RentalTime.Name, rentService.getRentalTimeList());
                }},
                model
        );
    }

    @PostMapping(Address.PostRent)
    public String rentBike(@RequestParam String bikeModel,
                           @RequestParam String bikeCondition,
                           @RequestParam Short timeId,
                           HttpServletRequest request,
                           Model model) {
        try {
            rentService.addRent(bikeModel, bikeCondition, timeId, cookieService.getValue(Attribute.UserLogin.Name, request));
        } catch(Throwable ex) {
            System.out.println(ex.getMessage());
        }

        return View.UserMenu.Name;
    }

    @RequestMapping(value = {Address.EndRent}, method = RequestMethod.GET)
    public String completeRent(Model model, @PathVariable Short bikeId) {
        try {
            rentService.endRent(bikeId);
        } catch(Throwable ex) {
            System.out.println(ex.getMessage());
        }

        return View.UserMenu.Name;
    }



}
