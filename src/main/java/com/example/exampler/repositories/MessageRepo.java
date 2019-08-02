package com.example.exampler.repositories;

import com.example.exampler.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer>
{
    List<Message> findByTag(String tag);

    List<Message> findByUsername(String username);

    Message findById(Long id);
}
