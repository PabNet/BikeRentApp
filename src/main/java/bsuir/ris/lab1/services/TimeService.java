package bsuir.ris.lab1.services;

import bsuir.ris.lab1.models.RentedBike;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.HashMap;

@Service
public class TimeService {

    private LocalTime getCheckTime(RentedBike rentedBike) {
        LocalTime startTime = rentedBike.getStartTime().toLocalTime(),
                rentalTime = rentedBike.getRent().getRentalTime().getTime().toLocalTime();

        return startTime.plusHours(rentalTime.getHour())
                .plusMinutes(rentalTime.getMinute())
                .plusSeconds(rentalTime.getSecond());

    }

    public boolean checkIfTimeIsUp(RentedBike rentedBike) {
        return LocalTime.now().isBefore(getCheckTime(rentedBike));
    }

    public Time getRemainingTime(RentedBike rentedBike) {
        LocalTime currentTime = LocalTime.now(), checkTime = getCheckTime(rentedBike);

        return Time.valueOf(checkTime
                .minusHours(currentTime.getHour())
                .minusMinutes(currentTime.getMinute())
                .minusSeconds(currentTime.getSecond()));
    }
}
