package javagram.javagram.model.entity;

import java.util.Date;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import javagram.javagram.validation.Username;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, message = "First name is too short")
    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, message = "First name is too short")
    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Username cannot be blank")
    @NonNull
    @Username(message = "Cannot contain special or uppercase characters.")
    @Size(min = 7, message = "Username is too short")
    @Column(name = "profile_name", nullable = false, unique = true)
    private String profileName;

    @Column(name = "created_at")
    @Past(message = "Date of birth must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @Email(message = "Invalid email")
    @NotBlank(message = "email cannot be blank")
    @NonNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "password cannot be blank")
    @NonNull
    private String password;




}
