package com.example.restapii.service;

import com.example.restapii.entity.UserEntity;
import com.example.restapii.exception.NoActiveId;
import com.example.restapii.exception.UserAlreadyExists;
import com.example.restapii.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserEntity registration(UserEntity user) throws UserAlreadyExists;

    User getOne(Long id) throws NoActiveId;

    Long deleteUser(Long id);
}
