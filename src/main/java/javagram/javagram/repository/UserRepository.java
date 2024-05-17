package javagram.javagram.repository;

import org.springframework.data.repository.CrudRepository;

import javagram.javagram.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

    
} 
    //access to database
    //all CRUD oparations should be her
    //should be an interface
    // extends CrudRepository<User, Integer>
    
    //прописывает только методы которых нет в CrudRepository

