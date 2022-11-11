package com.example.restapii.service.Impl;

import com.example.restapii.entity.UserEntity;
import com.example.restapii.exception.NoActiveId;
import com.example.restapii.exception.UserAlreadyExists;
import com.example.restapii.model.User;
import com.example.restapii.repo.UserRepo;
import com.example.restapii.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity registration(UserEntity user) throws UserAlreadyExists {

        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExists("User already exists");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws NoActiveId {
        UserEntity user = userRepo.findById(id).get();
        if (user.getId()==null) {
            throw new NoActiveId("Cant find user by id");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
