package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = DatabaseComponentName.RoleTable)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.RoleId)
    private short id;

    @Column(name = DatabaseComponentName.Name)
    private String name;

    public Role() {}
}
