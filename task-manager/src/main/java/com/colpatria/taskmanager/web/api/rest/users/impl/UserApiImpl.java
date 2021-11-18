package com.colpatria.taskmanager.web.api.rest.users.impl;


import com.colpatria.taskmanager.commons.constants.IEndpointUserApi;
import com.colpatria.taskmanager.commons.constants.ResponseMassage;
import com.colpatria.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.colpatria.taskmanager.commons.domains.generic.UserDTO;
import com.colpatria.taskmanager.services.users.IUserServices;
import com.colpatria.taskmanager.web.api.rest.users.IUserApi;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(IEndpointUserApi.BASE_URL)
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@Log4j2
public class UserApiImpl implements IUserApi {

    private final IUserServices iUserServices;

    public UserApiImpl(IUserServices iUserServices) {
        this.iUserServices = iUserServices;
    }


    /**
     * Author jsQuimbayo
     **/
    @Override
    @PutMapping(IEndpointUserApi.CREATE_USER)
    @ApiOperation(value = "guardar un usuario con sus datos", notes = "metodo para guardar un usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.CREATE_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.CREATE_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> createUser(UserDTO userDTO) {
        return iUserServices.createUser(userDTO);
    }



}
