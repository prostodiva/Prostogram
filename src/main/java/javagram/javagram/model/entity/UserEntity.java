package javagram.javagram.model.entity;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
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
    private UUID id;
      
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






    

    // @Past(message = "Date of birth must be in the past")
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    // @Age(message = "Must be at least 18 years old.")
    // private Date dateOfBirth;


    // public User(String id, String firstName, String lastName, String profileName, Date signDate, String email, String password) { //Date dateOfBirth
    //     this.id = id;
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.profileName = profileName;
    //     this.signDate = signDate;
    //     this.email = email;
    //     this.password = password;
    //   //this.dateOfBirth = dateOfBirth;
    // }

    // public UserEntity() {
    // }

    // public int getId() {
    //     return this.id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    // public String getFirstName() {
    //     return this.firstName;
    // }

    // public void setFirstName(String firstName) {
    //     this.firstName = firstName;
    // }

    // public String getLastName() {
    //     return this.lastName;
    // }

    // public void setLastName(String lastName) {
    //     this.lastName = lastName;
    // }

    // public String getprofileName() {
    //     return this.profileName;
    // }

    // public void setProfileName(String profileName) {
    //     this.profileName = profileName;
    // }

    // public Date getSignDate() {
    //     return this.signDate;
    // }

    // public void setSignDate(Date signDate) {
    //     this.signDate = signDate;
    // }

    // public String getEmail() {
    //     return this.email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public String getPassword() {
    //     return this.password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    // public Date getDateOfBirth() {
    //     return this.dateOfBirth;
    // }

    // public void setDateOfBirth(Date dateOfBirth) {
    //     this.dateOfBirth = dateOfBirth;
    // }

}
