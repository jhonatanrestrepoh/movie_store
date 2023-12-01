package co.edu.poli.user.controller;

import co.edu.poli.user.dto.UserDTO;
import co.edu.poli.user.persistence.entity.User;
import co.edu.poli.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void save(@Valid @RequestBody UserDTO userDTO){
        userService.save(userDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ userService.delete(id); }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
}
