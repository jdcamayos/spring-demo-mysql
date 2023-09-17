package com.spring.demo.mysql.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.mysql.demo.models.UserModel;
import com.spring.demo.mysql.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  UserService userServices;

  @GetMapping()
  public ArrayList<UserModel> getAll() {
    return userServices.getUsers();
  }

  @PostMapping()
  public UserModel saveUser(@RequestBody UserModel user) {
    return this.userServices.saveUser(user);
  }

  @GetMapping(path = "/{id}")
  public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
    return this.userServices.getById(id);
  }

  @GetMapping("/query")
  public ArrayList<UserModel> getUserByPriority(@RequestParam("priority") Integer priority) {
    return this.userServices.getByPriority(priority);
  }

  @DeleteMapping(path = "/{id}")
  public Boolean deleteUserById(@PathVariable("id") Long id) {
    return this.userServices.deleteUser(id);
  }

}
