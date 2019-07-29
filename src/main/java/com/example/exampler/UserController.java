package com.example.exampler;

import com.example.exampler.domain.Role;
import com.example.exampler.domain.User;
import com.example.exampler.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController
{
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String main(Map<String, Object> model)
    {
        List<User> users = userRepo.findAll();
        model.put("users", users);
        return "users";
    }
    @GetMapping("{user}")
    public String userEdit(@PathVariable User user, Model model)
    {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userEdit(
            @RequestParam String username,
            @RequestParam("id") User user,
            @RequestParam Map<String, String> roles,
            Model model)
    {
        user.setUsername(username);

        user.getRoles().clear();

        Set<String> collect = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        for(String role : roles.keySet())
        {
            if(collect.contains(role))
            {
                user.getRoles().add(Role.valueOf(role));
            }
        }
        userRepo.save(user);
        return "redirect:/user";
    }
}
