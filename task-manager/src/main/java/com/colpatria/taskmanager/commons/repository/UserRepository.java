package com.colpatria.taskmanager.commons.repository;


import com.colpatria.taskmanager.commons.domains.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {


    Optional<UserEntity> findByIdUser(String idUser);
    Optional<UserEntity> findByLoginNameUser(String nameUser);
}
