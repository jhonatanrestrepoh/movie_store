package co.edu.poli.user;

import co.edu.poli.user.persistence.entity.User;
import co.edu.poli.user.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserRepositoryMockTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void testSaveUser() {
        // Crear un nuevo usuario
        User user = new User();
        user.setName("John");
        user.setLastName("Doe");

        // Guardar el usuario en la base de datos
        userRepository.save(user);

        // Recuperar el usuario de la base de datos por ID
        User savedUser = userRepository.findById(user.getId()).orElse(null);

        // Verificar que el usuario se haya guardado correctamente
        assertNotNull(savedUser);
        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getLastName(), savedUser.getLastName());
    }
}
