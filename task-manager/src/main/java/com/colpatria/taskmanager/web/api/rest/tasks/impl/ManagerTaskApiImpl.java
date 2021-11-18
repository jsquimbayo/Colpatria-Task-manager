package com.colpatria.taskmanager.web.api.rest.tasks.impl;

import com.colpatria.taskmanager.commons.constants.IEndpointTaskApi;
import com.colpatria.taskmanager.commons.constants.ResponseMassage;
import com.colpatria.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.colpatria.taskmanager.commons.domains.generic.TaskDTO;
import com.colpatria.taskmanager.services.tasks.ItaskServices;
import com.colpatria.taskmanager.web.api.rest.tasks.ImanagerTaskApi;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IEndpointTaskApi.BASE_URL)
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@Log4j2
public class ManagerTaskApiImpl implements ImanagerTaskApi {

    private final ItaskServices itaskServices;

    public ManagerTaskApiImpl(ItaskServices itaskServices) {
        this.itaskServices = itaskServices;
    }


    /**
     * Author jsQuimbayo
     **/
    @Override
    @PutMapping(IEndpointTaskApi.CREATE_TASK)
    @ApiOperation(value = "guardar una tarea de usuario con sus datos", notes = "metodo para guardar una tarea")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = ResponseMassage.CREATE_SUCCESS, response = GenericResponseDTO.class),
        @ApiResponse(code = 400, message = ResponseMassage.CREATE_FAIL, response = String.class),
        @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> createTask(@RequestBody TaskDTO taskDTO){
        return itaskServices.createTask(taskDTO);
    }


    /**
     * Author jsQuimbayo
     **/
    @Override
    @GetMapping(IEndpointTaskApi.GET_TASKS)
    @ApiOperation(value = "Obtiene todas las tareas asociadas a un usuario", notes = "obtiene una tarea")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.GET_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.GET_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> getTasks(@PathVariable String idUser){
        return itaskServices.getTasks(idUser);
    }


    /**
     * Author jsQuimbayo
     **/
    @Override
    @PutMapping(IEndpointTaskApi.UPDATE_TASK)
    @ApiOperation(value = "actualiza tarea asociada a un usuario por id", notes = "actualiza una tarea")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.UPDATE_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.UPDATE_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> updateTask(@PathVariable String codeTask,
                                                         @RequestBody TaskDTO taskDTO){
        return itaskServices.updateTask(codeTask, taskDTO);
    }


    /**
     * Author jsQuimbayo
     **/
    @Override
    @DeleteMapping(IEndpointTaskApi.DELETE_TASK)
    @ApiOperation(value = "elimina tarea asociada a un usuario por id", notes = "elimina una tarea")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.DELETE_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.DELETE_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> deleteTask(@PathVariable String codeTask){
        return itaskServices.deleteTask(codeTask);
    }
}
