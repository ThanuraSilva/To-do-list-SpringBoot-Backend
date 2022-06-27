package com.thanura.dep8.dto;

import com.thanura.dep8.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoDTO {
    private int id;
    private String todo;
    private String userId;
}
