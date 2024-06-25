package javagram.javagram.repository;

// import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import javagram.javagram.model.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID>{
    // ArrayList<UserEntity> findAll();
    

} 


