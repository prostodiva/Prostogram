package javagram.javagram.web;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javagram.javagram.model.DTO.request.UserRequest;
import jakarta.validation.Valid;
import javagram.javagram.service.UserService;
import lombok.AllArgsConstructor;

import java.util.UUID;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    //does not work
    // @GetMapping("/signUp")
    // public String signUp() {
    //     return "signUp";       //looking for a html file inside a template folder
    // }

    @GetMapping("/users/{uuid}")
    public ResponseEntity<?> get(@PathVariable UUID uuid) {
        return ResponseEntity.ok(userService.get(uuid));
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(@Valid @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    @PutMapping("/user/{uuid}")
    public ResponseEntity<?> update(@PathVariable UUID uuid, @Valid @RequestBody UserRequest userRequest) {
        userService.update(uuid, userRequest);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }


    
}
