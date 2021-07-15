package com.example.acko.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.acko.model.Developer;

public interface DeveloperRepository  extends CrudRepository<Developer, Long> {
}
