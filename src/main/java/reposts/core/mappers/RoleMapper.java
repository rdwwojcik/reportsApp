package reposts.core.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import reposts.core.dto.RoleDTO;
import reposts.core.entities.Role;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role fromDTO(RoleDTO roleDTO);

//    @Mapping(target = "users", ignore = true )
    RoleDTO toDTO(Role role);

    List<Role> fromDTO(List<RoleDTO> rolesDTO);

    List<RoleDTO> toDTO(List<Role> roles);
}
