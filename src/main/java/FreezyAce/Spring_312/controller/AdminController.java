package FreezyAce.Spring_312.controller;

import FreezyAce.Spring_312.model.User;
import FreezyAce.Spring_312.service.RoleService;
import FreezyAce.Spring_312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        model.addAttribute("newUser", new User());
        model.addAttribute("user", userService.getUsers());
        model.addAttribute("userCurrent", user);
        model.addAttribute("role", roleService.getAllRole());
        return "/admin";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        System.out.println(user.toString());
        userService.update(id, user);
        return "redirect:/admin";
    }

//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") long id) {
//        model.addAttribute("user", userService.userById(id));
//        model.addAttribute("role", roleService.getAllRole());
//        return "users/edit";
//
//    }

    //    @GetMapping("/new")
//    public String newUser(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) auth.getPrincipal();
//        model.addAttribute("user", new User());
//        model.addAttribute("role", roleService.getAllRole());
//        model.addAttribute("userCurrent", user);
//        return "users/createUser";
//    }

//    @GetMapping("/{id}")
//    public String idUser(@PathVariable("id") long id, Model model) {
//        model.addAttribute("user", userService.userById(id));
//        return "users/userID";
//    }


}
