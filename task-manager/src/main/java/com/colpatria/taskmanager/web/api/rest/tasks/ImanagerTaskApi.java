package com.colpatria.taskmanager.web.api.rest.tasks;

import com.colpatria.taskmanager.commons.constants.IEndpointTaskApi;
import com.colpatria.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.colpatria.taskmanager.commons.domains.generic.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ImanagerTaskApi {

    @PutMapping(IEndpointTaskApi.CREATE_TASK)
    ResponseEntity<GenericResponseDTO> createTask(@RequestBody TaskDTO taskDTO);

    @GetMapping(IEndpointTaskApi.GET_TASKS)
    ResponseEntity<GenericResponseDTO> getTasks(@PathVariable String idUser);

    @PutMapping(IEndpointTaskApi.UPDATE_TASK)
    ResponseEntity<GenericResponseDTO> updateTask(@PathVariable String idTask,
                                      @RequestBody TaskDTO taskDTO);

    @DeleteMapping(IEndpointTaskApi.DELETE_TASK)
    ResponseEntity<GenericResponseDTO> deleteTask(@PathVariable String idTask);
}
