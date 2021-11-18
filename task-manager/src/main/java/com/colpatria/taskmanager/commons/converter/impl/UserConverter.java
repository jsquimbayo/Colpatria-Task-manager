package com.colpatria.taskmanager.commons.converter.impl;

import com.colpatria.taskmanager.commons.converter.IUserConverter;
import com.colpatria.taskmanager.commons.domains.entity.TaskEntity;
import com.colpatria.taskmanager.commons.domains.entity.UserEntity;
import com.colpatria.taskmanager.commons.domains.generic.TaskDTO;
import com.colpatria.taskmanager.commons.domains.generic.UserDTO;
import com.colpatria.taskmanager.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UserConverter implements IUserConverter {


    /**
     * Author jsQuimbayo
     * metodo que convierte de userdto a userEntity
     * *param taskDTO
     **/
    @Override
    public UserEntity userDtoToUserEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        try {
            userEntity = HelperMapper.modelMapper().map(userDTO, UserEntity.class);
        }catch (Exception e){
            log.info("No se agrego document para generar indice electronico" + e);
        }finally {
            return userEntity;
        }
    }


    /**
     * Author jsQuimbayo
     * metodo que convierte de taskdto a taskEntity
     * *param taskDTO
     **/
    @Override
    public UserDTO userEntityToUserDto(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        try {
            userDTO = HelperMapper.modelMapper().map(userEntity, UserDTO.class);
        }catch (Exception e){
            log.info("No se agrego document para generar indice electronico" + e);
        }finally {
            return userDTO;
        }
    }
}
