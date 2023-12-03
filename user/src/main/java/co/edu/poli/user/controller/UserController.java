package co.edu.poli.user.controller;

import co.edu.poli.common.response.FormatResponse;
import co.edu.poli.common.response.ResponseBuild;
import co.edu.poli.common.response.Response;
import co.edu.poli.user.dto.UserDTO;
import co.edu.poli.user.persistence.entity.User;
import co.edu.poli.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuild build;
    private final FormatResponse formatResponse;

    @PostMapping
    public Response save(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return build.failed(formatResponse.format(result));
        }
        userService.save(userDTO);
        return build.success(userDTO);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        try {
            userService.delete(id);
            return build.success("Deleted user");
        } catch (InvalidDataAccessApiUsageException e) {
            return build.failed("User not found for ID: " + id);
        }
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id) {
        return build.success(userService.findById(id));
    }

    @GetMapping
    public Response findAll() {
        return build.success(userService.findAll());
    }
}
