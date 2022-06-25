package com.nancybohane.TimeReporting.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.TimeReporting.models.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{

}
