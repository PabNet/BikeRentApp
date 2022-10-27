package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

@Data
@Entity
@Table(name = DatabaseComponentName.RentalHistoryTable)
public class RentalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.RentalHistoryId)
    private short id;

    @Column(name = DatabaseComponentName.Date)
    private Date currentDate;

    @OneToOne
    @JoinColumn(name = DatabaseComponentName.RentId, referencedColumnName = DatabaseComponentName.RentId)
    private Rent rent;

    @Transient
    private Time fullTime;

    @Column(name = DatabaseComponentName.FinalAmount)
    private double finalAmount;

    public RentalHistory(Rent rent)
    {
        this.currentDate = Date.valueOf(LocalDate.now());
        this.rent = rent;
        this.finalAmount = new Random().nextDouble();
    }

    public RentalHistory() {}
}
