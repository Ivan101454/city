package by.ivan.city.models;

import by.ivan.city.models.enums.Role;
import by.ivan.city.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "barrierfree", name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "first_name")
    @NotEmpty(message = "Name should't be empty ")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "login")
    private String login;
    @Column(name = "email")
    @Email
    @NotEmpty(message = "email shouldn't be empty")
    private String mail;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_id")
    private Role role;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_id")
    private Status status;


}
