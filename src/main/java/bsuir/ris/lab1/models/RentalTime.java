package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = DatabaseComponentName.RentalTimeTable)
public class RentalTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.RentalTimeId)
    private short id;

    @Column(name = DatabaseComponentName.Time)
    private Time time;

    public RentalTime() {}
}
