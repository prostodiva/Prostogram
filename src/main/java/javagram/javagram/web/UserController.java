package javagram.javagram.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javagram.javagram.model.DTO.request.UserRequest;
import javagram.javagram.model.entity.UserEntity;
import jakarta.validation.Valid;
import javagram.javagram.service.UserService;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    // @GetMapping("/users")
    // public RedirectView redirectWithRedirectView() {
    //     return new RedirectView("/form");
    // }

    // @GetMapping("/form")
    // public ModelAndView targetPage() {
    //     return new ModelAndView("form");
    // }

    //QUESTION TO TUTOR: 1. How to GET a list of all users from the database. - users table. 
    // @GetMapping("/")
    // public ResponseEntity<UserEntity> findAll() {
    //     return ResponseEntity.ok(userService.findAll());
    // }

    @GetMapping("/user/{uuid}")
    public ResponseEntity<?> get(@PathVariable UUID uuid) {
        return ResponseEntity.ok(userService.get(uuid));
    }

    @PostMapping("/user")
    public ResponseEntity<?> create(@Valid @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    @PutMapping("/user/{uuid}")
    public ResponseEntity<?> update(@PathVariable UUID uuid, @Valid @RequestBody UserRequest userRequest) {
        userService.update(uuid, userRequest);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{uuid}/user")       //the path was changed to match requestMatchers method in securityConfig
    public ResponseEntity<?> deleteStudent(@PathVariable UUID uuid, UserEntity entity) {
        userService.delete(uuid, entity);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
