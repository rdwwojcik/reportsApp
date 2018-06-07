package reposts.core.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reposts.AuthorizationUser;
import reposts.core.dto.UserDTO;
import reposts.core.entities.User;
import reposts.core.services.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDTO currentUser = userService.findByLogin(login);
        if (currentUser != null) { return new AuthorizationUser(currentUser); }
        throw new UsernameNotFoundException("User not found for login: " + login);
    }
}
