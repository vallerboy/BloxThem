package pl.oskarpolak.blox.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.blox.models.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    boolean existsByLogin(String login);

    //@Query(nativeQuery = true, value = "SELECT * FROM cos HEHE")
    //Optional<UserEntity> findByLoginAndPassword(String v, String f);
}
