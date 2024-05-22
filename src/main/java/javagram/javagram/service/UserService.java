package javagram.javagram.service;
import javagram.javagram.entity.User;

public interface UserService {

    User getUser(int id);
    User getUser(String username);
    User saveUser(User user);

    //business logic
    //UserService, FollowerService, PostService, TaskService - for each repo, service, controller

    //create user to save user. inside - call save method from repository
    // userRepository.save(new User(email, username))
   //Autowired 

}
