package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = DatabaseComponentName.BikeSpeedTable)
public class BikeSpeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.BikeSpeedId)
    private short id;

    @Column(name = DatabaseComponentName.SpeedsCount)
    private byte speedsCount;
}
