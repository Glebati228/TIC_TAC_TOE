package com.example.exampler.repositories;

import com.example.exampler.domain.Publication;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublicationRepo extends CrudRepository<Publication, Integer>
{
    List<Publication> findByTheme(String string);

}
