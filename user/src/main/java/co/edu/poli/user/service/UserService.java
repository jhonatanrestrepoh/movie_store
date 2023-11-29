package co.edu.poli.user.service;

import co.edu.poli.user.persistence.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);
    void delete(User user);
    User findById(Long id);
    List<User> findAll();
}
