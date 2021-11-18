package com.colpatria.taskmanager.commons.domains.generic;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TaskDTO implements Serializable {

    private String codeTask;
    private String typeTask;
    private String issueTask;
    private String startDate;
    private String endDate;
    private String priority;
    private String assignHours;
    private String usedHours;
    private String idUser;

}
