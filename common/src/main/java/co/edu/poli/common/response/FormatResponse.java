package co.edu.poli.common.response;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FormatResponse {
    public List<Map<String, String>> format(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream().map(error -> {
            Map<String, String> err = new HashMap<>();
            err.put(error.getField(), error.getDefaultMessage());
            return err;
        }).collect(Collectors.toList());
        return errors;
    }
}
