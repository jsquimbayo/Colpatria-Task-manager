package com.colpatria.taskmanager.commons.domains.entity;



import lombok.*;

import javax.persistence.*;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "col_tasks")
public class TaskEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTable;

    @Column(name = "code_task")
    private String codeTask;

    @Column(name = "type_task")
    private String typeTask;

    @Column(name = "issue_task")
    private String issueTask;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "priority_task")
    private String priority;

    @Column(name = "assigned_hours")
    private String assignHours;

    @Column(name = "used_hours")
    private String usedHours;

    @Column(name = "id_user")
    private String idUser;

}
