package com.example.restapii.repo;

import com.example.restapii.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
