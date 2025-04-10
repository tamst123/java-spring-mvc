package vn.hoidanit.laptopshop.controller;

import vn.hoidanit.laptopshop.service.UserService;

import vn.hoidanit.laptopshop.domain.User;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Table user
    @GetMapping("/admin/user")
    public String getAllUserPage(Model model) {
        List<User> arrUsers = this.userService.getAllUser();
        List<User> arrUserByEmail = this.userService.getAllUserByEmail("abc@gmail.com");
        model.addAttribute("users", arrUsers);
        model.addAttribute("users_by_email", arrUserByEmail);

        return "/admin/user/listUser";
    }

    // view user with id
    @GetMapping("/admin/user/{id}")
    public String viewUserById(Model model, @PathVariable long id) {
        Optional<User> user = this.userService.getUserById(id);
        model.addAttribute("user_by_id", user);
        System.out.println(user);
        return "/admin/user/showUser";
    }

    // Get page create user
    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // create user
    @PostMapping("/admin/user/create")
    public String postUserPage(Model model, @ModelAttribute("newUser") User userData) {
        this.userService.handleSaveUser(userData);
        return "redirect:/admin/user/listUser";
    }

    // @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    // public String createUserPage(Model model, @ModelAttribute("newUser") User
    // hoidanit) {
    // System.out.println(hoidanit);
    // this.userService.handleSaveUser(hoidanit);
    // return "admin/user/create";
    // }

}

// @RestController
// public class UserController {

// private UserService userService;

// public UserController(UserService userService) {
// this.userService = userService;
// }

// @GetMapping("/")
// public String getHomePage() {
// return this.userService.HandleHello();
// }

// }
