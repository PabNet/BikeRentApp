package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = DatabaseComponentName.BikeMaterialTable)
public class BikeMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.BikeMaterialId)
    private short id;

    @Column(name = DatabaseComponentName.Name)
    private String name;
}
