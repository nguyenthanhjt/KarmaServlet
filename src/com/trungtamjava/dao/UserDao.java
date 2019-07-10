package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.User;

public interface UserDao {
void add(User user);
void update(User user);
void delete(int id);
User get(int id);
User get(String username);
List<User> search(String name);
}
