package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = DatabaseComponentName.RentedBikeTable)
public class RentedBike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.RentedBikeId)
    private short id;

    @OneToOne
    @JoinColumn(name = DatabaseComponentName.RentId, referencedColumnName = DatabaseComponentName.RentId)
    private Rent rent;

    @Column(name = DatabaseComponentName.Time)
    private Time startTime;

    @Transient
    private Time remainingTime;

    @Transient
    private double delayPrice;

    public RentedBike() {}

    public RentedBike(Rent rent, Time startTime) {
        this.rent = rent;
        this.startTime = startTime;
    }
}
