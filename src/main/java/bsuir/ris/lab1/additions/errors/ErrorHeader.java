package bsuir.ris.lab1.additions.errors;

public enum ErrorHeader {
    AccountNotFound("An error occurred during authorization"),
    Common("An error has occurred"),
    AccountFound("An error occurred while registering an account"),
    BikeNotFound("Error reproducing information about this bike"),
    UserNotFound("Error playing information about this user"),
    CurrentRentListNotFound("At the moment you have no rented bikes"),
    RentalHistoryIsEmpty("Your bike rental history is empty"),
    ListOfDebtorsIsEmpty("Debtors not found");

    public String Text;
    ErrorHeader(String text) {
        this.Text = text;
    }
}
