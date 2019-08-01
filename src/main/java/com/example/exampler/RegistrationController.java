package com.example.exampler;

import com.example.exampler.domain.Role;
import com.example.exampler.domain.User;
import com.example.exampler.repositories.UserRepo;
import com.example.exampler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController
{
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model)
    {
        if(!userService.AddUser(user))
        {
            model.put("message", "User already exists");
            return "registration";
        }

        model.put("message", "  ");
        return "redirect:/login";
    }

    @GetMapping("/activation/{code}")
    public String activate(
            @PathVariable String code,
            Model model)
    {
        boolean active = userService.isActiveUser(code);

        if(active)
        {
            model.addAttribute("message", "Successfully activation");
        }
        else
            {
                model.addAttribute("message", "Activation failed!");
            }

        return "login";
    }
}
