package javagram.javagram.service;

import java.util.List;

import javagram.javagram.model.entity.UserEntity;

public interface UserService {

    List<UserEntity> findAll();
    UserEntity addUser(UserEntity userEntity);






}
