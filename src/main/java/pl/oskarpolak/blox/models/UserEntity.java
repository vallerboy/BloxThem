package pl.oskarpolak.blox.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String password;
    @Column(name = "has_admin")
    private boolean hasAdmin;
}
