package reposts.init;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reposts.core.dto.RoleDTO;
import reposts.core.dto.UserDTO;
import reposts.core.services.RoleService;
import reposts.core.services.UserService;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class InitUserAcount {

    private final UserService userService;
    private final RoleService roleService;

    public InitUserAcount(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
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

        RoleDTO role = new RoleDTO();
        role.setName("USER");
//        RoleDTO savedRole = roleService.save(role);

        user.setRoles(Arrays.asList(role));


        userService.save(user);
    }

}