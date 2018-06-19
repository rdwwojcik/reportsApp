package reposts.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import reposts.core.dto.UserDTO;
import reposts.core.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usernew")
    public String newUser(UserDTO user){
//        model.addAttribute("user", new UserDTO());
        return "userform";
    }

    @PostMapping
    public String saveUser(@Valid UserDTO user, BindingResult bindingResult) {
        System.out.println("Save user");
        if (bindingResult.hasErrors()) {
            System.out.println("Display userform");
            return "userform";
        }
        System.out.println("Display user");
        UserDTO savedUser = userService.save(user);
//        model.addAttribute("user", savedUser);
        return "usershow";
//        return "redirect:/results";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model){
        List<UserDTO> users = userService.findAll();
        model.addAttribute("users",users);
        return "userslist";
    }
}
