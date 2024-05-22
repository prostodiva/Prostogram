package javagram.javagram.security.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javagram.javagram.entity.User;
import javagram.javagram.service.UserService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustonAuthentificationManager implements AuthenticationManager {
    
     private UserService userServiceImpl;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) {
        User user = userServiceImpl.getUser(authentication.getName());
        if (!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
            throw new BadCredentialsException("You provided an incorrect password.");
        }

        return new UsernamePasswordAuthenticationToken(authentication.getName(), user.getPassword());
    }
}
