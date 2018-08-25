package pl.oskarpolak.blox.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.blox.models.CommentEntity;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {

    @Query(name = "UPDATE comment SET cos = ?1", nativeQuery = true)
    void udapteCosTam(String cos);
}
