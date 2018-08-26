package reposts.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reposts.core.dto.UserDTO;
import reposts.core.services.UserService;

import javax.management.Query;
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
    public String newUser(UserDTO userDTO){
        return "userform";
    }

    @PostMapping
    public String saveUser(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "userform";
        }
        UserDTO savedUser = userService.save(userDTO);
        model.addAttribute("user", savedUser);
        return "usershow";
//        return "redirect:/results";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model){
        List<UserDTO> users = userService.findAll();
        model.addAttribute("users",users);
        return "userslist";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") Long userId){
        System.out.println("UserID: " + userId);
        userService.delete(userService.findById(userId));
        return "redirect:/user/all";
    }
}
