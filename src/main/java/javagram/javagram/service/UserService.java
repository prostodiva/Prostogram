package javagram.javagram.service;
import java.util.UUID;

import org.springframework.stereotype.Service;

import javagram.javagram.exception.UserNotFoundException;
import javagram.javagram.model.DTO.request.UserRequest;
import javagram.javagram.model.DTO.response.UserResponse;
import javagram.javagram.model.entity.UserEntity;
import javagram.javagram.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    
    public UserResponse get(UUID uuid) {
        UserEntity entity = userRepository.findById(uuid).orElseThrow(UserNotFoundException::new);

        UserResponse response = new UserResponse();
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setProfileName(entity.getProfileName());
        response.setCreatedAt(entity.getCreatedAt());
        response.setEmail(entity.getEmail());
        response.setPassword(entity.getPassword());
        return response;
    }


    public UUID create(UserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setId(UUID.randomUUID());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setProfileName(request.getProfileName());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setEmail(request.getEmail());
        entity.setPassword(request.getPassword());
    
        userRepository.save(entity);

        return entity.getId();
    } 

    public boolean update(UUID uuid, UserRequest userRequest) {
        UserEntity entity = userRepository.findById(uuid).orElseThrow(UserNotFoundException::new);

        entity.setFirstName(userRequest.getFirstName());
        entity.setLastName(userRequest.getLastName());
        entity.setProfileName(userRequest.getProfileName());
        entity.setCreatedAt(userRequest.getCreatedAt());
        entity.setEmail(userRequest.getEmail());
        entity.setPassword(userRequest.getPassword());

        userRepository.save(entity);

        return true;

    }


    }



