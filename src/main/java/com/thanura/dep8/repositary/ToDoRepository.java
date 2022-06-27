package com.thanura.dep8.repositary;

import com.thanura.dep8.entity.ToDO;
import com.thanura.dep8.entity.User;

import java.util.List;

public interface ToDoRepository {
    List<ToDO>findAllToDosByUser(User user);

    long countToDosByUser(User user);

}
