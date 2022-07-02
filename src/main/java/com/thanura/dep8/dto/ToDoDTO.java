package com.thanura.dep8.dto;

import com.thanura.dep8.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Valid
public class ToDoDTO implements Serializable {
    @Null(message = "Id will be automatically generated")
    private int id;

    @NotNull(message = "To do can not be an empty value")
    private String todo;

    @NotNull(message = "User ID can not be an empty value")
    @Pattern(regexp = "[A-Fa-f0-9\\-]{36}")
    private String userId;
}
