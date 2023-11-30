package co.edu.poli.user.service;

import co.edu.poli.user.dto.UserDTO;
import co.edu.poli.user.persistence.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User save(UserDTO user);
    void delete(User user);
    User findById(Long id);
    List<User> findAll();
}
