package com.colpatria.taskmanager.commons.repository;


import com.colpatria.taskmanager.commons.domains.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface TaskRepository extends CrudRepository<TaskEntity, Integer> {


    Optional<TaskEntity> findByCodeTask(String codeTask);

    List<TaskEntity> findAllByIdUser(String idUser);

}
