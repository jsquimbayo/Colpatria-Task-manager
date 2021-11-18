package com.colpatria.taskmanager.commons.domains.entity;

import lombok.*;

import javax.persistence.*;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "col_users")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTable;

    @Column(name = "id_user")
    private String idUser;

    @Column(name = "name_user")
    private String nameUser;

    @Column(name = "last_name_user")
    private String lastNameUser;

    @Column(name = "identification_user")
    private String identUser;

    @Column(name = "mail_user")
    private String mailUser;

    @Column(name = "login_name_user")
    private String loginNameUser;

    @Column(name = "password_user")
    private String passwordUser;



}
