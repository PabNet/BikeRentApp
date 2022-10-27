package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = DatabaseComponentName.DelayTimeTable)
public class DelayTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.DelayTimeId)
    private short id;

    @Column(name = DatabaseComponentName.Time)
    private Time time;
}
