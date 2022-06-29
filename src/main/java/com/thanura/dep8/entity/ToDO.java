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
    @Column()
    private Date date;
    @Column()
    private Time time;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
    private User user;

    public ToDO(String todo, User user) {
        this.todo = todo;
        this.user = user;
    }

    public ToDO(String todo, Date date, Time time, User user) {
        this.todo = todo;
        this.date = date;
        this.time = time;
        this.user = user;
    }
}
