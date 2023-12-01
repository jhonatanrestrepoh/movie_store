package co.edu.poli.user;

import co.edu.poli.user.dto.UserDTO;
import co.edu.poli.user.mapper.UserDTOtoUser;
import co.edu.poli.user.persistence.entity.User;
import co.edu.poli.user.persistence.repository.UserRepository;
import co.edu.poli.user.service.UserService;
import co.edu.poli.user.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceMockTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserDTOtoUser userDTOtoUser;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        userService = new UserServiceImpl(userRepository, userDTOtoUser);

        User user = new User();
        user.setName("John");
        user.setLastName("Doe");

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
    }

    @Test
    public void whenValidGetID_ThenReturnUser() {
        User foundUser = userService.findById(1L);
        assertEquals("John", foundUser.getName());
    }
}
