package bsuir.ris.lab1.additions.web;

public enum View {
    Start("start"),
    Error("runtimeError"),
    Authorization("authorization"),
    Registration("registration"),
    UserMenu("userMenu"),
    AdminMenu("adminMenu"),
    FreeBikes("freeBikes"),
    BikeDescription("bike"),
    Debtors("debtors"),
    RentedBikes("rentedBikes"),
    RentalHistory("rentHistory"),
    UserDescription("user"),
    CurrentRent("currentRent"),
    Statistics("statistics"),
    Rent("rent");

    public String Name;
    View(String Name) {
        this.Name = Name;
    }
}
