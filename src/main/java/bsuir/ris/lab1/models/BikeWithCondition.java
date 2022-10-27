package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = DatabaseComponentName.BikeWithConditionTable)
public class BikeWithCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.BikeWithConditionId)
    private short id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DatabaseComponentName.BikeId)
    private Bike bike;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DatabaseComponentName.ConditionId)
    private Condition condition;
}
