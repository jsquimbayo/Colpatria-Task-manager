package com.colpatria.taskmanager.services.users;

import com.colpatria.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.colpatria.taskmanager.commons.domains.generic.UserDTO;
import org.springframework.http.ResponseEntity;

public interface IUserServices {

    ResponseEntity<GenericResponseDTO> createUser(UserDTO userDTO);
}
