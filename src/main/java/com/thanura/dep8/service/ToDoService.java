package com.thanura.dep8.service;

import com.thanura.dep8.dto.ToDoDTO;

import java.util.List;

public interface ToDoService {

    ToDoDTO saveToDo(ToDoDTO todo);

    List<ToDoDTO> getAllToDos(String userId);

    void deleteToDo(String userId,int toDoId);


}
