package pl.oskarpolak.blox.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String context;
    @Column(name = "user_id")
    private int userId; //todo zamienieć na mapowanie jeden do wielu :)
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
}
