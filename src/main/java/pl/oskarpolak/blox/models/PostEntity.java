package pl.oskarpolak.blox.models;

import lombok.Data;
import org.hibernate.validator.constraints.EAN;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String context;



    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity user;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comments;

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
