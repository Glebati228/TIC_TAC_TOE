package com.example.exampler;

import com.example.exampler.domain.Role;
import com.example.exampler.domain.User;
import com.example.exampler.repositories.UserRepo;
import com.example.exampler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String main(Map<String, Object> model)
    {
        List<User> users = userService.findAll();
        model.put("users", users);
        return "users";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEdit(@PathVariable User user, Model model)
    {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userEdit(
            @RequestParam String username,
            @RequestParam("id") User user,
            @RequestParam Map<String, String> roles,
            Model model)
    {
        userService.saveUsers(username, user, roles);
        return "redirect:/user";
    }

    @GetMapping("profile")
    public String profile(
            @AuthenticationPrincipal User user,
            Model model
    )
    {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "profile";
    }

    @PostMapping("profile")
    public String setProfile(
            @RequestParam String email,
            @RequestParam String password,
            @AuthenticationPrincipal User user)
    {
        userService.UpdateUser(user, password, email);
        return "redirect:/user/profile";
    }
}