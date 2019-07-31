package com.example.exampler;

import com.example.exampler.domain.User;
import com.example.exampler.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dialog")
public class MessagesController
{
    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "{user}", method = RequestMethod.GET)
    public String main(
            @PathVariable User user,
            Model model)
    {
        model.addAttribute("user", user);
        return "dialogs";
    }
    @RequestMapping(value="send", method = RequestMethod.POST)
    public String dialog(@RequestParam String text)
    {

        return "dialogs";
    }
}
