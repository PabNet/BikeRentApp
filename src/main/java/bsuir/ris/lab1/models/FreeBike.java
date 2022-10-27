package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = DatabaseComponentName.FreeBikeTable)
public class FreeBike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.FreeBikeId)
    private short id;

    @OneToOne
    @JoinColumn(name = DatabaseComponentName.BikeWithConditionId, referencedColumnName = DatabaseComponentName.BikeWithConditionId)
    private BikeWithCondition bikeAndCondition;

    @Column(name = DatabaseComponentName.Count)
    private short count;

    public FreeBike() {}

    public FreeBike(BikeWithCondition bikeWithCondition, short count)
    {
        this.bikeAndCondition = bikeWithCondition;
        this.count = count;
    }


}
