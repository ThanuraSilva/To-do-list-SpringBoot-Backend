package com.thanura.dep8.repositary;

import com.thanura.dep8.entity.ToDO;
import com.thanura.dep8.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<ToDO,Integer> {
    List<ToDO>findAllToDosByUser(User user);

    long countToDosByUser(User user);

}
