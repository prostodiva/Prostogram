package javagram.javagram.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javagram.javagram.model.entity.UserEntity;
import javagram.javagram.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserEntity> findAll (){
    return userService.findAll();
    }

    @PostMapping("/user")
    public UserEntity create(@RequestBody UserEntity userEntity) {
        return userService.addUser(userEntity);
    }
    

}


