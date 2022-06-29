package com.thanura.dep8.service.util;
import com.thanura.dep8.dto.ToDoDTO;
import com.thanura.dep8.dto.UserDTO;
import com.thanura.dep8.entity.ToDO;
import com.thanura.dep8.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private ModelMapper mapper;

    public EntityDTOConversion(ModelMapper mapper) {

        this.mapper = mapper;
    }
    public User getUserEntity(UserDTO userDTO){

        return mapper.map(userDTO, User.class);
    }
    public UserDTO getUserDTO(User user){
        return mapper.map(user,UserDTO.class);
    }
    public ToDO getToDoEntity (ToDoDTO toDoDTO){

        return mapper.map(toDoDTO, ToDO.class);
    }

    public ToDoDTO getToDoDTO(ToDO toDOEntity){
        return mapper.typeMap(ToDO.class, ToDoDTO.class)
                .addMapping(toDO->toDO.getUser().getId(),ToDoDTO::setUserId)
                .map(toDOEntity);
    }

}
