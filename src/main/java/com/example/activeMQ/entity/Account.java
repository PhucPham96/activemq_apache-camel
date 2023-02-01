package com.example.activeMQ.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;
    private String email;
    private String name;
}
