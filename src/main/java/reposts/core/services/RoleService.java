package reposts.core.services;

import reposts.core.dto.RoleDTO;

public interface RoleService extends ServiceInterface<RoleDTO> {

    RoleDTO findByName(String name);
}
