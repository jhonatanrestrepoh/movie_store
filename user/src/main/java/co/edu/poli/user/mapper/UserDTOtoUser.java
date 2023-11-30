package co.edu.poli.user.mapper;

import co.edu.poli.user.dto.UserDTO;
import co.edu.poli.user.persistence.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOtoUser implements IMapper<UserDTO, User>{
    @Override
    public User mapper(UserDTO in) {
        User task = new User();
        task.setName(in.getName());
        task.setLastName(in.getLastName());
        return task;
    }
}
