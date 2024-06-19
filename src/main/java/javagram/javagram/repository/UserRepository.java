package javagram.javagram.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import javagram.javagram.model.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID>{

    

} 


