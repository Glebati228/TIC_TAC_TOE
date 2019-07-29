package com.example.exampler;

import com.example.exampler.domain.Message;
import com.example.exampler.domain.User;
import com.example.exampler.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/editMessage")
public class MessageEditController
{
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("{message}")
    public String main(@PathVariable Long message, Model model)
    {
        Message message1 = messageRepo.findById(message.intValue()).get();
        model.addAttribute("message", message1);
        return "editMessage";
    }
    /*@PostMapping("/editMessage")
    public String editMessage(
            @RequestParam String text,
            @RequestParam String tag,
            @RequestParam("id") Message message,
            Model model)
    {
        message.SetText(text);
        message.SetTag(tag);
        messageRepo.save(message);
        return "redirect:/main";
    }*/
    /*@PostMapping("/deleteMessage")
    public String deleteMessage(@RequestParam("id") Message message)
    {
        messageRepo.delete(message);
        return "redirect:/main";
    }*/
}
