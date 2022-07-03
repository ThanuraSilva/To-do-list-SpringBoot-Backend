package com.thanura.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class User implements SuperEntity {
     @Id
     private String id;

     private String fullName;

     private String email;

     private String password;
}
