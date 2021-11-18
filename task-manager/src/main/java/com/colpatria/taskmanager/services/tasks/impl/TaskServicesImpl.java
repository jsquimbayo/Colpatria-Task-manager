package com.colpatria.taskmanager.services.tasks.impl;

import com.colpatria.taskmanager.commons.converter.ItaskConverter;
import com.colpatria.taskmanager.commons.domains.entity.TaskEntity;
import com.colpatria.taskmanager.commons.domains.entity.UserEntity;
import com.colpatria.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.colpatria.taskmanager.commons.domains.generic.TaskDTO;
import com.colpatria.taskmanager.commons.repository.TaskRepository;
import com.colpatria.taskmanager.commons.repository.UserRepository;
import com.colpatria.taskmanager.services.tasks.ItaskServices;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@Log4j2
public class TaskServicesImpl implements ItaskServices {


    @Autowired
    private ItaskConverter itaskConverter;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;



    /**
     * Author jsQuimbayo
     * metodo que crea una nueva tarea
     * *param taskDTO
     **/
    @Override
    @Modifying
    public ResponseEntity<GenericResponseDTO> createTask(TaskDTO taskDTO) {
        TaskEntity taskEntity = new TaskEntity();
        Optional<UserEntity> userEntity;
        try{
            userEntity = userRepository.findByIdUser(taskDTO.getIdUser());
            if(userEntity.isPresent()){
                taskEntity = itaskConverter.taskDtoToTaskEntity(taskDTO);
                taskRepository.save(taskEntity);
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("tarea creada")
                        .objectResponse(taskDTO)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("Error creando tarea no se encontro ningun usuario asociado")
                        .objectResponse(null)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            log.error("Algo fallo en la creacion de la tarea " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error creando tarea:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build(), HttpStatus.BAD_REQUEST);
        }

    }


    /**
     * Author jsQuimbayo
     * metodo que actualiza una  tarea
     * *param taskDTO, codeTask
     **/
    @Override
    @Modifying
    public ResponseEntity<GenericResponseDTO> updateTask(String codeTask, TaskDTO taskDTO) {
        TaskEntity taskEntity = new TaskEntity();
        Optional<TaskEntity> oldTask;
        try{
            oldTask = taskRepository.findByCodeTask(codeTask);
            if (oldTask.isPresent()){
                taskEntity = itaskConverter.taskDtoToTaskEntity(taskDTO);
                taskEntity.setIdTable(oldTask.get().getIdTable());
                taskRepository.save(taskEntity);
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("tarea actualizada")
                        .objectResponse(taskDTO)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("no se encontro ninguna tarea para actualizar")
                        .objectResponse(null)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }
        }catch (Exception e){
            log.error("Algo fallo en la creacion de la tarea " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error actualizando tarea:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Author jsQuimbayo
     * metodo que obtiene todas las tareas asociadas a un usuario
     * *param idUser
     **/
    @Override
    public ResponseEntity<GenericResponseDTO> getTasks(String idUser) {
        List<TaskEntity> tasksEntity = new ArrayList<>();
        try{
            tasksEntity = taskRepository.findAllByIdUser(idUser);
            if(!tasksEntity.isEmpty()){
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("tareas encontradas")
                        .objectResponse(tasksEntity)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("No se encontraron Tareas")
                        .objectResponse(tasksEntity)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }
        }catch (Exception e){
            log.error("Algo fallo en la actualizacion de la fecha " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error consultando la persona:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Author jsQuimbayo
     * metodo que elimina una  tarea
     * *param codeTask
     **/
    @Override
    @Modifying
    public ResponseEntity<GenericResponseDTO> deleteTask(String codeTask) {
        Optional<TaskEntity> oldTask;
        try{
            oldTask = taskRepository.findByCodeTask(codeTask);
            if(oldTask.isPresent()){
                taskRepository.delete(oldTask.get());
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("tarea eliminada")
                        .objectResponse(codeTask)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("No se pudo eliminar la tarea")
                        .objectResponse(codeTask)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }
        }catch (Exception e){
            log.error("Algo fallo en la creacion de la tarea " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error eliminando tarea:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }
}
