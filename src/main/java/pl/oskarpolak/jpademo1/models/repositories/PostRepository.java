package pl.oskarpolak.jpademo1.models.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.jpademo1.models.PostEntity;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {
}
