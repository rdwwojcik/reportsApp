package reposts.core.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import reposts.core.dto.UserDTO;
import reposts.core.entities.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User fromDTO(UserDTO userDTO);

    UserDTO toDTO(User user);

    List<User> fromDTO(List<UserDTO> usersDTO);

    List<UserDTO> toDTO(List<User> users);
}
