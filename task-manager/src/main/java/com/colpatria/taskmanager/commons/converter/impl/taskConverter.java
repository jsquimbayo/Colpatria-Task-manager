package com.colpatria.taskmanager.commons.converter.impl;

import com.colpatria.taskmanager.commons.converter.ItaskConverter;
import com.colpatria.taskmanager.commons.domains.entity.TaskEntity;
import com.colpatria.taskmanager.commons.domains.generic.TaskDTO;
import com.colpatria.taskmanager.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;


@Component
@Log4j2
public class taskConverter implements ItaskConverter {

    /**
     * Author jsQuimbayo
     * metodo que convierte de taskdto a taskEntity
     * *param taskDTO
     **/
    @Override
    public TaskEntity taskDtoToTaskEntity(TaskDTO taskDTO){
        TaskEntity taskEntity = new TaskEntity();
        try {
            taskEntity = HelperMapper.modelMapper().map(taskDTO, TaskEntity.class);
        }catch (Exception e){
            log.info("No se agrego document para generar indice electronico" + e);
        }finally {
            return taskEntity;
        }
    }


    /**
     * Author jsQuimbayo
     * metodo que convierte de taskdto a taskEntity
     * *param taskDTO
     **/
    @Override
    public TaskDTO taskEntityToTaskDto(TaskEntity taskEntity){
        TaskDTO taskDTO = new TaskDTO();
        try {
            taskDTO = HelperMapper.modelMapper().map(taskEntity, TaskDTO.class);
        }catch (Exception e){
            log.info("No se agrego document para generar indice electronico" + e);
        }finally {
            return taskDTO;
        }
    }


}
