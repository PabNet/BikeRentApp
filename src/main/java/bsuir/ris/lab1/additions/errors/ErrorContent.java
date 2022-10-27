package bsuir.ris.lab1.additions.errors;

public enum ErrorContent {
    AccountNotFound("Account not found. Use the information you entered and try again."),
    Common("During execution, the following exception was thrown: "),
    AccountFound("Аккаунт с таким логином уже существует. Попробуйте другой логин."),
    BikeNotFound("An account with this username already exists. Try another login."),
    UserNotFound("Системе не удалось найти и воспроизвести информацию о соотвутствующем пользователе. Попробуйте позже."),
    CurrentRentListNotFound("The system was unable to find and reproduce information about the corresponding user. Try later."),
    RentalHistoryIsEmpty("Your bike rental history is currently empty."),
    ListOfDebtorsIsEmpty("The system has not identified debtors at the moment.");

    public String Text;
    ErrorContent(String text) {
        this.Text = text;
    }
}
