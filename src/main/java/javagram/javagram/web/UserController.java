package javagram.javagram.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import javagram.javagram.entity.User;
import javagram.javagram.service.UserService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    UserService userService;
    
     @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
    
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/result")
    public String getResult() {
        return "result";
    }


    
}

//presentaition