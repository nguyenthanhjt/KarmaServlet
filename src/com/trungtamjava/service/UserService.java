package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.User;

public interface UserService {
void  add(User user);
void edit(User user);
void delete(int id);
User get(int id);
User get(String username,String password);
List<User> listUser(String name); 
}
