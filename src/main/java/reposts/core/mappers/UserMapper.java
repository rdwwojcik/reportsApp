package reposts.core.mappers;


import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import reposts.core.dto.RoleDTO;
import reposts.core.dto.UserDTO;
import reposts.core.entities.Role;
import reposts.core.entities.User;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract User fromDTO(UserDTO userDTO);

    @Mapping(target = "roles", ignore = true )
    public abstract UserDTO toDTO(User user);

    public abstract List<User> fromDTO(List<UserDTO> usersDTO);

    public abstract List<UserDTO> toDTO(List<User> users);

    @AfterMapping
    void addBackReference(User user, @MappingTarget UserDTO target) {
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for(Role role: user.getRoles()){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(role.getId());
            roleDTO.setName(role.getName());
            roleDTOS.add(roleDTO);
        }
        target.setRoles(roleDTOS);
    }
}
