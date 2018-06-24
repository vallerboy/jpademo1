package pl.oskarpolak.jpademo1.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.jpademo1.models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
