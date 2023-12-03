package co.edu.poli.user.mapper;

import co.edu.poli.user.dto.UserDTO;
import co.edu.poli.user.persistence.entity.User;
import co.edu.poli.common.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDTOtoUser implements IMapper<UserDTO, User>{
    @Override
    public User mapper(UserDTO in) {
        User user = new User();
        user.setName(in.getName());
        user.setLastName(in.getLastName());
        return user;
    }
}
