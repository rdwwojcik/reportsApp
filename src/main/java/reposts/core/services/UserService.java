package reposts.core.services;

import reposts.core.dto.UserDTO;

public interface UserService extends ServiceInterface<UserDTO>{

    UserDTO findByLogin(String login);
}
