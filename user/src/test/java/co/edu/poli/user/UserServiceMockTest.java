package co.edu.poli.user;

import co.edu.poli.user.dto.UserDTO;
import co.edu.poli.user.persistence.entity.User;
import co.edu.poli.user.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ComponentScan(basePackages = "co.edu.poli.user")
public class UserServiceMockTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void testFindById() {
        // Crear un usuario y guardarlo en la base de datos
        UserDTO userDTO = new UserDTO();
        userDTO.setName("John");
        userDTO.setLastName("Doe");

        User savedUser = userService.save(userDTO);

        // Obtener el ID del usuario recién creado
        Long userId = savedUser.getId();

        // Llamar al método findById para buscar el usuario por ID
        User foundUser = userService.findById(userId);

        // Verificar que el usuario se ha encontrado y sus propiedades son correctas
        assertNotNull(foundUser);
        assertEquals("John", foundUser.getName());
        assertEquals("Doe", foundUser.getLastName());
    }
}
