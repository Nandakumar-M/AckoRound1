package com.example.acko.repositories;

import com.example.acko.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository  extends CrudRepository<Team, Long> {
}
