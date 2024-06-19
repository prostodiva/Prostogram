package javagram.javagram;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javagram.javagram.repository.UserRepository;
import javagram.javagram.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserService userService;

    
    
    @Test
    public void addTest() {

    }

    @Test
    public void updateTest() {

    }

    @Test
    public void deleteTest() {

    }
    
}
