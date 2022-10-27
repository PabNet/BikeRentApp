package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = DatabaseComponentName.LateFeeTable)
public class LateFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.LateFeeId)
    private short id;

    @OneToOne
    @JoinColumn(name = DatabaseComponentName.BikeWithConditionId, referencedColumnName = DatabaseComponentName.BikeWithConditionId)
    private BikeWithCondition bikeAndCondition;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DatabaseComponentName.DelayTimeId)
    private DelayTime delayTime;
}
