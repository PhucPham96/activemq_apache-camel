package com.example.activeMQ.entity;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private Long id;
    private String city;
    private String province;
    List<Person> personList;
}
