package com.thanura.dep8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "To do can not be an empty value")
    private String todo;

    @Pattern(regexp = "[A-Fa-f0-9\\-]{36}",message = "Invalid user ID")
    private String userId;
}
