package com.colpatria.taskmanager.web.api.rest.users;

import com.colpatria.taskmanager.commons.constants.IEndpointUserApi;
import com.colpatria.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.colpatria.taskmanager.commons.domains.generic.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserApi {

    @PutMapping(IEndpointUserApi.CREATE_USER)
    ResponseEntity<GenericResponseDTO> createUser(@RequestBody UserDTO userDTO);
}
