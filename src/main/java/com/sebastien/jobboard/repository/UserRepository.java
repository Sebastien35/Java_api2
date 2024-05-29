package com.sebastien.jobboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sebastien.jobboard.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
