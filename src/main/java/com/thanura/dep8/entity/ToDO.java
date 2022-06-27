package com.thanura.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ToDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String todo;
    private Date date;
    private Time time;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
    private User user;

    public ToDO(int id, String todo) {
        this.id = id;
        this.todo = todo;
    }

    public ToDO(int id, String todo, User user) {
        this.id = id;
        this.todo = todo;
        this.user = user;
    }
}
