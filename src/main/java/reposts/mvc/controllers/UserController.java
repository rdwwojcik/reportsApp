package reposts.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reposts.core.dto.UserDTO;
import reposts.core.services.UserService;
import reposts.core.services.exceptions.UserAccountExistsException;

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
    public String registerUser(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {
        UserDTO newUser = new UserDTO();
        if (!bindingResult.hasErrors()) {
            newUser = saveUser(userDTO, bindingResult);
        }
        if(newUser == null){
            bindingResult.rejectValue("login", "message.regLogin");
        }

        if (bindingResult.hasErrors()) {
            return "userform";
        }

        model.addAttribute("user", newUser);
        return "usershow";
//        return "redirect:/results";
    }

    private UserDTO saveUser(UserDTO userDTO, BindingResult result){
        UserDTO saved;
        try{
            saved = userService.save(userDTO);
        } catch(UserAccountExistsException e){
            return null;
        }
        return saved;
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
