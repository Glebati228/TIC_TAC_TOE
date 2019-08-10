package com.example.exampler.controller;

import com.example.exampler.exeption.NotFoundExeption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("main")
public class MainController
{
    private int counter = 3;
   private List<Map<String, String>> messages = new ArrayList<Map<String, String>>()
   {{
     add(new HashMap<String, String>(){{
         put("id", "1");
         put("message","Some message");
     }});

     add(new HashMap<String, String>(){{
         put("id", "2");
         put("message", "Next message");
     }});

     add(new HashMap<String, String>(){{
         put("id", "3");
         put("message", "Message");
     }});
   }};

   @GetMapping
   public List<Map<String, String>> main()
   {
       return messages;
   }
   @GetMapping("{id}")
    public Map<String, String> getById(
            @PathVariable String id
   ) {
       return messages.stream()
               .filter(message -> message.get("id").equals(id))
               .findFirst()
               .orElseThrow(NotFoundExeption::new);
   }

   @PostMapping
    public Map<String, String> create(@RequestParam Map<String, String> message)
   {
       message.put("id", String.valueOf(counter++));
       messages.add(message);

       return message;
   }

   @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id,@RequestParam Map<String, String> upd)
   {
       Map<String, String> mess = messages.stream().filter(message -> message.get("id")
               .equals(upd)).findFirst()
               .orElseThrow(NotFoundExeption::new);

       mess.putAll(upd);
       mess.put("id", id);

       return mess;
   }

   @DeleteMapping("{id}")
    public void delete(@PathVariable String id)
   {
        Map<String, String> mes = messages.stream()
                .filter(message -> message.get("id")
                        .equals(id)).findFirst()
                .orElseThrow(NotFoundExeption::new);

        messages.remove(mes);
   }
}
