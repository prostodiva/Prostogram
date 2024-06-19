package javagram.javagram.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javagram.javagram.model.DTO.request.UserRequest;
import jakarta.validation.Valid;
import javagram.javagram.service.UserService;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

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
