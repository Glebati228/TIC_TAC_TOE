package com.example.exampler;

import com.example.exampler.domain.Message;
import com.example.exampler.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController
{
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String Name, Map<String, Object> model)
    {
        model.put("name", Name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model)
    {
        Iterable<Message> list = messageRepo.findAll();
        model.put("messages", list);
        return "main";
    }

    @PostMapping
    public String addMessage(@RequestParam String text, @RequestParam String tag, Map<String, Object> model)
    {
        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> list = messageRepo.findAll();
        model.put("messages", list);
        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String tag, Map<String, Object> model)
    {
        Iterable<Message> messages;
        if(tag != null && !tag.isEmpty())
        {
            messages = messageRepo.findByTag(tag);
        }
        else
            {
                messages = messageRepo.findAll();
            }
        model.put("messages", messages);
        return "main";
    }
}