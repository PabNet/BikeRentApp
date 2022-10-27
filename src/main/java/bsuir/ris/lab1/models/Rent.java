package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = DatabaseComponentName.RentTable)
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.RentId)
    private short id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DatabaseComponentName.BikeWithConditionId)
    private BikeWithCondition bike;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DatabaseComponentName.UserId)
    private User renter;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DatabaseComponentName.RentalTimeId)
    private RentalTime rentalTime;

    public Rent() {}

    public Rent(BikeWithCondition bike, User renter, RentalTime rentalTime) {
        this.bike = bike;
        this.renter = renter;
        this.rentalTime = rentalTime;
    }
}
