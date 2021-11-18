package com.colpatria.taskmanager.commons.constants;

public interface IEndpointTaskApi {

    String BASE_URL = "/managerTask/api/ts";

    String CREATE_TASK = "/createTask";

    String GET_TASKS = "/getTasks/{idUser}";

    String UPDATE_TASK = "/updateTask/{codeTask}";

    String DELETE_TASK = "/deleteTask/{codeTask}";

    String CREATE_USER = "/createUser";

}
