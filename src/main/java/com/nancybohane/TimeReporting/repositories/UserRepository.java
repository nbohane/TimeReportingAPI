package com.nancybohane.TimeReporting.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.TimeReporting.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
