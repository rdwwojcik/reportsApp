package reposts.core.services;

import reposts.core.entities.User;

public interface UserService {

    User findByLogin(String login);
}
