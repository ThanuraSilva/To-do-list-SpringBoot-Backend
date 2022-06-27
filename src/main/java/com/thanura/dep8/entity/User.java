package com.thanura.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User implements SuperEntity {
     @Id
     private String id;
     @Column(name = "fullname",nullable = false)
     private String fullName;
     @Column(nullable = false,unique = true)
     private String email;
     @Column(nullable = false)
     private String password;
}
