package co.edu.poli.user.service;

import co.edu.poli.user.dto.UserDTO;
import co.edu.poli.user.mapper.UserDTOtoUser;
import co.edu.poli.user.persistence.entity.User;
import co.edu.poli.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserDTOtoUser userDTOtoUser;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public User save(UserDTO userDTO) {
        return userRepository.save(userDTOtoUser.mapper(userDTO));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
