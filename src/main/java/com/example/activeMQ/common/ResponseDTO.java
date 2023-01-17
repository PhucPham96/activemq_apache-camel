package com.example.activeMQ.common;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {

    public String name;
    public List<T> data;
}
