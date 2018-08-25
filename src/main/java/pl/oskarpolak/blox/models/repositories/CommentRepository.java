package pl.oskarpolak.blox.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.blox.models.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    //to jest native query

    @Modifying //dla zapytan update trzeba adnotacje modifying aby dzialalo
    @Query(value = "UPDATE comment SET context = ?1", nativeQuery = true)
    int setContextFor(String cos);
}
