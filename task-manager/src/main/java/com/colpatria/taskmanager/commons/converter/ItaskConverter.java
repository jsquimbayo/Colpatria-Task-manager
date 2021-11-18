package com.colpatria.taskmanager.commons.converter;

import com.colpatria.taskmanager.commons.domains.entity.TaskEntity;
import com.colpatria.taskmanager.commons.domains.generic.TaskDTO;

public interface ItaskConverter {
    TaskEntity taskDtoToTaskEntity(TaskDTO taskDTO);

    TaskDTO taskEntityToTaskDto(TaskEntity taskEntity);
}
