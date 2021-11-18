package com.colpatria.taskmanager.commons.domains.generic;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {

    private String idUser;
    private String nameUser;
    private String lastNameUser;
    private String identUser;
    private String mailUser;
    private String loginNameUser;
    private String passwordUser;
}
