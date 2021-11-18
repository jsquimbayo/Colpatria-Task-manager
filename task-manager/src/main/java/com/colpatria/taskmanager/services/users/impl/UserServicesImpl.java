package com.colpatria.taskmanager.services.users.impl;

import com.colpatria.taskmanager.commons.converter.IUserConverter;
import com.colpatria.taskmanager.commons.domains.entity.TaskEntity;
import com.colpatria.taskmanager.commons.domains.entity.UserEntity;
import com.colpatria.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.colpatria.taskmanager.commons.domains.generic.UserDTO;
import com.colpatria.taskmanager.commons.repository.UserRepository;
import com.colpatria.taskmanager.services.users.IUserServices;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
@Log4j2
public class UserServicesImpl implements IUserServices {

    @Autowired
    private IUserConverter iUserConverter;

    @Autowired
    private UserRepository userRepository;


    @Override
    @Modifying
    public ResponseEntity<GenericResponseDTO> createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        try{
            userEntity = iUserConverter.userDtoToUserEntity(userDTO);
            if(!userEntity.getIdUser().isEmpty()){
                userRepository.save(userEntity);
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("usuario creado")
                        .objectResponse(userEntity)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("Error creando el usuario, verificar datos")
                        .objectResponse(null)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            log.error("Algo fallo en la creacion del usuario " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error creando el usuario:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
