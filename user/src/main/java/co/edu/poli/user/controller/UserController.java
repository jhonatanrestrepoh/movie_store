package co.edu.poli.user.controller;

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
    public void save(@Valid @RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        User user = userService.findById(id);
        userService.delete(user);

    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
}
