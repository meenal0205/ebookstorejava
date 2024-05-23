package com.ebookstoreProject.ebookstore.services;

import com.ebookstoreProject.ebookstore.entity.UserEntity;
import com.ebookstoreProject.ebookstore.model.User;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User createUser(User user);
    List<User> getAllUser();
    User getUserById(Integer Id);
    User updateUser(Integer Id, User user);
    User updateBasket(Integer id1, Integer id2,User user);
    User addquantity(Integer id1, Integer id2, User user);
    User reducequantity(Integer id1, Integer id2, User user);
}
