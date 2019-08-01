package com.example.exampler;
import com.example.exampler.domain.Message;
import com.example.exampler.domain.User;
import com.example.exampler.repositories.MessageRepo;
import com.example.exampler.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class GreetingController
{
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;

    @Value("${file-upload}")
    private String filepath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model)
    {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Model model)
    {
        Iterable<Message> messages = messageRepo.findAll();
        Iterable<User> users = userRepo.findAll();

        model.addAttribute("messages", messages);
        model.addAttribute("users", users);

        return "main";
    }
    @GetMapping("/peop")
    public String peoples(Model model)
    {
        Iterable<User> users = userRepo.findAll();
        model.addAttribute("peoples", users);
        return "people";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            @RequestParam("file") MultipartFile file,
            @RequestParam("time") String datetime,
            Model model) throws IOException {
        Message message = new Message(text, tag, user, datetime);

        if(file != null && !file.getOriginalFilename().isEmpty())
        {
            File uploads = new File(filepath);
            if(!uploads.exists())
            {
                uploads.mkdir();
            }

            String randname = UUID.randomUUID().toString() + file.getOriginalFilename();
            file.transferTo(new File(filepath + "/" + randname));

            message.setFilename(randname);
        }

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model)
    {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty())
        {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messages", messages);

        return "main";
    }
}