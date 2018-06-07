package reposts.init;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reposts.core.dto.UserDTO;
import reposts.core.entities.User;
import reposts.core.services.UserService;

import javax.annotation.PostConstruct;

@Component
public class InitUserAcount {

    private final UserService userService;

    public InitUserAcount(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init(){
        UserDTO user = new UserDTO();
        user.setFirstName("Radek");
        user.setLastName("Wójcik");
        user.setEmail("radek@gmail.com");
        user.setLogin("radek");
        user.setPassword("radek");

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashPass = encoder.encode("radek");

        user.setPasswordHash(hashPass);

//        Role role = new Role();
//        role.setRole("USER");
//
//        List<Role> roleList = new ArrayList<>();
//        roleList.add(role);
//
//        user.setRoles(roleList);

//        List<User> users = new ArrayList<>();
//        users.add(user);

        userService.save(user);
    }

}