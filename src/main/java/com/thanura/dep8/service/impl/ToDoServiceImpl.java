package com.thanura.dep8.service.impl;

import com.thanura.dep8.dto.ToDoDTO;
import com.thanura.dep8.entity.ToDO;
import com.thanura.dep8.entity.User;
import com.thanura.dep8.repositary.ToDoRepository;
import com.thanura.dep8.repositary.UserRepository;
import com.thanura.dep8.service.ToDoService;
import com.thanura.dep8.service.exception.NotFoundException;
import com.thanura.dep8.service.exception.UnauthorizedAccessException;
import com.thanura.dep8.service.util.EntityDTOConversion;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ToDoServiceImpl implements ToDoService {

    public final UserRepository userRepository;

    public final EntityDTOConversion transform;

    public final ToDoRepository toDoRepository;

    public ToDoServiceImpl(UserRepository userRepository, EntityDTOConversion transform, ToDoRepository toDoRepository) {
        this.userRepository = userRepository;
        this.transform = transform;
        this.toDoRepository = toDoRepository;
    }


    @Override
    public ToDoDTO saveToDo(ToDoDTO todo) throws NotFoundException {
        ToDO toDoEntity = transform.getToDoEntity(todo);
        toDoEntity.setUser(getUser(todo.getUserId()));
        return transform.getToDoDTO(toDoRepository.save(toDoEntity));

    }

    @Override
    public List<ToDoDTO> getAllToDos(String userId) {
        return toDoRepository.findAllToDosByUser(getUser(userId))
                .stream().map(transform::getToDoDTO).collect(Collectors.toList());

    }

    @Override
    public void deleteToDo(String userId, int toDoId) throws NotFoundException {
        ToDO toDO =
                toDoRepository.findById(toDoId).orElseThrow(() -> new NotFoundException("Invalid Note"));
        if(getUser(userId) != toDO.getUser()){
            toDoRepository.deleteById(toDoId);
            throw new UnauthorizedAccessException("Not allow to delete the todo details");
        }

    }

    //because of the neediness of the user
    private User getUser(String userId){
        return userRepository.findById(userId).orElseThrow(()->new NotFoundException("User not found"));
    }
}
