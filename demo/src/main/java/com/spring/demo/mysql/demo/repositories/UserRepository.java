package com.spring.demo.mysql.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.mysql.demo.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
  public abstract ArrayList<UserModel> findByPriority(Integer priority);
}
