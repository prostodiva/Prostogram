package javagram.javagram.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.UUID;
import javagram.javagram.model.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, UUID>{

    

} 

    //access to database
    //прописываем только методы которых нет в CrudRepository

