package com.thanura.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ToDO {
    @Id
    private Integer id;

    private String todo;

    private Date date;

    private Time time;



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
