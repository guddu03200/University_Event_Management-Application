package com.Guddu.University_Event_Management.repository;


import com.Guddu.University_Event_Management.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEventRepo extends CrudRepository<Event, Integer> {
    List<Event> findByEventDate(LocalDate Date);
}
