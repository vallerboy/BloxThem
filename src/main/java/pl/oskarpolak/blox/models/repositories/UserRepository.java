package pl.oskarpolak.blox.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.blox.models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
