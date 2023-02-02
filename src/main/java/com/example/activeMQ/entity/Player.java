package com.example.activeMQ.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private Long id;
    private String name;
//    private Team team;
}
