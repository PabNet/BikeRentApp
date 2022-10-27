package bsuir.ris.lab1.additions.web;

public class Address {
    public static final String Base = "/",
                               Error = "/runtimeError/{header}/{content}",
                               Authorization = "/authorization",
                               Registration = "/registration",
                               FreeBikes = "/freeBikes",
                               CurrentRent = "/currentRent",
                               RentalHistory = "/rentHistory",
                               Debtors = "/debtors",
                               RentedBikes = "/rentedBikes",
                               BikeDescription = "/bike/{id}",
                               UserDescription = "/user/{id}",
                               Statistics = "/statistics",
                               Rent = "/rent/{id}",
                               PostRent = "/rent",
                               EndRent = "/endRent/{bikeId}";
}
