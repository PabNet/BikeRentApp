package bsuir.ris.lab1.models;

import bsuir.ris.lab1.additions.entities.DatabaseComponentName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = DatabaseComponentName.UserTable)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DatabaseComponentName.UserId)
    private short id;

    @Column(name = DatabaseComponentName.Login)
    private String login;

    @Column(name = DatabaseComponentName.Password)
    private String password;

    @Column(name = DatabaseComponentName.Name)
    private String name;

    @Column(name = DatabaseComponentName.Email)
    private String email;

    @Column(name = DatabaseComponentName.Phone)
    private String phoneNumber;

    @Column(name = DatabaseComponentName.PassportData)
    private String passportData;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DatabaseComponentName.RoleId)
    private Role role;

    public User() {}

    public User(String login,
                String password,
                String name,
                String email,
                String phone,
                String passportData,
                Role role) {
        this.role = role;
        this.phoneNumber = phone;
        this.login = login;
        this.email = email;
        this.passportData = passportData;
        this.name = name;
        this.password = password;
    }
}
