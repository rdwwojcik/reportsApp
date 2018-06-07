package reposts.core.services;

import reposts.core.entities.User;

public interface UserService extends ServiceInterface<User>{

    User findByLogin(String login);
}
