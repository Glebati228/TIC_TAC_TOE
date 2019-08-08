package com.example.exampler;

import com.example.exampler.domain.Message;
import com.example.exampler.domain.Publication;
import com.example.exampler.repositories.PublicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publications")
public class PublicationController
{
    @Autowired
    private PublicationRepo publicationRepo;

    @GetMapping
    public String main(
            Model model
    )
    {
        Iterable<Publication> publications = publicationRepo.findAll();

        model.addAttribute("publications", publications);
        return "pubList";
    }

    @GetMapping("{publication.id}")
    public String publication(
            @PathVariable Publication publication,
            Model model)
    {
        model.addAttribute("publication", publication);
        return "public";
    }

    @PostMapping
    public String addPublication()
    {

        return "pubList";
    }
}
