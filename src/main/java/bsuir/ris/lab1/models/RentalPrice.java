package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = DatabaseComponentName.RentalPriceTable)
public class RentalPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.RentalPriceId)
    private short id;

    @OneToOne
    @JoinColumn(name = DatabaseComponentName.BikeWithConditionId, referencedColumnName = DatabaseComponentName.BikeWithConditionId)
    private BikeWithCondition bikeAndCondition;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DatabaseComponentName.RentalTimeId)
    private RentalTime rentalTime;

    @Column(name = DatabaseComponentName.Price)
    private double price;
}
