package com.example.exampler.repositories;

import com.example.exampler.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepo extends CrudRepository<Message, Integer>
{
    List<Message> findByTag(String tag);

    @Override
    Optional<Message> findById(Integer integer);
}
