package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = DatabaseComponentName.BikeTable)
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.BikeId)
    private short id;

    @Column(name = DatabaseComponentName.Model)
    private String model;

    @Column(name = DatabaseComponentName.CreationYear)
    private short creationYear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DatabaseComponentName.BikeMaterialId)
    private BikeMaterial material;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DatabaseComponentName.BikeSpeedId)
    private BikeSpeed speeds;

    public Bike() {}

    public Bike(String model, short creationYear, BikeMaterial material, BikeSpeed speeds)
    {
        this.model = model;
        this.creationYear = creationYear;
        this.material = material;
        this.speeds = speeds;
    }
}
