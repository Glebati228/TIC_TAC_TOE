package com.example.exampler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController
{
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String Name, Map<String, Object> model)
    {
        model.put("name", Name);
        return "greeting";
    }

    @GetMapping
    public String main(@RequestParam(name = "name", required = false, defaultValue = "main") String Name, Map<String, Object> model)
    {
        model.put("name", Name);
        return "main";
    }
}