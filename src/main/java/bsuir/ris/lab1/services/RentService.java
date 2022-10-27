package bsuir.ris.lab1.services;

import bsuir.ris.lab1.models.*;
import bsuir.ris.lab1.services.repositories.*;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

@Service
public class RentService {
    @Autowired
    private RentalHistoryRepository rentalHistoryRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private RentedBikeRepository rentedBikeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LateFeeRepository lateFeeRepository;

    @Autowired
    private DelayTimeRepository delayTimeRepository;

    @Autowired
    private BikeWithConditionRepository bikeWithConditionRepository;

    @Autowired
    private RentalTimeRepository rentalTimeRepository;

    @Autowired
    private TimeService timeService;

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private RentalPriceRepository rentalPriceRepository;

    @Autowired
    private FreeBikeRepository freeBikeRepository;

    @Autowired
    private ConditionRepository conditionRepository;

    public Iterable<RentalHistory> getRentalHistoryOfUser(String login) {
        var rentalHistoryList = (ArrayList<RentalHistory>) rentalHistoryRepository.findAll();

        rentalHistoryList.removeIf(rentalHistory -> !rentalHistory.getRent().getRenter().getLogin().equals(login));

        if(rentalHistoryList.size() == 0) {
            rentalHistoryList = null;
        }

        return rentalHistoryList;
    }

    public Iterable<RentedBike> getCurrentRentOfUser(String login) {
        var rentedList = (ArrayList<RentedBike>) rentedBikeRepository.findAll();

        rentedList.removeIf(rentedBike -> !rentedBike.getRent().getRenter().getLogin().equals(login));

        if (rentedList.size() != 0) {
            rentedList.removeIf(rentedBike -> !timeService.checkIfTimeIsUp(rentedBike));
            for (var rentedBike : rentedList) {
                rentedBike.setRemainingTime(timeService.getRemainingTime(rentedBike));
            }
        }
        else {
            rentedList = null;
        }

        return rentedList;
    }

    public Iterable<RentedBike> getDebtorsList() {
        var rentedList = (ArrayList<RentedBike>) rentedBikeRepository.findAll();

        if(rentedList.size() != 0) {
            rentedList.removeIf(rentedBike -> timeService.checkIfTimeIsUp(rentedBike));

            for(var rentedBike : rentedList) {
                rentedBike.setDelayPrice(getDelayPrice(rentedBike));
            }
        }
        else {
            rentedList = null;
        }

        return rentedList;
    }

    private double getDelayPrice(RentedBike rentedBike) {

        return 2;
    }

    public BikeWithCondition getBikeByFreeBikeId(Short id) {
        return freeBikeRepository.findById(id).get().getBikeAndCondition();
    }

    public BikeWithCondition getBikeByBikeIdAndConditionId(Short bikeId, Short conditionId) {
        var bikeWithConditions = bikeWithConditionRepository.findAll();
        for (var bike : bikeWithConditions) {
            if(bike.getBike().getId() == bikeId && bike.getCondition().getId() == conditionId) {
                return bike;
            }
        }

        return null;
    }

    public Iterable<RentalTime> getRentalTimeList() {
        return rentalTimeRepository.findAll();
    }

    public void addRent(String bikeModel,
                        String bikeCondition,
                        Short timeId,
                        String login) throws Throwable {

        RentalTime rentalTime = rentalTimeRepository.findById(timeId).get();
        BikeWithCondition bikeWithCondition = this.getBikeByBikeIdAndConditionId(bikeRepository.findByModel(bikeModel).getId(),
                                                               conditionRepository.findByName(bikeCondition).getId());
        User renter = userRepository.findByLogin(login);

        Rent rent = new Rent(bikeWithCondition,
                renter,
                rentalTime);

        rentRepository.save(rent);

        rentedBikeRepository.save(new RentedBike(rent, Time.valueOf(LocalTime.now())));

        /*var rentalPrices = rentalPriceRepository.findAll();
        RentalPrice rentalPrice = new RentalPrice();
        for(var price : rentalPrices) {
            if(price.getRentalTime().equals(rentalTime) && price.getBikeAndCondition().equals(bikeWithCondition)) {
                rentalPrice = price;
                break;
            }
        }*/

        var freeBikes = freeBikeRepository.findAll();
        for(var bike : freeBikes) {
            if(bike.getBikeAndCondition().getId() == bikeWithCondition.getId()) {
                bike.setCount((short)(bike.getCount() - 1));
                freeBikeRepository.save(bike);
                break;
            }
        }


    }

    public void endRent(Short bikeId)
    {
        var rentedBike = this.rentedBikeRepository.findById(bikeId).get();

        rentalHistoryRepository.save(new RentalHistory(rentedBike.getRent()));

        var freeBikes = freeBikeRepository.findAll();
        var flag = false;
        for(var bike : freeBikes) {
            if(bike.getBikeAndCondition().getId() == rentedBike.getRent().getBike().getId()) {
                bike.setCount((short)(bike.getCount() + 1));
                flag = true;
                freeBikeRepository.save(bike);
                break;
            }
        }
        if(!flag)
        {
            freeBikeRepository.save(new FreeBike(rentedBike.getRent().getBike(), (short)1));
        }

        this.rentedBikeRepository.delete(rentedBike);
    }




}
