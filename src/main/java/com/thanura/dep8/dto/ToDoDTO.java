package com.thanura.dep8.dto;

import com.thanura.dep8.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoDTO implements Serializable {
    private int id;
    private String todo;
    private String userId;
}
