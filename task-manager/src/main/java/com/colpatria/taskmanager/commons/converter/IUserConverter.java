package com.colpatria.taskmanager.commons.converter;

import com.colpatria.taskmanager.commons.domains.entity.UserEntity;
import com.colpatria.taskmanager.commons.domains.generic.UserDTO;

public interface IUserConverter {

    UserEntity userDtoToUserEntity(UserDTO userDTO);

    UserDTO userEntityToUserDto(UserEntity userEntity);
}
