package com.example.exampler;

import com.example.exampler.domain.Message;
import com.example.exampler.domain.User;
import com.example.exampler.repositories.MessageRepo;
import com.example.exampler.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/del")
public class EDUserController
{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("{user}")
    public String main(
            @PathVariable User user,
            Model model
    )
    {
        model.addAttribute("user", user);
        return "delUser";
    }

    @PostMapping
    public String deleteUser(
            @RequestParam("id") User user,
            Model model
    )
    {
        User user1 = userRepo.findByUsername(user.getUsername());
        if(user1 == null)
        {
            model.addAttribute("message", "This guy not found");
            return "redirect:/user";
        }

        List<Message> messageList = messageRepo.findByUsername(user.getUsername());
        for (Message message : messageList)
        {
            messageRepo.delete(message);
        }
        userRepo.delete(user);
        return "redirect:/user";
    }
}
