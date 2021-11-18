package com.colpatria.taskmanager.services.tasks;

import com.colpatria.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.colpatria.taskmanager.commons.domains.generic.TaskDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItaskServices {


    ResponseEntity<GenericResponseDTO> createTask(TaskDTO taskDTO);

    ResponseEntity<GenericResponseDTO> updateTask(String codeTask,TaskDTO taskDTO);

    ResponseEntity<GenericResponseDTO> getTasks(String idUser);

    ResponseEntity<GenericResponseDTO> deleteTask(String codeTask);



}
