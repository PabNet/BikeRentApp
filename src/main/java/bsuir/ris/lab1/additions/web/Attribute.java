package bsuir.ris.lab1.additions.web;

public enum Attribute {
    ErrorContent("content"),
    ErrorHeader("header"),
    Bike("bike"),
    User("user"),
    FreeBikes("freeBikes"),
    RentedBikes("rentedBikes"),
    CurrentRentList("rentedList"),
    RentalHistory("rentalHistory"),
    Debtors("debtors"),
    UserLogin("userLogin"),
    RentalTime("rentalTimes");

    public String Name;
    Attribute(String name) {
        this.Name = name;
    }
}
