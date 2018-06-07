package reposts.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reposts.core.dto.UserDTO;
import reposts.core.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser(){
        return "index";
    }

    @GetMapping("/userform")
    public String newUser(Model model){
        model.addAttribute("user", new UserDTO());
        return "userform";
    }

    @PostMapping
    public String saveUser(@Valid UserDTO userDTO, Model model) {
        UserDTO savedUser = userService.save(userDTO);
        model.addAttribute("user", savedUser);
        return "usershow";
    }


}
