package com.thanura.dep8.service;

import com.thanura.dep8.dto.ToDoDTO;
import com.thanura.dep8.service.exception.NotFoundException;

import java.util.List;

public interface ToDoService {

    ToDoDTO saveToDo(ToDoDTO todo) throws NotFoundException;

    List<ToDoDTO> getAllToDos(String userId) throws NotFoundException;

    void deleteToDo(String userId,int toDoId);


}
